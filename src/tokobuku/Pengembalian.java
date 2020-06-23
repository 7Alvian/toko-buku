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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS 10
 */
public class Pengembalian extends javax.swing.JInternalFrame {
private static Connection koneksi;
private DefaultTableModel model;
    
    public Pengembalian() {
        initComponents();
        model = new DefaultTableModel();
        this.jTable1.setModel(model);
        model.addColumn("ID Transaksi");
        model.addColumn("ID Distributor");
        model.addColumn("ID Buku");
        model.addColumn("Jumlah");
        model.addColumn("Keterangan");
        ambil_data_tabel();
        tampil_combobuku();
        tampil_combodistri();
    }
    
    public void tampil_combobuku()
    {
        try {
        Connection con = buka_koneksi();
        Statement stt = con.createStatement();
        String sql = "select * from buku";      
        ResultSet res = stt.executeQuery(sql);                                
        cmbjudul.removeAllItems();
        while(res.next()){
            
            cmbjudul.addItem(res.getString("id_buku"));                                      
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_combodistri()
    {
        try {
        Connection con = buka_koneksi();
        Statement stt = con.createStatement();
        String sql = "select * from distributor";      
        ResultSet res = stt.executeQuery(sql);                                
        cmbdistri.removeAllItems();
        while(res.next()){
            
            cmbdistri.addItem(res.getString("id_distributor"));                                      
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
            String sql = "Select * from transaksi_pengembalian";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[5];
                o[0] = r.getString("id_transaksi");
                o[1] = r.getString("id_distributor");
                o[2] = r.getString("id_buku");
                o[3] = r.getString("jumlah");
                o[4] = r.getString("keterangan");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btntambah = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtjumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmbjudul = new javax.swing.JComboBox<>();
        cmbdistri = new javax.swing.JComboBox<>();
        cmbket = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Transaksi Pengembalian");

        jLabel6.setText("Keterangan");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("TRANSAKSI PENGEMBALIAN");

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        jLabel2.setText("ID_Transaksi");

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        jLabel3.setText("ID_Distributor");

        jLabel4.setText("ID_Buku");

        jLabel5.setText("Jumlah");

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "ID Distributor", "ID Buku", "Jumlah", "Keterangan"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cmbket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cacat", "Halaman Tidak Lengkap" }));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtjumlah)
                            .addComponent(cmbjudul, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbdistri, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbket, 0, 1, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btntambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbdistri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btntambah)
                            .addComponent(btnhapus)
                            .addComponent(btnedit)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        Connection c = buka_koneksi();
        String sqlkode = "Update buku SET `stok`= stok - " + this.txtjumlah.getText() + " "
                + "Where id_buku=" + cmbjudul.getSelectedItem() + "";
        String sqlkode1 = "Insert into transaksi_pengembalian (`id_transaksi`,`id_distributor`,`id_buku`,`jumlah`,`keterangan`) "
                + "values ('" + this.txtid.getText() + "',"
                + "'" + this.cmbdistri.getSelectedItem()+ "',"
                + "'" + this.cmbjudul.getSelectedItem()+ "',"
                + "'" + this.txtjumlah.getText() + "',"
                + "'" + this.cmbket.getSelectedItem() + "')";
        try {
            PreparedStatement p2 = (PreparedStatement) c.prepareStatement(sqlkode);
            PreparedStatement p1 = (PreparedStatement) c.prepareStatement(sqlkode1);
            p2.executeUpdate();
            p2.close();
            p1.executeUpdate();
            p1.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Terjadi kesalahan" + ex.getMessage());
        }
        this.btnhapus.enable(true);
        ambil_data_tabel();
        tampil_combobuku();
        tampil_combodistri();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        Connection c = buka_koneksi();
        String sqlkode = "Delete from transaksi_pengembalian "
                + "Where id_transaksi='" + this.txtid.getText() + "'";
        try {
            PreparedStatement p2 = (PreparedStatement) c.prepareStatement(sqlkode);
            p2.executeUpdate();
            p2.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Terjadi kesalahan" + ex.getMessage());
        }
        ambil_data_tabel();
        tampil_combobuku();
        tampil_combodistri();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = this.jTable1.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i, 0);
        this.txtid.setText(id);
        String distributor = (String) model.getValueAt(i, 1);
        this.cmbdistri.setSelectedItem(distributor);
        String judul = (String) model.getValueAt(i, 2);
        this.cmbjudul.setSelectedItem(judul);
        String jum = (String) model.getValueAt(i, 3);
        this.txtjumlah.setText(jum);
        String ket = (String) model.getValueAt(i, 4);
        this.cmbket.setSelectedItem(ket);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        Connection c = buka_koneksi();
        String sqlkode = "Update transaksi_pengembalian SET`id_distributor`='" + this.cmbdistri.getSelectedItem() + "'  ,"
                + "`id_buku`='" + this.cmbjudul.getSelectedItem() + "',"
                + "`jumlah`='" + this.txtjumlah.getText() + "',"
                + "`keterangan`='" + this.cmbket.getSelectedItem() + "'"
                + "Where id_transaksi='" + this.txtid.getText() + "'";
        try {
            PreparedStatement p2 = (PreparedStatement) c.prepareStatement(sqlkode);
            p2.executeUpdate();
            p2.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Terjadi kesalahan" + ex.getMessage());
        }
        ambil_data_tabel();
        tampil_combobuku();
        tampil_combodistri();
    }//GEN-LAST:event_btneditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ambil_data_tabel();
        tampil_combobuku();
        tampil_combodistri();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cmbdistri;
    private javax.swing.JComboBox<String> cmbjudul;
    private javax.swing.JComboBox<String> cmbket;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtjumlah;
    // End of variables declaration//GEN-END:variables
}