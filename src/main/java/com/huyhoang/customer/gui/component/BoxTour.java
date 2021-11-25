package com.huyhoang.customer.gui.component;

import com.huyhoang.swing.image.PictureBox;
import com.huyhoang.swing.slideshow.SlideShowTransparent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class BoxTour extends com.huyhoang.swing.panel.PanelTransparent {

    private boolean over;
    private MigLayout layout;
    private Animator animator;
    private SlideShowTransparent slideShowTransparent1;

    public BoxTour() {
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        createBg();
        overTransparent();
        createSlide();
    }
    
    private void createBg() {
        layout = new MigLayout("fill, insets 0, wrap", "[fill]", "[fill]");
        bg.setLayout(layout);
    }

    private void overTransparent() {
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (over) {
                    slideShowTransparent1.start();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                if (over) {
                    bg.setAlpha(0.1f * fraction);
                } else {
                    bg.setAlpha(0.1f * (1f - fraction));
                }

            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }

    private void createSlide() {
        slideShowTransparent1 = new SlideShowTransparent();
        PictureBox picture1 = new PictureBox();
        picture1.setImage(new ImageIcon(getClass().getResource("/icon/slide1.jpg")));
        PictureBox picture2 = new PictureBox();
        picture2.setImage(new ImageIcon(getClass().getResource("/icon/slide2.jpeg")));
        PictureBox picture3 = new PictureBox();
        picture3.setImage(new ImageIcon(getClass().getResource("/icon/slide3.jpg")));
        slideShowTransparent1.initSlideshow(picture1, picture2, picture3);
        slideShowTransparent1.setDuration(1500);
        bg.add(slideShowTransparent1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new com.huyhoang.swing.panel.PanelTransparent();

        setBackground(new java.awt.Color(30, 30, 30));
        setAlpha(1.0F);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bg.setBorderRadius(10);
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bgMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseEntered
        over = true;
        if (animator.isRunning()) {
            animator.stop();
        }
        animator.start();
    }//GEN-LAST:event_bgMouseEntered

    private void bgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseExited
        over = false;
        if (animator.isRunning()) {
            animator.stop();
        }
        animator.start();
        slideShowTransparent1.select(0);
        slideShowTransparent1.stop();
    }//GEN-LAST:event_bgMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.panel.PanelTransparent bg;
    // End of variables declaration//GEN-END:variables
}
