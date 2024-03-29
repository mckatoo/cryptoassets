/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces;

import io.ikatoo.cryptoassets.services.binance.GeneralService;
import io.ikatoo.cryptoassets.uteis.FormManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.beans.PropertyVetoException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author mckatoo
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private static final GeneralService generalService = new GeneralService();

    public FrmMain() {
        initComponents();
    }

    private void verificaConexao() throws InterruptedException, ExecutionException {
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            if (generalService.ping()) {
                lbStatus.setText("On Line");
                lbStatus.setForeground(Color.black);
                pnStatus.setBackground(Color.decode("#60ff83"));
            } else {
                lbStatus.setText("Off Line");
                lbStatus.setForeground(Color.white);
                pnStatus.setBackground(Color.decode("#c90c0c"));
            }
        }
    }

    private static FrmMain instance;

    private static FrmMain getInstance() {
        if (instance == null) {
            instance = new FrmMain();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        pnStatus = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CryptoAssets Portifolio Manager");
        setBackground(new java.awt.Color(73, 81, 176));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frmMain"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(26, 82, 134));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jToggleButton1.setBackground(new java.awt.Color(0, 51, 153));
        buttonGroup1.add(jToggleButton1);
        jToggleButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon("/media/ARQUIVOS/COMMON/PROJETOS/cryptoassets/desktop/cryptoassets/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/sharp-attach_money-white-18/1x/sharp_attach_money_white_18dp.png")); // NOI18N
        jToggleButton1.setText("PORTIFOLIO");
        jToggleButton1.setToolTipText("");
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon("/media/ARQUIVOS/COMMON/PROJETOS/cryptoassets/desktop/cryptoassets/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/sharp-attach_money-black-18/1x/sharp_attach_money_black_18dp.png")); // NOI18N
        jToggleButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButton1StateChanged(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1);

        jToggleButton2.setBackground(new java.awt.Color(0, 51, 153));
        buttonGroup1.add(jToggleButton2);
        jToggleButton2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setIcon(new javax.swing.ImageIcon("/media/ARQUIVOS/COMMON/PROJETOS/cryptoassets/desktop/cryptoassets/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/sharp-trending_up-white-18/1x/sharp_trending_up_white_18dp.png")); // NOI18N
        jToggleButton2.setText("GRAPHICS");
        jToggleButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToggleButton2.setFocusPainted(false);
        jToggleButton2.setSelectedIcon(new javax.swing.ImageIcon("/media/ARQUIVOS/COMMON/PROJETOS/cryptoassets/desktop/cryptoassets/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/sharp-trending_up-black-18/1x/sharp_trending_up_black_18dp.png")); // NOI18N
        jToggleButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButton2StateChanged(evt);
            }
        });
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2);

        jToggleButton3.setBackground(new java.awt.Color(0, 51, 153));
        buttonGroup1.add(jToggleButton3);
        jToggleButton3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(254, 254, 254));
        jToggleButton3.setIcon(new javax.swing.ImageIcon("/home/mckatoo/projetos/cryptoassets/desktop/cryptoassets/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/sharp-settings-white-18/1x/sharp_settings_white_18dp.png")); // NOI18N
        jToggleButton3.setText("DEFINITIONS");
        jToggleButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToggleButton3.setFocusPainted(false);
        jToggleButton3.setSelectedIcon(new javax.swing.ImageIcon("/media/ARQUIVOS/COMMON/PROJETOS/cryptoassets/desktop/cryptoassets/src/main/java/io/ikatoo/cryptoassets/interfaces/icons/sharp-settings-black-18/1x/sharp_settings_black_18dp.png")); // NOI18N
        jToggleButton3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButton3StateChanged(evt);
            }
        });
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jToggleButton3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jToggleButton3PropertyChange(evt);
            }
        });
        jPanel1.add(jToggleButton3);

        jPanel3.setBackground(new java.awt.Color(26, 82, 134));

        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnStatusLayout = new javax.swing.GroupLayout(pnStatus);
        pnStatus.setLayout(pnStatusLayout);
        pnStatusLayout.setHorizontalGroup(
            pnStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStatusLayout.createSequentialGroup()
                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pnStatusLayout.setVerticalGroup(
            pnStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStatusLayout.createSequentialGroup()
                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(26, 82, 134));

        jDesktopPane2.setBackground(new java.awt.Color(26, 82, 134));

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                verificaConexao();
                return null;
            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FrmPortifolio portifolio = new FrmPortifolio();
                try {
                    FormManager.openInternalForm(portifolio, jDesktopPane1);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        });
        try {
            future.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            executorService.shutdown();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FrmGraphics graphics = new FrmGraphics();
                try {
                    FormManager.openInternalForm(graphics, jDesktopPane1);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        });
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FrmDefinitions definitions = new FrmDefinitions();
                try {
                    FormManager.openInternalForm(definitions, jDesktopPane1);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        });
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jToggleButton3PropertyChange
    }//GEN-LAST:event_jToggleButton3PropertyChange

    private void jToggleButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButton3StateChanged
        if (jToggleButton3.isSelected()) {
            jToggleButton3.setForeground(Color.black);
        } else {
            jToggleButton3.setForeground(Color.white);
        }
    }//GEN-LAST:event_jToggleButton3StateChanged

    private void jToggleButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButton2StateChanged
        if (jToggleButton2.isSelected()) {
            jToggleButton2.setForeground(Color.black);
        } else {
            jToggleButton2.setForeground(Color.white);
        }
    }//GEN-LAST:event_jToggleButton2StateChanged

    private void jToggleButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButton1StateChanged
        if (jToggleButton1.isSelected()) {
            jToggleButton1.setForeground(Color.black);
        } else {
            jToggleButton1.setForeground(Color.white);
        }
    }//GEN-LAST:event_jToggleButton1StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMain().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JDesktopPane jDesktopPane2;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JToggleButton jToggleButton1;
    public static javax.swing.JToggleButton jToggleButton2;
    public static javax.swing.JToggleButton jToggleButton3;
    public static javax.swing.JLabel lbStatus;
    public static javax.swing.JPanel pnStatus;
    // End of variables declaration//GEN-END:variables
}
