/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;
import java.awt.Dimension;
/**
 *
 * @author pipin
 */
public class kasir extends javax.swing.JFrame {
    DefaultTableModel tabModel;
ResultSet RsBarang=null;

    String NamaBarang;
    int HargaBarang;
    int JumlahBeli;
    int TotalBayar;
    int UangBayar;
    int UangKembalian;
    int Plastik;
    int Totebag;
    int bayar;
    double Pph;

    void tampilTengah(){
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
    }
    /**
     * Creates new form kasir
     */
    public kasir() {
        initComponents();
        tampilTengah();
        tampilData();
        SetEditOff();
    }
    
    public void radio(){
        if(jRadioPlastik.isSelected()){
            Plastik = bayar + 4000;
            jTextTB.setText(""+Plastik);
        }else if (jRadioTB.isSelected()){
            Totebag = bayar + 6000;
            jTextTB.setText(""+Totebag);
        } else {
            jTextTB.setText(""+bayar);
        }
    }
    
     private void tampilData(){
        try{
            Object[] judul_kolom = {"Nama Barang", "Harga Barang", "Jumlah Beli", "Total Bayar", "Uang Bayar", "Uang Kembalian", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelKasir.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsBarang=stt.executeQuery("SELECT * from kasir ");  
            while(RsBarang.next()){
                Object[] data={
                    RsBarang.getString("NamaBarang"),
                    RsBarang.getString("HargaBarang"),
                    RsBarang.getString("JumlahBeli"),
                    RsBarang.getString("TotalBayar"),
                    RsBarang.getString("UangBayar"),
                    RsBarang.getString("UangKembalian"),
                    RsBarang.getString("CreateDate")
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
        
        jButtonSimpan.setEnabled(false);
        jButtonHapus.setEnabled(false);
        jButtonBatal.setEnabled(false);
        jButtonJH.setEnabled(false);
        jButtonBayar.setEnabled(false);
    }
        
        private void SetEditOff(){
            jComboBoxNB.setEnabled(false);
            jTextHB.setEnabled(false);
            jTextJB.setEnabled(false);
            jTextTB.setEnabled(false);
            jTextUB.setEnabled(false);
            jTextUK.setEnabled(false);
        }
        
        private void SetEditOn(){
            jComboBoxNB.setEnabled(true);
            jTextHB.setEnabled(true);
            jTextJB.setEnabled(true);
            jTextTB.setEnabled(true);
            jTextUB.setEnabled(true);
            jTextUK.setEnabled(true);
        }
        
        private void BersihData(){
            jComboBoxNB.setSelectedIndex(0); 
            jTextHB.setText("");
            jTextJB.setText("");
            jTextTB.setText(""); 
            jTextUB.setText("");
            jTextUK.setText("");
            jCheckBoxPph.setSelected(rootPaneCheckingEnabled);
            jComboBoxNB.requestFocus();
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGrup = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabelNB = new javax.swing.JLabel();
        jLabelHB = new javax.swing.JLabel();
        jLabelJB = new javax.swing.JLabel();
        jLabelTB = new javax.swing.JLabel();
        jLabelUB = new javax.swing.JLabel();
        jLabelUK = new javax.swing.JLabel();
        jComboBoxNB = new javax.swing.JComboBox<>();
        jTextHB = new javax.swing.JTextField();
        jTextJB = new javax.swing.JTextField();
        jTextTB = new javax.swing.JTextField();
        jTextUB = new javax.swing.JTextField();
        jTextUK = new javax.swing.JTextField();
        jButtonBaru = new javax.swing.JButton();
        jButtonSimpan = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonBatal = new javax.swing.JButton();
        jButtonJH = new javax.swing.JButton();
        jButtonBayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelKasir = new javax.swing.JTable();
        jButtonKeluar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioPlastik = new javax.swing.JRadioButton();
        jRadioTB = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxPph = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("KASIR PENJUALAN");

        jLabelNB.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelNB.setText("Nama Barang");

        jLabelHB.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelHB.setText("Harga Barang");

        jLabelJB.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelJB.setText("Jumlah Beli");

        jLabelTB.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelTB.setText("Total Bayar");

        jLabelUB.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelUB.setText("Uang Bayar");

        jLabelUK.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelUK.setText("Uang Kembalian");

        jComboBoxNB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBoxNB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Barang", "Oreo", "Tango", "Floridina", "Beras", "Minyak", "Telor" }));
        jComboBoxNB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNBActionPerformed(evt);
            }
        });

        jTextHB.setText("jTextField1");

        jTextJB.setText("jTextField2");

        jTextTB.setText("jTextField3");

        jTextUB.setText("jTextField4");

        jTextUK.setText("jTextField5");

        jButtonBaru.setText("TAMBAH BARU");
        jButtonBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaruActionPerformed(evt);
            }
        });

        jButtonSimpan.setText("SIMPAN");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jButtonHapus.setText("HAPUS");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonBatal.setText("BATAL");
        jButtonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalActionPerformed(evt);
            }
        });

        jButtonJH.setText("JUMLAH HARGA");
        jButtonJH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJHActionPerformed(evt);
            }
        });

        jButtonBayar.setText("BAYAR");
        jButtonBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBayarActionPerformed(evt);
            }
        });

        TabelKasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelKasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelKasir);

        jButtonKeluar.setText("KELUAR");
        jButtonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKeluarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("Tambahan");

        ButtonGrup.add(jRadioPlastik);
        jRadioPlastik.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jRadioPlastik.setText("Plastik");
        jRadioPlastik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPlastikActionPerformed(evt);
            }
        });

        ButtonGrup.add(jRadioTB);
        jRadioTB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jRadioTB.setText("Tas");
        jRadioTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTBActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("Pph");

        jCheckBoxPph.setText("10%");

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelNB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelHB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelJB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelTB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelUB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelUK, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBoxNB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextHB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextJB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextTB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextUB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextUK, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonBaru, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonSimpan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonHapus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonBatal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonJH, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonBayar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonKeluar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jRadioPlastik, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jRadioTB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCheckBoxPph, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(83, 83, 83))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addComponent(jLabelNB))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelJB)
                                            .addComponent(jLabelHB)
                                            .addComponent(jLabelTB)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabelUB)
                                            .addComponent(jLabel3)))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabelUK)))
                                .addGap(51, 51, 51)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextUK)
                                    .addComponent(jComboBoxNB, 0, 371, Short.MAX_VALUE)
                                    .addComponent(jTextHB)
                                    .addComponent(jTextJB)
                                    .addComponent(jTextTB)
                                    .addComponent(jTextUB)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addComponent(jRadioPlastik)
                                                .addGap(70, 70, 70)
                                                .addComponent(jRadioTB))
                                            .addComponent(jCheckBoxPph))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(38, 38, 38)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonJH))
                        .addGap(42, 42, 42))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButtonBaru)
                .addGap(55, 55, 55)
                .addComponent(jButtonSimpan)
                .addGap(71, 71, 71)
                .addComponent(jButtonBatal)
                .addGap(60, 60, 60)
                .addComponent(jButtonHapus)
                .addGap(61, 61, 61)
                .addComponent(jButtonKeluar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jButtonBayar))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNB)
                                    .addComponent(jComboBoxNB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelHB))
                            .addComponent(jTextHB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelJB)
                            .addComponent(jTextJB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonJH)
                            .addComponent(jLabelTB)
                            .addComponent(jTextTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jRadioPlastik)
                            .addComponent(jRadioTB))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelUB)
                            .addComponent(jTextUB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jCheckBoxPph))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUK)
                    .addComponent(jTextUK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBaru)
                    .addComponent(jButtonSimpan)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBatal)
                        .addComponent(jButtonHapus)
                        .addComponent(jButtonKeluar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaruActionPerformed
        BersihData();
        jButtonJH.setEnabled(true);
        jComboBoxNB.setEnabled(true);
        jTextHB.setEnabled(true);
        jTextJB.setEnabled(true);
        jRadioPlastik.setEnabled(false);
        jRadioTB.setEnabled(false);
        
       
    }//GEN-LAST:event_jButtonBaruActionPerformed

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        String NamaBarang=jComboBoxNB.getSelectedItem().toString();
        String HargaBarang=jTextHB.getText();
        String JumlahBeli=jTextJB.getText();
        String TotalBayar=jTextTB.getText();
        String UangBayar=jTextUB.getText();
        String UangKembalian=jTextUK.getText();
        
        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);
        
                if (NamaBarang.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama Barang tidak boleh kosong");
            jComboBoxNB.requestFocus();
        }else if (HargaBarang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga Barang tidak boleh kosong");
            jTextHB.requestFocus();
        }else if (JumlahBeli.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Jumlah Barang tidak boleh kosong");
            jTextJB.requestFocus();
        }else if (TotalBayar.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Total Bayar tidak boleh kosong");
            jTextJB.requestFocus();
        }else if (UangBayar.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Uang Bayar tidak boleh kosong");
            jTextUB.requestFocus();
        }else if (UangKembalian.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Uang Kembalian tidak boleh kosong");
            jTextUK.requestFocus();
        }
        else if (!(new Scanner(JumlahBeli).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Jumlah Beli harus angka");
            jTextJB.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into kasir(NamaBarang,HargaBarang,JumlahBeli,TotalBayar,UangBayar,UangKembalian,CreateDate)"+
                    "VALUES('"+NamaBarang+"','"+HargaBarang+"','"+JumlahBeli+"','"+TotalBayar+"','"+UangBayar+"','"+UangKembalian+"','"+CreateDate+"')");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
          jButtonSimpan.setEnabled(false);
          jButtonHapus.setEnabled(false);
          jButtonJH.setEnabled(false);
          jButtonBayar.setEnabled(false); 
          jRadioPlastik.setEnabled(false);
          jRadioTB.setEnabled(false);
          
          SetEditOn();
          setEnabled(true);
          SetEditOff();
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void TabelKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelKasirMouseClicked
       SetEditOn();
        jComboBoxNB.setEnabled(false);
        tblKeForm();
    }//GEN-LAST:event_TabelKasirMouseClicked

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        String NamaBarang=jComboBoxNB.getSelectedItem().toString();
        
        if(NamaBarang.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
            jComboBoxNB.requestFocus();
        } else if(JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ini?", "Informasi", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("delete from kasir where NamaBarang='"+NamaBarang+"'");
                BersihData();
                tampilData();
                
                SetEditOff();
                
                JOptionPane.showMessageDialog(this,"Data berhasil dihapus","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Hapus data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jButtonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalActionPerformed
       BersihData();
        jButtonSimpan.setEnabled(false);
        jButtonBayar.setEnabled(false);
        jButtonHapus.setEnabled(false);
        jButtonJH.setEnabled(false);
        SetEditOff();
    }//GEN-LAST:event_jButtonBatalActionPerformed

    private void jButtonJHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJHActionPerformed
        jTextUB.setEnabled(true);
        jRadioPlastik.setEnabled(true);
        jRadioTB.setEnabled(true);
        
        jButtonBayar.setEnabled(true);
        
        int HargaBarang=Integer.parseInt(jTextHB.getText());
        int JumlahBeli =Integer.parseInt(jTextJB.getText());
        
        bayar = HargaBarang * JumlahBeli;
        jTextTB.setText(""+bayar);
        
        
    }//GEN-LAST:event_jButtonJHActionPerformed

    private void jButtonBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBayarActionPerformed
        int TotalBayar=0, TotalBayar2=0, TotalBayar3;
        TotalBayar = Integer.parseInt(jTextTB.getText());
         if(jCheckBoxPph.isSelected()){
            TotalBayar2 = TotalBayar / 10;
        }else{
             TotalBayar2=0;
         }
         TotalBayar3= TotalBayar + TotalBayar2;
        
        
        int UangBayar =Integer.parseInt(jTextUB.getText());
        
        int UangKembalian = UangBayar - TotalBayar3;
        
        if(UangKembalian <=0){
            JOptionPane.showMessageDialog(null,"Uang Yang Anda Bayarkan Kurang Rp. "+UangKembalian);
            jTextUK.requestFocus();
        }else{
            jTextUK.setText(""+Integer.toString(UangKembalian));
        }
        
        
       jButtonSimpan.setEnabled(true);
        jButtonBatal.setEnabled(true);
    }//GEN-LAST:event_jButtonBayarActionPerformed

    private void jButtonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKeluarActionPerformed
        int answer = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar", "Selesai", JOptionPane.OK_OPTION);
        if (answer == JOptionPane.OK_OPTION){

        dispose();
        }
    }//GEN-LAST:event_jButtonKeluarActionPerformed

    private void jComboBoxNBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNBActionPerformed
        NamaBarang=(String)jComboBoxNB.getSelectedItem();
        
        if(NamaBarang=="Oreo"){
            HargaBarang = 10000;
        }else if(NamaBarang=="Floridina"){
            HargaBarang = 5000;
        }else if(NamaBarang=="Tango"){
            HargaBarang = 8000;
        }else if(NamaBarang=="Beras"){
            HargaBarang = 12500;
        }else if(NamaBarang=="Minyak"){
            HargaBarang = 20000;
        }else if(NamaBarang=="Telor"){
            HargaBarang = 25000;
        }
        
        jTextHB.setText(""+HargaBarang);
    }//GEN-LAST:event_jComboBoxNBActionPerformed

    private void jRadioPlastikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPlastikActionPerformed
        radio();
    }//GEN-LAST:event_jRadioPlastikActionPerformed

    private void jRadioTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTBActionPerformed
        radio();
    }//GEN-LAST:event_jRadioTBActionPerformed

        void tblKeForm(){
        jComboBoxNB.setSelectedItem(tabModel.getValueAt(TabelKasir.getSelectedRow(),0)+"");    
        jTextHB.setText(tabModel.getValueAt(TabelKasir.getSelectedRow(),1)+"");
        jTextJB.setText(tabModel.getValueAt(TabelKasir.getSelectedRow(),2)+"");
        jTextTB.setText(tabModel.getValueAt(TabelKasir.getSelectedRow(),3)+"");
        jTextUB.setText(tabModel.getValueAt(TabelKasir.getSelectedRow(),4)+"");
        jTextUK.setText(tabModel.getValueAt(TabelKasir.getSelectedRow(),5)+"");
        
        
        jButtonBayar.setEnabled(true);
        jButtonHapus.setEnabled(true);
        jButtonBatal.setEnabled(true);
        jButtonJH.setEnabled(true);
        jButtonSimpan.setEnabled(false);
    }
        
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
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButtonGrup;
    private javax.swing.JTable TabelKasir;
    private javax.swing.JButton jButtonBaru;
    private javax.swing.JButton jButtonBatal;
    private javax.swing.JButton jButtonBayar;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonJH;
    private javax.swing.JButton jButtonKeluar;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JCheckBox jCheckBoxPph;
    private javax.swing.JComboBox<String> jComboBoxNB;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelHB;
    private javax.swing.JLabel jLabelJB;
    private javax.swing.JLabel jLabelNB;
    private javax.swing.JLabel jLabelTB;
    private javax.swing.JLabel jLabelUB;
    private javax.swing.JLabel jLabelUK;
    private javax.swing.JRadioButton jRadioPlastik;
    private javax.swing.JRadioButton jRadioTB;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextHB;
    private javax.swing.JTextField jTextJB;
    private javax.swing.JTextField jTextTB;
    private javax.swing.JTextField jTextUB;
    private javax.swing.JTextField jTextUK;
    // End of variables declaration//GEN-END:variables
}
