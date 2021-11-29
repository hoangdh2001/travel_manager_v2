/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.dao;

import com.huyhoang.model.NhanVien;
import com.huyhoang.service.NhanVienService;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NGUYE
 */
public interface NhanVienDAO {

    public boolean addNhanVien(NhanVien diaDanh);

    public boolean updateNhanVien(NhanVien diaDanh);

    public boolean deleteNhanVien(String id);

    public NhanVien getNhanVien(String id);

    public List<NhanVien> getNhanViens();

    public List<NhanVien> getNhanVien(int numPage);

    public int getSoLuongNhanVien();

//    private SessionFactory sessionFactory;
//
//    public NhanVienDAO() {
//        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
//    }
//
//    @Override
//    public boolean addNhanVien(NhanVien diaDanh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean updateNhanVien(NhanVien diaDanh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean deleteNhanVien(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public NhanVien getNhanVien(String id) {
//       Session session = sessionFactory.openSession();
//        Transaction transaction = session.getTransaction();
//
//        try {
//            transaction.begin();
//            NhanVien rs = session.find(NhanVien.class, id);
//            transaction.commit();
//
//            return rs;
//        } catch (Exception e) {
//            System.err.println(e);
//            transaction.rollback();
//        }
//        return null;
//    }
//
//    @Override
//    public List<NhanVien> getNhanViens() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<NhanVien> getNhanVien(int numPage) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getSoLuongNhanVien() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
