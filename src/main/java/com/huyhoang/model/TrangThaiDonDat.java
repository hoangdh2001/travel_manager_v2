package com.huyhoang.model;

import java.awt.Color;

public enum TrangThaiDonDat {
	MOI("Mới", Color.GREEN),
	DANG_XU_LY("Đang xử lý", Color.ORANGE),
	HUY("Hủy", Color.RED),
	HOAN_THANH("Hoàn thành", Color.DARK_GRAY);
	private final String trangThai;
	private final Color mauTrangThai;
	/**
	 * @param trangThai
	 * @param mauTrangThai
	 */
	private TrangThaiDonDat(String trangThai, Color mauTrangThai) {
		this.trangThai = trangThai;
		this.mauTrangThai = mauTrangThai;
	}
	/**
	 * @return the trangThai
	 */
	public String getTrangThai() {
		return trangThai;
	}
	/**
	 * @return the mauTrangThai
	 */
	public Color getMauTrangThai() {
		return mauTrangThai;
	}
}
