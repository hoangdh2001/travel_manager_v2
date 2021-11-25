package com.huyhoang.customer.gui.component;

import com.huyhoang.swing.image.PictureBox;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class BoxTour extends com.huyhoang.swing.panel.PanelTransparent {

    private boolean over;
    private Animator animator;

    public BoxTour() {
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        overTransparent();
        createSlide();
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
                    panelTransparent1.setAlpha(0.1f * fraction);
                } else {
                    panelTransparent1.setAlpha(0.1f * (1f - fraction));
                }

            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }

    private void createSlide() {
        PictureBox picture1 = new PictureBox();
        picture1.setImage(new ImageIcon(getClass().getResource("/icon/slide1.jpg")));
        PictureBox picture2 = new PictureBox();
        picture2.setImage(new ImageIcon(getClass().getResource("/icon/slide2.jpeg")));
        PictureBox picture3 = new PictureBox();
        picture3.setImage(new ImageIcon(getClass().getResource("/icon/slide3.jpg")));
        slideShowTransparent1.initSlideshow(picture1, picture2, picture3);
        slideShowTransparent1.setDuration(1500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new com.huyhoang.swing.panel.PanelTransparent();
        jLabel1 = new javax.swing.JLabel();
        slideShowTransparent1 = new com.huyhoang.swing.slideshow.SlideShowTransparent();

        setBackground(new java.awt.Color(30, 30, 30));
        setAlpha(1.0F);

        panelTransparent1.setBackground(new java.awt.Color(255, 255, 255));
        panelTransparent1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelTransparent1.setBorderRadius(10);
        panelTransparent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelTransparent1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelTransparent1MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Du lịch vùng tây bắc");

        slideShowTransparent1.setOpaque(false);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 71, Short.MAX_VALUE))
            .addComponent(slideShowTransparent1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addComponent(slideShowTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelTransparent1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTransparent1MouseEntered
        over = true;
        if (animator.isRunning()) {
            animator.stop();
        }
        animator.start();
    }//GEN-LAST:event_panelTransparent1MouseEntered

    private void panelTransparent1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTransparent1MouseExited
        over = false;
        if (animator.isRunning()) {
            animator.stop();
        }
        animator.start();
        slideShowTransparent1.select(0);
        slideShowTransparent1.stop();
    }//GEN-LAST:event_panelTransparent1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.huyhoang.swing.panel.PanelTransparent panelTransparent1;
    private com.huyhoang.swing.slideshow.SlideShowTransparent slideShowTransparent1;
    // End of variables declaration//GEN-END:variables
}
