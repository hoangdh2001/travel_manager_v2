package com.huyhoang.swing.scrollbar;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;

public class ScrollPaneCustom extends JScrollPane {
    public ScrollPaneCustom() {
        setOpaque(false);
        setViewport(new ViewPortCustom());
        setBorder(null);
        setVerticalScrollBar(new ScrollBarCustom());
    }
    
    private class ViewPortCustom extends JViewport {
        public ViewPortCustom() {
            setOpaque(false);
            setViewportBorder(new EmptyBorder(5, 5, 5, 5));
        }
        
    }
}
