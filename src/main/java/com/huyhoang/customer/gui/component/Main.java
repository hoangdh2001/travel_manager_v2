package com.huyhoang.customer.gui.component;

import com.huyhoang.swing.scrollbar.ScrollPaneCustom;

public class Main extends javax.swing.JLayeredPane {

    public Content getContent() {
        return content;
    }

    public Header getHeader() {
        return header;
    }

    public ScrollPaneCustom getScrollPaneCustom1() {
        return scrollPaneCustom1;
    }
    
    public Main() {
        initComponents();
        bg2.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg3 = new javax.swing.JPanel();
        header = new com.huyhoang.customer.gui.component.Header();
        bg2 = new com.huyhoang.swing.panel.LayerPaneGradient();
        scrollPaneCustom1 = new com.huyhoang.swing.scrollbar.ScrollPaneCustom();
        content = new com.huyhoang.customer.gui.component.Content();

        setLayout(new java.awt.CardLayout());

        bg3.setOpaque(false);

        javax.swing.GroupLayout bg3Layout = new javax.swing.GroupLayout(bg3);
        bg3.setLayout(bg3Layout);
        bg3Layout.setHorizontalGroup(
            bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
        bg3Layout.setVerticalGroup(
            bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg3Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(649, Short.MAX_VALUE))
        );

        setLayer(bg3, javax.swing.JLayeredPane.POPUP_LAYER);
        add(bg3, "card4");

        bg2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bg2.setLayout(new java.awt.BorderLayout());

        scrollPaneCustom1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneCustom1.setViewportView(content);

        bg2.add(scrollPaneCustom1, java.awt.BorderLayout.CENTER);

        add(bg2, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.panel.LayerPaneGradient bg2;
    private javax.swing.JPanel bg3;
    private com.huyhoang.customer.gui.component.Content content;
    private com.huyhoang.customer.gui.component.Header header;
    private com.huyhoang.swing.scrollbar.ScrollPaneCustom scrollPaneCustom1;
    // End of variables declaration//GEN-END:variables
}
