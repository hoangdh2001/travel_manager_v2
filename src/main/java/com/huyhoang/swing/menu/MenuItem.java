package com.huyhoang.swing.menu;

import com.huyhoang.swing.model.ModelMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

public class MenuItem extends javax.swing.JPanel {

    private boolean selected;
    private boolean hover;

    public MenuItem(ModelMenu menu) {
        initComponents();
        setOpaque(false);
        if (menu.getMenuType() == ModelMenu.MenuType.MENU) {
            lbIcon.setIcon(menu.toIcon());
            lbName.setText(menu.getName());
        } else if (menu.getMenuType() == ModelMenu.MenuType.TITLE) {
            lbIcon.setText(menu.getName());
            lbIcon.setFont(new Font("sansserif", 1, 12));
            lbName.setVisible(false);
        } else if(menu.getMenuType() == ModelMenu.MenuType.SEPARATOR) {
           lbIcon.setIcon(new ImageIcon(getClass().getResource("/icon/seperator.png")));
           lbName.setVisible(false);
        }
        else {
            lbName.setText(" ");
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public void setHover(boolean hover) {
        this.hover = hover;
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        lbName.setForeground(new java.awt.Color(204, 204, 204));
        lbName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addComponent(lbName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (selected || hover) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected) {
                g2.setColor(new Color(0, 0, 0, 0.3f));
            } else {
                g2.setColor(new Color(0, 0, 0, 0.1f));
            }
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
        }
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
