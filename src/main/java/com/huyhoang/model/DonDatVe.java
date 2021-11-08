package com.huyhoang.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dondatve")
public class DonDatVe {

    @Id
    @Column(name = "dondatve_id")
    private String maDonDatVe;
    @Column(name = "ngaydat")
    private Date ngayDat;
    @ManyToOne
    @JoinColumn(name = "khachhang_id", nullable = false)
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "nhanvien_id", nullable = false)
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "chuyen_id", nullable = false)
    private ChuyenDuLich chuyenDuLich;
    @ManyToOne
    @JoinColumn(name = "huongdanvien_id", nullable = true)
    private HuongDanVien huongDanVien;
    @Enumerated(EnumType.STRING)
    private TrangThaiDonDat trangThai;
    @OneToMany
    @JoinColumn(name = "dondatve_id")
    private List<HanhKhach> dsHanhKhach;
    @Column(name = "soluong")
    private int soLuong;
    @Column(name = "thanhtien", columnDefinition = "money")
    private double thanhTien;

    /**
     * @param maDonDatVe
     * @param ngayDat
     * @param khachHang
     * @param nhanVien
     * @param chuyenDuLich
     * @param huongDanVien
     * @param trangThai 
     */
    public DonDatVe(String maDonDatVe, Date ngayDat, KhachHang khachHang, NhanVien nhanVien, ChuyenDuLich chuyenDuLich, HuongDanVien huongDanVien, TrangThaiDonDat trangThai) {
        this.maDonDatVe = maDonDatVe;
        this.ngayDat = ngayDat;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.chuyenDuLich = chuyenDuLich;
        this.huongDanVien = huongDanVien;
        this.trangThai = trangThai;
    }
    
    /**
     * @param ngayDat
     * @param trangThai 
     */
    public DonDatVe(TrangThaiDonDat trangThai) {
        this.ngayDat = new Date();
        this.trangThai = trangThai;
        this.dsHanhKhach = new ArrayList<>();
        this.soLuong = getSoLuong();
        this.thanhTien = getThanhTien();
    }

    /**
     *
     */
    public DonDatVe() {
        this(TrangThaiDonDat.MOI);
    }

    public void themHanhKhach(String hoTen, boolean gioiTinh, Date ngaySinh) {
        dsHanhKhach.add(new HanhKhach(hoTen, gioiTinh, ngaySinh));
    }

    /**
     * @return the maDonDatVe
     */
    public String getMaDonDatVe() {
        return maDonDatVe;
    }

    /**
     * @param maDonDatVe the maDonDatVe to set
     */
    public void setMaDonDatVe(String maDonDatVe) {
        this.maDonDatVe = maDonDatVe;
    }

    /**
     * @return the ngayDat
     */
    public Date getNgayDat() {
        return ngayDat;
    }

    /**
     * @param ngayDat the ngayDat to set
     */
    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    /**
     * @return the khachHang
     */
    public KhachHang getKhachHang() {
        return khachHang;
    }

    /**
     * @param khachHang the khachHang to set
     */
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    /**
     * @return the nhanVien
     */
    public NhanVien getNhanVien() {
        return nhanVien;
    }

    /**
     * @param nhanVien the nhanVien to set
     */
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    /**
     * @return the chuyenDuLich
     */
    public ChuyenDuLich getChuyenDuLich() {
        return chuyenDuLich;
    }

    /**
     * @param chuyenDuLich the chuyenDuLich to set
     */
    public void setChuyenDuLich(ChuyenDuLich chuyenDuLich) {
        this.chuyenDuLich = chuyenDuLich;
    }

    /**
     * @return the huongDanVien
     */
    public HuongDanVien getHuongDanVien() {
        return huongDanVien;
    }

    /**
     * @param huongDanVien the huongDanVien to set
     */
    public void setHuongDanVien(HuongDanVien huongDanVien) {
        this.huongDanVien = huongDanVien;
    }

    /**
     * @return the trangThai
     */
    public TrangThaiDonDat getTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(TrangThaiDonDat trangThai) {
        this.trangThai = trangThai;
    }

    /**
     * @return the dsHanhKhach
     */
    public List<HanhKhach> getDsHanhKhach() {
        return dsHanhKhach;
    }

    /**
     * @param dsHanhKhach the dsHanhKhach to set
     */
    public void setDsHanhKhach(List<HanhKhach> dsHanhKhach) {
        this.dsHanhKhach = dsHanhKhach;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return dsHanhKhach.size();
    }

    /**
     * @return the thanhTien
     */
    public double getThanhTien() {
        return chuyenDuLich.getGiaChuyenDi() * soLuong;
    }

    @Override
    public String toString() {
        return "DonDatVe [maDonDatVe=" + maDonDatVe + ", ngayDat=" + ngayDat + ", khachHang=" + khachHang
                + ", nhanVien=" + nhanVien + ", chuyenDuLich=" + chuyenDuLich + ", huongDanVien=" + huongDanVien
                + ", trangThai=" + trangThai + ", dsHanhKhach=" + dsHanhKhach + ", soLuong=" + soLuong + ", thanhTien="
                + thanhTien + "]";
    }
    
//    public ModelRow convertToRowTable() {
//        return new ModelRow(new Object[] {new CellMenu(), khachHang.getAvatar(), khachHang.getHoTen(), khachHang.getDiaChi().getTinhThanh(), trangThai, new CellCollapse()},
//                new Object[] {});
//    }
}
