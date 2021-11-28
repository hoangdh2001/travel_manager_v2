package com.huyhoang.dao;

import com.huyhoang.model.LoaiChuyenDi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LoaiChuyenDi_DAO extends Remote { 
    public boolean addLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi) throws RemoteException;
    public List<LoaiChuyenDi> getDsLoaiChuyenDi() throws RemoteException;
}
