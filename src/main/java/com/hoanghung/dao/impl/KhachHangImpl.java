package com.hoanghung.dao.impl;

import com.hoanghung.dao.KhachHang_DAO;
import com.hoanghung.model.KhachHang;
import com.hoanghung.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class KhachHangImpl implements KhachHang_DAO {
    private SessionFactory sessionFactory;

    public KhachHangImpl() {
        this.sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }
    
    @Override
    public KhachHang getKhachHangByLogin(String sdt, byte[] matKhau) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        
        String sql = "select * from khachhang "
                + "where sdt = '" + sdt + "' "
                + "and matKhau = :x";
        try {
            tr.begin();
            KhachHang khachHang = session
                    .createNativeQuery(sql, KhachHang.class)
                    .setParameter("x", matKhau)
                    .getSingleResult();
            tr.commit();
            return khachHang;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }

    @Override
    public boolean updateKhachHang(KhachHang khachHang) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        
        try {
            tr.begin();
            session.update(khachHang);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }
}
