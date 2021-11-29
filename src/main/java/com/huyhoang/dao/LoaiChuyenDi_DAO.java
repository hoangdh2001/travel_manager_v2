package com.huyhoang.dao;

import com.huyhoang.model.LoaiChuyenDi;
import java.util.List;

public interface LoaiChuyenDi_DAO { 
    public boolean addLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi);
    public List<LoaiChuyenDi> getDsLoaiChuyenDi();
}
