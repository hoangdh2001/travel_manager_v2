package com.huyhoang.customer.form;

import com.huyhoang.swing.image.PictureBox;
import com.huyhoang.swing.panel.LayerPaneGradient;
import com.huyhoang.swing.slideshow.SlideShowTransparent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;

public class TourInfo extends javax.swing.JLayeredPane {
    private LayerPaneGradient pnlCenter;
    private SlideShowTransparent slide;
    private LayerPaneGradient session;
    
    private MigLayout layout;
    public TourInfo() {
        initComponents();
        builldDisplay();
    }
    
    private void builldDisplay() {
        layout = new MigLayout("fill, insets 0, wrap", "[fill]", "300[fill]");
        setLayout(layout);
        createPaneCenter();
        createSession();
        createSlide();
    }
    
    private void createSlide() {
        slide = new SlideShowTransparent();
        PictureBox picture1 = new PictureBox();
        picture1.setImage(new ImageIcon(getClass().getResource("/icon/slide1.jpg")));
        PictureBox picture2 = new PictureBox();
        picture2.setImage(new ImageIcon(getClass().getResource("/icon/slide2.jpeg")));
        PictureBox picture3 = new PictureBox();
        picture3.setImage(new ImageIcon(getClass().getResource("/icon/slide3.jpg")));
        slide.initSlideshow(picture1, picture2, picture3);
        add(slide, "pos 0al 0al n n, w 100%, h 450!");
    }
    
    private void createSession() {
        session = new LayerPaneGradient();
        session.setColor1(new Color(34, 34, 34, 10));
        session.setColor2(new Color(19, 19, 19));
        setLayer(session, JLayeredPane.POPUP_LAYER);
        add(session, "pos 0al 0al n n, w 100%, h 450!");
    }
    
    private void createPaneCenter() {
        pnlCenter = new LayerPaneGradient();
        pnlCenter.setColor1(new Color(34, 34, 34, 150));
        setLayer(pnlCenter, POPUP_LAYER);
        add(pnlCenter);
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
