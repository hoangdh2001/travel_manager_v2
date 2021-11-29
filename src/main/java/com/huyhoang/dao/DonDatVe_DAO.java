package com.huyhoang.dao;
 
import com.huyhoang.model.DonDatVe;

public interface DonDatVe_DAO {
    public boolean addDonDatVe(DonDatVe donDatVe);
    public String getMaxID();
}
