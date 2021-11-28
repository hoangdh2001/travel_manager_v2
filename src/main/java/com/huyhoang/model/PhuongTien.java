package com.huyhoang.model;

public enum PhuongTien {
    XE_KHACH("Xe khách"),
    MAY_BAY("Máy bay");
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
