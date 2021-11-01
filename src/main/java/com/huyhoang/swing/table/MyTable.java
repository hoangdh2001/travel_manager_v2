package com.huyhoang.swing.table;

import com.huyhoang.swing.event.EventTable;
import com.huyhoang.swing.event.EventTableSelected;
import com.huyhoang.swing.model.ModelRow;
import com.huyhoang.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class MyTable extends JPanel {

    private MigLayout layout;
    private EventTableSelected event;
    private int rowHeight = 50;
    private Color rowLineColor = Color.BLACK;
    private int rowBorderRadius = 5;
    private int shadowSize = 6;
    private float shadowOpacity = 0.5f;
    private Color shadowColor = Color.BLACK;

    public int getRowHeight() {
        return rowHeight;
    }

    public void setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
    }

    public Color getRowLineColor() {
        return rowLineColor;
    }

    public void setRowLineColor(Color rowLineColor) {
        this.rowLineColor = rowLineColor;
    }

    public int getRowBorderRadius() {
        return rowBorderRadius;
    }

    public void setRowBorderRadius(int rowBorderRadius) {
        this.rowBorderRadius = rowBorderRadius;
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
    }

    public float getShadowOpacity() {
        return shadowOpacity;
    }

    public void setShadowOpacity(float shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
    }

    public MyTable() {
        setOpaque(false);
        buildDisplay();
    }

    private void buildDisplay() {
        layout = new MigLayout("wrap, fill, insets 0", "0[fill]0", "3[]3");
        setLayout(layout);
    }

    public void addRow(ModelRow modelRow) {
        RowTable row = new RowTable(modelRow, getComponentCount(), event, getEventTable(), rowHeight);
        row.setBackground(getBackground());
        row.setForeground(getForeground());
        row.setRowLineColor(rowLineColor);
        row.setRowBorderRadius(rowBorderRadius);
        row.setShadowSize(shadowSize);
        row.setShadowOpacity(shadowOpacity);
        row.setShadowColor(shadowColor);
        add(row, "h " + (rowHeight + 5) + "!");
    }

    private EventTable getEventTable() {
        return new EventTable() {
            @Override
            public boolean tableSelected(RowTable row, boolean open) {
                if (open) {
                    new RowCollapseAnimation(layout, row, rowHeight + 5).openMenu();
                    closeAll();
                } else {
                    new RowCollapseAnimation(layout, row, rowHeight + 5).closeMenu();
                }
                return true;
            }
        };
    }

    public void closeAll() {
        for (Component c : getComponents()) {
            RowTable row = (RowTable) c;
            if (row.isOpen()) {
                new RowCollapseAnimation(layout, row, rowHeight + 5, 200).closeMenu();
                row.setOpen(false);
            }
        }
    }

    public void addEvent(EventTableSelected event) {
        this.event = event;
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(new Color(249, 249, 249));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(new EmptyBorder(5, 5, 5, 10));
    }
    
}
