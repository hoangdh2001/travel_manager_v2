package com.huyhoang.customer.gui.dialog;

import com.huyhoang.customer.gui.Main;
import com.huyhoang.dao.DonDatVe_DAO;
import com.huyhoang.dao.impl.DonDatVeImpl;
import com.huyhoang.model.ChiTietThamQuan;
import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.model.DonDatVe;
import com.huyhoang.swing.autoid.AutoID;
import com.huyhoang.swing.image.PictureBox;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class DialogBookTour extends javax.swing.JDialog {

    private boolean show;
    private Animator start;
    private DonDatVe_DAO donDatVe_DAO;
    private DonDatVe donDatVe;

    public DialogBookTour(java.awt.Frame parent, ChuyenDuLich chuyenDuLich) {
        super(parent, true);
        donDatVe_DAO = new DonDatVeImpl();
        String maxID = donDatVe_DAO.getMaxID();
        String maDon;
        if (maxID == null) {
            maDon = "HD0000001";
        } else {
            maDon = AutoID.generateId(maxID, "HD");
        }
        this.donDatVe = new DonDatVe(maDon, Main.khachHang, chuyenDuLich);
        initComponents();
        buildDisplay();
    }

    

    private void buildDisplay() {
        start();
        loadDataForm();
    }
    
    private void loadDataForm() {
        String diaDanh = "[";
        String tinh = "Du lịch ";
        List<ChiTietThamQuan> dsChiTietThamQuan = donDatVe.getChuyenDuLich().getDsChiTietThamQuan();
        if (dsChiTietThamQuan.size() > 0) {
            for (int i = 0; i < dsChiTietThamQuan.size(); i++) {
                slideShowTransparent1.addImage(new PictureBox(new ImageIcon(dsChiTietThamQuan.get(i).getAnhDiaDanh())));
                if (i == (dsChiTietThamQuan.size() - 1)) {
                    diaDanh = diaDanh + dsChiTietThamQuan.get(i).getDiaDanh().getTenDiaDanh() + "]";
                    tinh = tinh + dsChiTietThamQuan.get(i).getDiaDanh().getTinh();
                } else {
                    diaDanh = diaDanh + dsChiTietThamQuan.get(i).getDiaDanh().getTenDiaDanh() + " - ";
                    tinh = tinh + dsChiTietThamQuan.get(i).getDiaDanh().getTinh() + " - ";
                }
            }
        }
        tenTour.setText(tinh);
        tenDiaDanh.setText(diaDanh);
    }

    private void start() {
        setBackground(new Color(0, 0, 0, 0));
        setOpacity(0);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (!show) {
                    dispose();
                }
            }
        };
        start = new Animator(200, target);
        start.setResolution(0);
        start.setAcceleration(0.5f);
    }

    @Override
    public void setVisible(boolean b) {
        show = b;
        if (show) {
            start.start();
        }
        super.setVisible(b);
    }

    private void close() {
        if (start.isRunning()) {
            start.stop();
        }
        show = false;
        start.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layerPaneShadow1 = new com.huyhoang.swing.panel.LayerPaneShadow();
        jLabel1 = new javax.swing.JLabel();
        switchButton1 = new com.huyhoang.swing.button.SwitchButton();
        buttonBadges1 = new com.huyhoang.swing.button.ButtonBadges();
        jLabel2 = new javax.swing.JLabel();
        buttonBadges2 = new com.huyhoang.swing.button.ButtonBadges();
        jLabel3 = new javax.swing.JLabel();
        slideShowTransparent1 = new com.huyhoang.swing.slideshow.SlideShowTransparent();
        tenTour = new com.huyhoang.swing.label.WrapLabel();
        tenDiaDanh = new com.huyhoang.swing.label.WrapLabel();
        button1 = new com.huyhoang.swing.button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        layerPaneShadow1.setBackground(new java.awt.Color(19, 19, 19));
        layerPaneShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        layerPaneShadow1.setBorderRadius(10);
        layerPaneShadow1.setShadowOpacity(0.3F);
        layerPaneShadow1.setShadowSize(10);
        layerPaneShadow1.setShadowType(com.huyhoang.swing.graphics.ShadowType.BOT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Số lượng");

        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("1");

        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hướng dẫn viên");

        tenTour.setForeground(new java.awt.Color(255, 255, 255));
        tenTour.setText("Du lịch");
        tenTour.setToolTipText("");
        tenTour.setVAlignStyle(0.0F);
        tenTour.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tenDiaDanh.setForeground(new java.awt.Color(255, 255, 255));
        tenDiaDanh.setText("[địa danh]");
        tenDiaDanh.setToolTipText("");
        tenDiaDanh.setVAlignStyle(0.0F);
        tenDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        layerPaneShadow1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPaneShadow1.setLayer(switchButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPaneShadow1.setLayer(buttonBadges1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPaneShadow1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPaneShadow1.setLayer(buttonBadges2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPaneShadow1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPaneShadow1.setLayer(slideShowTransparent1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPaneShadow1.setLayer(tenTour, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPaneShadow1.setLayer(tenDiaDanh, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerPaneShadow1Layout = new javax.swing.GroupLayout(layerPaneShadow1);
        layerPaneShadow1.setLayout(layerPaneShadow1Layout);
        layerPaneShadow1Layout.setHorizontalGroup(
            layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerPaneShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layerPaneShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layerPaneShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layerPaneShadow1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(slideShowTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tenTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tenDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addContainerGap())
        );
        layerPaneShadow1Layout.setVerticalGroup(
            layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerPaneShadow1Layout.createSequentialGroup()
                .addGroup(layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slideShowTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layerPaneShadow1Layout.createSequentialGroup()
                        .addComponent(tenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(switchButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        button1.setAlpha(0.0F);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPaneShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(layerPaneShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        close();
    }//GEN-LAST:event_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.Button button1;
    private com.huyhoang.swing.button.ButtonBadges buttonBadges1;
    private com.huyhoang.swing.button.ButtonBadges buttonBadges2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.huyhoang.swing.panel.LayerPaneShadow layerPaneShadow1;
    private com.huyhoang.swing.slideshow.SlideShowTransparent slideShowTransparent1;
    private com.huyhoang.swing.button.SwitchButton switchButton1;
    private com.huyhoang.swing.label.WrapLabel tenDiaDanh;
    private com.huyhoang.swing.label.WrapLabel tenTour;
    // End of variables declaration//GEN-END:variables
}
