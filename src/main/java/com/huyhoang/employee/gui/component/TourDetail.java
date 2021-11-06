package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.image.PictureBox;
import com.huyhoang.swing.panel.PanelShadow;
import javax.swing.ImageIcon;

public class TourDetail extends PanelShadow {

    public TourDetail() {
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        PictureBox pic1 = new PictureBox();
        pic1.setImage(new ImageIcon(getClass().getResource("/icon/Hinh-anh-thien-nhien-dep.jpg")));
        PictureBox pic2 = new PictureBox();
        pic2.setImage(new ImageIcon(getClass().getResource("/icon/hinh-anh-suy-tu-1.jpg")));
        PictureBox pic3 = new PictureBox();
        pic3.setImage(new ImageIcon(getClass().getResource("/icon/hình-ảnh-phong-cảnh-đẹp-1024x680.jpg")));
        slideShow.initSlideshow(pic1, pic2, pic3);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slideShow = new com.huyhoang.swing.slideshow.Slideshow();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setShadowSize(3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slideShow, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideShow, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.slideshow.Slideshow slideShow;
    // End of variables declaration//GEN-END:variables
}
