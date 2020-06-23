/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokobuku;


import java.awt.Desktop;
/**
 *
 * @author WINDOWS 10
 */
public class Menu extends javax.swing.JFrame {
Buku bu = new Buku();
Distributor dis = new Distributor();
Penerbit pen = new Penerbit();
LaporanDataBukuDistributor lap = new LaporanDataBukuDistributor();
LaporanDataBukuPenerbit kua  = new LaporanDataBukuPenerbit();
Penerimaan terima =  new Penerimaan();
Penjualan jual = new Penjualan();
Pengembalian kembali = new Pengembalian();
LaporanPenjualan lapjual = new LaporanPenjualan();
    
    public Menu() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dekstop = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        itembuku = new javax.swing.JMenuItem();
        itemdistributor = new javax.swing.JMenuItem();
        itempenerbit = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        itembukudistri = new javax.swing.JMenuItem();
        itemladatabukupen = new javax.swing.JMenuItem();
        itempenjualan = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        itempenerimaan = new javax.swing.JMenuItem();
        itemkembali = new javax.swing.JMenuItem();
        itemjual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Utama");

        javax.swing.GroupLayout dekstopLayout = new javax.swing.GroupLayout(dekstop);
        dekstop.setLayout(dekstopLayout);
        dekstopLayout.setHorizontalGroup(
            dekstopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
        );
        dekstopLayout.setVerticalGroup(
            dekstopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );

        jMenuBar2.setToolTipText("Menu Utama");

        jMenu4.setText("Pendataan");

        itembuku.setText("Data Buku");
        itembuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itembukuMouseClicked(evt);
            }
        });
        itembuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itembukuActionPerformed(evt);
            }
        });
        jMenu4.add(itembuku);

        itemdistributor.setText("Data Distributor");
        itemdistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemdistributorActionPerformed(evt);
            }
        });
        jMenu4.add(itemdistributor);

        itempenerbit.setText("Data Penerbit");
        itempenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itempenerbitActionPerformed(evt);
            }
        });
        jMenu4.add(itempenerbit);

        jMenuBar2.add(jMenu4);

        jMenu6.setText("Laporan");

        itembukudistri.setText("Laporan Data Buku (Distributor)");
        itembukudistri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itembukudistriMouseClicked(evt);
            }
        });
        itembukudistri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itembukudistriActionPerformed(evt);
            }
        });
        jMenu6.add(itembukudistri);

        itemladatabukupen.setText("Laporan Data Buku (Penerbit)");
        itemladatabukupen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemladatabukupenActionPerformed(evt);
            }
        });
        jMenu6.add(itemladatabukupen);

        itempenjualan.setText("Laporan Penjualan");
        itempenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itempenjualanActionPerformed(evt);
            }
        });
        jMenu6.add(itempenjualan);

        jMenuBar2.add(jMenu6);

        jMenu5.setText("Transaksi");

        itempenerimaan.setText("Transaksi Penerimaan");
        itempenerimaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itempenerimaanActionPerformed(evt);
            }
        });
        jMenu5.add(itempenerimaan);

        itemkembali.setText("Transaksi Retur");
        itemkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemkembaliActionPerformed(evt);
            }
        });
        jMenu5.add(itemkembali);

        itemjual.setText("Transaksi Penjualan");
        itemjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemjualActionPerformed(evt);
            }
        });
        jMenu5.add(itemjual);

        jMenuBar2.add(jMenu5);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dekstop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dekstop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itembukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itembukuActionPerformed
    if (!bu.isShowing()){
        dekstop.add(bu);
        bu.setVisible(true);
    }
    }//GEN-LAST:event_itembukuActionPerformed

    private void itembukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itembukuMouseClicked
        
    }//GEN-LAST:event_itembukuMouseClicked

    private void itemdistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemdistributorActionPerformed
        if (!dis.isShowing()) {
            dekstop.add(dis);
            dis.setVisible(true);
        }
    }//GEN-LAST:event_itemdistributorActionPerformed

    private void itempenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itempenerbitActionPerformed
        if (!pen.isShowing()) {
            dekstop.add(pen);
            pen.setVisible(true);
        }
    }//GEN-LAST:event_itempenerbitActionPerformed

    private void itemladatabukupenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemladatabukupenActionPerformed
        if (!kua.isShowing()) {
            dekstop.add(kua);
            kua.setVisible(true);
        }
    }//GEN-LAST:event_itemladatabukupenActionPerformed

    private void itempenerimaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itempenerimaanActionPerformed
        if (!terima.isShowing()) {
            dekstop.add(terima);
            terima.setVisible(true);
        }
    }//GEN-LAST:event_itempenerimaanActionPerformed

    private void itemkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemkembaliActionPerformed
       if (!kembali.isShowing()) {
            dekstop.add(kembali);
            kembali.setVisible(true);
       }
    }//GEN-LAST:event_itemkembaliActionPerformed

    private void itemjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemjualActionPerformed
        if (!jual.isShowing()) {
            dekstop.add(jual);
            jual.setVisible(true);
       }
    }//GEN-LAST:event_itemjualActionPerformed

    private void itembukudistriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itembukudistriMouseClicked
           
    }//GEN-LAST:event_itembukudistriMouseClicked

    private void itembukudistriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itembukudistriActionPerformed
         if (!lap.isShowing()) {
            dekstop.add(lap);
            lap.setVisible(true);
         }
    }//GEN-LAST:event_itembukudistriActionPerformed

    private void itempenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itempenjualanActionPerformed
        if (!lapjual.isShowing()) {
            dekstop.add(lapjual);
            lapjual.setVisible(true);
       }
    }//GEN-LAST:event_itempenjualanActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dekstop;
    private javax.swing.JMenuItem itembuku;
    private javax.swing.JMenuItem itembukudistri;
    private javax.swing.JMenuItem itemdistributor;
    private javax.swing.JMenuItem itemjual;
    private javax.swing.JMenuItem itemkembali;
    private javax.swing.JMenuItem itemladatabukupen;
    private javax.swing.JMenuItem itempenerbit;
    private javax.swing.JMenuItem itempenerimaan;
    private javax.swing.JMenuItem itempenjualan;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables
}
