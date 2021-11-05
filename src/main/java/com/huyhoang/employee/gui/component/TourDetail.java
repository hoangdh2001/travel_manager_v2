package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.panel.PanelShadow;
import com.huyhoang.swing.slideshow.ItemImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

public class TourDetail extends PanelShadow {
    public TourDetail() {
        initComponents();
        buildDisplay();
    }
    
    private void buildDisplay() {
        initData();
    }
    
    private void initData() {
        ItemImage img1 = new ItemImage();
        img1.setData(new ImageIcon(getClass().getResource("/icon/Hinh-anh-thien-nhien-dep.jpg")), "Hình ảnh thiên nhiên");
        ItemImage img2 = new ItemImage();
        img2.setData(new ImageIcon(getClass().getResource("/icon/hinh-anh-suy-tu-1.jpg")), "Hình ảnh suy tư");
        ItemImage img3 = new ItemImage();
        img3.setData(new ImageIcon(getClass().getResource("/icon/hình-ảnh-phong-cảnh-đẹp-1024x680.jpg")), "Hình ảnh phong cảnh đẹp");
        
        slideShow.addCom(img1, img2, img3);
        slideShow.setAnimate(15);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slideShow = new com.huyhoang.swing.slideshow.SlideShow();
        lblNameTour = new javax.swing.JLabel();
        buttonBadges1 = new com.huyhoang.swing.button.ButtonBadges();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setShadowSize(3);

        lblNameTour.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblNameTour.setText("Peruvian Hightlights");

        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/info_20px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblNameTour, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(206, 206, 206)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(slideShow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideShow, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNameTour)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(471, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.ButtonBadges buttonBadges1;
    private javax.swing.JLabel lblNameTour;
    private com.huyhoang.swing.slideshow.SlideShow slideShow;
    // End of variables declaration//GEN-END:variables
}
