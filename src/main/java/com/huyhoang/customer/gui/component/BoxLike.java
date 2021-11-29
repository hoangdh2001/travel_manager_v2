package com.huyhoang.customer.gui.component;

import com.huyhoang.swing.button.ButtonTransparent;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class BoxLike extends javax.swing.JPanel {
    
    private boolean over;
    private MigLayout layout;
    private Animator animator;
    private ButtonTransparent buttonTransparent;
    
    public BoxLike() {
        initComponents();
        buildDisplay();
    }
    
    private void buildDisplay() {
        overTransparent();
        createBg();
    }
    
    private void createBg() {
        layout = new MigLayout("fillx, insets 0, wrap", "[fill]push[fill]");
        bg.setLayout(layout);
    }
    
    private void overTransparent() {
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double point;
                if (over) {
                    buttonTransparent.setAlpha(fraction);
                    point = 130 + (10 * (1f - fraction));
                } else {
                    buttonTransparent.setAlpha(1f - fraction);
                    point = 130 + (10 * fraction);
                }
                layout.setComponentConstraints(buttonTransparent, "pos 0.85al " + point + " n n, w 40!, h 40!");
                bg.revalidate();
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new com.huyhoang.swing.panel.LayerPaneGradient2();

        setOpaque(false);

        bg.setBorderRadius(20);
        bg.setColor1(new java.awt.Color(71, 14, 244));
        bg.setColor2(new java.awt.Color(134, 127, 231));
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bgMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
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
    }//GEN-LAST:event_bgMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.panel.LayerPaneGradient2 bg;
    // End of variables declaration//GEN-END:variables
}
