package com.huyhoang.dao;

import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.service.ChuyenDuLichService;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ChuyenDuLichDAO implements ChuyenDuLichService{
    private SessionFactory sessionFactory;
    public ChuyenDuLichDAO() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }
    
    @Override
    public boolean addChuyenDuLich(ChuyenDuLich chuyenDuLich) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            session.save(chuyenDuLich);
            tr.commit();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    @Override
    public boolean updateChuyenDuLich(ChuyenDuLich chuyenDuLich) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteChuyenDuLich(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChuyenDuLich getChuyenDuLich(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChuyenDuLich> getChuyenDuLichs() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            List<ChuyenDuLich> rs = session
                    .createNamedQuery("getChuyenDuLichs", ChuyenDuLich.class)
                    .getResultList();
            tr.commit();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    
}
