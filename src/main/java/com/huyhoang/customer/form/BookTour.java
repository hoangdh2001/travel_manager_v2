package com.huyhoang.customer.form;

import com.huyhoang.swing.combobox.ComboBoxSuggestion;
import com.huyhoang.swing.panel.PanelRoundLine;
import com.huyhoang.swing.textfield.MyTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class BookTour extends javax.swing.JPanel {

    public BookTour() {
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        createPanelForm();
    }

    private void createPanelForm() {
        pnlForm.setLayout(new MigLayout("fillx, insets 0, wrap", "", ""));

        createForm();
    }

    private void createForm() {
        JPanel form = new JPanel();
        form.setOpaque(false);
        form.setLayout(new MigLayout("insets 10", "push[center]10[center]10[center]10[center]10[center]push", "10[]"));
        JLabel lblHoTen = new JLabel("Họ tên");
        lblHoTen.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        form.add(lblHoTen, "left");

        JLabel lblGioiTinh = new JLabel("Giới tính");
        lblGioiTinh.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        form.add(lblGioiTinh, "left");

        JLabel lblNgaySinh = new JLabel("Ngày sinh");
        lblNgaySinh.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        form.add(lblNgaySinh, "left, span 3, wrap");

        MyTextField txtHoTen = new MyTextField();
        txtHoTen.setHint("Vui lòng nhập họ tên");
        txtHoTen.setBackground(Color.WHITE);
        txtHoTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        form.add(txtHoTen, "w 200!");

        ComboBoxSuggestion<String> cmbGioiTinh = new ComboBoxSuggestion<>();
        cmbGioiTinh.addItem("Giới tính");
        cmbGioiTinh.addItem("Nam");
        cmbGioiTinh.addItem("Nữ");
        cmbGioiTinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        form.add(cmbGioiTinh, "w 120!");

        ComboBoxSuggestion<Object> cmbNgaySinh = new ComboBoxSuggestion<>();
        cmbNgaySinh.addItem("Ngày");
        for (int i = 1; i <= 31; i++) {
            cmbNgaySinh.addItem(i);
        }
        cmbNgaySinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        form.add(cmbNgaySinh, "w 100!");

        ComboBoxSuggestion<Object> cmbThang = new ComboBoxSuggestion<>();
        cmbThang.addItem("Tháng");
        for (int i = 1; i <= 12; i++) {
            cmbThang.addItem(i);
        }
        cmbThang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        form.add(cmbThang, "w 100!");

        ComboBoxSuggestion<Object> cmbNam = new ComboBoxSuggestion<>();
        cmbNam.addItem("Năm");
        for (int i = 1951; i <= 2009; i++) {
            cmbNam.addItem(i);
        }
        cmbNam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        form.add(cmbNam, "w 100!");

        pnlForm.add(form);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        panelRoundLine1 = new com.huyhoang.swing.panel.PanelRoundLine();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonBadges1 = new com.huyhoang.swing.button.ButtonBadges();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(57, 20, 10, 20));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Hành khách");
        add(lblTitle, java.awt.BorderLayout.PAGE_START);

        pnlForm.setOpaque(false);

        panelRoundLine1.setBorderSize(1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Số khách hàng");

        jLabel2.setText("1");

        javax.swing.GroupLayout panelRoundLine1Layout = new javax.swing.GroupLayout(panelRoundLine1);
        panelRoundLine1.setLayout(panelRoundLine1Layout);
        panelRoundLine1Layout.setHorizontalGroup(
            panelRoundLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLine1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRoundLine1Layout.setVerticalGroup(
            panelRoundLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLine1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelRoundLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addComponent(panelRoundLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 229, Short.MAX_VALUE))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addComponent(panelRoundLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 296, Short.MAX_VALUE))
        );

        add(pnlForm, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.button.ButtonBadges buttonBadges1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTitle;
    private com.huyhoang.swing.panel.PanelRoundLine panelRoundLine1;
    private javax.swing.JPanel pnlForm;
    // End of variables declaration//GEN-END:variables
}
