package com.huyhoang.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ChuyenDuLich {
	private String maChuyen;
	private List<LoaiChuyenDi> dsLoaiChuyenDi;
	private double giaChuyenDi;
	private List<ChiTietThamQuan> dsChiTietThamQuan;
	private Date ngayKhoiHanh;
	private Date ngayKetThuc;
	private String moTa;
	private String dieuKien;
	private int soLuong;
	/**
	 * @param maChuyen
	 * @param giaChuyenDi
	 * @param ngayKhoiHanh
	 * @param ngayKetThuc
	 * @param moTa
	 * @param dieuKien
	 * @param soLuong
	 */
	public ChuyenDuLich(String maChuyen, double giaChuyenDi, Date ngayKhoiHanh, Date ngayKetThuc, String moTa,
			String dieuKien, int soLuong) {
		this.maChuyen = maChuyen;
		this.giaChuyenDi = giaChuyenDi;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
		this.dieuKien = dieuKien;
		this.soLuong = soLuong;
		this.dsLoaiChuyenDi = new ArrayList<LoaiChuyenDi>();
		this.dsChiTietThamQuan = new ArrayList<ChiTietThamQuan>();
	}
	/**
	 * 
	 */
	public ChuyenDuLich() {
	}
	public void themChiTietThamQuan(ChuyenDuLich chuyenDuLich, DiaDanh diaDanh, byte[] anhDiaDanh) {
		ChiTietThamQuan chiTietThamQuan = new ChiTietThamQuan(chuyenDuLich, diaDanh, anhDiaDanh);
		dsChiTietThamQuan.add(chiTietThamQuan);
	}
	
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
	@Override
	public String toString() {
		return "ChuyenDuLich [maChuyen=" + maChuyen + ", dsLoaiChuyenDi=" + dsLoaiChuyenDi + ", giaChuyenDi="
				+ giaChuyenDi + ", dsChiTietThamQuan=" + dsChiTietThamQuan + ", ngayKhoiHanh=" + ngayKhoiHanh
				+ ", ngayKetThuc=" + ngayKetThuc + ", moTa=" + moTa + ", dieuKien=" + dieuKien + ", soLuong=" + soLuong
				+ "]";
	}
}