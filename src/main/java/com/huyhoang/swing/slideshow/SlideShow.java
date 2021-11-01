package com.huyhoang.swing.slideshow;

import java.awt.Component;

public class SlideShow extends javax.swing.JPanel {
    private int numCom = 0;

    public SlideShow() {
        initComponents();
    }
    
    public void addCom(Component... com) {
        panelSlide.init(com);
    }
    
    public void setAnimate(int animate) {
        panelSlide.setAnimate(animate);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSlide = new com.huyhoang.swing.slideshow.PanelSlide();
        buttonSlide1 = new com.huyhoang.swing.slideshow.ButtonSlide();
        buttonSlide2 = new com.huyhoang.swing.slideshow.ButtonSlide();

        buttonSlide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_back_50px_1.png"))); // NOI18N
        buttonSlide1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSlide1ActionPerformed(evt);
            }
        });

        buttonSlide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_back_50px.png"))); // NOI18N
        buttonSlide2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSlide2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSlideLayout = new javax.swing.GroupLayout(panelSlide);
        panelSlide.setLayout(panelSlideLayout);
        panelSlideLayout.setHorizontalGroup(
            panelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSlideLayout.createSequentialGroup()
                .addComponent(buttonSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 459, Short.MAX_VALUE)
                .addComponent(buttonSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSlideLayout.setVerticalGroup(
            panelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonSlide1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
            .addComponent(buttonSlide2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSlide1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSlide1ActionPerformed
        numCom++;
        if (numCom < panelSlide.getCount()) {
            panelSlide.setAnimateRight(false);
            panelSlide.show(numCom);
        } else {
            numCom = 0;
            panelSlide.setAnimateRight(false);
            panelSlide.show(numCom);
        }
    }//GEN-LAST:event_buttonSlide1ActionPerformed

    private void buttonSlide2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSlide2ActionPerformed
        numCom--;
        if (numCom >= 0) {
            panelSlide.setAnimateRight(true);
            panelSlide.show(numCom);

        } else {
            panelSlide.setAnimateRight(true);
            numCom = panelSlide.getCount() - 1;
            panelSlide.show(numCom);
        }
    }//GEN-LAST:event_buttonSlide2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.slideshow.ButtonSlide buttonSlide1;
    private com.huyhoang.swing.slideshow.ButtonSlide buttonSlide2;
    private com.huyhoang.swing.slideshow.PanelSlide panelSlide;
    // End of variables declaration//GEN-END:variables
}
