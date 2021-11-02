package com.huyhoang.model;

public enum PhuongTien {
    XE_KHACH("Xe kh�ch"),
    MAY_BAY("M�y bay");
    private final String phuongTien;

    /**
     * @param phuongTien
     */
    private PhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    /**
     * @return the phuongTien
     */
    public String getPhuongTien() {
        return phuongTien;
    }
}
