package com.huyhoang.dao.daoimpl;

import com.huyhoang.dao.LoaiChuyenDi_DAO;
import com.huyhoang.model.LoaiChuyenDi;
import com.huyhoang.util.HibernateUtil;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LoaiChuyenDi_Impl extends UnicastRemoteObject implements LoaiChuyenDi_DAO {
    private SessionFactory sessionFactory;
    
    public LoaiChuyenDi_Impl() {
        this.sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    @Override
    public boolean addLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi) throws RemoteException {
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
    public List<LoaiChuyenDi> getDsLoaiChuyenDi() throws RemoteException {
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
