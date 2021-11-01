package com.huyhoang.employee.gui.form;

import com.huyhoang.swing.model.ModelRow;
import com.huyhoang.swing.table.CellCollapse;
import com.huyhoang.swing.table.CellMenu;
import net.miginfocom.swing.MigLayout;

public class TourListForm extends javax.swing.JPanel {

    private MigLayout layout;

    public TourListForm() {
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        
    }

//    private void initData() {
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable1 = new com.huyhoang.swing.table.MyTable();

        setBackground(new java.awt.Color(102, 102, 255));
        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Tour List");

        jScrollPane1.setViewportView(myTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(112, 112, 112)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.huyhoang.swing.table.MyTable myTable1;
    // End of variables declaration//GEN-END:variables
}
