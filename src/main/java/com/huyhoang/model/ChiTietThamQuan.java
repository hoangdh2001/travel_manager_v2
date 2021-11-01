package com.huyhoang.model;

import java.util.Arrays;

public class ChiTietThamQuan {
	private ChuyenDuLich chuyenDuLich;
	private DiaDanh diaDanh;
	private byte[] anhDiaDanh;
	/**
	 * @param chuyenDuLich
	 * @param diaDanh
	 * @param anhDiaDanh
	 */
	public ChiTietThamQuan(ChuyenDuLich chuyenDuLich, DiaDanh diaDanh, byte[] anhDiaDanh) {
		this.chuyenDuLich = chuyenDuLich;
		this.diaDanh = diaDanh;
		this.anhDiaDanh = anhDiaDanh;
	}
	/**
	 * 
	 */
	public ChiTietThamQuan() {
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
	 * @return the diaDanh
	 */
	public DiaDanh getDiaDanh() {
		return diaDanh;
	}
	/**
	 * @param diaDanh the diaDanh to set
	 */
	public void setDiaDanh(DiaDanh diaDanh) {
		this.diaDanh = diaDanh;
	}
	/**
	 * @return the anhDiaDanh
	 */
	public byte[] getAnhDiaDanh() {
		return anhDiaDanh;
	}
	/**
	 * @param anhDiaDanh the anhDiaDanh to set
	 */
	public void setAnhDiaDanh(byte[] anhDiaDanh) {
		this.anhDiaDanh = anhDiaDanh;
	}
	@Override
	public String toString() {
		return "ChiTietThamQuan [chuyenDuLich=" + chuyenDuLich + ", diaDanh=" + diaDanh + ", anhDiaDanh="
				+ Arrays.toString(anhDiaDanh) + "]";
	}
}
