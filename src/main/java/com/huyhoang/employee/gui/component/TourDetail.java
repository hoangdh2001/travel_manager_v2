package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.panel.PanelShadow;
import com.huyhoang.swing.slideshow.ItemImage;
import javax.swing.ImageIcon;

public class TourDetail extends PanelShadow {
    public TourDetail() {
        initComponents();
        ItemImage img1 = new ItemImage();
        img1.setData(new ImageIcon(getClass().getResource("/icon/Hinh-anh-thien-nhien-dep.jpg")), "Hình ảnh thiên nhiên");
        ItemImage img2 = new ItemImage();
        img2.setData(new ImageIcon(getClass().getResource("/icon/hinh-anh-suy-tu-1.jpg")), "Hình ảnh suy tư");
        ItemImage img3 = new ItemImage();
        img3.setData(new ImageIcon(getClass().getResource("/icon/hình-ảnh-phong-cảnh-đẹp-1024x680.jpg")), "Hình ảnh phong cảnh đẹp");
        
        slideShow1.addCom(img1, img2, img3);
        slideShow1.setAnimate(8);
        add(slideShow1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slideShow1 = new com.huyhoang.swing.slideshow.SlideShow();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setShadowOpacity(0.2F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slideShow1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideShow1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 375, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.slideshow.SlideShow slideShow1;
    // End of variables declaration//GEN-END:variables
}
