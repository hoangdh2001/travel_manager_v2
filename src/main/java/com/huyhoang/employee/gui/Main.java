package com.huyhoang.employee.gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.huyhoang.employee.gui.component.Content;
import com.huyhoang.employee.gui.component.Header;
import com.huyhoang.employee.gui.component.Menu;
import com.huyhoang.employee.gui.form.Form2;
import com.huyhoang.employee.gui.form.TourListForm;
import com.huyhoang.swing.event.EventMenuSelected;
import com.huyhoang.swing.panel.ComponentResizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private boolean show = true;
    private MigLayout layout;
    private Menu menu;
    private Header header;
    private Content content;

    public Main() {
        initComponents();
        buildDisplay();
        resized();
    }

    private void buildDisplay() {
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
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        layout = new MigLayout("fill, insets 0", "195[fill]", "[fill]0[fill]");
        bg.setLayout(layout);
        menu = new Menu();
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void menuSelected(int index) {
                if (index == 0) {
                    content.showForm(new TourListForm());
                } else if (index == 1) {
                    content.showForm(new Form2());
                }
            }
        });

        header = new Header();
        header.moving(this);

        bg.setLayer(menu, JLayeredPane.POPUP_LAYER);
        bg.add(menu, "pos 0al 0al 200 100%");
        bg.add(header, "h 70!, wrap");
        content = new Content();
        content.showForm(new TourListForm());
        bg.add(content, "w 100%, h 100%");
    }

    private void resized() {
        ComponentResizer com = new ComponentResizer();
        com.registerComponent(this);
        com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        com.setSnapSize(new Dimension(10, 10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new com.huyhoang.swing.panel.LayerPaneShadow();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        bg.setShadowOpacity(0.3F);
        bg.setShadowSize(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1643, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.panel.LayerPaneShadow bg;
    // End of variables declaration//GEN-END:variables
}
