package com.huyhoang.dao;

import com.huyhoang.model.ChuyenDuLich;
import java.util.List;

public interface ChuyenDuLich_DAO {
    public boolean addChuyenDuLich(ChuyenDuLich chuyenDuLich);
    public boolean updateChuyenDuLich(ChuyenDuLich chuyenDuLich);
    public boolean deleteChuyenDuLich(String id);
    public ChuyenDuLich getChuyenDuLich(String id);
    public List<ChuyenDuLich> getDsChuyenDuLich();
    public List<ChuyenDuLich> getDsChuyenDuLichMoi();
    public List<ChuyenDuLich> getDsChuyenDuLichNhieuDonDatNhat();
}
