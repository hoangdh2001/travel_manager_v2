package com.hoanghung.employee.gui;

import com.hoanghung.model.ChiTietThamQuan;
import com.hoanghung.model.ChiTietThamQuan_PK;
import com.hoanghung.model.ChuyenDuLich;
import com.hoanghung.model.DiaChi;
import com.hoanghung.model.DiaDanh;
import com.hoanghung.model.DonDatVe;
import com.hoanghung.model.DongTour;
import com.hoanghung.model.HuongDanVien;
import com.hoanghung.model.KhachHang;
import com.hoanghung.model.LoaiChuyenDi;
import com.hoanghung.model.NhanVien;
import com.hoanghung.model.PhuongTien;
import com.hoanghung.model.TrangThaiChuyenDi;
import com.hoanghung.model.TrangThaiDonDat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
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
        
        Transaction tr = session.getTransaction();
        
        try {
            tr.begin();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
        
    }
}
