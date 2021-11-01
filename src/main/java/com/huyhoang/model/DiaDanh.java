package com.huyhoang.model;

public class DiaDanh {
	private String maDiaDanh;
	private String tenDiaDanh;
	private String tinh;
	/**
	 * @param maDiaDanh
	 * @param tenDiaDanh
	 * @param tinh
	 */
	public DiaDanh(String maDiaDanh, String tenDiaDanh, String tinh) {
		this.maDiaDanh = maDiaDanh;
		this.tenDiaDanh = tenDiaDanh;
		this.tinh = tinh;
	}
	/**
	 * 
	 */
	public DiaDanh() {
	}
	/**
	 * @return the maDiaDanh
	 */
	public String getMaDiaDanh() {
		return maDiaDanh;
	}
	/**
	 * @param maDiaDanh the maDiaDanh to set
	 */
	public void setMaDiaDanh(String maDiaDanh) {
		this.maDiaDanh = maDiaDanh;
	}
	/**
	 * @return the tenDiaDanh
	 */
	public String getTenDiaDanh() {
		return tenDiaDanh;
	}
	/**
	 * @param tenDiaDanh the tenDiaDanh to set
	 */
	public void setTenDiaDanh(String tenDiaDanh) {
		this.tenDiaDanh = tenDiaDanh;
	}
	/**
	 * @return the tinh
	 */
	public String getTinh() {
		return tinh;
	}
	/**
	 * @param tinh the tinh to set
	 */
	public void setTinh(String tinh) {
		this.tinh = tinh;
	}
	@Override
	public String toString() {
		return "DiaDanh [maDiaDanh=" + maDiaDanh + ", tenDiaDanh=" + tenDiaDanh + ", tinh=" + tinh + "]";
	}
}
