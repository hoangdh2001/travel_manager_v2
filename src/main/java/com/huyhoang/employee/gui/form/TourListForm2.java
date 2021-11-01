package com.huyhoang.employee.gui.form;

import com.huyhoang.swing.model.ModelRow;
import com.huyhoang.swing.scrollbar.ScrollBarCustom;
import com.huyhoang.swing.slideshow.BackgroundImage;
import com.huyhoang.swing.slideshow.SlideShow;
import com.huyhoang.swing.table.CellCollapse;
import com.huyhoang.swing.table.CellMenu;
import com.huyhoang.swing.table.MyTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class TourListForm2 extends JLayeredPane {

    private MigLayout layout;
    private MyTable table;
    private SlideShow slideShow;

    public TourListForm2() {
        setOpaque(false);
        buildDisplay();
    }

    private void buildDisplay() {
        createJScrollPane();
        layout = new MigLayout("fill, debug", "0[fill]10", "50[fill]");
        setLayout(layout);
        JLabel item = new JLabel("Tour List");
        item.setFont(new Font("sansserif", Font.PLAIN, 18));
        setLayer(item, JLayeredPane.POPUP_LAYER);
        add(item, "pos 0 0 n n");
        createTable();
        createSlideShow();
    }

    private void createTable() {
        table = new MyTable();
        table.setShadowOpacity(0.3f);
        table.setShadowSize(2);
        table.setBackground(Color.WHITE);
        table.setRowLineColor(Color.LIGHT_GRAY);
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(table);
        table.fixTable(sp);
        add(sp);
        initData();
    }
    
    private void initData() {
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        table.addRow(new ModelRow(new Object[]{new CellMenu(), "Hoàng", "Chinh đẹp trai", "Hoàng đẹp trai", new CellCollapse()}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
    }
    
    private void createSlideShow() {
        slideShow = new SlideShow();
        BackgroundImage img1 = new BackgroundImage(new ImageIcon("/icon/hinh-anh-suy-tu-1.jpg"));
        BackgroundImage img2 = new BackgroundImage(new ImageIcon("/icon/hình-ảnh-phong-cảnh-đẹp-1024x680.jpg"));
        BackgroundImage img3 = new BackgroundImage(new ImageIcon("/icon/Hinh-anh-thien-nhien-dep.jpg"));
        BackgroundImage img4 = new BackgroundImage(new ImageIcon("/icon/a1_6.jpg"));
        slideShow.addCom(img1, img2, img3, img4);
        slideShow.setAnimate(5);
        add(slideShow);
    }

    private void createJScrollPane() {
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(this);
        sp.getViewport().setBackground(new Color(249, 249, 249));
        sp.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        sp.setBorder(new EmptyBorder(5, 5, 5, 5));
    }
}
