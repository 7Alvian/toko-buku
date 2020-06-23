/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokobuku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author WINDOWS 10
 */
public class LaporanPenjualan extends javax.swing.JInternalFrame {
private static Connection koneksi;
private DefaultTableModel model;

    public LaporanPenjualan() {
        initComponents();
        model = new DefaultTableModel();
        this.jTable1.setModel(model);
        model.addColumn("ID_Transaksi");
        model.addColumn("ID_Buku");
        model.addColumn("Judul");
        model.addColumn("Tanggal");
        model.addColumn("Jumlah");
        ambil_data_tabel();
    }

    private static Connection buka_koneksi(){
        if(koneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/toko";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url,user,password);
            }catch(SQLException t){
                System.out.println("Error buat koneksi");
            }
        }
        return koneksi;
    }
    
     private void ambil_data_tabel() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = buka_koneksi();
            Statement s = c.createStatement();
            String sql = "Select * from penjualan";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[5];
                o[0] = r.getString("id_transaksi");
                o[1] = r.getString("id_barang");
                o[2] = r.getString("nama_barang");
                o[3] = r.getString("tanggal");
                o[4] = r.getString("jumlah");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan " + e.getMessage());
        }
    }
    private void filter(String query) {
        TableRowSorter<DefaultTableModel> ft = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(ft);
        ft.setRowFilter(RowFilter.regexFilter(query));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnbulan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcaritahun = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcaribulan = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Laporan Penjualan");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Transaksi", "ID_Buku", "Judul", "Tanggal", "Jumlah"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnbulan.setText("Lihat");
        btnbulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbulanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Laporan Penjualan");

        jButton1.setText("Lihat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Perbulan");

        jLabel3.setText("Pertahun");

        txtcaritahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaritahunActionPerformed(evt);
            }
        });

        jLabel4.setText("Cari");

        jButton2.setText("Refresh Laporan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(23, 23, 23)
                                .addComponent(txtcaribulan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbulan)
                                .addGap(18, 18, 18)
                                .addComponent(txtcaritahun, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnbulan)
                    .addComponent(jButton1)
                    .addComponent(txtcaritahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcaribulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaritahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaritahunActionPerformed
        
    }//GEN-LAST:event_txtcaritahunActionPerformed

    private void btnbulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbulanActionPerformed
        String query = txtcaribulan.getText().toString();
        filter(query);
    }//GEN-LAST:event_btnbulanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String query = txtcaritahun.getText().toString();
        filter(query);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ambil_data_tabel();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbulan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcaribulan;
    private javax.swing.JTextField txtcaritahun;
    // End of variables declaration//GEN-END:variables
}
