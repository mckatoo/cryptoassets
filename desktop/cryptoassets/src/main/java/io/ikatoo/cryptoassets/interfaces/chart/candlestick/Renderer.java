/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.chart.candlestick;

import java.awt.Color;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.xy.OHLCDataset;

/**
 *
 * @author mckatoo
 */
public class Renderer {

    private final String asset;
    private final String interval;
//    private final OHLCDataset dataset;

//    public Renderer(String asset, OHLCDataset dataset) {
    public Renderer(String asset, String interval) {
        this.asset = asset;
        this.interval = interval;
//        this.dataset = dataset;
    }

    public JFreeChart Build() throws IOException, InterruptedException {
        OHLCDataset dataSet = new DataSet().createDataSet(asset, interval);
//        JFreeChart chart = ChartFactory.createCandlestickChart(asset, "Time", "Price", dataset, false);
        JFreeChart chart = ChartFactory.createCandlestickChart(asset, "Time", "Price", dataSet, false);

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE); // light yellow = new Color(0xffffe0)
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.lightGray);
        ((NumberAxis) plot.getRangeAxis()).setAutoRangeIncludesZero(false);

        ((DateAxis) plot.getDomainAxis()).setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());

        ((CandlestickRenderer) plot.getRenderer()).setDrawVolume(false);
        return chart;
    }

}
