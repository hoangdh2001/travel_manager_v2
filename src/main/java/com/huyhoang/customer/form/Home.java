package com.huyhoang.customer.form;

import com.huyhoang.customer.gui.component.BoxTour;
import com.huyhoang.customer.gui.component.Map;
import com.huyhoang.swing.image.PictureBox;
import javax.swing.ImageIcon;
import com.huyhoang.dao.ChuyenDuLich_DAO;
import com.huyhoang.dao.daoimpl.ChuyenDuLichImpl;
import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.swing.event.EventTour;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import net.miginfocom.swing.MigLayout;

public class Home extends javax.swing.JPanel {

    private EventTour event;
    private ChuyenDuLich_DAO chuyenDuLich_DAO;

    public void addEventTour(EventTour event) {
        this.event = event;
    }

    public Home() {
        this.chuyenDuLich_DAO = new ChuyenDuLichImpl();
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        createSlide();
        createMapTour();
    }

    private void createSlide() {
        PictureBox picture1 = new PictureBox();
        picture1.setImage(new ImageIcon(getClass().getResource("/icon/slide1.jpg")));
        PictureBox picture2 = new PictureBox();
        picture2.setImage(new ImageIcon(getClass().getResource("/icon/slide2.jpeg")));
        PictureBox picture3 = new PictureBox();
        picture3.setImage(new ImageIcon(getClass().getResource("/icon/slide3.jpg")));
        slideShowTransparent1.initSlideshow(picture1, picture2, picture3);
        slideShowTransparent1.showPagination();
        slideShowTransparent1.start();
    }

    private void createMapTour() {
        pnlSuggestions.setLayout(new MigLayout("fillx, insets 0"));
        loadDataMapTourDaXemGanDay();
        loadDataMapTourMoi();
        loadDataMapTourPhoBien();
    }
    
    private void loadDataMapTourDaXemGanDay() {
        
    }

    private void loadDataMapTourMoi() {
        List<ChuyenDuLich> dsChuyenDuLich = chuyenDuLich_DAO.getDsChuyenDuLichMoi();
        if (dsChuyenDuLich != null && dsChuyenDuLich.size() > 0) {
            Map mapTourMoi = new Map();
            mapTourMoi.setTitle("Chuyến du lịch mới nhất");
            for (ChuyenDuLich chuyenDuLich : dsChuyenDuLich) {
                BoxTour boxTour = new BoxTour();
                boxTour.setChuyenDuLich(chuyenDuLich);
                boxTour.addEventBoxTour(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        event.openTour(chuyenDuLich);
                        boxTour.refresh();
                    }
                });
                mapTourMoi.addBox(boxTour, 200, 280);
            }
            pnlSuggestions.add(mapTourMoi);
        }
    }
    
    private void loadDataMapTourPhoBien() {
        List<ChuyenDuLich> dsChuyenDuLich = chuyenDuLich_DAO.getDsChuyenDuLichNhieuDonDatNhat();
        if (dsChuyenDuLich != null && dsChuyenDuLich.size() > 0) {
            Map mapTourMoi = new Map();
            mapTourMoi.setTitle("Phổ biến");
            for (ChuyenDuLich chuyenDuLich : dsChuyenDuLich) {
                BoxTour boxTour = new BoxTour();
                boxTour.setChuyenDuLich(chuyenDuLich);
                boxTour.addEventBoxTour(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        event.openTour(chuyenDuLich);
                        boxTour.refresh();
                    }
                });
                mapTourMoi.addBox(boxTour, 200, 280);
            }
            pnlSuggestions.add(mapTourMoi);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuggestions = new javax.swing.JPanel();
        slideShowTransparent1 = new com.huyhoang.swing.slideshow.SlideShowTransparent();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(57, 20, 0, 20));
        setOpaque(false);

        pnlSuggestions.setOpaque(false);

        javax.swing.GroupLayout pnlSuggestionsLayout = new javax.swing.GroupLayout(pnlSuggestions);
        pnlSuggestions.setLayout(pnlSuggestionsLayout);
        pnlSuggestionsLayout.setHorizontalGroup(
            pnlSuggestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        pnlSuggestionsLayout.setVerticalGroup(
            pnlSuggestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slideShowTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
            .addComponent(pnlSuggestions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideShowTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSuggestions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlSuggestions;
    private com.huyhoang.swing.slideshow.SlideShowTransparent slideShowTransparent1;
    // End of variables declaration//GEN-END:variables
}
