package com.huyhoang.swing.table;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class Cell extends JLabel {

    public Cell(String text) {
        super(text);
        setForeground(new Color(60, 60, 60));
        setBorder(new EmptyBorder(0, 20, 0, 0));
    }
}
