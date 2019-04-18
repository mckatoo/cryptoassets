/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.chart.candlestick;

import io.ikatoo.cryptoassets.services.binance.MarketDataService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;
import org.json.JSONArray;

/**
 *
 * @author mckatoo
 */
public class DataSet {

    private final MarketDataService marketDataService = new MarketDataService();

    public OHLCDataset createDataSet(String asset, String interval) throws IOException, InterruptedException {
        List<OHLCDataItem> dataItems = new ArrayList<>();
        JSONArray jsonArray = marketDataService.getKlineCandlestickData(asset, interval);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray line = jsonArray.getJSONArray(i);
            OHLCDataItem item = new OHLCDataItem(
                    new Date(line.getLong(0)), //date
                    line.getDouble(1), //open
                    line.getDouble(2), //hight
                    line.getDouble(3), //low
                    line.getDouble(4), //close
                    line.getDouble(5) //volume
            );
            dataItems.add(item);
        }
        OHLCDataItem[] data = dataItems.toArray(new OHLCDataItem[dataItems.size()]);
        OHLCDataset dataset = new DefaultOHLCDataset(asset, data);
        return dataset;
    }
}
