package com.huyhoang.customer.form;

import com.huyhoang.swing.image.PictureBox;
import javax.swing.ImageIcon;


public class Home extends javax.swing.JPanel {

    public Home() {
        initComponents();
        buildDisplay();
    }
    
    private void buildDisplay() {
        createSlide();
    }
    
    private void createSlide() {
        PictureBox picture1 = new PictureBox();
        picture1.setImage(new ImageIcon(getClass().getResource("/icon/slide1.jpg")));
        PictureBox picture2 = new PictureBox();
        picture2.setImage(new ImageIcon(getClass().getResource("/icon/slide2.jpeg")));
        PictureBox picture3 = new PictureBox();
        picture3.setImage(new ImageIcon(getClass().getResource("/icon/slide3.jpg")));
        slideShowTransparent1.initSlideshow(picture1, picture2, picture3);
        slideShowTransparent1.showPagination();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slideShowTransparent1 = new com.huyhoang.swing.slideshow.SlideShowTransparent();
        jPanel1 = new javax.swing.JPanel();
        tour1 = new com.huyhoang.customer.gui.component.Tour();
        tour2 = new com.huyhoang.customer.gui.component.Tour();
        tour3 = new com.huyhoang.customer.gui.component.Tour();
        tour4 = new com.huyhoang.customer.gui.component.Tour();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        slideShowTransparent1.setOpaque(false);

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tour1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(tour2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(tour3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tour4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tour4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tour3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tour2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tour1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slideShowTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideShowTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private com.huyhoang.swing.slideshow.SlideShowTransparent slideShowTransparent1;
    private com.huyhoang.customer.gui.component.Tour tour1;
    private com.huyhoang.customer.gui.component.Tour tour2;
    private com.huyhoang.customer.gui.component.Tour tour3;
    private com.huyhoang.customer.gui.component.Tour tour4;
    // End of variables declaration//GEN-END:variables
}
