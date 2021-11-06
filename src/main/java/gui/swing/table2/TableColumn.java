package gui.swing.table2;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableColumn extends JTable {

    public TableColumn() {
        setBackground(new Color(245, 245, 245));
        setRowHeight(40);
        setFillsViewportHeight(false);
        getTableHeader().setReorderingAllowed(false);
//        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                return new TableCell(o);
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableCell.CellType celLType = TableCell.CellType.CENTER;
                if (column == 0) {
                    celLType = TableCell.CellType.LEFT;
                } else if (column == getColumnCount() - 1) {
                    celLType = TableCell.CellType.RIGHT;
                }
                return new TableCell(value, isSelected, celLType);
            }

        });
    }

//    @Override
//    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
//        TableCell.CellType celLType = TableCell.CellType.CENTER;
//        if (i1 == 0) {
//            celLType = TableCell.CellType.LEFT;
//        } else if (i1 == getColumnCount() - 1) {
//            celLType = TableCell.CellType.RIGHT;
//        }
//        return new TableCell(getValueAt(i, i1), isCellSelected(i, i1), celLType);
//    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.BLACK);
        scroll.setBorder(new EmptyBorder(5, 5, 5, 10));
        scroll.getVerticalScrollBar().setUnitIncrement(20);
    }
}
