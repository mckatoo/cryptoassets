/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.chart.candlestick;

import io.ikatoo.cryptoassets.interfaces.Loader;
import io.ikatoo.cryptoassets.interfaces.chart.candlestick.model.Trade;
import io.ikatoo.cryptoassets.services.binance.MarketDataService;
import io.ikatoo.cryptoassets.uteis.TimeUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.json.JSONArray;

/**
 *
 * @author mckatoo
 */
@SuppressWarnings("serial")
public class JfreeCandlestickChart extends JPanel {

    private static final DateFormat READABLE_TIME_FORMAT = new SimpleDateFormat("kk:mm:ss");

    private OHLCSeries ohlcSeries;
    private TimeSeries volumeSeries;

    private static final int MIN = 60000;
    // Every minute
    private int timeInterval = 1;
    private Trade candelChartIntervalFirstPrint = null;
    private double open = 0.0;
    private double close = 0.0;
    private double low = 0.0;
    private double high = 0.0;
    private double volume = 0;

    public JfreeCandlestickChart(String title, int width, int height) {
        final JFreeChart candlestickChart = createChart(title);
        final ChartPanel chartPanel = new ChartPanel(candlestickChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(width, height));
        chartPanel.setMouseZoomable(true);
        chartPanel.setMouseWheelEnabled(true);
        add(chartPanel, BorderLayout.CENTER);
    }

    private JFreeChart createChart(String chartTitle) {

        /**
         * Creating candlestick subplot
         */
        // Create OHLCSeriesCollection as a price dataset for candlestick chart
        OHLCSeriesCollection candlestickDataset = new OHLCSeriesCollection();
        ohlcSeries = new OHLCSeries("Price");
        candlestickDataset.addSeries(ohlcSeries);
        NumberAxis priceAxis = new NumberAxis("Price");
        priceAxis.setAutoRangeIncludesZero(false);
        CandlestickRenderer candlestickRenderer = new CandlestickRenderer(CandlestickRenderer.WIDTHMETHOD_AVERAGE,
                false, new CustomHighLowItemLabelGenerator(new SimpleDateFormat("kk:mm"), new DecimalFormat("0.000")));
        XYPlot candlestickSubplot = new XYPlot(candlestickDataset, null, priceAxis, candlestickRenderer);
        candlestickSubplot.setBackgroundPaint(Color.white);

        /**
         * Creating volume subplot
         */
        TimeSeriesCollection volumeDataset = new TimeSeriesCollection();
        volumeSeries = new TimeSeries("Volume");
        volumeDataset.addSeries(volumeSeries);
        NumberAxis volumeAxis = new NumberAxis("Volume");
        volumeAxis.setAutoRangeIncludesZero(false);
        volumeAxis.setNumberFormatOverride(new DecimalFormat("0"));
        XYBarRenderer timeRenderer = new XYBarRenderer();
        timeRenderer.setShadowVisible(false);
        timeRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{2}",
                new SimpleDateFormat("kk:mm"), new DecimalFormat("0")));
        XYPlot volumeSubplot = new XYPlot(volumeDataset, null, volumeAxis, timeRenderer);
        volumeSubplot.setBackgroundPaint(Color.white);

        /**
         * Create chart main plot with two subplots (candlestickSubplot,
         * volumeSubplot) and one common dateAxis
         */
        DateAxis dateAxis = new DateAxis("Time");
        dateAxis.setDateFormatOverride(new SimpleDateFormat("kk:mm"));
        dateAxis.setLowerMargin(0.02);
        dateAxis.setUpperMargin(0.02);
        CombinedDomainXYPlot mainPlot = new CombinedDomainXYPlot(dateAxis);
        mainPlot.setGap(10.0);
        mainPlot.add(candlestickSubplot, 3);
        mainPlot.add(volumeSubplot, 1);
        mainPlot.setOrientation(PlotOrientation.VERTICAL);

        JFreeChart chart = new JFreeChart(chartTitle, JFreeChart.DEFAULT_TITLE_FONT, mainPlot, true);
        chart.removeLegend();
        return chart;
    }

    /**
     * Fill series with data.
     *
     * @param time
     * @param o
     * @param h
     * @param l
     * @param c
     * @param v
     */
    public void addCandel(long time, double o, double h, double l, double c, double v) {
        try {
            // Add bar to the data. Let's repeat the same bar
            FixedMillisecond t = new FixedMillisecond(
                    READABLE_TIME_FORMAT.parse(TimeUtils.convertToReadableTime(time)));
            ohlcSeries.add(t, o, h, l, c);
            volumeSeries.add(t, v);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aggregate the (open, high, low, close, volume) based on the predefined
     * time interval (1 minute)
     *
     * @param t the t
     */
    public void onTrade(Trade t) {
        double price = t.getPrice();
        if (candelChartIntervalFirstPrint != null) {
            long time = t.getTime();
            if (timeInterval == (int) ((time / MIN) - (candelChartIntervalFirstPrint.getTime() / MIN))) {
                close = price;
                addCandel(time, open, high, low, close, volume);
                candelChartIntervalFirstPrint = null;
            } else {
                if (price < low) {
                    low = price;
                }

                if (price > high) {
                    high = price;
                }
                volume = t.getSize();
            }
        } else {
            candelChartIntervalFirstPrint = t;
            open = price;
            low = price;
            high = price;
            volume = t.getSize();
        }
    }

    public void historyTrade(String asset, String interval) throws IOException, InterruptedException {

        MarketDataService marketDataService = new MarketDataService();
        JSONArray jsonArray = marketDataService.getKlineCandlestickData(asset, interval);
        Loader loader = new Loader();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                for (int i = 0; i < jsonArray.length(); i++) {
                    addCandel(
                            jsonArray.getJSONArray(i).getLong(0),
                            jsonArray.getJSONArray(i).getDouble(1),
                            jsonArray.getJSONArray(i).getDouble(2),
                            jsonArray.getJSONArray(i).getDouble(3),
                            jsonArray.getJSONArray(i).getDouble(4),
                            jsonArray.getJSONArray(i).getDouble(5)
                    );
                }
                return null;
            }
        });

        try {
            future.get(60, TimeUnit.SECONDS);
        } catch (ExecutionException | TimeoutException ex) {
            Logger.getLogger(JfreeCandlestickChart.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            loader.dispose();
            executorService.shutdown();
        }

    }

}
