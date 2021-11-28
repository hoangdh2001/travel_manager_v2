package com.huyhoang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaichuyendi")
public class LoaiChuyenDi {

    @Id
    @Column(name = "loaichuyen_id")
    private String maLoaiChuyen;
    @Column(name = "tenloai", columnDefinition = "nvarchar(255)", nullable = false)
    private String tenLoaiChuyen;

    /**
     * @param maLoaiChuyen
     * @param tenLoaiChuyen
     */
    public LoaiChuyenDi(String maLoaiChuyen, String tenLoaiChuyen) {
        this.maLoaiChuyen = maLoaiChuyen;
        this.tenLoaiChuyen = tenLoaiChuyen;
    }

    /**
     *
     */
    public LoaiChuyenDi() {
    }

    /**
     * @return the maLoaiCD
     */
    public String getMaLoaiCD() {
        return maLoaiChuyen;
    }

    /**
     * @param maLoaiChuyen the maLoaiCD to set
     */
    public void setMaLoaiCD(String maLoaiChuyen) {
        this.maLoaiChuyen = maLoaiChuyen;
    }

    /**
     * @return the tenLoaiCD
     */
    public String getTenLoaiCD() {
        return tenLoaiChuyen;
    }

    /**
     * @param tenLoaiChuyen the tenLoaiCD to set
     */
    public void setTenLoaiCD(String tenLoaiChuyen) {
        this.tenLoaiChuyen = tenLoaiChuyen;
    }

    @Override
    public String toString() {
        return tenLoaiChuyen;
    }
}
