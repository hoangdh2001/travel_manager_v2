package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.panel.PanelShadow;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import net.miginfocom.swing.MigLayout;

public class TabHidden extends PanelShadow {
    
    private MigLayout layout;
    private boolean tabShow;

    public boolean isTabShow() {
        return tabShow;
    }

    public void setTabShow(boolean tabShow) {
        this.tabShow = tabShow;
    }
    
    public void addAction(ActionListener evt) {
        btnClose.addActionListener(evt);
    }
    
    public TabHidden() {
        initComponents();
        btnClose.setMnemonic(KeyEvent.VK_X);
        
//        layout = new MigLayout("fill, insets 0", "[fill]", "50[fill]");
//        setLayout(layout);
        
//        add(btnClose, "pos 0al 0al");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose = new javax.swing.JButton();
        tourDetail1 = new com.huyhoang.employee.gui.component.TourDetail();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 1));
        setShadowOpacity(0.2F);
        setShadowSize(2);

        btnClose.setText("Close");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnClose)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(tourDetail1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tourDetail1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private com.huyhoang.employee.gui.component.TourDetail tourDetail1;
    // End of variables declaration//GEN-END:variables
}
