package com.huyhoang.customer.gui.component;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Content extends JPanel {

    public Content() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setOpaque(false);
        setLayout(new BorderLayout());
    }

    public void showForm(Component form) {
        removeAll();
        add(form);
        repaint();
        revalidate();
    }
    
}
