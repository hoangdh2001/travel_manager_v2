package com.huyhoang.employee.gui.form;

import com.huyhoang.swing.slideshow.BackgroundImage;
import com.huyhoang.swing.slideshow.SlideShow;
import javax.swing.ImageIcon;

public class Form2 extends javax.swing.JPanel {

    public Form2() {
        initComponents();
        slideShow = new SlideShow();
        BackgroundImage img1 = new BackgroundImage(new ImageIcon("/icon/hinh-anh-suy-tu-1.jpg"));
        BackgroundImage img2 = new BackgroundImage(new ImageIcon("/icon/hình-ảnh-phong-cảnh-đẹp-1024x680.jpg"));
        BackgroundImage img3 = new BackgroundImage(new ImageIcon("/icon/Hinh-anh-thien-nhien-dep.jpg"));
        BackgroundImage img4 = new BackgroundImage(new ImageIcon("/icon/a1_6.jpg"));
        slideShow.addCom(img1, img2, img3, img4);
        slideShow.setAnimate(5);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slideShow = new com.huyhoang.swing.slideshow.SlideShow();

        setBackground(new java.awt.Color(204, 204, 0));
        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addComponent(slideShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(slideShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.slideshow.SlideShow slideShow;
    // End of variables declaration//GEN-END:variables
}
