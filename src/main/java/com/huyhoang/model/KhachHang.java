package com.huyhoang.model;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "khachhang", uniqueConstraints = {
    @UniqueConstraint(columnNames = "sdt")})
public class KhachHang {

    @Id
    @Column(name = "khachhang_id")
    private String maKhachHang;
    @Column(name = "hoten", columnDefinition = "nvarchar(255)", nullable = false)
    private String hoTen;
    @Column(columnDefinition = "image", nullable = false)
    private byte[] avatar;
    @Column(name = "CCCD", columnDefinition = "varchar(12)", nullable = false)
    private String cCCD;
    @Column(name = "sdt", columnDefinition = "varchar(10)", nullable = false)
    private String soDienThoai;
    private String email;
    @ManyToOne
    @JoinColumn(name = "diachi_id", nullable = false)
    private DiaChi diaChi;
    @Column(name = "matkhau", nullable = false)
    private byte[] matKhau;

    /**
     * @param maKhachHang
     * @param hoTen
     * @param cCCD
     * @param soDienThoai
     * @param email
     * @param diaChi
     * @param matKhau
     */
    public KhachHang(String maKhachHang, String hoTen, byte[] avatar, String cCCD, String soDienThoai, String email, DiaChi diaChi,
            byte[] matKhau) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.avatar = avatar;
        this.cCCD = cCCD;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
    }

    /**
     *
     */
    public KhachHang() {
    }

    /**
     * @return the maKhachHang
     */
    public String getMaKhachHang() {
        return maKhachHang;
    }

    /**
     * @param maKhachHang the maKhachHang to set
     */
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }
    /**
     * @return avatar
     */
    public byte[] getAvatar() {
        return avatar;
    }
    
    /**
     * @param avatar 
     */
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
    
    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the cCCD
     */
    public String getcCCD() {
        return cCCD;
    }

    /**
     * @param cCCD the cCCD to set
     */
    public void setcCCD(String cCCD) {
        this.cCCD = cCCD;
    }

    /**
     * @return the soDienThoai
     */
    public String getSoDienThoai() {
        return soDienThoai;
    }

    /**
     * @param soDienThoai the soDienThoai to set
     */
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the diaChi
     */
    public DiaChi getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the matKhau
     */
    public byte[] getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(byte[] matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "KhachHang [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", cCCD=" + cCCD + ", soDienThoai="
                + soDienThoai + ", email=" + email + ", diaChi=" + diaChi + ", matKhau=" + Arrays.toString(matKhau)
                + "]";
    }
}
