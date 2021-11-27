package com.huyhoang.customer.form;

import com.huyhoang.swing.button.ButtonBadges;
import com.huyhoang.swing.button.ToggleButtonBadges;
import com.huyhoang.swing.image.PictureBox;
import com.huyhoang.swing.label.LabelResizingShadow;
import com.huyhoang.swing.panel.LayerPaneGradient;
import com.huyhoang.swing.slideshow.SlideShowTransparent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

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
        createTitle();
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
        slide.start();
        add(slide, "pos 0al 0al n n, w 100%, h 500!");
    }
    
    private void createSession() {
        session = new LayerPaneGradient();
        session.setColor1(new Color(34, 34, 34, 10));
        session.setColor2(new Color(10, 10, 10));
        setLayer(session, JLayeredPane.POPUP_LAYER);
        add(session, "pos 0al 230 n n, w 100%, h 280!");
    }
    
    private void createPaneCenter() {
        pnlCenter = new LayerPaneGradient();
        MigLayout layout2 = new MigLayout("insets 0", "30[]", "20[]");
        pnlCenter.setLayout(layout2);
        
        ButtonBadges  btnDat = new ButtonBadges();
        btnDat.setBackground(new Color(29, 185, 84));
        btnDat.setIcon(new ImageIcon(getClass().getResource("/icon/play_info.png")));
        pnlCenter.add(btnDat, "pos 30 20 n n, w 54!, h 54!");
        
        btnDat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                layout2.setComponentConstraints(btnDat, "pos 27 17 n n, w 60!, h 60!");
                pnlCenter.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                layout2.setComponentConstraints(btnDat, "pos 30 20 n n, w 55!, h 55!");
                pnlCenter.revalidate();
            }
        });
        
        pnlCenter.setColor1(new Color(34, 34, 34, 150));
        setLayer(pnlCenter, POPUP_LAYER);
        
        ToggleButtonBadges btnLike = new ToggleButtonBadges();
        btnLike.setBackground(new Color(0, 0, 0, 0));
        btnLike.setIcon(new ImageIcon(getClass().getResource("/icon/like.png")));
        btnLike.setRolloverIcon(new ImageIcon(getClass().getResource("/icon/like_over.png")));
        btnLike.setSelectedIcon(new ImageIcon(getClass().getResource("/icon/like_selected.png")));
        pnlCenter.add(btnLike, "pos 104 20 n n, w 54!, h 54!");
        
        add(pnlCenter);
    }
    
    private void createTitle() {
        LabelResizingShadow tourName = new LabelResizingShadow();
        tourName.setText("Du lịch Củ Chi - Tây Ninh");
        
        tourName.setFont(new Font("sansserif", Font.BOLD, 30));
        tourName.setForeground(Color.WHITE);
        add(tourName, "pos 20 210 n n, w 450!, h 50!");
        
        LabelResizingShadow diaDanh = new LabelResizingShadow();
        diaDanh.setText("[KHU DI TÍCH ĐỊA ĐẠO - ĐỀN BẾN DƯỢC- CÁP TREO VÂN SƠN TÂY NINH]");
        diaDanh.setFont(new Font("sansserif", Font.BOLD, 30));
        diaDanh.setForeground(Color.WHITE);
        add(diaDanh, "pos 20 240 n n, w 650!, h 60!");
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
