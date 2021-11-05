package com.huyhoang.swing.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellButton extends javax.swing.JPanel {
    public CellButton(ModelAction action) {
        initComponents();
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                action.getEvent().update(action.getObj());
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                action.getEvent().delete(action.getObj());
            }
        });
        btnLook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                action.getEvent().look(action.getObj());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLook = new com.huyhoang.swing.button.ButtonBadges();
        btnEdit = new com.huyhoang.swing.button.ButtonBadges();
        btnDelete = new com.huyhoang.swing.button.ButtonBadges();

        setOpaque(false);
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 0, 5);
        flowLayout1.setAlignOnBaseline(true);
        setLayout(flowLayout1);

        btnLook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye_20px.png"))); // NOI18N
        add(btnLook);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        add(btnEdit);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        add(btnDelete);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.ButtonBadges btnDelete;
    private com.huyhoang.swing.button.ButtonBadges btnEdit;
    private com.huyhoang.swing.button.ButtonBadges btnLook;
    // End of variables declaration//GEN-END:variables
}
