package com.huyhoang.employee.gui.form;

import com.huyhoang.employee.gui.component.TourDetail;
import com.huyhoang.model.TrangThaiChuyenDi;
import com.huyhoang.model.TrangThaiDonDat;
import com.huyhoang.swing.event.EventAction;
import com.huyhoang.swing.model.ModelRow;
import com.huyhoang.swing.table.CellCollapse;
import com.huyhoang.swing.table.CellMore;
import com.huyhoang.swing.table.ModelAction;
import com.huyhoang.swing.table.MyTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class TourListForm extends JLayeredPane {

    private MigLayout layout;
    private TourDetail tourDetail;
    private MyTable tableTour;
    private MyTable tableCustomer;
    private JScrollPane sp1;
    private JScrollPane sp2;
    private final double tableSize = 60;
    private final double slideSize = 40;
    private final double tableCSize = 68;
    private final int height = 95;
    private boolean show;

    public TourListForm() {
        buildDisplay();
    }

    private void buildDisplay() {
        layout = new MigLayout("fill, insets 0, debug");
        setLayout(layout);
        JLabel item = new JLabel("Tour List");
        item.setFont(new Font("sansserif", Font.PLAIN, 18));
        add(item, "pos 5 10 n n");
        createTableOrders();
        createTableTour();
        createSlideShow();
        setLayer(tourDetail, JLayeredPane.POPUP_LAYER);

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double pointTableC;
                double pointTourD;
                double sizeTourD;
                if (show) {
                    pointTableC = 32 + (tableCSize * fraction);
                    pointTourD = 60 * fraction;
                    sizeTourD = 30 + ((slideSize - 30) * fraction);
                    if(fraction >= 0.5f) {
                        sp1.setVisible(true);
                    }
                } else {
                    pointTableC = 32 + (tableCSize * (1f - fraction));
                    pointTourD = 60 * (1f - fraction);
                    sizeTourD = 30 + ((slideSize - 30) * (1f - fraction));
                    if (fraction >= 0.5f) {
                        sp1.setVisible(false);
                    }
                }

                layout.setComponentConstraints(sp2, "w " + tableCSize + "%, h "+ height +"%, pos " + pointTableC + "% 1al n n");
                layout.setComponentConstraints(tourDetail, "w " + sizeTourD + "%, h "+ height +"%, pos " + pointTourD + "% 1al n n");
                revalidate();
            }

            @Override
            public void end() {
                show = !show;
                if(!show) {
                    sp2.setVisible(false);
                }
            }
        };
        Animator animator = new Animator(1000, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                    sp2.setVisible(true);
                }
            }
        });
    }

    private void createTableTour() {
        tableTour = new MyTable();
        tableTour.setShadowOpacity(0.3f);
        tableTour.setShadowSize(2);
        tableTour.setBackground(Color.WHITE);
        tableTour.setRowLineColor(Color.LIGHT_GRAY);
        sp1 = new JScrollPane();
        sp1.setViewportView(tableTour);
        sp1.setVisible(true);
        tableTour.fixTable(sp1);
        add(sp1, "w " + tableSize + "%, h "+ height +"%, pos 0al 1al n n");
        initData();
    }

    private void initData() {
        EventAction eventAction = new EventAction() {
            @Override
            public void look(Object obj) {
                System.out.println("Look");
            }

            @Override
            public void delete(Object obj) {
                System.out.println("Delete");
            }

            @Override
            public void update(Object obj) {
                System.out.println("Update");
            }
        };
        ModelRow row = new ModelRow();
        row.setRow(new Object[]{new CellMore(), "D0001", "04 Nov 2021", "Cao cấp", TrangThaiChuyenDi.CHUA_KHOI_HANH, new ModelAction(null, eventAction), new CellCollapse()});
        row.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row);
        ModelRow row2 = new ModelRow();
        row2.setRow(new Object[]{new CellMore(), "D0002", "02 Nov 2021", "Tiết kiệm", TrangThaiChuyenDi.DANG_KHOI_HANH, new ModelAction(null, eventAction), new CellCollapse()});
        row2.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row2.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row2.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row2);
        ModelRow row3 = new ModelRow();
        row3.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.HUY, new ModelAction(null, eventAction), new CellCollapse()});
        row3.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row3.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row3.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row3);
        ModelRow row4 = new ModelRow();
        row4.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.DANG_XU_LY, new ModelAction(null, eventAction), new CellCollapse()});
        row4.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row4.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row4.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row4);
        ModelRow row5 = new ModelRow();
        row5.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row5.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row5.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row5.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row5);
        ModelRow row6 = new ModelRow();
        row6.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_BAT_DAU, new ModelAction(null, eventAction), new CellCollapse()});
        row6.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row6.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row6.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row6);
        ModelRow row7 = new ModelRow();
        row7.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row7.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row7.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row7.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row7);
        ModelRow row9 = new ModelRow();
        row9.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row9.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row9.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row9.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row9);
        ModelRow row10 = new ModelRow();
        row10.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row10.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row10.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row10.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row10);
        ModelRow row11 = new ModelRow();
        row11.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row11.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row11.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row11.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row11);
        ModelRow row12 = new ModelRow();
        row12.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row12.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row12.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row12.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row12);
        ModelRow row13 = new ModelRow();
        row13.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row13.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row13.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row13.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row13);
        ModelRow row14 = new ModelRow();
        row14.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row14.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row14.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row14.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row14);
        ModelRow row15 = new ModelRow();
        row15.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row15.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row15.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row15.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row15);
        ModelRow row16 = new ModelRow();
        row16.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row16.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row16.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row16.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row16);
        ModelRow row17 = new ModelRow();
        row17.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row17.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row17.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row17.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row17);
        ModelRow row18 = new ModelRow();
        row18.setRow(new Object[]{new CellMore(), "D0003", "01 Nov 2021", "Giá tốt", TrangThaiChuyenDi.SAP_KET_THUC, new ModelAction(null, eventAction), new CellCollapse()});
        row18.setTitleSubRow(new Object[]{"Id", "Tên địa danh", "Tỉnh thành"});
        row18.addSubRow(new Object[]{"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row18.addSubRow(new Object[]{"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row18);
    }

    private void createTableOrders() {
        tableCustomer = new MyTable();
        tableCustomer.setShadowOpacity(0.3f);
        tableCustomer.setShadowSize(2);
        tableCustomer.setBackground(Color.WHITE);
        tableCustomer.setRowLineColor(Color.LIGHT_GRAY);
        sp2 = new JScrollPane();
        sp2.setViewportView(tableCustomer);
        tableCustomer.fixTable(sp2);
        sp2.setVisible(false);
        add(sp2, "w " + tableCSize + "%, h "+ height +"%, pos 100% 1al n n");
        initDataOrders();
    }

    private void initDataOrders() {

        EventAction eventAction = new EventAction() {
            @Override
            public void look(Object obj) {
                System.out.println("Look");
            }

            @Override
            public void delete(Object obj) {
                System.out.println("Delete");
            }

            @Override
            public void update(Object obj) {
                System.out.println("Update");
            }
        };
        Icon icon = new ImageIcon(getClass().getResource("/icon/Avatar11-512.png"));
        ModelRow row = new ModelRow();
        row.setRow(new Object[]{new CellMore(), icon, "KH0001", "F", "Hà Nội", TrangThaiDonDat.DANG_XU_LY, new ModelAction(null, eventAction), new CellCollapse()});
        tableCustomer.addRow(row);
        ModelRow row2 = new ModelRow();
        row2.setRow(new Object[]{new CellMore(), icon, "KH0002", "D", "TP.HCM", TrangThaiDonDat.HOAN_THANH, new ModelAction(null, eventAction), new CellCollapse()});
        tableCustomer.addRow(row2);
        ModelRow row3 = new ModelRow();
        row3.setRow(new Object[]{new CellMore(), icon, "KH0003", "A", "Đà Nẵng", TrangThaiDonDat.HUY, new ModelAction(null, eventAction), new CellCollapse()});
        tableCustomer.addRow(row3);
        ModelRow row4 = new ModelRow();
        row4.setRow(new Object[]{new CellMore(), icon, "KH0004", "B", "Cần Thơ", TrangThaiDonDat.MOI, new ModelAction(null, eventAction), new CellCollapse()});
        tableCustomer.addRow(row4);
    }

    private void createSlideShow() {
        tourDetail = new TourDetail();
        add(tourDetail, "w " + slideSize + "%, h "+ height +"%, pos 1al 1al n n");
    }
}
