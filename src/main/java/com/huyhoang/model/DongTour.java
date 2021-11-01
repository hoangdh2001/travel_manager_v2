package com.huyhoang.model;

public enum DongTour {
	CAO_CAP("Cao cấp"),
	TIET_KIEM("Tiết kiệm"),
	GIA_TOT("Giá tốt");
	private final String dongTour;

	/**
	 * @param dongTour
	 */
	private DongTour(String dongTour) {
		this.dongTour = dongTour;
	}

	/**
	 * @return the dongTour
	 */
	public String getDongTour() {
		return dongTour;
	}
	
}
