/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.employee.gui.dialog;

import com.huyhoang.dao.ChiTietThamQuanDAO;
import com.huyhoang.dao.ChuyenDuLichDAO;
import com.huyhoang.dao.DiaChiDAO;
import com.huyhoang.dao.DiaDanhDao;
import com.huyhoang.dao.LoaiChuyenDiDAO;
import com.huyhoang.dao.NhanVienDAO;
import com.huyhoang.model.ChiTietThamQuan;
import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.model.DiaChi;
import com.huyhoang.model.DiaDanh;
import com.huyhoang.model.DongTour;
import com.huyhoang.model.LoaiChuyenDi;
import com.huyhoang.model.NhanVien;
import com.huyhoang.model.PhuongTien;
import com.huyhoang.model.TrangThaiChuyenDi;
import com.huyhoang.swing.event.EventAddImage;
import com.huyhoang.swing.model.AutoID;
import com.huyhoang.swing.model.ModelAddImage;
import com.huyhoang.swing.slideshow.EventPagination;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYE
 */
public class DialogTour extends javax.swing.JDialog {

    private ChuyenDuLichDAO chuyenDuLichDAO;
    private LoaiChuyenDiDAO loaiChuyenDiDAO;
    private DiaDanhDao diaDanhDao;
    private NhanVienDAO nhanVienDAO;
    private DiaChiDAO diaChiDAO;
    private ChiTietThamQuanDAO chiTietThamQuanDAO;

    private List<LoaiChuyenDi> listlLoaiChuyenDis;
    private List<DiaDanh> listDiaDanhs;
    private List<ChiTietThamQuan> chiTietThamQuans;
    private DefaultComboBoxModel<LoaiChuyenDi> cmbLoaiChuyenDiModel = new DefaultComboBoxModel<>();

    private ChuyenDuLich chuyenDuLich;

    public DialogTour(java.awt.Frame parent) {
        super(parent, true);
        initComponents();

        chuyenDuLichDAO = new ChuyenDuLichDAO();
        loaiChuyenDiDAO = new LoaiChuyenDiDAO();
        diaDanhDao = new DiaDanhDao();
        nhanVienDAO = new NhanVienDAO();
        diaChiDAO = new DiaChiDAO();
        chiTietThamQuanDAO = new ChiTietThamQuanDAO();

        chiTietThamQuans = new ArrayList<ChiTietThamQuan>();
        chuyenDuLich = new ChuyenDuLich();

        setPropertiesForm();
        comboBoxHandle();

        loadPageDiaDanhHandle();
        searchHandle();

        loadDataDiaDanh(pnlPageDD.getCurrentIndex());

        addValueTable_CTTQ();
        themHinhAnhHandle();
        loaiBoChiTietThamQuan();

        insertChuyenDuLichHandle();

        clearForm();
    }

    private void setPropertiesForm() {
        Color colorBtn = new Color(184, 238, 241);

        tblDiaDanh.getTableHeader().setPreferredSize(new Dimension(getWidth(), 30));
        tblDiaDanh.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        tblCTTQ.getTableHeader().setPreferredSize(new Dimension(getWidth(), 30));
        tblCTTQ.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

        cmbTimKiemTinh.addItem("");
        jdcNgayBatDau.setDateFormatString("dd-MM-yyy");
        jdcNgayKetThuc.setDateFormatString("dd-MM-yyy");

        btnLamMoi.setBackground(colorBtn);
        btnThem.setBackground(colorBtn);
        btnThemCTTQ.setBackground(colorBtn);
        btnLoaiBo.setBackground(colorBtn);
    }

    /**
     * Xử lý load dữ liệu lên các combobox
     */
    private void comboBoxHandle() {
        listlLoaiChuyenDis = loaiChuyenDiDAO.getLoaiChuyenDis();
        cmbLoaiChuyenDiModel.addAll(listlLoaiChuyenDis);

        DongTour[] dongTours = DongTour.values();
        for (DongTour i : dongTours) {
            cmbDongTour.addItem(i.getDongTour());
        }

        PhuongTien[] phuongTiens = PhuongTien.values();
        for (PhuongTien i : phuongTiens) {
            cmbPhuongTien.addItem(i.getPhuongTien());
        }

        // phường 4, gò vấp, HCM
        cmbNoiKhoiHanh.addItem(diaChiDAO.getTinhByMaDiaChi("DC-0001204"));
        // Hải Hòa, Ngũ hành sơn, đà nẵng
        cmbNoiKhoiHanh.addItem(diaChiDAO.getTinhByMaDiaChi("DC-0000121"));
        //sài đồng, long biên, hà nội
        cmbNoiKhoiHanh.addItem(diaChiDAO.getTinhByMaDiaChi("DC-0000678"));

        diaDanhDao.getTinhThanhDiaDanhs().forEach(i -> {
            cmbTimKiemTinh.addItem(i);
        });
    }

    private void searchHandle() {
        cmbTimKiemTinh.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                loadPage();
                ((DefaultTableModel) tblDiaDanh.getModel()).setRowCount(0);
                loadDataDiaDanh(pnlPageDD.getCurrentIndex());
            }
        });
    }

    /**
     * Load dữ liệu lên bảng địa danh dựa và số trang
     *
     * @param numPage
     */
    private void loadDataDiaDanh(int numPage) {
        ((DefaultTableModel) tblDiaDanh.getModel()).setRowCount(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String textSearch = txtTimKiem.getText().trim();

                List<DiaDanh> list = diaDanhDao.searchDiaDanhs(textSearch, cmbTimKiemTinh.getSelectedItem().toString(), numPage);
                Set<DiaDanh> temp = new HashSet<>();

                for (DiaDanh i : list) {
                    temp.add(i);
                }

                if (temp != null) {
                    temp.forEach(i -> {
                        System.out.println(i);
                        tblDiaDanh.addRow(new DiaDanh(i.getMaDiaDanh(), i.getTenDiaDanh(),
                                i.getTinh()).convertToRowTable());
                        
                    });

                    tblDiaDanh.repaint();
                    tblDiaDanh.revalidate();
                }
            }
        }).start();
    }

    /**
     * Load số trang - tạo số trang
     */
    private void loadPage() {
        int row = diaDanhDao.getSoLuongSearch(txtTimKiem.getText().trim(), cmbTimKiemTinh.getSelectedItem().toString());
        int x = row % 20 == 0 ? row / 20 : (row / 20) + 1;
        if (x == 0) {
            x = 1;
        }
        pnlPageDD.init(x);
    }

    /**
     * Xử lý load trang ở bảng địa danh
     */
    private void loadPageDiaDanhHandle() {
        pnlPageDD.addEventPagination(new EventPagination() {
            @Override
            public void onClick(int pageClick) {
                loadDataDiaDanh(pageClick);
            }
        });
        loadPage();
    }

    /**
     * làm mới lại giao diện
     */
    private void clearForm() {
        ChuyenDuLich last = chuyenDuLichDAO.getLastChuyenDuLich();
        String newID = AutoID.generateId(last.getMaChuyen(), "CD");
        System.out.println(last.getMaChuyen());

        txtMa.setText(newID);
//        cmbPhuongTien.setSelectedIndex(0);
        txtSoLuong.setText("");
//        cmbLoaiChuyenDi.setSelectedIndex(0);
//        cmbDongTour.setSelectedIndex(0);

        txtGiaChuyen.setText("");
        txaMoTa.setText("");

    }

    /**
     *
     *
     */
    private void addValueTable_CTTQ() {
        tblDiaDanh.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                    String maDiaDanh = (String) tblDiaDanh.getValueAt(tblDiaDanh.getSelectedRow(), 0);
                    String maChuyenDi = txtMa.getText();
//                    tblCTTQ.addRow(new Object[]{"id", maDD, new ModelAddImage("hinh anh string", event)});
                    tblCTTQ.addRow(new Object[]{maChuyenDi, maDiaDanh, ""});
                    tblCTTQ.repaint();
                    tblCTTQ.revalidate();

                }
            }

        });
    }

    private void themHinhAnhHandle() {

        btnThemAnh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tblCTTQ.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Chưa chọn chi tiết tham quan nêm không thêm ảnh được");

                } else {
                    JFileChooser chooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "jpeg", "gif", "png");
                    chooser.setFileFilter(filter);

                    String fileName = "";
                    String filePath = "";

                    int returnVal = chooser.showOpenDialog(null);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        fileName = chooser.getSelectedFile().getName();
                        filePath = chooser.getSelectedFile().getAbsolutePath();

                        //thêm đường dẫn vào cột hình ảnh của dòng đang được chọn
                        tblCTTQ.setValueAt(filePath, tblCTTQ.getSelectedRow(), 2);
                        tblCTTQ.getSelectionModel().clearSelection();

                        System.out.println("You chose to open this file: " + fileName);
                    } else {
                        return;
                    }
                }

            }
        });
    }

    /**
     * lấy dữ liệu từ bảng chi tiết tham quan (tblCTTQ) để tạo ChiTietThamQuan
     * sau đó thêm vào chuyenDuLich.themChiTietThamQuan(..., ...)
     */
    private void createAndSet_ChiTietThamQuan() {
        int rowCount_CTTQ = tblCTTQ.getRowCount();

        for (int row = 0; row < rowCount_CTTQ; row++) {
            DiaDanh diaDanh = diaDanhDao.getDiaDanh(tblCTTQ.getValueAt(row, 1).toString());

            File file = new File(tblCTTQ.getValueAt(row, 2).toString());
            byte[] anhPhong = null;
            try {
                anhPhong = Files.readAllBytes(file.toPath());
            } catch (IOException ex) {

            }

            chuyenDuLich.themChiTietThamQuan(diaDanh, anhPhong);
        }

    }

    private void loaiBoChiTietThamQuan() {
        btnLoaiBo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((DefaultTableModel) tblCTTQ.getModel()).removeRow(tblCTTQ.getSelectedRow());
            }
        });
    }

    private void insertChuyenDuLichHandle() {

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // check có đủ ảnh hay chưa: nếu số dòng != số đường dẫn ảnh -> lỗi
                if (checkPathImage() == false) {
                    JOptionPane.showMessageDialog(null, "Thiếu ảnh của chi tiết tham quan");
                } else {

                    createAndSet_ChiTietThamQuan();

                    if (insert_CDL() == true) {

                        //Nếu thêm chi tiết tham quan thành công thì thông báo tất cả thêm thành công
                        if (insert_CTTQ() == true) {
                            JOptionPane.showMessageDialog(null, "Thêm thành công");
                        } else {
                            JOptionPane.showMessageDialog(null, "Thêm thất bại");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại");
                    }
                }
            }
        });
    }

    /**
     * kiểm tra đã chọn đầy đủ hình ảnh cho chi tiết tham quan hay chưa
     *
     * @return true: đủ
     * @return false: thiếu đường dẫn
     */
    private boolean checkPathImage() {

        for (int row = 0; row < tblCTTQ.getRowCount(); row++) {
            String value = (String) tblCTTQ.getValueAt(row, 2);
            if (value.equals("")) {
                return false;
            }
        }

        return true;
    }

    /**
     * chèn chuyến du lịch xuống database
     */
    private boolean insert_CDL() {

        String maCDL = txtMa.getText();
        double gia = Double.parseDouble(txtGiaChuyen.getText());
        LoaiChuyenDi loaiChuyenDi = cmbLoaiChuyenDiModel.getElementAt(cmbLoaiChuyenDi.getSelectedIndex());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate now = LocalDate.now();

        System.out.println(now);
        System.out.println(now.getYear() + "" + now.getMonthValue() + "" + now.getDayOfMonth());

        Date ngayTao = new java.sql.Date(now.getYear() - 1900, now.getMonthValue(), now.getDayOfMonth());
        System.out.println(".actionPerformed()" + ngayTao);

        Date ngayKhoiHanh = new java.sql.Date(jdcNgayBatDau.getDate().getTime());
        Date ngayKetThuc = new java.sql.Date(jdcNgayKetThuc.getDate().getTime());

        TrangThaiChuyenDi trangThai = TrangThaiChuyenDi.CHUA_KHOI_HANH;
        PhuongTien phuongTien = PhuongTien.getValuePhuongTien(cmbPhuongTien.getSelectedItem().toString());
        DongTour dongTour = DongTour.getEnumDongTour(cmbDongTour.getSelectedItem().toString());

        String moTa = txaMoTa.getText().trim();

        int soLuong = Integer.parseInt(txtSoLuong.getText());

        NhanVien nhanVien = nhanVienDAO.getNhanVien("NV0004");

        String maDiaChi = "";
        switch (cmbNoiKhoiHanh.getSelectedIndex()) {
            case 0:
                maDiaChi = "DC-0001204";
                break;
            case 1:
                maDiaChi = "DC-0000121";
                break;
            case 2:
                maDiaChi = "DC-0000678";
                break;
            default:
                break;
        }
        DiaChi noiKhoiHanh = diaChiDAO.getDiaChi(maDiaChi);
        System.out.println("maDiaChi" + maDiaChi);
        System.out.println("noiKhoiHanh" + noiKhoiHanh);

        chuyenDuLich.setMaChuyen(maCDL);
        chuyenDuLich.setGiaChuyenDi(gia);
        chuyenDuLich.setLoaiChuyenDi(loaiChuyenDi);
        chuyenDuLich.setNgayTao(ngayTao);
        chuyenDuLich.setNgayKhoiHanh(ngayKhoiHanh);
        chuyenDuLich.setNgayKetThuc(ngayKetThuc);

        chuyenDuLich.setTrangThai(trangThai);
        chuyenDuLich.setPhuongTien(phuongTien);
        chuyenDuLich.setDongTour(dongTour);
        chuyenDuLich.setMoTa(moTa);
        chuyenDuLich.setSoLuong(soLuong);
        chuyenDuLich.setNhanVien(nhanVien);
        chuyenDuLich.setNoiKhoiHanh(noiKhoiHanh);

        boolean result = chuyenDuLichDAO.addChuyenDuLich(chuyenDuLich);

        return result;
    }

    private boolean insert_CTTQ() {

        List<ChiTietThamQuan> list = chuyenDuLich.getDsChiTietThamQuan();
        for (ChiTietThamQuan i : list) {
            if (chiTietThamQuanDAO.addChiTietThamQuan(i) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeft = new com.huyhoang.swing.panel.PanelShadow();
        txtMa = new javax.swing.JTextField();
        lblMa = new javax.swing.JLabel();
        lblNgayBatDau = new javax.swing.JLabel();
        jdcNgayBatDau = new com.toedter.calendar.JDateChooser();
        lblNgayKetThuc = new javax.swing.JLabel();
        jdcNgayKetThuc = new com.toedter.calendar.JDateChooser();
        lblPhuongTien = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lblSoLuong = new javax.swing.JLabel();
        lblLoaiChuyenDi = new javax.swing.JLabel();
        lblDongTour = new javax.swing.JLabel();
        lblGiaChuyen = new javax.swing.JLabel();
        txtGiaChuyen = new javax.swing.JTextField();
        lblMoTa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMoTa = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        cmbPhuongTien = new javax.swing.JComboBox<>();
        cmbLoaiChuyenDi = new javax.swing.JComboBox<>(cmbLoaiChuyenDiModel);
        cmbDongTour = new javax.swing.JComboBox<>();
        lblNoiKhoiHanh = new javax.swing.JLabel();
        cmbNoiKhoiHanh = new javax.swing.JComboBox<>();
        pnlTopRight = new com.huyhoang.swing.panel.PanelShadow();
        pnlTimKiem = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        cmbTimKiemTinh = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDiaDanh = new com.huyhoang.swing.table2.MyTable();
        pnlPageDD = new com.huyhoang.swing.table2.PanelPage();
        btnThemCTTQ = new javax.swing.JButton();
        pnlBottomRight = new com.huyhoang.swing.panel.PanelShadow();
        pnlPageHDV = new com.huyhoang.swing.table2.PanelPage();
        btnLoaiBo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCTTQ = new com.huyhoang.swing.table2.MyTable();
        btnThemAnh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 0));

        pnlLeft.setBackground(new java.awt.Color(255, 255, 255));

        txtMa.setEditable(false);
        txtMa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        lblMa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblMa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMa.setText("Mã tour");

        lblNgayBatDau.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNgayBatDau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgayBatDau.setText("Ngày bắt đầu");

        lblNgayKetThuc.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNgayKetThuc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgayKetThuc.setText("Ngày kết thúc");

        lblPhuongTien.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPhuongTien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPhuongTien.setText("Phương tiện");

        txtSoLuong.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        lblSoLuong.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSoLuong.setText("Số lượng");

        lblLoaiChuyenDi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblLoaiChuyenDi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiChuyenDi.setText("Loại chuyến đi");

        lblDongTour.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblDongTour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDongTour.setText("Dòng tour");

        lblGiaChuyen.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblGiaChuyen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGiaChuyen.setText("Giá chuyến");

        txtGiaChuyen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        lblMoTa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblMoTa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMoTa.setText("Mô tả");

        txaMoTa.setColumns(20);
        txaMoTa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txaMoTa.setRows(5);
        jScrollPane1.setViewportView(txaMoTa);

        btnThem.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnThem.setText("Thêm");

        btnLamMoi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnLamMoi.setText("Làm mới");

        cmbPhuongTien.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        cmbLoaiChuyenDi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        cmbDongTour.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        lblNoiKhoiHanh.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNoiKhoiHanh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNoiKhoiHanh.setText("Nơi khởi hành");

        cmbNoiKhoiHanh.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addComponent(lblNoiKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbNoiKhoiHanh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMoTa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGiaChuyen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDongTour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDongTour, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblNgayBatDau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNgayKetThuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPhuongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLoaiChuyenDi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(jdcNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(jdcNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(cmbPhuongTien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbLoaiChuyenDi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlLeftLayout.createSequentialGroup()
                                .addComponent(btnLamMoi)
                                .addGap(18, 18, 18)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLeftLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblPhuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbPhuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiChuyenDi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLoaiChuyenDi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDongTour, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDongTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGiaChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNoiKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNoiKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlTopRight.setBackground(new java.awt.Color(255, 255, 255));

        pnlTimKiem.setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        cmbTimKiemTinh.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(cmbTimKiemTinh, 0, 224, Short.MAX_VALUE)
                .addGap(111, 111, 111))
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiem)
                    .addComponent(cmbTimKiemTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tblDiaDanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã địa danh", "Tên", "Tỉnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiaDanh.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(tblDiaDanh);

        pnlPageDD.setOpaque(false);

        btnThemCTTQ.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnThemCTTQ.setText("Thêm vào Chi tiết tham quan");

        javax.swing.GroupLayout pnlTopRightLayout = new javax.swing.GroupLayout(pnlTopRight);
        pnlTopRight.setLayout(pnlTopRightLayout);
        pnlTopRightLayout.setHorizontalGroup(
            pnlTopRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTopRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTopRightLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(pnlTopRightLayout.createSequentialGroup()
                        .addComponent(pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(btnThemCTTQ, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(pnlTopRightLayout.createSequentialGroup()
                        .addComponent(pnlPageDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlTopRightLayout.setVerticalGroup(
            pnlTopRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTopRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemCTTQ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPageDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pnlBottomRight.setBackground(new java.awt.Color(255, 255, 255));

        pnlPageHDV.setOpaque(false);

        btnLoaiBo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnLoaiBo.setText("Loại bỏ");

        tblCTTQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chuyến đi", "Mã địa danh", "Hình ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTTQ.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(tblCTTQ);

        btnThemAnh.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnThemAnh.setText("Thêm ảnh");

        javax.swing.GroupLayout pnlBottomRightLayout = new javax.swing.GroupLayout(pnlBottomRight);
        pnlBottomRight.setLayout(pnlBottomRightLayout);
        pnlBottomRightLayout.setHorizontalGroup(
            pnlBottomRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomRightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoaiBo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(pnlBottomRightLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pnlPageHDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBottomRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBottomRightLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlBottomRightLayout.setVerticalGroup(
            pnlBottomRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomRightLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlBottomRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoaiBo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(pnlPageHDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(pnlBottomRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBottomRightLayout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTopRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBottomRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTopRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlBottomRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLoaiBo;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemAnh;
    private javax.swing.JButton btnThemCTTQ;
    private javax.swing.JComboBox<String> cmbDongTour;
    private javax.swing.JComboBox cmbLoaiChuyenDi;
    private javax.swing.JComboBox<String> cmbNoiKhoiHanh;
    private javax.swing.JComboBox<String> cmbPhuongTien;
    private javax.swing.JComboBox<String> cmbTimKiemTinh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcNgayBatDau;
    private com.toedter.calendar.JDateChooser jdcNgayKetThuc;
    private javax.swing.JLabel lblDongTour;
    private javax.swing.JLabel lblGiaChuyen;
    private javax.swing.JLabel lblLoaiChuyenDi;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblMoTa;
    private javax.swing.JLabel lblNgayBatDau;
    private javax.swing.JLabel lblNgayKetThuc;
    private javax.swing.JLabel lblNoiKhoiHanh;
    private javax.swing.JLabel lblPhuongTien;
    private javax.swing.JLabel lblSoLuong;
    private com.huyhoang.swing.panel.PanelShadow pnlBottomRight;
    private com.huyhoang.swing.panel.PanelShadow pnlLeft;
    private com.huyhoang.swing.table2.PanelPage pnlPageDD;
    private com.huyhoang.swing.table2.PanelPage pnlPageHDV;
    private javax.swing.JPanel pnlTimKiem;
    private com.huyhoang.swing.panel.PanelShadow pnlTopRight;
    private com.huyhoang.swing.table2.MyTable tblCTTQ;
    private com.huyhoang.swing.table2.MyTable tblDiaDanh;
    private javax.swing.JTextArea txaMoTa;
    private javax.swing.JTextField txtGiaChuyen;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
