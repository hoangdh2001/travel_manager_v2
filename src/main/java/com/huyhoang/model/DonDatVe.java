package com.huyhoang.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DonDatVe {
	private String maDonDatVe;
	private Date ngayDat;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private ChuyenDuLich chuyenDuLich;
	private HuongDanVien huongDanVien;
	private TrangThaiDonDat trangThai;
	private List<HanhKhach> dsHanhKhach;
	private int soLuong;
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
	public DonDatVe(String maDonDatVe, Date ngayDat, KhachHang khachHang, NhanVien nhanVien, ChuyenDuLich chuyenDuLich,
			HuongDanVien huongDanVien, TrangThaiDonDat trangThai) {
		this.maDonDatVe = maDonDatVe;
		this.ngayDat = ngayDat;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.chuyenDuLich = chuyenDuLich;
		this.huongDanVien = huongDanVien;
		this.trangThai = trangThai;
		this.dsHanhKhach = new ArrayList<HanhKhach>();
		this.soLuong = getSoLuong();
		this.thanhTien = getThanhTien();
	}
	public DonDatVe(String maDonDatVe, KhachHang khachHang, NhanVien nhanVien, ChuyenDuLich chuyenDuLich,
			HuongDanVien huongDanVien, TrangThaiDonDat trangThai) {
		this.maDonDatVe = maDonDatVe;
		this.ngayDat = Date.valueOf(LocalDate.now());
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.chuyenDuLich = chuyenDuLich;
		this.huongDanVien = huongDanVien;
		this.trangThai = trangThai;
		this.dsHanhKhach = new ArrayList<HanhKhach>();
		this.soLuong = getSoLuong();
		this.thanhTien = getThanhTien();
	}
	/**
	 * 
	 */
	public DonDatVe() {
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
}
