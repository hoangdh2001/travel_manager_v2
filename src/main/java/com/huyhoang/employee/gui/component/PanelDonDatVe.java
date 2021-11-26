/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.employee.gui.component;

import java.awt.Color;

/**
 *
 * @author NGUYE
 */
public class PanelDonDatVe extends javax.swing.JPanel {

    public PanelDonDatVe() {
        initComponents();
        setPropertiesForm();
    }
    
    private void setPropertiesForm() {
        int txtRadius = 10;
        int cmbRadius = 10;
        int btnRadius = 10;
        Color colorBtn = new Color(184, 238, 241);
        
        txtTimKiem.setBorderLine(true);
        txtTimKiem.setBorderRadius(txtRadius);

        cmbChonCot.addItem("Tên khách hàng");
        cmbChonCot.addItem("Mã khách hàng");
        cmbChonCot.addItem("Số điện thoại");
        cmbChonCot.addItem("Căn cước công dân");
        cmbChonCot.addItem("Email");
        
        cmbTrangThai.addItem("Trang thai 1");
        cmbTrangThai.addItem("Trang thai 2");
        
        cmbNhanVien.addItem("Nhan vien 1");
        cmbNhanVien.addItem("Nhan vien 2");
        
        btnThem.setBackground(colorBtn);
        
        cmbSoTrang.addItem("1");
        cmbSoTrang.addItem("2");
        cmbSoTrang.addItem("3");
        cmbSoTrang.addItem("4");
                
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new com.huyhoang.swing.panel.PanelShadow();
        txtTimKiem = new com.huyhoang.swing.textfield.MyTextField();
        cmbChonCot = new javax.swing.JComboBox<>();
        cmbTrangThai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        cmbNhanVien = new javax.swing.JComboBox<>();
        jdcNgayDat = new com.toedter.calendar.JDateChooser();
        pnlCenter = new com.huyhoang.swing.panel.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTour = new com.huyhoang.swing.table2.MyTable();
        pnlPhanTrang = new javax.swing.JPanel();
        lblTrang = new javax.swing.JLabel();
        cmbSoTrang = new javax.swing.JComboBox<>();
        btnTruoc = new javax.swing.JButton();
        btnSau = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiem.setText("Tìm kiếm");
        txtTimKiem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        cmbChonCot.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmbChonCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbChonCotActionPerformed(evt);
            }
        });

        cmbTrangThai.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTrangThaiActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(204, 255, 204));
        btnThem.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 0, 0));
        btnThem.setText("Thêm");

        cmbNhanVien.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmbNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbChonCot, 0, 127, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jdcNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cmbTrangThai, 0, 127, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cmbNhanVien, 0, 127, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jdcNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTopLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbChonCot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));

        tblTour.setBackground(new java.awt.Color(255, 255, 255));
        tblTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "1", null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Mã đơn đặt", "Khách hàng", "Ngày đặt", "Số lượng", "Trạng thái", "Chuyến đi", "Nhân viên", "Hướng dẫn viên", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTour.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(tblTour);

        pnlPhanTrang.setBackground(new java.awt.Color(255, 255, 255));

        lblTrang.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblTrang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrang.setText("Trang");

        cmbSoTrang.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        btnTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/double_left.png"))); // NOI18N

        btnSau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/double_right.png"))); // NOI18N
        btnSau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("1");

        javax.swing.GroupLayout pnlPhanTrangLayout = new javax.swing.GroupLayout(pnlPhanTrang);
        pnlPhanTrang.setLayout(pnlPhanTrangLayout);
        pnlPhanTrangLayout.setHorizontalGroup(
            pnlPhanTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhanTrangLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTruoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSau)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        pnlPhanTrangLayout.setVerticalGroup(
            pnlPhanTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhanTrangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPhanTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPhanTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSau, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlPhanTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(674, Short.MAX_VALUE))
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPhanTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbChonCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbChonCotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbChonCotActionPerformed

    private void cmbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTrangThaiActionPerformed

    private void cmbNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSau;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTruoc;
    private javax.swing.JComboBox<String> cmbChonCot;
    private javax.swing.JComboBox<String> cmbNhanVien;
    private javax.swing.JComboBox<String> cmbSoTrang;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JDateChooser jdcNgayDat;
    private javax.swing.JLabel lblTrang;
    private com.huyhoang.swing.panel.PanelShadow pnlCenter;
    private javax.swing.JPanel pnlPhanTrang;
    private com.huyhoang.swing.panel.PanelShadow pnlTop;
    private com.huyhoang.swing.table2.MyTable tblTour;
    private com.huyhoang.swing.textfield.MyTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
