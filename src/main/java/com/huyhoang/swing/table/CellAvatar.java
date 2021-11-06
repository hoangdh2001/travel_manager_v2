package com.huyhoang.swing.table;

import javax.swing.Icon;

public class CellAvatar extends javax.swing.JPanel {

    public CellAvatar(Icon icon) {
        initComponents();
        imageAvatar1.setIcon(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.huyhoang.swing.image.ImageAvatar();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.image.ImageAvatar imageAvatar1;
    // End of variables declaration//GEN-END:variables
}
