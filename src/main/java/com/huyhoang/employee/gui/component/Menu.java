package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.event.EventMenuSelected;
import com.huyhoang.swing.graphics.ShadowRenderer;
import com.huyhoang.swing.menu.ListMenu;
import com.huyhoang.swing.model.ModelMenu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class Menu extends JPanel {
    private ListMenu listMenu;
    private PanelTitle panelTitle;
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu.addEventMenuSelected(event);
    }
    public Menu() {
        initComponents();
        buildDisplay();
    }
    
    private void buildDisplay() {
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "5[]0[]0"));
        listMenu = new ListMenu();
        panelTitle = new PanelTitle();
        listMenu.setOpaque(false);
        add(panelTitle, "h 50!");
        add(listMenu);
        init();
    }
    
    private void init() {
        listMenu.addItem(new ModelMenu("1", "Home", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("2", "Tour List", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("", " ", ModelMenu.MenuType.EMPTY));
        listMenu.addItem(new ModelMenu("", " ", ModelMenu.MenuType.SEPARATOR));

        listMenu.addItem(new ModelMenu("", " ", ModelMenu.MenuType.EMPTY));
        listMenu.addItem(new ModelMenu("", "", ModelMenu.MenuType.EMPTY));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(26, 27, 37));
        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    protected void paintComponent(Graphics g) {
        createShadow(g);
        super.paintComponent(g);
    }
    
    private void createShadow(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth() - 6;
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, width, height);
        ShadowRenderer render = new ShadowRenderer(3, 0.15f, Color.BLACK);
        g2.drawImage(render.createShadow(img), 0, 0, null);
        g2.drawImage(img, 0, 0, null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
