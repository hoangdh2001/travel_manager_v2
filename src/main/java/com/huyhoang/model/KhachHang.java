package com.huyhoang.model;

import java.util.Arrays;

public class KhachHang {
	private String maKhachHang;
	private String hoTen;
	private String cCCD;
	private String soDienThoai;
	private String email;
	private DiaChi diaChi;
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
	public KhachHang(String maKhachHang, String hoTen, String cCCD, String soDienThoai, String email, DiaChi diaChi,
			byte[] matKhau) {
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
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
