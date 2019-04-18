/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.chart.candlestick;

import io.ikatoo.cryptoassets.interfaces.Loader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.OHLCDataset;

/**
 *
 * @author mckatoo
 */
public class CandlestickChart {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    private JFreeChart chart;

    public void Create(JPanel panel, String asset, String interval) throws TimeoutException, InterruptedException, ExecutionException, IOException {

        Loader loader = new Loader();
        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                loader.getContentPane().setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
                loader.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
                loader.setVisible(true);
                return null;
            }
        });

//        OHLCDataset dataSet = new DataSet().createDataSet(asset, interval);
//        chart = new Renderer(asset, dataSet).Build();
        chart = new Renderer(asset, interval).Build();
        future.get(60, TimeUnit.SECONDS);
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(new ChartPanel(chart), BorderLayout.CENTER);
        loader.dispose();
        while (!future.isDone()) {
            executorService.shutdown();
        }
    }
}
