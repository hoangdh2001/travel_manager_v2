package com.huyhoang.swing.table;

import com.huyhoang.model.TrangThaiChuyenDi;
import com.huyhoang.model.TrangThaiDonDat;

public class CellStatus extends javax.swing.JPanel {

    public CellStatus(Object o) {
        initComponents();
        if (o instanceof TrangThaiChuyenDi) {
            TrangThaiChuyenDi trangThai = (TrangThaiChuyenDi) o;
            lblStatus.setText(trangThai.getTrangThai());
//            lblStatus.setColorStatus(trangThai.getMauTrangThai());
            lblStatus.setForeground(trangThai.getMauTrangThai());
        } else if (o instanceof TrangThaiDonDat) {
            TrangThaiDonDat trangThai = (TrangThaiDonDat) o;
            lblStatus.setText(trangThai.getTrangThai());
//            lblStatus.setColorStatus(trangThai.getMauTrangThai());
            lblStatus.setForeground(trangThai.getMauTrangThai());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStatus = new com.huyhoang.swing.table.LabelStatus3();

        setOpaque(false);

        lblStatus.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.table.LabelStatus3 lblStatus;
    // End of variables declaration//GEN-END:variables
}
