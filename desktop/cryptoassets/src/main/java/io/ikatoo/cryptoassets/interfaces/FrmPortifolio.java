/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces;

import io.ikatoo.cryptoassets.config.Parameters;
import io.ikatoo.cryptoassets.interfaces.renderers.DefaultCellRenderer;
import io.ikatoo.cryptoassets.interfaces.renderers.PortifolioCellRenderer;
import io.ikatoo.cryptoassets.models.Portifolio;
import io.ikatoo.cryptoassets.models.abstracts.PortifolioATM;
import io.ikatoo.cryptoassets.services.binance.AccountService;
import io.ikatoo.cryptoassets.services.binance.MarketDataService;
import io.ikatoo.cryptoassets.services.binance.OrdersService;
import io.ikatoo.cryptoassets.services.calculations.Financial;
import io.ikatoo.cryptoassets.services.calculations.Price;
import io.ikatoo.cryptoassets.uteis.FormManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class FrmPortifolio extends javax.swing.JInternalFrame {

    private final ExecutorService _executorService;

    private String pathIcon;
    private String totalBtc;
    private String profitBtc;

    /**
     * Creates new form frmPortifolio
     */
    public FrmPortifolio() {
        _executorService = Executors.newFixedThreadPool(10);
        initComponents();
    }

    private static FrmPortifolio instance;

    private static FrmPortifolio getInstance() {
        if (instance == null) {
            instance = new FrmPortifolio();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setTitle("Portifolio Balance");
        setFrameIcon(new javax.swing.ImageIcon("/home/mckatoo/projetos/cryptoassets/desktop/cryptoassets/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/sharp-attach_money-white-18/1x/sharp_attach_money_white_18dp.png")); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    }//GEN-LAST:event_formFocusGained

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        Future<Void> future = _executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                AccountService accountService = new AccountService();
                OrdersService orderService = new OrdersService();
                MarketDataService marketDataService = new MarketDataService();

                try {
                    JSONArray balance = accountService.getBalances(100000);

//                    PortifolioATM model = new PortifolioATM();
                    for (int i = 0; i < balance.length(); i++) {
                        JSONObject jsonBalance = (JSONObject) balance.get(i);

                        BigDecimal free = jsonBalance.getBigDecimal("free").setScale(8, RoundingMode.HALF_EVEN);
                        BigDecimal locked = jsonBalance.getBigDecimal("locked").setScale(8, RoundingMode.HALF_EVEN);
                        BigDecimal zero = BigDecimal.ZERO.setScale(8, RoundingMode.HALF_EVEN);
                        BigDecimal total = locked.add(free);

                        String asset = jsonBalance.get("asset").toString();

                        if (!total.equals(zero)) {
                            JSONArray allOrders = orderService.getAllOrders(asset, 0, 0, 0, Parameters.getLimit(), Parameters.getRecvWindow());
                            BigDecimal _price = zero.setScale(8, RoundingMode.HALF_EVEN);
                            long dateBuy = 0;

                            if (!(asset.equals("BTC")) && (allOrders.length() > 0)) {
                                JSONObject averagePrice = Price.averagePrice(allOrders, total);
                                _price = averagePrice.getBigDecimal("price");
                                dateBuy = averagePrice.getLong("dateBuy");
                            }
                            String pathImage = new File("").getCanonicalPath() + "/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/coins/32/color/" + jsonBalance.get("asset").toString().toLowerCase() + ".png";
                            BigDecimal current = marketDataService.getSymbolPriceTicker(asset).getBigDecimal("price");
                            BigDecimal profitMoney, profitPercent;
                            if ((current.compareTo(zero) == 1) && (_price.compareTo(zero) == 1)) {
                                profitMoney = Financial.calcProfit(current, _price);
                                profitPercent = Financial.calcProfitPercent(current, _price);
                            } else {
                                profitMoney = zero;
                                profitPercent = zero;
                            }

                            Portifolio portifolio = new Portifolio(
                                    new ImageIcon(pathImage),
                                    asset,
                                    _price,
                                    new Date(dateBuy),
                                    current,
                                    profitPercent,
                                    free,
                                    locked,
                                    total.setScale(8, RoundingMode.HALF_EVEN)
                            );
                            
//                            model.add(portifolio);
//                            tbAssets.setModel(model);
//                            tbAssets.setRowHeight(40);
//                            for (int j = 0; j < tbAssets.getColumnCount(); j++) {
//                                if ((j == 0) || (j == 5)) {
//                                    tbAssets.getColumnModel().getColumn(j).setCellRenderer(new PortifolioCellRenderer());
//                                } else {
//                                    tbAssets.getColumnModel().getColumn(j).setCellRenderer(new DefaultCellRenderer());
//                                }
//                            }

//                            tbAssets.getColumnModel().getColumn(0).setMaxWidth(40);
//                            tbAssets.getColumnModel().getColumn(1).setMaxWidth(50);
//                            tbAssets.getColumnModel().getColumn(5).setMaxWidth(90);
//                            tbAssets.getColumnModel().getColumn(0).setMinWidth(40);
//                            tbAssets.getColumnModel().getColumn(1).setMinWidth(50);
//                            tbAssets.getColumnModel().getColumn(5).setMinWidth(90);
                        }
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }

                return null;
            }
        });


    }//GEN-LAST:event_formComponentShown

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public String getTotalBtc() {
        return totalBtc;
    }

    public String getProfitBtc() {
        return profitBtc;
    }

    public String getPathIcon() {
        return pathIcon;
    }
}
