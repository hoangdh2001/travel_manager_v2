/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.dao;

import com.huyhoang.model.LoaiChuyenDi;
import com.huyhoang.service.LoaiChuyenDiService;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NGUYE
 */
public class LoaiChuyenDiDAO implements LoaiChuyenDiService{

    private SessionFactory sessionFactory;

    public LoaiChuyenDiDAO() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    
    @Override
    public boolean addLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLoaiChuyenDi(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoaiChuyenDi getLoaiChuyenDi(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoaiChuyenDi> getLoaiChuyenDis() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            List<LoaiChuyenDi> rs = session
                    .createNativeQuery(" select * from loaichuyendi ", LoaiChuyenDi.class)
                    .getResultList();
            tr.commit();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

    @Override
    public List<LoaiChuyenDi> getLoaiChuyenDi(int numPage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSoLuongLCD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
