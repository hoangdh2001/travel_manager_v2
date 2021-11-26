package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.button.ButtonMenu;
import com.huyhoang.swing.event.EventMenuSelected;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public Menu() {
        initComponents();
        pnlMenu.setLayout(new MigLayout("wrap, fillx, inset 8", "[fill]", "[]0[]"));
    }

    public void initMenu(EventMenuSelected event) {
        this.event = event;
        addMenu(new ImageIcon(getClass().getResource("/icon/home.png")),
                 new ImageIcon(getClass().getResource("/icon/home_selected.png")),
                 new ImageIcon(getClass().getResource("/icon/home_over.png")),
                 "Home", 0);
        addMenu(new ImageIcon(getClass().getResource("/icon/search.png")),
                 new ImageIcon(getClass().getResource("/icon/search_selected.png")),
                 new ImageIcon(getClass().getResource("/icon/search_over.png")), "Search", 1);
    }

    private void addMenu(Icon icon, Icon selectedIcon, Icon overIcon, String text, int index) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(icon);
        menu.setSelectedIcon(selectedIcon);
        menu.setRolloverIcon(overIcon);
        menu.setIconTextGap(20);
        menu.setText(text);
        menu.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pnlMenu.add(menu);
        menu.addActionListener((ActionEvent ae) -> {
            event.menuSelected(index);
            setSelected(menu);
        });
    }

    private void addEmpty() {
        pnlMenu.add(new JLabel(), "push");
    }

    private void setSelected(ButtonMenu menu) {
        for (Component com : pnlMenu.getComponents()) {
            if (com instanceof ButtonMenu) {
                ButtonMenu b = (ButtonMenu) com;
                b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExpand = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setOpaque(false);

        btnExpand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/more.png"))); // NOI18N
        btnExpand.setContentAreaFilled(false);
        btnExpand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExpand.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/more_selected.png"))); // NOI18N
        btnExpand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExpand)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExpand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.setOpaque(false);

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpandActionPerformed

    }//GEN-LAST:event_btnExpandActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExpand;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
