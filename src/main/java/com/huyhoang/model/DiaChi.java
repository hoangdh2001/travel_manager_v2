package com.huyhoang.model;

public class DiaChi {
	private String maDiaChi;
	private String phuongXa;
	private String quanHuyen;
	private String tinhThanh;
	/**
	 * @param maDiaChi
	 * @param phuongXa
	 * @param quanHuyen
	 * @param tinhThanh
	 */
	public DiaChi(String maDiaChi, String phuongXa, String quanHuyen, String tinhThanh) {
		this.maDiaChi = maDiaChi;
		this.phuongXa = phuongXa;
		this.quanHuyen = quanHuyen;
		this.tinhThanh = tinhThanh;
	}
	/**
	 * 
	 */
	public DiaChi() {
	}
	/**
	 * @return the maDiaChi
	 */
	public String getMaDiaChi() {
		return maDiaChi;
	}
	/**
	 * @param maDiaChi the maDiaChi to set
	 */
	public void setMaDiaChi(String maDiaChi) {
		this.maDiaChi = maDiaChi;
	}
	/**
	 * @return the phuongXa
	 */
	public String getPhuongXa() {
		return phuongXa;
	}
	/**
	 * @param phuongXa the phuongXa to set
	 */
	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}
	/**
	 * @return the quanHuyen
	 */
	public String getQuanHuyen() {
		return quanHuyen;
	}
	/**
	 * @param quanHuyen the quanHuyen to set
	 */
	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}
	/**
	 * @return the tinhThanh
	 */
	public String getTinhThanh() {
		return tinhThanh;
	}
	/**
	 * @param tinhThanh the tinhThanh to set
	 */
	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}
	@Override
	public String toString() {
		return "DiaChi [maDiaChi=" + maDiaChi + ", phuongXa=" + phuongXa + ", quanHuyen=" + quanHuyen + ", tinhThanh="
				+ tinhThanh + "]";
	}
	
}
