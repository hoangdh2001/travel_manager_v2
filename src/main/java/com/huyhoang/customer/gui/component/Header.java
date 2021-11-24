
package com.huyhoang.customer.gui.component;

import java.awt.event.ActionListener;

public class Header extends javax.swing.JPanel {
    
    public Header() {
        initComponents();
    }
    
    public void addActionMinimize(ActionListener evt) {
        btnMi.addActionListener(evt);
    }
    
    public void addActionMaximize(ActionListener evt) {
        btnRe.addActionListener(evt);
    }
    
    public void addActionClose(ActionListener evt) {
        btnClose.addActionListener(evt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myTextField1 = new com.huyhoang.swing.textfield.MyTextField();
        jPanel1 = new javax.swing.JPanel();
        btnMi = new com.huyhoang.swing.button.Button();
        btnClose = new com.huyhoang.swing.button.Button();
        btnRe = new com.huyhoang.swing.button.Button();

        setBackground(new java.awt.Color(18, 18, 18));

        myTextField1.setBackgroundColor(new java.awt.Color(255, 255, 255));
        myTextField1.setBorderLine(true);
        myTextField1.setBorderRadius(38);
        myTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myTextField1.setHint("Search tour");
        myTextField1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_25px.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(19, 19, 19));

        btnMi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mi.png"))); // NOI18N
        btnMi.setToolTipText("");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        btnClose.setToolTipText("");
        btnClose.setOverColor(new java.awt.Color(205, 26, 43));

        btnRe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/max.png"))); // NOI18N
        btnRe.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnMi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnRe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.Button btnClose;
    private com.huyhoang.swing.button.Button btnMi;
    private com.huyhoang.swing.button.Button btnRe;
    private javax.swing.JPanel jPanel1;
    private com.huyhoang.swing.textfield.MyTextField myTextField1;
    // End of variables declaration//GEN-END:variables

}
