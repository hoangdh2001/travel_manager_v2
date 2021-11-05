package com.huyhoang.employee.gui;

import com.huyhoang.model.ChiTietThamQuan;
import com.huyhoang.model.ChiTietThamQuan_PK;
import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.model.DiaChi;
import com.huyhoang.model.DiaDanh;
import com.huyhoang.model.DonDatVe;
import com.huyhoang.model.DongTour;
import com.huyhoang.model.HanhKhach;
import com.huyhoang.model.HuongDanVien;
import com.huyhoang.model.KhachHang;
import com.huyhoang.model.LoaiChuyenDi;
import com.huyhoang.model.NhanVien;
import com.huyhoang.model.PhuongTien;
import com.huyhoang.model.TrangThaiChuyenDi;
import com.huyhoang.model.TrangThaiDonDat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.ogm.OgmSession;
//import org.hibernate.ogm.OgmSessionFactory;
//import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
//import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySetting(OgmProperties.ENABLED, true)
                .configure()
                .build();
        
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(ChiTietThamQuan.class)
                .addAnnotatedClass(ChiTietThamQuan_PK.class)
                .addAnnotatedClass(ChuyenDuLich.class)
                .addAnnotatedClass(DiaChi.class)
                .addAnnotatedClass(DiaDanh.class)
                .addAnnotatedClass(DonDatVe.class)
                .addAnnotatedClass(DongTour.class)
                .addAnnotatedClass(HanhKhach.class)
                .addAnnotatedClass(HuongDanVien.class)
                .addAnnotatedClass(KhachHang.class)
                .addAnnotatedClass(LoaiChuyenDi.class)
                .addAnnotatedClass(NhanVien.class)
                .addAnnotatedClass(PhuongTien.class)
                .addAnnotatedClass(TrangThaiChuyenDi.class)
                .addAnnotatedClass(TrangThaiDonDat.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.getCurrentSession();
//        OgmSessionFactory sessionFactory = metadata.getSessionFactoryBuilder().unwrap(OgmSessionFactoryBuilder.class).build();
//        OgmSession session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();
        
        try {
            tr.begin();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
        
    }
}
