package com.huyhoang.service;

import com.huyhoang.model.ChuyenDuLich;
import java.util.List;

public interface ChuyenDuLichService {
    public boolean addChuyenDuLich(ChuyenDuLich chuyenDuLich);
    public boolean updateChuyenDuLich(ChuyenDuLich chuyenDuLich);
    public boolean deleteChuyenDuLich(String id);
    public ChuyenDuLich getChuyenDuLich(String id);
    public List<ChuyenDuLich> getChuyenDuLichs();
}
