package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.graphics.ShadowRenderer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Header extends javax.swing.JPanel {

    private int xx;
    private int yy;
    
    public Header() {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight() - 2;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(getBackground());
        g2.fillRect(0, 0, width, height);
        g.drawImage(new ShadowRenderer(1, 0.3f, Color.GRAY).createShadow(img), -1, 0, null);
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }

    public void moving(JFrame frame) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                yy = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                frame.setLocation(x - xx - 195, y - yy);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonInfo1 = new com.huyhoang.swing.button.ButtonInfo();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setOpaque(false);

        buttonInfo1.setBorderPainted(false);
        buttonInfo1.setBorderRadius(10);
        buttonInfo1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        buttonInfo1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/avatar.png"))); // NOI18N
        buttonInfo1.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/expand_arrow_15px.png"))); // NOI18N
        buttonInfo1.setTextName("Đỗ Huy Hoàng");
        buttonInfo1.setTextRoll("Quản lý");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(763, Short.MAX_VALUE)
                .addComponent(buttonInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.ButtonInfo buttonInfo1;
    // End of variables declaration//GEN-END:variables
}
