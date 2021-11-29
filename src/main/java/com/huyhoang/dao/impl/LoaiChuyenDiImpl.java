package com.huyhoang.dao.impl;

import com.huyhoang.dao.LoaiChuyenDi_DAO;
import com.huyhoang.model.LoaiChuyenDi;
import com.huyhoang.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LoaiChuyenDiImpl implements LoaiChuyenDi_DAO {
    private SessionFactory sessionFactory;
    
    public LoaiChuyenDiImpl() {
        this.sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    @Override
    public boolean addLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        
        try {
            tr.begin();
            session.save(loaiChuyenDi);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    @Override
    public List<LoaiChuyenDi> getDsLoaiChuyenDi() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();
        
        List<LoaiChuyenDi> dsLoaiChuyenDi = new ArrayList<>();
        
        try {
            tr.begin();
            dsLoaiChuyenDi = session
                    .createNamedQuery("getDsLoaiChuyenDi", LoaiChuyenDi.class)
                    .getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
        return dsLoaiChuyenDi;
    }
    
}
