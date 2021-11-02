package com.huyhoang.swing.slideshow;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ItemImage extends javax.swing.JPanel {
    
    private Icon icon;
    
    public ItemImage() {
        setOpaque(false);
        initComponents();
    }

    public void setData(Icon icon, String name) {
        this.icon = icon;
        lblName.setText(name);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (icon != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Rectangle size = getAutoSize(icon);
            g2.drawImage(toImage(icon), size.x, size.y, size.width, size.height, this);
        }
        super.paintComponent(g);
    }

    private Rectangle getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new com.huyhoang.swing.label.TextEffect();

        setBackground(new java.awt.Color(255, 51, 102));
        setOpaque(false);

        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name");
        lblName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblName.setShadowColor(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.label.TextEffect lblName;
    // End of variables declaration//GEN-END:variables
}
