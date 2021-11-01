package com.huyhoang.swing.table;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class PanelRow extends JPanel {
    private MigLayout layout;

    public PanelRow() {
        layout = new MigLayout("novisualpadding, fill, insets 0", "[fill, grow]", "[fill, grow]");
        setLayout(layout);
        setOpaque(false);
        setBorder(new EmptyBorder(0, 5, 0, 5));
    }
}
