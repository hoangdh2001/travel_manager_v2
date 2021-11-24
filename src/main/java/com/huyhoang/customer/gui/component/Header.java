
package com.huyhoang.customer.gui.component;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myTextField1 = new com.huyhoang.swing.textfield.MyTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        myTextField1.setBackgroundColor(new java.awt.Color(255, 255, 255));
        myTextField1.setBorderLine(true);
        myTextField1.setBorderRadius(38);
        myTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myTextField1.setHint("Search tour");
        myTextField1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_25px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.textfield.MyTextField myTextField1;
    // End of variables declaration//GEN-END:variables

}
