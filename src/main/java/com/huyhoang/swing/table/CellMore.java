package com.huyhoang.swing.table;

import com.huyhoang.swing.event.EventPopupMenu;
import com.huyhoang.swing.model.ModelMore;
import com.huyhoang.swing.panel.DropMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellMore extends javax.swing.JPanel {

    public CellMore(ModelMore more) {
        initComponents();
        
        EventPopupMenu event = new EventPopupMenu() {
            @Override
            public void menuSelected(int subMenu) {
                if(subMenu == 0) {
                    System.out.println("Xem");
                } else if(subMenu == 1) {
                    System.out.println("Sửa");
                } else if(subMenu == 2) {
                    System.out.println("Xóa");
                }
            }
        };

        btnMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String[] menuItem = {"Xem tho đơn đặt", "Sửa", "Xóa"};
                DropMenu dropMenu = new DropMenu(more.getFrame(), event, menuItem);
                int x = more.getFrame().getX() + 260;
                System.out.println(more.getFrame().getX());
                System.out.println(CellMore.this.getX());
                System.out.println(x);
                int y = more.getFrame().getY() + 150;
                System.out.println(more.getFrame().getY());
                System.out.println(y);
                dropMenu.setLocation(x, y);
                dropMenu.setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMore = new com.huyhoang.swing.button.Button();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 5, 5));
        setOpaque(false);

        btnMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/more_20px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMore, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.Button btnMore;
    // End of variables declaration//GEN-END:variables
}
