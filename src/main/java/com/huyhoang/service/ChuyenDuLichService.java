package com.huyhoang.service;

import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.model.LoaiChuyenDi;
import com.huyhoang.model.PhuongTien;
import com.huyhoang.model.TrangThaiChuyenDi;
import java.util.List;

public interface ChuyenDuLichService {

    public boolean addChuyenDuLich(ChuyenDuLich chuyenDuLich);

    public boolean updateChuyenDuLich(ChuyenDuLich chuyenDuLich);

    public boolean deleteChuyenDuLich(String id);

    public ChuyenDuLich getChuyenDuLich(String id);

    public List<ChuyenDuLich> getChuyenDuLichs();

    public List<ChuyenDuLich> getChuyenDuLich(int numPage);

    public int getSoLuongCDL();

    public List<ChuyenDuLich> searchChuyenDuLichs(String textSearch, LoaiChuyenDi loaiChuyenDi,
            TrangThaiChuyenDi trangThaiCDL, PhuongTien phuongTien,
            String ngayBD, String ngayKT, String ngayTao, int numPage);

    public int soLuongSearch(String textSearch, LoaiChuyenDi loaiChuyenDi, TrangThaiChuyenDi trangThaiCDL, PhuongTien phuongTien,
            String ngayBD, String ngayKT, String ngayTao);
}
