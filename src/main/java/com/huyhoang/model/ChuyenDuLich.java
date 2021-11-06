package com.huyhoang.model;

import com.huyhoang.swing.event.EventAction;
import com.huyhoang.swing.event.EventPopupMenu;
import com.huyhoang.swing.model.ModelRow;
import com.huyhoang.swing.table.CellCollapse;
import com.huyhoang.swing.table.CellMenu;
import com.huyhoang.swing.model.ModelAction;
import com.huyhoang.swing.model.ModelMore;
import java.awt.Frame;
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
@Table(name = "chuyendulich")
public class ChuyenDuLich {

    @Id
    @Column(name = "chuyen_id")
    private String maChuyen;
    @Column(name = "tenchuyendi", columnDefinition = "nvarchar(255)")
    private String tenChuyenDi;
    @ManyToOne
    @JoinColumn(name = "loaichuyendi_id")
    private LoaiChuyenDi loaiChuyenDi;
    @Column(name = "ngay_tao")
    private Date ngayTao;
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
     * @param tenChuyenDi
     * @param giaChuyenDi
     * @param loaiChuyenDi
     * @param ngayTao
     * @param ngayKhoiHanh
     * @param ngayKetThuc
     * @param trangThai
     * @param phuongTien
     * @param dongTour
     * @param moTa
     * @param dieuKien
     * @param soLuong
     */
    public ChuyenDuLich(String maChuyen, String tenChuyenDi, double giaChuyenDi, LoaiChuyenDi loaiChuyenDi, Date ngayTao, Date ngayKhoiHanh, Date ngayKetThuc, TrangThaiChuyenDi trangThai,
            PhuongTien phuongTien, DongTour dongTour, String moTa,
            String dieuKien, int soLuong) {
        this.maChuyen = maChuyen;
        this.tenChuyenDi = tenChuyenDi;
        this.giaChuyenDi = giaChuyenDi;
        this.loaiChuyenDi = loaiChuyenDi;
        this.ngayTao = ngayTao;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.phuongTien = phuongTien;
        this.dongTour = dongTour;
        this.moTa = moTa;
        this.dieuKien = dieuKien;
        this.soLuong = soLuong;
        this.dsChiTietThamQuan = new ArrayList<ChiTietThamQuan>();
    }

    /**
     * @param trangThai
     */
    public ChuyenDuLich(TrangThaiChuyenDi trangThai) {
        this.trangThai = trangThai;
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
     * @return tenChuyenDi
     */
    public String getTenChuyenDi() {
        return tenChuyenDi;
    }
    
    /**
     * @param tenChuyenDi 
     */
    public void setTenChuyenDi(String tenChuyenDi) {
        this.tenChuyenDi = tenChuyenDi;
    }
    
    /**
     * @return the loaiChuyenDi
     */
    public LoaiChuyenDi getLoaiChuyenDi() {
        return loaiChuyenDi;
    }

    /**
     * @param loaiChuyenDi the dsLoaiChuyenDi to set
     */
    public void setLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi) {
        this.loaiChuyenDi = loaiChuyenDi;
    }

    /**
     * @return ngayTao
     */
    public Date getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao
     */
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
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
        return "ChuyenDuLich [maChuyen=" + maChuyen + ", dsLoaiChuyenDi=" + loaiChuyenDi + ", giaChuyenDi="
                + giaChuyenDi + ", dsChiTietThamQuan=" + dsChiTietThamQuan + ", ngayKhoiHanh=" + ngayKhoiHanh
                + ", ngayKetThuc=" + ngayKetThuc + ", moTa=" + moTa + ", dieuKien=" + dieuKien + ", soLuong=" + soLuong
                + "]";
    }
    
    public ModelRow convertToRowTable(Frame frame) {
        ModelRow row = new ModelRow();
        row.setRow(new Object[] {new ModelMore(this, frame), maChuyen, ngayTao, dongTour, trangThai, new CellCollapse()});
        row.setTitleSubRow(new Object[] {"Id", "Tên địa danh", "Tỉnh"});
        dsChiTietThamQuan.forEach(chiTietThamQuan -> {
            row.addSubRow(new Object[] {chiTietThamQuan.getDiaDanh().getMaDiaDanh(), chiTietThamQuan.getDiaDanh().getTenDiaDanh(), chiTietThamQuan.getDiaDanh().getTinh()});
        });
        return  row;
    }
}
