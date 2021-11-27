package com.huyhoang.customer.form;

import com.huyhoang.customer.gui.component.BoxTour;
import com.huyhoang.customer.gui.component.Map;
import com.huyhoang.swing.button.ButtonBadges;
import com.huyhoang.swing.button.ToggleButtonBadges;
import com.huyhoang.swing.image.PictureBox;
import com.huyhoang.swing.label.LabelResizingShadow;
import com.huyhoang.swing.label.LabelRibbon;
import com.huyhoang.swing.panel.LayerPaneGradient;
import com.huyhoang.swing.slideshow.SlideShowTransparent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;

public class TourInfo extends javax.swing.JLayeredPane {

    private LayerPaneGradient pnlCenter;
    private SlideShowTransparent slide;
    private LayerPaneGradient session;
    private MigLayout layout;
    private ToggleButtonBadges btnLike;
    
    public void addEventLike(ActionListener action) {
        btnLike.addActionListener(action);
    }
    
    public TourInfo() {
        initComponents();
        builldDisplay();
    }

    private void builldDisplay() {
        layout = new MigLayout("fill, insets 0, wrap", "[fill]", "300[fill]");
        setLayout(layout);
        createTitle();
        createPaneCenter();
        createSession();
        createSlide();
    }

    private void createSlide() {
        slide = new SlideShowTransparent();
        PictureBox picture1 = new PictureBox();
        picture1.setImage(new ImageIcon(getClass().getResource("/icon/slide1.jpg")));
        PictureBox picture2 = new PictureBox();
        picture2.setImage(new ImageIcon(getClass().getResource("/icon/slide2.jpeg")));
        PictureBox picture3 = new PictureBox();
        picture3.setImage(new ImageIcon(getClass().getResource("/icon/slide3.jpg")));
        slide.initSlideshow(picture1, picture2, picture3);
        slide.start();
        add(slide, "pos 0al 0al n n, w 100%, h 500!");
    }

    private void createSession() {
        session = new LayerPaneGradient();
        session.setColor1(new Color(34, 34, 34, 10));
        session.setColor2(new Color(10, 10, 10));
        setLayer(session, JLayeredPane.POPUP_LAYER);
        add(session, "pos 0al 230 n n, w 100%, h 280!");
    }

    private void createPaneCenter() {
        pnlCenter = new LayerPaneGradient();
        MigLayout layout2 = new MigLayout("fill, insets 0", "20[fill]push[fill]20", "100[]10[]10[]20[]5[]20[]20");
        pnlCenter.setLayout(layout2);

        ButtonBadges btnDat = new ButtonBadges();
        btnDat.setBackground(new Color(29, 185, 84));
        btnDat.setIcon(new ImageIcon(getClass().getResource("/icon/booking.png")));
        pnlCenter.add(btnDat, "pos 30 20 n n, w 54!, h 54!");

        btnDat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                layout2.setComponentConstraints(btnDat, "pos 27 17 n n, w 60!, h 60!");
                pnlCenter.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                layout2.setComponentConstraints(btnDat, "pos 30 20 n n, w 55!, h 55!");
                pnlCenter.revalidate();
            }
        });

        pnlCenter.setColor1(new Color(34, 34, 34, 150));
        setLayer(pnlCenter, POPUP_LAYER);

        btnLike = new ToggleButtonBadges();
        btnLike.setBackground(new Color(0, 0, 0, 0));
        btnLike.setIcon(new ImageIcon(getClass().getResource("/icon/like.png")));
        btnLike.setRolloverIcon(new ImageIcon(getClass().getResource("/icon/like_over.png")));
        btnLike.setSelectedIcon(new ImageIcon(getClass().getResource("/icon/like_selected.png")));
        pnlCenter.add(btnLike, "pos 104 20 n n, w 54!, h 54!");
        
        LabelRibbon lblGia = new LabelRibbon();
        lblGia.setText("Du lịch tham quan");
        lblGia.setForeground(Color.WHITE);
        lblGia.setBackground(new Color(29, 185, 84));
        lblGia.setShadowOpacity(0.3f);
        lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnlCenter.add(lblGia, "pos 0.99al 27 n n, h 40!");
        
        JLabel lblNgayKhoiHanh = new JLabel("NGÀY KHỞI HÀNH: 27-11-2021");
        lblNgayKhoiHanh.setForeground(new Color(29, 185, 84));
        lblNgayKhoiHanh.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pnlCenter.add(lblNgayKhoiHanh);
        
        JLabel lblGia2 = new JLabel("500,000 đ/người");
        lblGia2.setForeground(new Color(29, 185, 84));
        lblGia2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pnlCenter.add(lblGia2, "wrap");

        JLabel lblthoiGian = new JLabel("THỜI GIAN: 1 ngày");
        lblthoiGian.setForeground(Color.WHITE);
        lblthoiGian.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pnlCenter.add(lblthoiGian);

        JLabel lblPhuongTien = new JLabel("PHƯƠNG TIỆN: Đi về bằng xe");
        lblPhuongTien.setForeground(Color.WHITE);
        lblPhuongTien.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pnlCenter.add(lblPhuongTien, "wrap");

        JLabel lblNoiKhoiHanh = new JLabel("NƠI KHỞI HÀNH: Bến Tre");
        lblNoiKhoiHanh.setForeground(Color.WHITE);
        lblNoiKhoiHanh.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pnlCenter.add(lblNoiKhoiHanh);

        JLabel lblDiemDen = new JLabel("ĐIỂM ĐẾN: Củ Chi - Tây Ninh");
        lblDiemDen.setForeground(Color.WHITE);
        lblDiemDen.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pnlCenter.add(lblDiemDen, "wrap");

        JLabel lblMota = new JLabel("Tour này có gì hay");
        lblMota.setForeground(new Color(29, 185, 84));
        lblMota.setFont(new Font("Segoe UI", Font.BOLD, 13));
        pnlCenter.add(lblMota, "wrap");

        JLabel lblDescription = new JLabel();
        String lblText = String.format("<html><div style=\"width:%dpx;font-size:10px;font-family:'Segoe UI', Arial, sans-serif;\">%s</div></html>", 500, "Một hành trình trong ngày đầy thú vị, có thể tận hưởng trọn vẹn các hoạt động: Du lịch sông nước, thăm nông trại hữu cơ, thưởng thức ẩm thực xứ Dừa, khám phá sân chim với không gian tươi xanh và không khí trong lành.");
        lblDescription.setText(lblText);
        lblDescription.setForeground(Color.WHITE);
        lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        pnlCenter.add(lblDescription, "wrap, span 2");

        createPanelSuggestion();
        add(pnlCenter);
    }

    private void createPanelSuggestion() {
        Map mapTour = new Map();
        mapTour.setTitle("Có thể bạn sẽ thích");
        for (int i = 0; i < 3; i++) {
            BoxTour boxTour = new BoxTour();
            boxTour.addEventBoxTour(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    boxTour.refresh();
                }
            });
            mapTour.addBox(boxTour, 200, 280);
        }
        pnlCenter.add(mapTour, "span 2");
    }

    private void createTitle() {
        LabelResizingShadow tourName = new LabelResizingShadow();
        tourName.setText("Du lịch Củ Chi - Tây Ninh");

        tourName.setFont(new Font("sansserif", Font.BOLD, 30));
        tourName.setForeground(Color.WHITE);
        add(tourName, "pos 20 210 n n, w 450!, h 50!");

        LabelResizingShadow diaDanh = new LabelResizingShadow();
        diaDanh.setText("[KHU DI TÍCH ĐỊA ĐẠO - ĐỀN BẾN DƯỢC- CÁP TREO VÂN SƠN TÂY NINH]");
        diaDanh.setFont(new Font("sansserif", Font.BOLD, 30));
        diaDanh.setForeground(Color.WHITE);
        add(diaDanh, "pos 20 240 n n, w 650!, h 60!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
