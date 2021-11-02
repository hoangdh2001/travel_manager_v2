package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.panel.PanelShadow;
import com.huyhoang.swing.slideshow.ItemImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
        slideShow.setAnimate(10);
    }
    
    private void createPnlTourDetail() {
        pnlTouDetail.setLayout(new MigLayout("fill, insets 0", "[][]", "10[]10"));
        JLabel tourName = new JLabel();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slideShow = new com.huyhoang.swing.slideshow.SlideShow();
        pnlTouDetail = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setShadowSize(3);

        pnlTouDetail.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlTouDetailLayout = new javax.swing.GroupLayout(pnlTouDetail);
        pnlTouDetail.setLayout(pnlTouDetailLayout);
        pnlTouDetailLayout.setHorizontalGroup(
            pnlTouDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTouDetailLayout.setVerticalGroup(
            pnlTouDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slideShow, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
            .addComponent(pnlTouDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideShow, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlTouDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlTouDetail;
    private com.huyhoang.swing.slideshow.SlideShow slideShow;
    // End of variables declaration//GEN-END:variables
}
