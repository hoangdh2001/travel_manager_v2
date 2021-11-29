package com.huyhoang.dao.impl;

import com.huyhoang.dao.KhachHang_DAO;
import com.huyhoang.model.KhachHang;
import com.huyhoang.util.HibernateUtil;
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
    
}
