package com.huyhoang.swing.table;

import com.huyhoang.swing.event.EventTable;
import com.huyhoang.swing.event.EventTableSelected;
import com.huyhoang.swing.graphics.ShadowRenderer;
import com.huyhoang.swing.model.ModelRow;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class RowTable extends JPanel {

    private ModelRow row;
    private boolean open;
    private EventTableSelected eventSelected;
    private EventTable event;
    private int index;
    private int rowHeight;
    private int shadowSize = 6;
    private float shadowOpacity = 0.5f;
    private Color shadowColor = Color.BLACK;
    private int rowBorderRadius = 5;
    private Color rowLineColor = Color.BLACK;

    public ModelRow getRow() {
        return row;
    }

    public void setRow(ModelRow row) {
        this.row = row;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public EventTableSelected getEventSelected() {
        return eventSelected;
    }

    public void setEventSelected(EventTableSelected eventSelected) {
        this.eventSelected = eventSelected;
    }

    public EventTable getEvent() {
        return event;
    }

    public void setEvent(EventTable event) {
        this.event = event;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRowHeight() {
        return rowHeight;
    }

    public void setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
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

    public int getRowBorderRadius() {
        return rowBorderRadius;
    }

    public void setRowBorderRadius(int rowBorderRadius) {
        this.rowBorderRadius = rowBorderRadius;
    }

    public Color getRowLineColor() {
        return rowLineColor;
    }

    public void setRowLineColor(Color rowLineColor) {
        this.rowLineColor = rowLineColor;
    }

    public RowTable(ModelRow item, int index, EventTableSelected eventSelected, EventTable event, int rowHeight) {
        this.row = item;
        this.index = index;
        this.eventSelected = eventSelected;
        this.event = event;
        this.rowHeight = rowHeight;
        buildDisplay();
    }

    private void buildDisplay() {
        setOpaque(false);
        setBorder(new EmptyBorder(2, 5, 5, 5));
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "0[fill, " + rowHeight + "!]0"));
        PanelRow firstRow = new PanelRow();
        for (Object o : row.getRow()) {
            if (o instanceof CellMenu) {
                firstRow.add(new CellMenu(), "split 2");
            } else if (o instanceof CellCollapse) {
                firstRow.add(new CellCollapse(), "w 40!, right");
            } else if (o instanceof CellButton) {
                CellButton btn = (CellButton) o;
                firstRow.add(btn);
            } else if (o instanceof ModelAction) {
                ModelAction action = (ModelAction) o;
                firstRow.add(new CellButton(action), "split 2");
            } else {
                String value = "";
                if (o != null) {
                    value = o + "";
                }
                firstRow.add(new Cell(value));
            }
        }
        add(firstRow);

        firstRow.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (row.getSubTable().size() > 0) {
                    if (event.tableSelected(RowTable.this, !open)) {
                        open = !open;
                    }
                }
//                eventSelected.row(index);
            }
        });

        PanelRow title = new PanelRow();
        if (row.getTitleSubRow() != null) {
            for (Object o : row.getTitleSubRow()) {
                if (o instanceof CellMenu) {
                    title.add(new CellMenu());
                } else if (o instanceof CellCollapse) {
                    title.add(new CellCollapse());
                } else {
                    String value = "";
                    if (o != null) {
                        value = o + "";
                    }
                    Cell cell = new Cell(value);
                    cell.setForeground(Color.GRAY);
                    title.add(cell);
                }
            }
            add(title);
            for (Object[] subRow : row.getSubTable()) {
                PanelRow panelRow = new PanelRow();
                for (int i = 0; i < row.getTitleSubRow().length; i++) {
                    String value = "";
                    if (i < subRow.length) {
                        if (subRow[i] != null) {
                            value = subRow[i] + "";
                        }
                    }
                    panelRow.add(new Cell(value));
                }
                add(panelRow);
            }
        } else {
            add(title);
            for (Object[] subRow : row.getSubTable()) {
                PanelRow panelRow = new PanelRow();
                for (Object object : subRow) {
                    String value = "";
                    if(object != null) {
                        value = object + "";
                    }
                    panelRow.add(new Cell(value));
                }
                add(panelRow);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        createShadow(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(rowLineColor);
        for (int i = 0; i < row.getSubTable().size() + 1; i++) {
            if (open) {
                int y = (i + 1) * rowHeight;
                g2.drawLine(5, y, getWidth() - 5, y);
            }
        }
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }

    private void createShadow(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int size = shadowSize * 2;
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - size;
        int height = getHeight() - size;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(getBackground());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRoundRect(0, 0, width, height, rowBorderRadius, rowBorderRadius);
        ShadowRenderer render = new ShadowRenderer(shadowSize, shadowOpacity, shadowColor);
        g2.drawImage(render.createShadow(img), 0, 0, null);
        g2.drawImage(img, x, y, null);
    }
}
