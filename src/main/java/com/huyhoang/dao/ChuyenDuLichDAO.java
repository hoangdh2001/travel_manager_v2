package com.huyhoang.dao;

import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.model.LoaiChuyenDi;
import com.huyhoang.model.PhuongTien;
import com.huyhoang.model.TrangThaiChuyenDi;
import com.huyhoang.service.ChuyenDuLichService;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ChuyenDuLichDAO implements ChuyenDuLichService {

    private SessionFactory sessionFactory;

    public ChuyenDuLichDAO() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    @Override
    public boolean addChuyenDuLich(ChuyenDuLich chuyenDuLich) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            session.save(chuyenDuLich);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    @Override
    public boolean updateChuyenDuLich(ChuyenDuLich chuyenDuLich) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteChuyenDuLich(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChuyenDuLich getChuyenDuLich(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChuyenDuLich> getChuyenDuLichs() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            List<ChuyenDuLich> rs = session
                    .createNamedQuery("getChuyenDuLichs", ChuyenDuLich.class)
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
    public List<ChuyenDuLich> getChuyenDuLich(int numPage) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();
        String sql = "select cdl.* from chuyendulich cdl order by chuyen_id offset :x row fetch next 20 rows only";
        try {
            tr.begin();
            List<ChuyenDuLich> dsPhong = session
                    .createNativeQuery(sql, ChuyenDuLich.class)
                    .setParameter("x", numPage * 20)
                    .getResultList();

            tr.commit();
            return dsPhong;

        } catch (Exception e) {
            tr.rollback();
        }
        session.close();
        return null;
    }

    @Override
    public int getSoLuongCDL() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();

        String sql = "select count(*) from chuyendulich";
        try {
            tr.begin();
            int rs = (int) session.
                    createNativeQuery(sql)
                    .getSingleResult();
            tr.commit();
            return rs;
        } catch (Exception e) {
            tr.rollback();
        }
        return 0;
    }

    @Override
    public List<ChuyenDuLich> searchChuyenDuLichs(String textSearch, LoaiChuyenDi loaiChuyenDi, TrangThaiChuyenDi trangThaiCDL,
            PhuongTien phuongTien, String ngayBD, String ngayKT, String ngayTao, int numPage) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        String queryNgayThangNam = " and ( ";

        if (!ngayBD.equals("")) {
            queryNgayThangNam += " ngaykhoihanh = '" + ngayBD + "'  ";
        } else {
            queryNgayThangNam += " ngaykhoihanh like '%%' ";
        }

        if (!ngayKT.equals("")) {
            queryNgayThangNam += "  or ngayketthuc = '" + ngayKT + "'  ";
        }

        if (!ngayTao.equals("")) {
            queryNgayThangNam += "  or ngay_tao = '" + ngayTao + "'  ";
        }

        queryNgayThangNam += " ) ";

        int soLuong = numPage * 20;
        System.out.println("offset DAO: " + soLuong);
        if (soLuong < 0) {
            soLuong = Math.abs(soLuong);
        }

        String query = "select cdl.* from chuyendulich cdl where  "
                + " chuyen_id like N'%" + textSearch + "%'"
                + " and loaichuyendi_id like '%" + (loaiChuyenDi == null ? "" : loaiChuyenDi.getMaLoaiCD()) + "%'"
                + " and trangthai like '%" + (trangThaiCDL == null ? "" : trangThaiCDL) + "%' "
                + " and phuongtien like '%" + (phuongTien == null ? "" : phuongTien) + "%' "
                + queryNgayThangNam
                + " order by chuyen_id offset " + soLuong + " rows fetch next 20 rows only";
        try {
            transaction.begin();
            List<ChuyenDuLich> list = session.createNativeQuery(query, ChuyenDuLich.class)
                    .getResultList();
            transaction.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return null;
    }

    @Override
    public int soLuongSearch(String textSearch, LoaiChuyenDi loaiChuyenDi, TrangThaiChuyenDi trangThaiCDL, PhuongTien phuongTien,
            String ngayBD, String ngayKT, String ngayTao) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        String queryNgayThangNam = " and ( ";

        if (!ngayBD.equals("")) {
            queryNgayThangNam += " ngaykhoihanh = '" + ngayBD + "'  ";
        } else {
            queryNgayThangNam += " ngaykhoihanh like '%%' ";
        }
        if (!ngayKT.equals("")) {
            queryNgayThangNam += "  or ngayketthuc = '" + ngayKT + "'  ";
        }
        if (!ngayTao.equals("")) {
            queryNgayThangNam += "  or ngay_tao = '" + ngayTao + "'  ";
        }
        queryNgayThangNam += " ) ";

        String query = "select count(*) from chuyendulich where  "
                + " chuyen_id like N'%" + textSearch + "%'"
                + " and loaichuyendi_id like '%" + (loaiChuyenDi == null ? "" : loaiChuyenDi.getMaLoaiCD()) + "%'"
                + " and trangthai like '%" + (trangThaiCDL == null ? "" : trangThaiCDL) + "%' "
                + " and phuongtien like '%" + (phuongTien == null ? "" : phuongTien) + "%' "
                + queryNgayThangNam;

        try {
            transaction.begin();
            int list = (int) session.createNativeQuery(query).getSingleResult();
            transaction.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return 0;
    }

    @Override
    public ChuyenDuLich getLastChuyenDuLich() {
    Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            String query = "SELECT * FROM chuyendulich "
                    + " WHERE chuyen_id = (SELECT MAX(chuyen_id) FROM chuyendulich)";
            ChuyenDuLich nhanVien = session.createNativeQuery(query, ChuyenDuLich.class).getSingleResult();
            transaction.commit();

            return nhanVien;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    
    

}
