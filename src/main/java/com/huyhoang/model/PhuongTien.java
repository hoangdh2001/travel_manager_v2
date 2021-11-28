package com.huyhoang.model;

public enum PhuongTien {
    XE_KHACH("Xe khách"),
    MAY_BAY("Máy bay");
    private final String phuongTien;

    /**
     * @param phuongTien
     */
    private PhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public static PhuongTien getValuePhuongTien(String phuongTien) {
        for (PhuongTien i : PhuongTien.values()) {
            if (i.phuongTien.equals(phuongTien)) {
                return i;
            }
        }
        return null;
    }

    /**
     * @return the phuongTien
     */
    public String getPhuongTien() {
        return phuongTien;
    }
}
