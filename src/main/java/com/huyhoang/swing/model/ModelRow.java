package com.huyhoang.swing.model;

import java.util.ArrayList;
import java.util.List;


public class ModelRow {
    private Object[] row;
    private Object[] titleSubRow;
    private List<Object[]> subTable;

    public ModelRow() {
        subTable = new ArrayList<>();
    }
    public void addSubRow(Object[] subRow) {
        subTable.add(subRow);
    }

    public Object[] getRow() {
        return row;
    }

    public void setRow(Object[] row) {
        this.row = row;
    }

    public Object[] getTitleSubRow() {
        return titleSubRow;
    }

    public void setTitleSubRow(Object[] titleSubRow) {
        this.titleSubRow = titleSubRow;
    }

    public List<Object[]> getSubTable() {
        return subTable;
    }

    public void setSubTable(List<Object[]> subTable) {
        this.subTable = subTable;
    }

    @Override
    public String toString() {
        return "ModelRow{" + "row=" + row + ", titleSubRow=" + titleSubRow + ", subTable=" + subTable + '}';
    }
}
