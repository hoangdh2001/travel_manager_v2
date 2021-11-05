package com.huyhoang.swing.table;

public class CellMore extends javax.swing.JPanel {

    public CellMore() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new com.huyhoang.swing.button.Button();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 5, 5));
        setOpaque(false);

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/more_20px.png"))); // NOI18N
        button1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.Button button1;
    // End of variables declaration//GEN-END:variables
}
