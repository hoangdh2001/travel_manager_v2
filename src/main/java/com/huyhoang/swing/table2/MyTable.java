package com.huyhoang.swing.table2;

import com.huyhoang.model.TrangThaiChuyenDi;
import com.huyhoang.model.TrangThaiDonDat;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
    public MyTable() {
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof TrangThaiChuyenDi | value instanceof TrangThaiDonDat) {
                    CellStatus cell = new CellStatus(value);
                    if (isSelected) {
                        cell.setBackground(getSelectionBackground());
//                        cell.setForeground(new Color(15, 89, 140));
                    } else {
                        cell.setBackground(Color.WHITE);
//                        cell.setForeground(new Color(102, 102, 102));
                    }
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setBorder(noFocusBorder);
                    if (isSelected) {
                        com.setBackground(getSelectionBackground());
//                        com.setForeground(new Color(15, 89, 140));
                    } else {
                        com.setBackground(Color.WHITE);
//                        com.setForeground(new Color(102, 102, 102));
                    }
                    return com;
                }
            }
        });
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
