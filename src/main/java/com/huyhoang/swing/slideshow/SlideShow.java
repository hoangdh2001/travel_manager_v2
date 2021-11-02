package com.huyhoang.swing.slideshow;

import com.huyhoang.swing.radio.MyRadioButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class SlideShow extends javax.swing.JPanel {

    private int numCom = 0;
    private Timer timer;
    private List<MyRadioButton> list;

    public SlideShow() {
        list = new ArrayList<>();
        initComponents();
        createRadioButton();
        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                numCom++;
                if (numCom < panelSlide.getCount()) {
                    panelSlide.setAnimateRight(false);
                    panelSlide.show(numCom);
                    list.get(numCom).setSelected(true);
                } else {
                    numCom = 0;
                    panelSlide.setAnimateRight(false);
                    panelSlide.show(numCom);
                    if(!list.isEmpty())
                        list.get(numCom).setSelected(true);
                }
            }
        });
        timer.start();

    }

    public void addCom(Component... com) {
        panelSlide.init(com);
    }

    public void setAnimate(int animate) {
        panelSlide.setAnimate(animate);
    }

    private void createRadioButton() {
        addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent arg0) {
                if (panelSlide.getCount() >= 2) {
                    ButtonGroup group = new ButtonGroup();
                    for (int i = 0; i < panelSlide.getCount(); i++) {
                        MyRadioButton item = new MyRadioButton();
                        if(i == 0)
                            item.setSelected(true);
                        item.setDotColor(Color.WHITE);
                        item.setIndex(i);
                        item.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                if (timer.isRunning()) {
                                    timer.stop();
                                    if (item.getIndex() > numCom) {
                                        panelSlide.setAnimateRight(false);
                                        panelSlide.show(item.getIndex());
                                    } else {
                                        panelSlide.setAnimateRight(true);
                                        panelSlide.show(item.getIndex());
                                    }
                                    numCom = item.getIndex();
                                    timer.start();
                                }
                            }
                        });
                        group.add(item);
                        pnlRaidoBtn.add(item);
                        list.add(item);
                    }
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent arg0) {
            }

            @Override
            public void ancestorMoved(AncestorEvent arg0) {
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSlide = new com.huyhoang.swing.slideshow.PanelSlide();
        buttonSlide1 = new com.huyhoang.swing.slideshow.ButtonSlide();
        buttonSlide2 = new com.huyhoang.swing.slideshow.ButtonSlide();
        pnlRaidoBtn = new javax.swing.JPanel();

        buttonSlide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next.png"))); // NOI18N
        buttonSlide1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSlide1ActionPerformed(evt);
            }
        });

        buttonSlide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pre.png"))); // NOI18N
        buttonSlide2.setRight(false);
        buttonSlide2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSlide2ActionPerformed(evt);
            }
        });

        pnlRaidoBtn.setOpaque(false);

        javax.swing.GroupLayout panelSlideLayout = new javax.swing.GroupLayout(panelSlide);
        panelSlide.setLayout(panelSlideLayout);
        panelSlideLayout.setHorizontalGroup(
            panelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSlideLayout.createSequentialGroup()
                .addComponent(buttonSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRaidoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSlideLayout.setVerticalGroup(
            panelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonSlide1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonSlide2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSlideLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlRaidoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSlide1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSlide1ActionPerformed
        if (timer.isRunning()) {
            timer.stop();
            numCom++;
            if (numCom < panelSlide.getCount()) {
                panelSlide.setAnimateRight(false);
                panelSlide.show(numCom);
            } else {
                numCom = 0;
                panelSlide.setAnimateRight(false);
                panelSlide.show(numCom);
            }
            list.get(numCom).setSelected(true);
            timer.start();
        }
    }//GEN-LAST:event_buttonSlide1ActionPerformed

    private void buttonSlide2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSlide2ActionPerformed
        if (timer.isRunning()) {
            timer.stop();
            numCom--;
            if (numCom >= 0) {
                panelSlide.setAnimateRight(true);
                panelSlide.show(numCom);

            } else {
                panelSlide.setAnimateRight(true);
                numCom = panelSlide.getCount() - 1;
                panelSlide.show(numCom);
            }
            list.get(numCom).setSelected(true);
            timer.start();
        }
    }//GEN-LAST:event_buttonSlide2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.slideshow.ButtonSlide buttonSlide1;
    private com.huyhoang.swing.slideshow.ButtonSlide buttonSlide2;
    private com.huyhoang.swing.slideshow.PanelSlide panelSlide;
    private javax.swing.JPanel pnlRaidoBtn;
    // End of variables declaration//GEN-END:variables
}
