package com.huyhoang.customer.gui;

import com.huyhoang.customer.form.Home;
import com.huyhoang.customer.form.Search;
import com.huyhoang.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private int xx;
    private int yy;
    private boolean show;
    private Animator start;

    public Main() {
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        start();
        createMenu();
        createHeader();
        createContent();
    }

    private void createMenu() {
        menu.initMenu((int index) -> {
            if (index == 0) {
                content.showForm(new Home());
            } else if (index == 1) {
                content.showForm(new Search());
            }
        });
        move(menu.getjPanel1(), 0);
    }

    private void createHeader() {
        header.addActionMinimize((ActionEvent arg0) -> {
            setState(JFrame.ICONIFIED);
        });
        header.addActionMaximize((ActionEvent arg0) -> {
            if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                bg.setBackground(new Color(18, 18, 18));
                bg.setBorder(new EmptyBorder(10, 10, 10, 10));
                setExtendedState(JFrame.NORMAL);
            } else {
                bg.setBackground(new Color(0, 0, 0, 0));
                bg.setBorder(new EmptyBorder(0, 0, 40, 0));
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
        header.addActionClose((ActionEvent arg0) -> {
            close();
        });
        move(header, menu.getWidth());
    }

    private void createContent() {
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
        scroll.getViewport().setOpaque(false);
        content.add(new Home());
    }

    private void start() {
        setBackground(new Color(0, 0, 0, 0));
        setOpacity(0);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (!show) {
                    System.exit(0);
                }
            }
        };
        start = new Animator(200, target);
        start.setResolution(0);
        start.setAcceleration(0.5f);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        show = b;
        if (show) {
            start.start();
        }
    }

    private void close() {
        if (start.isRunning()) {
            start.stop();
        }
        show = false;
        start.start();
    }

    private void move(Component com, int o) {
        System.out.println(com.getX());
        com.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                yy = e.getY();
            }
        });
        com.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                if (getExtendedState() == MAXIMIZED_BOTH) {
                    bg.setBackground(new Color(18, 18, 18));
                    bg.setBorder(new EmptyBorder(10, 10, 10, 10));
                    setExtendedState(JFrame.NORMAL);
                    setLocation(x - xx - o, y - yy);
                }
                setLocation(x - xx - o, y - yy);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new com.huyhoang.swing.panel.LayerPaneShadow();
        menu = new com.huyhoang.customer.gui.component.Menu();
        main = new com.huyhoang.swing.panel.LayerPaneGradient();
        header = new com.huyhoang.customer.gui.component.Header();
        scrollPaneCustom1 = new com.huyhoang.swing.scrollbar.ScrollPaneCustom();
        content = new com.huyhoang.customer.gui.component.Content();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bg.setShadowOpacity(0.3F);
        bg.setShadowSize(10);

        header.setOpaque(false);

        scrollPaneCustom1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneCustom1.setViewportView(content);

        main.setLayer(header, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main.setLayer(scrollPaneCustom1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
            .addComponent(scrollPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.setLayer(menu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(main, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.panel.LayerPaneShadow bg;
    private com.huyhoang.customer.gui.component.Content content;
    private com.huyhoang.customer.gui.component.Header header;
    private com.huyhoang.swing.panel.LayerPaneGradient main;
    private com.huyhoang.customer.gui.component.Menu menu;
    private com.huyhoang.swing.scrollbar.ScrollPaneCustom scrollPaneCustom1;
    // End of variables declaration//GEN-END:variables
}
