package com.huyhoang.customer.gui.component;

import com.huyhoang.swing.button.Button;
import com.huyhoang.swing.button.PopupMenu;
import com.huyhoang.swing.event.EventMenuSelected;
import com.huyhoang.swing.textfield.MyTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Header extends javax.swing.JPanel {

    private PopupMenu popupMenu;
    private EventMenuSelected event;

    public MyTextField getMyTextField1() {
        return myTextField1;
    }

    public void addActionMinimize(ActionListener evt) {
        btnMi.addActionListener(evt);
    }

    public void addActionMaximize(ActionListener evt) {
        btnRe.addActionListener(evt);
    }

    public void addActionClose(ActionListener evt) {
        btnClose.addActionListener(evt);
    }

    public Header() {
        initComponents();
        myTextField1.setVisible(false);
        buildDisplay();
    }

    private void buildDisplay() {
        createPopupMenu();
    }

    private void createPopupMenu() {
        popupMenu = new PopupMenu();
        popupMenu.setBackground(new Color(40, 40, 40));
        popupMenu.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                buttonInfo1.setSelected(false);
            }
            
        });
        event = new EventMenuSelected() {
            @Override
            public void menuSelected(int index) {
                
            }
        };
        addItem("Hồ sơ");
        addItem("Cài đặt");
        popupMenu.addSeperator();
        addItem("Đăng xuất");
    }
    
    private void addItem(String text) {
        Button item = new Button();
        item.setText(text);
        item.setBackground(new Color(40, 40, 40));
        item.setForeground(Color.WHITE);
        item.setBorderRadius(5);
        item.setHorizontalAlignment(Button.LEADING);
        item.addActionListener((ActionEvent arg0) -> {
            event.menuSelected(popupMenu.getItemCount());
            popupMenu.setVisible(false);
            item.setBackground(item.getBackgroundColor());
        });
        popupMenu.addItem(item);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMi = new com.huyhoang.swing.button.Button();
        btnClose = new com.huyhoang.swing.button.Button();
        btnRe = new com.huyhoang.swing.button.Button();
        buttonInfo1 = new com.huyhoang.swing.button.ButtonInfo();
        buttonBadges1 = new com.huyhoang.swing.button.ButtonBadges();
        buttonBadges2 = new com.huyhoang.swing.button.ButtonBadges();
        myTextField1 = new com.huyhoang.swing.textfield.MyTextField();

        setBackground(new java.awt.Color(18, 18, 18));

        jPanel1.setBackground(new java.awt.Color(19, 19, 19));

        btnMi.setBackground(new java.awt.Color(19, 19, 19));
        btnMi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mi.png"))); // NOI18N
        btnMi.setToolTipText("Minimize");

        btnClose.setBackground(new java.awt.Color(19, 19, 19));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        btnClose.setToolTipText("Close");
        btnClose.setOverColor(new java.awt.Color(205, 26, 43));

        btnRe.setBackground(new java.awt.Color(19, 19, 19));
        btnRe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/max.png"))); // NOI18N
        btnRe.setToolTipText("Maximize");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnMi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnRe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        buttonInfo1.setBackground(new java.awt.Color(19, 19, 19));
        buttonInfo1.setForeground(new java.awt.Color(255, 255, 255));
        buttonInfo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/expand_bottom.png"))); // NOI18N
        buttonInfo1.setText("Đỗ Huy Hoàng");
        buttonInfo1.setBorderRadius(37);
        buttonInfo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonInfo1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/avatar.jpg"))); // NOI18N
        buttonInfo1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/expand_bottom.png"))); // NOI18N
        buttonInfo1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/expand_top.png"))); // NOI18N
        buttonInfo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInfo1ActionPerformed(evt);
            }
        });

        buttonBadges1.setBackground(new java.awt.Color(10, 10, 10));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next_arrow.png"))); // NOI18N

        buttonBadges2.setBackground(new java.awt.Color(10, 10, 10));
        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N

        myTextField1.setBackgroundColor(new java.awt.Color(255, 255, 255));
        myTextField1.setBorderLine(true);
        myTextField1.setBorderRadius(38);
        myTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myTextField1.setHint("Search tour");
        myTextField1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_25px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(buttonInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInfo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInfo1ActionPerformed
        popupMenu.setVisible(true);
        popupMenu.show(buttonInfo1, 0, buttonInfo1.getHeight() + 5);
        popupMenu.setPopupSize(200, (int) popupMenu.getPreferredSize().getHeight());
    }//GEN-LAST:event_buttonInfo1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.Button btnClose;
    private com.huyhoang.swing.button.Button btnMi;
    private com.huyhoang.swing.button.Button btnRe;
    private com.huyhoang.swing.button.ButtonBadges buttonBadges1;
    private com.huyhoang.swing.button.ButtonBadges buttonBadges2;
    private com.huyhoang.swing.button.ButtonInfo buttonInfo1;
    private javax.swing.JPanel jPanel1;
    private com.huyhoang.swing.textfield.MyTextField myTextField1;
    // End of variables declaration//GEN-END:variables

}
