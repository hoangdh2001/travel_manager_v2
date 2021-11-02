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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chuyendulich")
public class ChuyenDuLich {

    @Id
    @Column(name = "chuyen_id")
    private String maChuyen;
    @ManyToMany
    @JoinTable(name = "chitietloaichuyen", joinColumns = @JoinColumn(name = "chuyen_id"), inverseJoinColumns = @JoinColumn(name = "loaichuyen_id"))
    private List<LoaiChuyenDi> dsLoaiChuyenDi;
    @Column(name = "giachuyen", columnDefinition = "money")
    private double giaChuyenDi;
    @OneToMany(mappedBy = "chuyenDuLich")
    private List<ChiTietThamQuan> dsChiTietThamQuan;
    @Column(name = "ngaykhoihanh", columnDefinition = "datetime")
    private Date ngayKhoiHanh;
    @Column(name = "ngayketthuc", columnDefinition = "datetime")
    private Date ngayKetThuc;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "trangthai")
    private TrangThaiChuyenDi trangThai;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "phuongtien")
    private PhuongTien phuongTien;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "dongtour")
    private DongTour dongTour;
    @Column(name = "mota", columnDefinition = "nvarchar(max)")
    private String moTa;
    @Column(name = "dieukien", columnDefinition = "nvarchar(max)")
    private String dieuKien;
    @Column(name = "soluong")
    private int soLuong;

    /**
     * @param maChuyen
     * @param giaChuyenDi
     * @param ngayKhoiHanh
     * @param ngayKetThuc
     * @param trangThai
     * @param phuongTien
     * @param dongTour
     * @param moTa
     * @param dieuKien
     * @param soLuong
     */
    public ChuyenDuLich(String maChuyen, double giaChuyenDi, Date ngayKhoiHanh, Date ngayKetThuc, TrangThaiChuyenDi trangThai,
            PhuongTien phuongTien, DongTour dongTour, String moTa,
            String dieuKien, int soLuong) {
        this.maChuyen = maChuyen;
        this.giaChuyenDi = giaChuyenDi;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.phuongTien = phuongTien;
        this.dongTour = dongTour;
        this.moTa = moTa;
        this.dieuKien = dieuKien;
        this.soLuong = soLuong;
        this.dsLoaiChuyenDi = new ArrayList<LoaiChuyenDi>();
        this.dsChiTietThamQuan = new ArrayList<ChiTietThamQuan>();
    }
    
    /**
     * @param trangThai 
     */
    public ChuyenDuLich(TrangThaiChuyenDi trangThai)  {
        this.trangThai = trangThai;
        this.dsLoaiChuyenDi = new ArrayList<>();
        this.dsChiTietThamQuan = new ArrayList<>();
    }

    /**
     *
     */
    public ChuyenDuLich() {
        this(TrangThaiChuyenDi.DANG_XU_LY);
    }
    /**
     * @param chuyenDuLich
     * @param diaDanh
     * @param anhDiaDanh 
     */
    public void themChiTietThamQuan(ChuyenDuLich chuyenDuLich, DiaDanh diaDanh, byte[] anhDiaDanh) {
        ChiTietThamQuan chiTietThamQuan = new ChiTietThamQuan(chuyenDuLich, diaDanh, anhDiaDanh);
        dsChiTietThamQuan.add(chiTietThamQuan);
    }
    /**
     * @param maLoaiChuyen
     * @param tenLoaiChuyen 
     */
    public void themLoaiChuyenDi(String maLoaiChuyen, String tenLoaiChuyen) {
        LoaiChuyenDi loaiChuyenDi = new LoaiChuyenDi(maLoaiChuyen, tenLoaiChuyen);
        dsLoaiChuyenDi.add(loaiChuyenDi);
    }

    /**
     * @return the maChuyen
     */
    public String getMaChuyen() {
        return maChuyen;
    }

    /**
     * @param maChuyen the maChuyen to set
     */
    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    /**
     * @return the dsLoaiChuyenDi
     */
    public List<LoaiChuyenDi> getDsLoaiChuyenDi() {
        return dsLoaiChuyenDi;
    }

    /**
     * @param dsLoaiChuyenDi the dsLoaiChuyenDi to set
     */
    public void setDsLoaiChuyenDi(List<LoaiChuyenDi> dsLoaiChuyenDi) {
        this.dsLoaiChuyenDi = dsLoaiChuyenDi;
    }

    /**
     * @return the giaChuyenDi
     */
    public double getGiaChuyenDi() {
        return giaChuyenDi;
    }

    /**
     * @param giaChuyenDi the giaChuyenDi to set
     */
    public void setGiaChuyenDi(double giaChuyenDi) {
        this.giaChuyenDi = giaChuyenDi;
    }

    /**
     * @return the dsChiTietThamQuan
     */
    public List<ChiTietThamQuan> getDsChiTietThamQuan() {
        return dsChiTietThamQuan;
    }

    /**
     * @param dsChiTietThamQuan the dsChiTietThamQuan to set
     */
    public void setDsChiTietThamQuan(List<ChiTietThamQuan> dsChiTietThamQuan) {
        this.dsChiTietThamQuan = dsChiTietThamQuan;
    }

    /**
     * @return the ngayKhoiHanh
     */
    public Date getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    /**
     * @param ngayKhoiHanh the ngayKhoiHanh to set
     */
    public void setNgayKhoiHanh(Date ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    /**
     * @return the ngayKetThuc
     */
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    /**
     * @param ngayKetThuc the ngayKetThuc to set
     */
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the dieuKien
     */
    public String getDieuKien() {
        return dieuKien;
    }

    /**
     * @param dieuKien the dieuKien to set
     */
    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    /**
     * @return the trangThai
     */
    public TrangThaiChuyenDi getTrangThai() {
        return trangThai;
    }
    
    /**
     * @param trangThai 
     */
    public void setTrangThai(TrangThaiChuyenDi trangThai) {
        this.trangThai = trangThai;
    }
    
    /**
     * @return the phuongTien
     */
    public PhuongTien getPhuongTien() {
        return phuongTien;
    }
    
    /**
     * @param phuongTien 
     */
    public void setPhuongTien(PhuongTien phuongTien) {
        this.phuongTien = phuongTien;
    }
    
    /**
     * @return the dongTour
     */
    public DongTour getDongTour() {
        return dongTour;
    }
    /**
     * @param dongTour 
     */
    public void setDongTour(DongTour dongTour) {
        this.dongTour = dongTour;
    }
    
    @Override
    public String toString() {
        return "ChuyenDuLich [maChuyen=" + maChuyen + ", dsLoaiChuyenDi=" + dsLoaiChuyenDi + ", giaChuyenDi="
                + giaChuyenDi + ", dsChiTietThamQuan=" + dsChiTietThamQuan + ", ngayKhoiHanh=" + ngayKhoiHanh
                + ", ngayKetThuc=" + ngayKetThuc + ", moTa=" + moTa + ", dieuKien=" + dieuKien + ", soLuong=" + soLuong
                + "]";
    }
}
