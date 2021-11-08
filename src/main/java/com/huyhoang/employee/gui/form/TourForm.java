package com.huyhoang.employee.gui.form;

import com.huyhoang.dao.ChuyenDuLichDAO;
import com.huyhoang.employee.gui.component.TabLayout;
import com.huyhoang.model.ChuyenDuLich;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class TourForm extends javax.swing.JLayeredPane {

    private MigLayout layout;
    private ChuyenDuLichDAO chuyenDuLichDAO;
    private TabLayout tab;
    private final DecimalFormat df = new DecimalFormat("##0.###");
    private Animator animator;

    public void addEvent(MouseListener evt) {
        tableTour.addMouseListener(evt);
    }

    public TourForm() {
        chuyenDuLichDAO = new ChuyenDuLichDAO();
        initComponents();

        layout = new MigLayout("fill, insets 0, wrap", "0[fill]0", "0[fill]0");
        pnlTabelTour.setLayout(layout);
        createTabPane();

        pnlTabelTour.removeAll();
        pnlTabelTour.add(createTabPane(), "pos 15% 1al n n,w 100%,h 100%");
        pnlTabelTour.add(jPanel1, "h 13%");
        pnlTabelTour.add(sp, "h 82%");
        pnlTabelTour.add(jPanel2);

        buildDisplay();
        pnlTabelTour.setVisible(true);
        pnlTableOrder.setVisible(false);

    }

    private void buildDisplay() {
        createTableTour();
    }

    private void createTableTour() {
        tableTour.getTableHeader().setResizingAllowed(false);
        tableTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                    if (!animator.isRunning()) {
                        if (!tab.isShow()) {
                            tab.setVisible(true);
                            animator.start();
                        }
                    }
                }
            }

        });

        loadData();
    }

    private void loadData() {
        List<ChuyenDuLich> rs = chuyenDuLichDAO.getChuyenDuLichs();
        rs.forEach(r -> {
            tableTour.addRow(r.convertToRowTable());
        });
    }

    private TabLayout createTabPane() {
        tab = new TabLayout();
//        setLayer(tab, JLayeredPane.POPUP_LAYER);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (tab.isShow()) {
                    width = 15 * fraction;
                } else {
                    width = 15 * (1f - fraction);
                }
                width = Double.valueOf(df.format(width));
                layout.setComponentConstraints(tab, "pos " + width + "% 1al n n, w 100%, h 100%");
                tab.repaint();
                tab.revalidate();

                pnlTabelTour.revalidate();
            }

            @Override
            public void end() {
                tab.setShow(!tab.isShow());
                if (!tab.isShow()) {
                    tab.setVisible(false);
                }
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        tab.addAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!animator.isRunning()) {
                    if (tab.isShow()) {
                        animator.start();
                    }
                }
            }
        });

        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if (!animator.isRunning()) {
                        if (tab.isShow()) {
                            animator.start();
                        }
                    }
                }
            }
        });
        return tab;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTabelTour = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        myTextField1 = new com.huyhoang.swing.textfield.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        sp = new javax.swing.JScrollPane();
        tableTour = new com.huyhoang.swing.table2.MyTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        pnlTableOrder = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        pnlTabelTour.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabelTour.setOpaque(false);
        pnlTabelTour.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_filter_15px.png"))); // NOI18N
        jLabel3.setText("Filter");

        myTextField1.setToolTipText("");
        myTextField1.setBackgroundColor(new java.awt.Color(255, 255, 255));
        myTextField1.setBorderLine(true);
        myTextField1.setBorderRadius(30);
        myTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        myTextField1.setHint("Search");
        myTextField1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_25px.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tour List");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_alphabetical_sorting_15px.png"))); // NOI18N
        jLabel2.setText("Sort by");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tên chuyến đi", "Ngày tạo", "Loại chuyến", "Ngày khởi hành", "Ngày kết thúc", "Trạng thái" }));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_15px.png"))); // NOI18N
        jButton5.setText("Add Tour");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pnlTabelTour.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tableTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên chuyến", "Ngày tạo", "Loại chuyến", "Ngày khởi hành", "Ngày kết thúc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTour.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableTour.setRowHeight(40);
        tableTour.setSelectionBackground(new java.awt.Color(135, 175, 218));
        sp.setViewportView(tableTour);
        if (tableTour.getColumnModel().getColumnCount() > 0) {
            tableTour.getColumnModel().getColumn(0).setResizable(false);
            tableTour.getColumnModel().getColumn(1).setResizable(false);
            tableTour.getColumnModel().getColumn(2).setResizable(false);
            tableTour.getColumnModel().getColumn(3).setResizable(false);
            tableTour.getColumnModel().getColumn(4).setResizable(false);
            tableTour.getColumnModel().getColumn(5).setResizable(false);
            tableTour.getColumnModel().getColumn(6).setResizable(false);
        }

        pnlTabelTour.add(sp, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setText("Show");
        jPanel2.add(jLabel4);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox2);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_double_left_15px_3 - Copy.png"))); // NOI18N
        jPanel2.add(jButton6);

        jButton1.setText("1");
        jPanel2.add(jButton1);

        jButton2.setText("2");
        jPanel2.add(jButton2);

        jButton3.setText("3");
        jPanel2.add(jButton3);

        jButton4.setText("4");
        jPanel2.add(jButton4);

        jButton7.setText("...");
        jPanel2.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_double_left_15px_3.png"))); // NOI18N
        jPanel2.add(jButton8);

        pnlTabelTour.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        add(pnlTabelTour, "card2");

        pnlTableOrder.setOpaque(false);

        javax.swing.GroupLayout pnlTableOrderLayout = new javax.swing.GroupLayout(pnlTableOrder);
        pnlTableOrder.setLayout(pnlTableOrderLayout);
        pnlTableOrderLayout.setHorizontalGroup(
            pnlTableOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );
        pnlTableOrderLayout.setVerticalGroup(
            pnlTableOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );

        add(pnlTableOrder, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (!animator.isRunning()) {
            if (!tab.isShow()) {
                tab.setVisible(true);
                animator.start();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.huyhoang.swing.textfield.MyTextField myTextField1;
    private javax.swing.JPanel pnlTabelTour;
    private javax.swing.JPanel pnlTableOrder;
    private javax.swing.JScrollPane sp;
    private com.huyhoang.swing.table2.MyTable tableTour;
    // End of variables declaration//GEN-END:variables
}
