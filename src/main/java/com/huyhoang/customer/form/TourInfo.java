package com.huyhoang.customer.form;

import com.huyhoang.swing.image.PictureBox;
import com.huyhoang.swing.panel.LayerPaneGradient;
import com.huyhoang.swing.slideshow.SlideShowTransparent;
import java.awt.Color;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class TourInfo extends javax.swing.JLayeredPane {
    private SlideShowTransparent slide;
    private LayerPaneGradient pnlCenter;
    private LayerPaneGradient bg;
    private MigLayout layout;
    public TourInfo() {
        initComponents();
        builldDisplay();
    }
    
    private void builldDisplay() {
        layout = new MigLayout("fill, insets 0, wrap", "[fill]", "300[fill]");
        setLayout(layout);
        createBG();
        createPaneCenter();
//        createSlide();
    }
    
    private void createBG() {
        bg = new LayerPaneGradient();
        bg.setColor1(new Color(180, 75, 59));
        add(bg, "pos 0al 0al n n, w 100%, h 600!");
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
        slide.start();
        add(slide, "pos 0al 0al n n, w 100%, h 400!");
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
