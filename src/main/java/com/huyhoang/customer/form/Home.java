package com.huyhoang.customer.form;

import com.huyhoang.swing.image.PictureBox;
import javax.swing.ImageIcon;
import com.huyhoang.customer.gui.component.BoxTour;
import com.huyhoang.swing.event.EventTour;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends javax.swing.JPanel {

    private EventTour event;

    public void addEventTour(EventTour event) {
        this.event = event;
    }

    public Home() {
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        createSlide();
        createMapTour();
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
        slideShowTransparent1.start();
    }

    private void createMapTour() {
        for (int i = 0; i < 8; i++) {
            BoxTour boxTour = new BoxTour();
            boxTour.addEventBoxTour(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    event.openTour();
                    boxTour.refresh();
                }
            });
            mapTour1.addBox(boxTour, 200, 280);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mapTour1 = new com.huyhoang.customer.gui.component.Map();
        slideShowTransparent1 = new com.huyhoang.swing.slideshow.SlideShowTransparent();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(57, 20, 0, 20));
        setOpaque(false);

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapTour1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(mapTour1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        slideShowTransparent1.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slideShowTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideShowTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private com.huyhoang.customer.gui.component.Map mapTour1;
    private com.huyhoang.swing.slideshow.SlideShowTransparent slideShowTransparent1;
    // End of variables declaration//GEN-END:variables
}
