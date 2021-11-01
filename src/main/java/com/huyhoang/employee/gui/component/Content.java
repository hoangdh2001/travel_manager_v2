package com.huyhoang.employee.gui.component;

import com.huyhoang.swing.scrollbar.ScrollBarCustom;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Content extends JPanel {
    public Content() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setBackground(new Color(249, 249, 249));
    }
    
    public void showForm(Component form) {
        removeAll();
        add(form);
        repaint();
        revalidate();
    }
    
    public void fixScrollBar(JScrollPane sp) {
        sp.getViewport().setBackground(Color.WHITE);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        sp.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}
