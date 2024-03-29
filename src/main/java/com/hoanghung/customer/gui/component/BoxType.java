package com.hoanghung.customer.gui.component;

import com.hoanghung.model.LoaiChuyenDi;
import java.awt.Color;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class BoxType extends com.hoanghung.swing.panel.PanelTransparent {
    private boolean over;
    private Animator animator;
    private LoaiChuyenDi loaiChuyenDi;
    public BoxType(LoaiChuyenDi loaiChuyenDi) {
        this.loaiChuyenDi = loaiChuyenDi;
        initComponents();
        buildDisplay();
    }
    
    private void buildDisplay() {
        loadData();
        overTransparent();
    }
    
    private void loadData() {
        wrapLabel1.setText(loaiChuyenDi.getTenLoaiChuyen());
        wrapLabel1.repaint();
        wrapLabel1.revalidate();
        setBackground(Color.decode(loaiChuyenDi.getMauLoai()));
        repaint();
        revalidate();
    }
    
    private void overTransparent() {
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (over) {
                    bg.setAlpha(0.2f * fraction);
                } else {
                    bg.setAlpha(0.2f * (1f - fraction));
                }
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

        bg = new com.hoanghung.swing.panel.LayerPaneTransparent();
        wrapLabel1 = new com.hoanghung.swing.label.WrapLabel();

        setBackground(new java.awt.Color(39, 133, 106));
        setBorderRadius(20);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bg.setBorderRadius(20);
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bgMouseExited(evt);
            }
        });

        wrapLabel1.setForeground(new java.awt.Color(255, 255, 255));
        wrapLabel1.setText("Du lịch");
        wrapLabel1.setVAlignStyle(0.0F);
        wrapLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        bg.setLayer(wrapLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wrapLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wrapLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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
        if(animator.isRunning()) {
            animator.stop();
        }
        animator.start();
    }//GEN-LAST:event_bgMouseEntered

    private void bgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseExited
        over= false;
        if(animator.isRunning()) {
            animator.stop();
        }
        animator.start();
    }//GEN-LAST:event_bgMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hoanghung.swing.panel.LayerPaneTransparent bg;
    private com.hoanghung.swing.label.WrapLabel wrapLabel1;
    // End of variables declaration//GEN-END:variables
}
