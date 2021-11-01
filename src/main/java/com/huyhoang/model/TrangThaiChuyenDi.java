package com.huyhoang.model;

import java.awt.Color;

public enum TrangThaiChuyenDi {
	DANG_XU_LY("Đang xử lý", Color.ORANGE),
	CHUA_KHOI_HANH("Chưa khởi hành", Color.GREEN),
	SAP_BAT_DAU("Sắp bắt đầu", Color.RED),
	HUY("Hủy", Color.BLACK),
	DANG_KHOI_HANH("Đang khởi hành", Color.BLUE),
	SAP_KET_THUC("Sắp kết thúc", Color.CYAN),
	KET_THUC("Kết thúc", Color.DARK_GRAY);
	private final String trangThai;
	private final Color mauTrangThai;
	/**
	 * @param trangThai
	 * @param mauTrangThai
	 */
	private TrangThaiChuyenDi(String trangThai, Color mauTrangThai) {
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
