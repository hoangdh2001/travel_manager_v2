package com.huyhoang.dao.impl;

import com.huyhoang.dao.DonDatVe_DAO;
import com.huyhoang.model.DonDatVe;
import com.huyhoang.util.HibernateUtil;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DonDatVeImpl implements DonDatVe_DAO {
    private SessionFactory sessionFactory;
    public DonDatVeImpl() {
        this.sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }
    @Override
    public boolean addDonDatVe(DonDatVe donDatVe) {
        Session session =sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        
        try {
            tr.begin();
            session.save(donDatVe);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    @Override
    public String getMaxID() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();

        String sql = "select max(dondatve_id) from dondatve";

        try {
            tr.begin();
            String id = (String) session
                    .createNativeQuery(sql)
                    .getSingleResult();
            tr.commit();
            return id;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }
    
}
