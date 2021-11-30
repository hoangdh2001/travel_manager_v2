/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoanghung.dao;

import com.hoanghung.model.ChiTietThamQuan;
import com.hoanghung.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NGUYE
 */
public interface ChiTietThamQuan_DAO {

    public boolean addChiTietThamQuan(ChiTietThamQuan chiTietThamQuan);

    public boolean updateChiTietThamQuan(ChiTietThamQuan chiTietThamQuan);

    public boolean deleteChiTietThamQuan(String id);

    public ChiTietThamQuan getChiTietThamQuan(String id);

    public List<ChiTietThamQuan> getChiTietThamQuans();

    public List<ChiTietThamQuan> getChiTietThamQuan(int numPage);

    public int getSoLuongChiTietThamQuan();

}
