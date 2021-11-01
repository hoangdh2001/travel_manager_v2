package com.huyhoang.swing.model;

public class ModelRow {
    private Object[] row;
    private Object[][] subRow;

    public ModelRow(Object[] row, Object[]... subRow) {
        this.row = row;
        this.subRow = subRow;
    }

    public ModelRow() {
    }

    public Object[] getRow() {
        return row;
    }

    public void setRow(Object[] row) {
        this.row = row;
    }

    public Object[][] getSubRow() {
        return subRow;
    }

    public void setSubRow(Object[][] subRow) {
        this.subRow = subRow;
    }

    @Override
    public String toString() {
        return "ModelRow{" + "row=" + row + ", subRow=" + subRow + '}';
    }
    
}
