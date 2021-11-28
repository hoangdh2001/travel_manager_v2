package com.huyhoang.swing.table2;

import com.huyhoang.model.TrangThaiChuyenDi;
import com.huyhoang.model.TrangThaiDonDat;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
    
    public MyTable() {
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof TrangThaiChuyenDi | value instanceof TrangThaiDonDat) {
                    CellStatus cell = new CellStatus(value);
                    if (isSelected) {
                        cell.setBackground(getSelectionBackground());
//                        cell.setForeground(new Color(15, 89, 140));
                    } else {
//                        cell.setBackground(Color.WHITE);
//                        cell.setForeground(new Color(102, 102, 102));
                        if (row % 2 == 0) {
                            cell.setBackground(Color.WHITE);
                        } else {
                            cell.setBackground(new Color(233, 235, 245));
                        }
                    }
                    return cell;
                } else {
                    JLabel com = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setBorder(noFocusBorder);
                    com.setOpaque(true);
                    com.setHorizontalAlignment(JLabel.CENTER);
                    if (isSelected) {
                        com.setBackground(getSelectionBackground());
//                        com.setForeground(new Color(15, 89, 140));
                    } else {
                        if (row % 2 == 0) {
                            com.setBackground(Color.WHITE);
                        } else {
                            com.setBackground(new Color(233, 235, 245));
                        }
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
