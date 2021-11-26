package com.huyhoang.swing.scrollbar;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

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
            setViewportBorder(BorderFactory.createEmptyBorder());
        }
        
    }
}
