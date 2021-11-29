package com.huyhoang.dao;

import com.huyhoang.model.DiaChi;
import com.huyhoang.service.DiaChiService;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NGUYE
 */
public class DiaChiDAO implements DiaChiService {

    private SessionFactory sessionFactory;

    public DiaChiDAO() {
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        this.sessionFactory = hibernateUtil.getSessionFactory();
    }

    @Override
    public DiaChi getDiaChi(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            String query = "select *from diachi where diachi_id like '" + id + "' ";
            DiaChi rs = (DiaChi) session.createNativeQuery(query).getSingleResult();
            transaction.commit();

            return rs;
        } catch (Exception e) {
            System.err.println(e);
            transaction.rollback();
        }
        return null;
    }

    @Override
    public List<String> getAllTinhThanh() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            String query = "SELECT  DISTINCT(tinhthanh)  FROM  diachi";
            List<String> tinhThanhs = session.createNativeQuery(query).getResultList();

            transaction.commit();
            return tinhThanhs;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return null;
    }

    @Override
    public List<String> getQuanHuyenTheoTinhThanh(String tinhThanh) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            String query = "SELECT  DISTINCT(quanhuyen)  FROM diachi WHERE tinhthanh LIKE N'%" + tinhThanh + "%'";
            List<String> quanHuyens = session.createNativeQuery(query).getResultList();

            transaction.commit();

            return quanHuyens;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return null;
    }

    @Override
    public List<String> getPhuongXaTheoQHTH(String quanHuyen, String tinhThanh) {
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            String query = "SELECT DISTINCT(xaphuong) FROM diachi "
                    + " WHERE tinhthanh LIKE N'%" + tinhThanh + "%' AND quanhuyen LIKE N'%" + quanHuyen + "%'";
            List<String> xaPhuongs = session.createNativeQuery(query).getResultList();

            transaction.commit();
            return xaPhuongs;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return null;
    }

    @Override
    public String getMaDiaChiByTinh(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTinhByMaDiaChi(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            String query = "select tinhthanh from diachi where diachi_id = '" + id + "' ";
            String diaDanh = (String) session.createNativeQuery(query).getSingleResult();
            transaction.commit();

            return diaDanh;
        } catch (Exception e) {
            System.err.println(e);
            transaction.rollback();
        }
        return null;
    }

}
