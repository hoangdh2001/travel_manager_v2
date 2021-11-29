package com.huyhoang.dao.impl;

import com.huyhoang.dao.DiaChi_DAO;
import com.huyhoang.model.DiaChi;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DiaChiImpl implements DiaChi_DAO {
    private SessionFactory sessionFactory;

    public DiaChiImpl() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }
    
    @Override
    public List<String> getAllTinhThanh() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();
        String sql = "select distinct tinhthanh from diachi";
        try {
            tr.begin();
            List<String> dsTinhThanh = session
                    .createNativeQuery(sql)
                    .getResultList();
            tr.commit();
            return dsTinhThanh;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }
    
}
