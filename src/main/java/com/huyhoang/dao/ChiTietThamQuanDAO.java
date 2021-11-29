/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.dao;

import com.huyhoang.model.ChiTietThamQuan;
import com.huyhoang.service.ChiTietThamQuanService;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NGUYE
 */
public class ChiTietThamQuanDAO implements ChiTietThamQuanService{

    private SessionFactory sessionFactory;

    public ChiTietThamQuanDAO() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }
    @Override
    public boolean addChiTietThamQuan(ChiTietThamQuan chiTietThamQuan) {
         Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            session.save(chiTietThamQuan);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    @Override
    public boolean updateChiTietThamQuan(ChiTietThamQuan diaDanh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteChiTietThamQuan(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChiTietThamQuan getChiTietThamQuan(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChiTietThamQuan> getChiTietThamQuans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChiTietThamQuan> getChiTietThamQuan(int numPage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSoLuongChiTietThamQuan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
