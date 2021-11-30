package com.hoanghung.dao;

import com.hoanghung.model.LoaiChuyenDi;
import java.util.List;

public interface LoaiChuyenDi_DAO { 
    public boolean addLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi);
    public List<LoaiChuyenDi> getDsLoaiChuyenDi();
    //nh
    public boolean updateLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi);
    public boolean deleteLoaiChuyenDi(String id);
    public LoaiChuyenDi getLoaiChuyenDi(String id);
    public List<LoaiChuyenDi> getLoaiChuyenDis();
    public List<LoaiChuyenDi> getLoaiChuyenDi(int numPage);
    public int getSoLuongLCD();
}
