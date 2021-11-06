package com.huyhoang.employee.gui.form;

public class TourForm extends javax.swing.JPanel {

    public TourForm() {
        initComponents();
        buildDisplay();
        pnlTabelTour.setVisible(true);
        pnlTableOrder.setVisible(false);
    }
    
    private void buildDisplay() {
        createTableTour();
    }
    
    private void createTableTour() {
        tableTour.fixTable(sp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTabelTour = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        tableTour = new gui.swing.table2.TableColumn();
        pnlTableOrder = new javax.swing.JPanel();

        setOpaque(false);
        setLayout(new java.awt.CardLayout());

        pnlTabelTour.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabelTour.setOpaque(false);

        tableTour.setBackground(new java.awt.Color(249, 249, 249));
        tableTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "ID", "Tên chuyến đi", "Ngày tạo", "Loại chuyến", "Ngày khởi hành", "Ngày kết thúc", "Trạng thái", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTour.setRowHeight(50);
        sp.setViewportView(tableTour);
        if (tableTour.getColumnModel().getColumnCount() > 0) {
            tableTour.getColumnModel().getColumn(0).setResizable(false);
            tableTour.getColumnModel().getColumn(1).setResizable(false);
            tableTour.getColumnModel().getColumn(2).setResizable(false);
            tableTour.getColumnModel().getColumn(3).setResizable(false);
            tableTour.getColumnModel().getColumn(4).setResizable(false);
            tableTour.getColumnModel().getColumn(5).setResizable(false);
            tableTour.getColumnModel().getColumn(6).setResizable(false);
            tableTour.getColumnModel().getColumn(7).setResizable(false);
            tableTour.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout pnlTabelTourLayout = new javax.swing.GroupLayout(pnlTabelTour);
        pnlTabelTour.setLayout(pnlTabelTourLayout);
        pnlTabelTourLayout.setHorizontalGroup(
            pnlTabelTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
        );
        pnlTabelTourLayout.setVerticalGroup(
            pnlTabelTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelTourLayout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );

        add(pnlTabelTour, "card2");

        pnlTableOrder.setOpaque(false);

        javax.swing.GroupLayout pnlTableOrderLayout = new javax.swing.GroupLayout(pnlTableOrder);
        pnlTableOrder.setLayout(pnlTableOrderLayout);
        pnlTableOrderLayout.setHorizontalGroup(
            pnlTableOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1173, Short.MAX_VALUE)
        );
        pnlTableOrderLayout.setVerticalGroup(
            pnlTableOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
        );

        add(pnlTableOrder, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlTabelTour;
    private javax.swing.JPanel pnlTableOrder;
    private javax.swing.JScrollPane sp;
    private gui.swing.table2.TableColumn tableTour;
    // End of variables declaration//GEN-END:variables
}
