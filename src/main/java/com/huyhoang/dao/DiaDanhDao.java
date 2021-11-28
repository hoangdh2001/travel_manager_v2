package com.huyhoang.dao;

import com.huyhoang.model.DiaDanh;
import com.huyhoang.service.DiaDanhService;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DiaDanhDao implements DiaDanhService {

    private SessionFactory sessionFactory;

    public DiaDanhDao() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    @Override
    public boolean addDiaDanh(DiaDanh diaDanh) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            session.save(diaDanh);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    @Override
    public boolean updateDiaDanh(DiaDanh diaDanh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDiaDanh(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DiaDanh getDiaDanh(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DiaDanh> getDiaDanhs() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            List<DiaDanh> rs = session
                    .createNamedQuery("getDiaDanhs", DiaDanh.class)
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
    public List<DiaDanh> getDiaDanh(int numPage) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();
        String sql = "select cdl.* from diadanh cdl order by diadanh_id offset :x row fetch next 20 rows only";
        try {
            tr.begin();
            List<DiaDanh> list = session
                    .createNativeQuery(sql, DiaDanh.class)
                    .setParameter("x", numPage * 20)
                    .getResultList();

            tr.commit();
            return list;

        } catch (Exception e) {
            tr.rollback();
        }
        session.close();
        return null;
    }

    @Override
    public int getSoLuongDiaDanh() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();

        String sql = "select count(*) from diadanh";
        try {
            tr.begin();
            int rs = (int) session.createNativeQuery(sql).getSingleResult();
            tr.commit();
            return rs;
        } catch (Exception e) {
            tr.rollback();
        }
        return 0;
    }

}
