package com.huyhoang.model;

import java.sql.Date;
import java.util.Arrays;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String cCCD;
	private boolean gioiTinh;
	private String soDienThoai;
	private String email;
	private Date ngaySinh;
	private byte[] matKhau;
	/**
	 * @param maNhanVien
	 * @param tenNhanVien
	 * @param cCCD
	 * @param gioiTinh
	 * @param soDienThoai
	 * @param email
	 * @param ngaySinh
	 * @param matKhau
	 */
	public NhanVien(String maNhanVien, String tenNhanVien, String cCCD, boolean gioiTinh, String soDienThoai,
			String email, Date ngaySinh, byte[] matKhau) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.cCCD = cCCD;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.matKhau = matKhau;
	}
	/**
	 * 
	 */
	public NhanVien() {
	}
	/**
	 * @return the maNhanVien
	 */
	public String getMaNhanVien() {
		return maNhanVien;
	}
	/**
	 * @param maNhanVien the maNhanVien to set
	 */
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	/**
	 * @return the tenNhanVien
	 */
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	/**
	 * @param tenNhanVien the tenNhanVien to set
	 */
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
	 * @return the gioiTinh
	 */
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
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
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}
	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
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
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", cCCD=" + cCCD + ", gioiTinh="
				+ gioiTinh + ", soDienThoai=" + soDienThoai + ", email=" + email + ", ngaySinh=" + ngaySinh
				+ ", matKhau=" + Arrays.toString(matKhau) + "]";
	}
}
