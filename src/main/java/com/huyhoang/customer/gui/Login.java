/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.customer.gui;

import com.huyhoang.dao.KhachHang_DAO;
import com.huyhoang.dao.impl.KhachHangImpl;
import com.huyhoang.model.KhachHang;
import com.huyhoang.swing.button.ButtonBadges;
import com.huyhoang.swing.button.SwitchButton;
import com.huyhoang.swing.label.WrapLabel;
import com.huyhoang.swing.textfield.MyPasswordField;
import com.huyhoang.swing.textfield.MyTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Login extends javax.swing.JFrame {
    
    private int xx;
    private int yy;
    private boolean show;
    private Animator start;
    private ButtonBadges buttonBadges1;
    private ButtonBadges buttonBadges2;
    private javax.swing.JLabel jLabel1;
    private com.huyhoang.swing.button.SwitchButton switchButton1;
    private com.huyhoang.swing.textfield.MyPasswordField txtMatKhau;
    private com.huyhoang.swing.textfield.MyTextField txtSdt;
    private com.huyhoang.swing.label.WrapLabel wrapLabel1;
    private KhachHang_DAO khachHang_DAO;
    private KhachHang khachHang;
    
    public Login() {
        this.khachHang_DAO = new KhachHangImpl();
        initComponents();
        buildDisplay();
    }
    
    private void setTextWhenBack() {
        txtSdt.selectAll();
        txtSdt.requestFocus();
        txtMatKhau.setText("");
    }
    
    private void buildDisplay() {
        start();
        jPanel1.setLayout(new MigLayout("wrap", "push[center]push[center]push", "push[center]20[center]10[center]10[center]20[center]10[center]push"));
        createLogin();
    }
    
    private void createLogin() {
        txtSdt = new MyTextField();
        wrapLabel1 = new WrapLabel();
        jLabel1 = new JLabel();
        switchButton1 = new SwitchButton();
        buttonBadges1 = new ButtonBadges();
        buttonBadges2 = new ButtonBadges();
        txtMatKhau = new MyPasswordField();
        
        wrapLabel1.setForeground(new Color(255, 255, 255));
        wrapLabel1.setText("Đăng nhập để tiếp tục");
        wrapLabel1.setHAlignStyle(0.5F);
        wrapLabel1.setVAlignStyle(0.0F);
        wrapLabel1.setFont(new Font("Segoe UI", 1, 30)); // NOI18N
        jPanel1.add(wrapLabel1, "w 100%, h 100!, span 2");
        
        txtSdt.setForeground(new Color(255, 255, 255));
        txtSdt.setBackgroundColor(new Color(51, 51, 51));
        txtSdt.setCaretColor(new Color(255, 255, 255));
        txtSdt.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        txtSdt.setHint("Email hoặc số điện thoại");
        txtSdt.setSuffixIcon(new ImageIcon(getClass().getResource("/icon/letter.png"))); // NOI18N
        jPanel1.add(txtSdt, "w 100%, span 2");
        
        txtMatKhau.setBackground(new Color(51, 51, 51));
        txtMatKhau.setForeground(new Color(255, 255, 255));
        txtMatKhau.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        txtMatKhau.setHint("Mật khẩu");
        txtMatKhau.setCaretColor(new Color(255, 255, 255));
        txtMatKhau.setSuffixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtMatKhau.setSelectionColor(new Color(38, 117, 191));
        jPanel1.add(txtMatKhau, "w 100%, span 2");
        
        jLabel1.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new Color(200, 200, 200));
        jLabel1.setText("Ghi nhớ tôi");
        jPanel1.add(jLabel1);
        
        switchButton1.setBackground(new Color(29, 185, 84));
        jPanel1.add(switchButton1);
        
        buttonBadges1.setText("Đăng nhập");
        buttonBadges1.setFont(new Font("SansSerif", 1, 18)); // NOI18N
        buttonBadges1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String sdt = txtSdt.getText().trim();
                byte[] matKhau = String.valueOf(txtMatKhau.getPassword()).getBytes();
                if(sdt.length() < 0) {
                    setTextWhenBack();
                    return;
                }
                if(matKhau.length < 0) {
                    setTextWhenBack();
                    return;
                }
                
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        khachHang = khachHang_DAO.getKhachHangByLogin(sdt, matKhau);
                        if(khachHang != null) {
                            new MainFrame(khachHang).setVisible(true);
                            dispose();
                        } else {
                            
                        }
                    }
                }).start();
            }
        });
        jPanel1.add(buttonBadges1, "w 80%, h 40!, span 2");
        
        buttonBadges2.setText("Thoát");
        buttonBadges2.setFont(new Font("SansSerif", 1, 18)); // NOI18N
        buttonBadges2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                close();
            }
        });
        jPanel1.add(buttonBadges2, "w 80%, h 40!, span 2");
        
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
                    System.exit(0);
                }
            }
        };
        start = new Animator(200, target);
        start.setResolution(0);
        start.setAcceleration(0.5f);
    }
    
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        show = b;
        if (show) {
            start.start();
        }
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
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        layerPaneShadow1.setBackground(new java.awt.Color(19, 19, 19));
        layerPaneShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        layerPaneShadow1.setBorderRadius(20);
        layerPaneShadow1.setShadowOpacity(0.3F);
        layerPaneShadow1.setShadowSize(10);

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        layerPaneShadow1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerPaneShadow1Layout = new javax.swing.GroupLayout(layerPaneShadow1);
        layerPaneShadow1.setLayout(layerPaneShadow1Layout);
        layerPaneShadow1Layout.setHorizontalGroup(
            layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layerPaneShadow1Layout.setVerticalGroup(
            layerPaneShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPaneShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPaneShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private com.huyhoang.swing.panel.LayerPaneShadow layerPaneShadow1;
    // End of variables declaration//GEN-END:variables
}
