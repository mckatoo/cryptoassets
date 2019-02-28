/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces;

import io.ikatoo.cryptoassets.interfaces.renderers.Renderers;
import io.ikatoo.cryptoassets.models.Portifolio;
import io.ikatoo.cryptoassets.models.abstracts.PortifolioATM;
import io.ikatoo.cryptoassets.services.AccountService;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class FrmPortifolio extends javax.swing.JInternalFrame {

    private final PortifolioATM _model = new PortifolioATM();

    /**
     * Creates new form frmPortifolio
     */
    public FrmPortifolio() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbAssets = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setTitle("Portifolio Balance");
        setFrameIcon(new javax.swing.ImageIcon("/home/mckatoo/projetos/cryptoassets/desktop/cryptoassets/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/sharp-attach_money-white-18/1x/sharp_attach_money_white_18dp.png")); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tbAssets.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbAssets.getTableHeader().setReorderingAllowed(false);
        tbAssets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAssetsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAssets);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    }//GEN-LAST:event_formFocusGained

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        AccountService http = new AccountService();

        long now = new Timestamp(System.currentTimeMillis()).getTime();

        try {
            JSONArray resultado = http.getBalances(10000, now);

            for (int i = 0; i < resultado.length(); i++) {
                JSONObject json = (JSONObject) resultado.get(i);

                BigDecimal free = new BigDecimal(json.get("free").toString()).setScale(8, RoundingMode.HALF_EVEN).stripTrailingZeros();
                BigDecimal locked = new BigDecimal(json.get("locked").toString()).setScale(8, RoundingMode.HALF_EVEN).stripTrailingZeros();
                BigDecimal zero = new BigDecimal("0.00000000").setScale(8, RoundingMode.HALF_EVEN).stripTrailingZeros();

                if ((free.compareTo(zero) == 1) || (locked.compareTo(zero) == 1)) {
                    JLabel labelImage = new JLabel();
                    String pathImage = new File("").getCanonicalPath() + "/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/coins/32/color/" + json.get("asset").toString().toLowerCase() + ".png";
                    labelImage.setIcon(new ImageIcon(pathImage));

                    Portifolio portifolio = new Portifolio(
                            new ImageIcon(pathImage),
                            json.get("asset").toString(), //ASSET EX. BTC
                            zero, //BUY VALUE
                            new Date(), //DATE BUY
                            zero, //SELL VALUE
                            new Date(), //DATE SELL
                            zero, //CURRENT
                            zero, //PROFIT 
                            free, //FREE
                            locked, //IN ORDER
                            locked.add(free) //TOTAL BALANCE
                    );

                    
                    _model.add(portifolio);
                    tbAssets.setModel(_model);
                    tbAssets.setRowHeight(50);
                    tbAssets.getColumnModel().getColumn(0).setCellRenderer(new Renderers());
                    tbAssets.getColumnModel().getColumn(0).setPreferredWidth(50);
                    tbAssets.getColumnModel().getColumn(1).setPreferredWidth(50);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(FrmPortifolio.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_formComponentShown

    private void tbAssetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAssetsMouseClicked
        Portifolio portifolio = _model.getPortifolio(tbAssets.getSelectedRow());
        System.out.println(portifolio.getAsset() + " = " + portifolio.getTotalBalance());
    }//GEN-LAST:event_tbAssetsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAssets;
    // End of variables declaration//GEN-END:variables
}
