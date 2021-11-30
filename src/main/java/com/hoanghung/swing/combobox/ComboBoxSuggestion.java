package com.hoanghung.swing.combobox;

import javax.swing.JComboBox;

public class ComboBoxSuggestion<E> extends JComboBox<E> {

    public ComboBoxSuggestion() {
        setUI(new ComboSuggestionUI());
    }
}
