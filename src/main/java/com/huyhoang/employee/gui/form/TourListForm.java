package com.huyhoang.employee.gui.form;

import com.huyhoang.employee.gui.component.TourDetail;
import com.huyhoang.swing.button.ButtonOutLine;
import com.huyhoang.swing.event.EventAction;
import com.huyhoang.swing.model.ModelRow;
import com.huyhoang.swing.table.CellButton;
import com.huyhoang.swing.table.CellCollapse;
import com.huyhoang.swing.table.CellMenu;
import com.huyhoang.swing.table.ModelAction;
import com.huyhoang.swing.table.MyTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

public class TourListForm extends JLayeredPane {
    private MigLayout layout;
    private TourDetail tourDetail;
    private MyTable tableTour;
    private MyTable tableCustomer;
    private JScrollPane sp1;
    private JScrollPane sp2;
    private final double tableSize = 60;
    private final double slideSize = 40;

    public TourListForm() {
        buildDisplay();
    }

    private void buildDisplay() {
        layout = new MigLayout("fill, insets 0");
        setLayout(layout);
        JLabel item = new JLabel("Tour List");
        item.setFont(new Font("sansserif", Font.PLAIN, 18));
        add(item, "pos 0 0 n n");
        createTableTour();
        createSlideShow();
        createTableOrders();
    }
    
    private void createTableTour() {
        tableTour = new MyTable();
        tableTour.setShadowOpacity(0.3f);
        tableTour.setShadowSize(2);
        tableTour.setBackground(Color.WHITE);
        tableTour.setRowLineColor(Color.LIGHT_GRAY);
        sp1 = new JScrollPane();
        sp1.setViewportView(tableTour);
        tableTour.fixTable(sp1);
        add(sp1, "w " + tableSize + "%, h 90%, pos 0al 1al n n");
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
        row.setRow(new Object[] {new CellMenu(), "D0001", "04 Nov 2021", "Cao cấp", "Mới", new ModelAction(null, eventAction), new CellCollapse()});
        row.setTitleSubRow(new Object[] {"Id", "Created date", "Payment Priority"});
        row.addSubRow(new Object[] {"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row.addSubRow(new Object[] {"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row);
        ModelRow row2 = new ModelRow();
        row2.setRow(new Object[] {new CellMenu(), "D0002", "02 Nov 2021", "Tiết kiệm", "Đang xử lý", new ModelAction(null, eventAction), new CellCollapse()});
        row2.setTitleSubRow(new Object[] {"Id", "Created date", "Payment Priority"});
        row2.addSubRow(new Object[] {"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row2.addSubRow(new Object[] {"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row2);
        ModelRow row3 = new ModelRow();
        row3.setRow(new Object[] {new CellMenu(), "D0003", "01 Nov 2021", "Giá tốt", "Sắp bắt đầu", new ModelAction(null, eventAction), new CellCollapse()});
        row3.setTitleSubRow(new Object[] {"Id", "Created date", "Payment Priority"});
        row3.addSubRow(new Object[] {"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row3.addSubRow(new Object[] {"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableTour.addRow(row3);
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
        add(sp2, "w " + tableSize + "%, h 90%, pos 0al 1al n n");
        initDataOrders();
    }
    
    private void initDataOrders() {
        
        
        ModelRow row = new ModelRow();
        row.setRow(new Object[] {new CellMenu(), "D0001", "04 Nov 2021", "Cao cấp", "Mới", new CellCollapse()});
        row.setTitleSubRow(new Object[] {"Id", "Created date", "Payment Priority", "Payment Deadline", "Status", "Paid", "Debts", "Price"});
        row.addSubRow(new Object[] {"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row.addSubRow(new Object[] {"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableCustomer.addRow(row);
        ModelRow row2 = new ModelRow();
        row2.setRow(new Object[] {new CellMenu(), "D0002", "02 Nov 2021", "Tiết kiệm", "Đang xử lý", new CellCollapse()});
        row2.addSubRow(new Object[] {"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row2.addSubRow(new Object[] {"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableCustomer.addRow(row2);
        ModelRow row3 = new ModelRow();
        row3.setRow(new Object[] {new CellMenu(), "D0003", "01 Nov 2021", "Giá tốt", "Sắp bắt đầu", new CellCollapse()});
        row3.setTitleSubRow(new Object[] {"Id", "Created date", "Payment Priority", "Payment Deadline", "Status", "Paid", "Debts", "Price"});
        row3.addSubRow(new Object[] {"DD001", "Vũng tàu", "Bà rịa vũng tàu"});
        row3.addSubRow(new Object[] {"DD002", "Lầu đài rượu vang", "Bình thuần"});
        tableCustomer.addRow(row3);
    }


    private void createSlideShow() {
        tourDetail = new TourDetail();
        add(tourDetail, "w " + slideSize + "%, h 90%, pos 1al 1al n n");
    }
}
