package com.huyhoang.dao.daoimpl;

import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.huyhoang.dao.ChuyenDuLich_DAO;
import java.util.ArrayList;

public class ChuyenDuLichImpl implements ChuyenDuLich_DAO {

    private SessionFactory sessionFactory;

    public ChuyenDuLichImpl() {
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
            tr.rollback();
        }
        return false;
    }

    @Override
    public boolean updateChuyenDuLich(ChuyenDuLich chuyenDuLich) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();

        try {
            tr.begin();
            session.update(chuyenDuLich);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    @Override
    public boolean deleteChuyenDuLich(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();

        try {
            tr.begin();
            session.delete(session.find(ChuyenDuLich.class, id));
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    @Override
    public ChuyenDuLich getChuyenDuLich(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();

        try {
            tr.begin();
            ChuyenDuLich chuyenDuLich = session.find(ChuyenDuLich.class, id);
            tr.commit();
            return chuyenDuLich;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }

    @Override
    public List<ChuyenDuLich> getDsChuyenDuLich() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();

        List<ChuyenDuLich> dsChuyenDuLich = new ArrayList<>();

        try {
            tr.begin();
            dsChuyenDuLich = session
                    .createNamedQuery("getChuyenDuLichs", ChuyenDuLich.class)
                    .getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
        return dsChuyenDuLich;
    }

    /**
     * Lấy danh sách 5 chuyến du lịch mới nhất
     *
     * @return dsChuyenDuLich
     */
    @Override
    public List<ChuyenDuLich> getDsChuyenDuLichMoi() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();

        String sql = "select top 3 * from chuyendulich\n"
                + "where trangThai = 'CHUA_KHOI_HANH'\n"
                + "order by chuyen_id desc";
        try {
            tr.begin();
            List<ChuyenDuLich> dsChuyenDuLich = session
                    .createNativeQuery(sql, ChuyenDuLich.class)
                    .getResultList();
            tr.commit();
            return dsChuyenDuLich;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }
    /**
     * Lấy danh sách 5 chuyến du lịch phổ biến nhất
     * @return dsChuyenDuLich
     */
    @Override
    public List<ChuyenDuLich> getDsChuyenDuLichNhieuDonDatNhat() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();

        String sql = "select cd.* from chuyendulich cd join dondatve d\n"
                + "on cd.chuyen_id = d.chuyen_id\n"
                + "where cd.trangthai = 'CHUA_KHOI_HANH'\n"
                + "group by cd.chuyen_id, cd.dongtour, cd.giachuyen, cd.loaichuyendi_id, cd.mota,\n"
                + "cd.noikhoihanh, cd.ngay_tao, cd.ngayketthuc, cd.ngaykhoihanh,\n"
                + "cd.nhanvien_id, cd.phuongtien, cd.soluong, cd.trangthai\n"
                + "having COUNT(d.dondatve_id) = (select top 3 COUNT(d.dondatve_id) as slDonDat from chuyendulich cd join dondatve d";
        try {
            tr.begin();
            List<ChuyenDuLich> dsChuyenDuLich = session
                    .createNativeQuery(sql, ChuyenDuLich.class)
                    .getResultList();
            tr.commit();
            return dsChuyenDuLich;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }
}
