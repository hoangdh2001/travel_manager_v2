package com.hoanghung.dao;

import com.hoanghung.model.KhachHang;

public interface KhachHang_DAO {
    public KhachHang getKhachHangByLogin(String sdt, byte[] matKhau);
    public boolean updateKhachHang(KhachHang khachHang);
}
