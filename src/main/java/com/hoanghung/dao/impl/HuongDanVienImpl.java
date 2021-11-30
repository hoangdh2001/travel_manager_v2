package com.hoanghung.dao.impl;

import com.hoanghung.dao.HuongDanVien_DAO;
import com.hoanghung.model.HuongDanVien;
import com.hoanghung.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HuongDanVienImpl implements HuongDanVien_DAO {

    private SessionFactory sessionFactory;

    public HuongDanVienImpl() {
        this.sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    @Override
    public HuongDanVien getHuongDanVienRandom() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        String sql = "SELECT top 1 * FROM huongdanvien\n"
                + "ORDER BY NEWID()";
        try {
            tr.begin();
            HuongDanVien huongDanVien = session
                    .createNativeQuery(sql, HuongDanVien.class)
                    .getSingleResult();
            tr.commit();
            return huongDanVien;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }

}
