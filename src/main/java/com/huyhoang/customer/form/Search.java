package com.huyhoang.customer.form;

import com.huyhoang.customer.gui.component.BoxType;

public class Search extends javax.swing.JPanel {

    public Search() {
        initComponents();
        buildDisplay();
    }
    
    private void buildDisplay() {
        createMap();
    }
    
    private void createMap() {
        for (int i = 0; i < 3; i++) {
            BoxType boxType = new BoxType();
            map1.addBox(boxType, 200, 200);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        map1 = new com.huyhoang.customer.gui.component.Map();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(57, 20, 0, 20));
        setOpaque(false);

        map1.setTitle("Duyệt tìm tất cả");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(map1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(map1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.customer.gui.component.Map map1;
    // End of variables declaration//GEN-END:variables
}
