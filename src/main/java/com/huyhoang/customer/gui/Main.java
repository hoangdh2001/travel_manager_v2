package com.huyhoang.customer.gui;

import com.huyhoang.customer.form.Home;
import com.huyhoang.customer.form.Search;
import com.huyhoang.customer.form.TourInfo;
import com.huyhoang.model.ChiTietThamQuan;
import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.swing.event.EventMenuSelected;
import com.huyhoang.swing.event.EventTour;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.Json;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private int xx;
    private int yy;
    private boolean show;
    private Animator start;
    private Home home;
    private Search search;
    private final List<Component> historyComponent = new ArrayList<>();

    public Main() {
        initComponents();
        buildDisplay();
    }

    private void buildDisplay() {
        start();
        createForm();
        createMenu();
        createHeader();
        createContent();
        createChat();
    }

    private void createForm() {
        createFormHome();
        createFormSearch();
    }

    private void createMenu() {
        menu.initMenu((int index) -> {
            if (index == 0) {
                main.getContent().showForm(home);
            } else if (index == 1) {
                main.getContent().showForm(search);
            }
        });
        move(menu.getjPanel1(), 0);
    }

    private void createHeader() {
        main.getHeader().addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void menuSelected(int index) {
                if (index == 0) {
                    System.out.println("Open hồ sơ");
                } else if (index == 1) {
                    System.out.println("Open cài đặt");
                } else if (index == 2) {
                    System.out.println("Đăng xuất");
                }
            }
        });
        move(main.getHeader(), menu.getWidth());
    }

    private void createContent() {
        main.getScrollPaneCustom1().getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent arg0) {
                if (arg0.getValue() > 10) {
                    main.getHeader().hidden();
                } else {
                    main.getHeader().display();
                }
            }
        });
        main.getContent().add(home);
    }

    private void createChat() {
        chat.addActionMinimize((ActionEvent arg0) -> {
            setState(JFrame.ICONIFIED);
        });
        chat.addActionMaximize((ActionEvent arg0) -> {
            if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                bg.setBackground(new Color(18, 18, 18));
                bg.setBorder(new EmptyBorder(10, 10, 10, 10));
                setExtendedState(JFrame.NORMAL);
            } else {
                bg.setBackground(new Color(0, 0, 0, 0));
                bg.setBorder(new EmptyBorder(0, 0, 40, 0));
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
        chat.addActionClose((ActionEvent arg0) -> {
            close();
        });
        move(chat.getPnlTop(), menu.getWidth() + main.getHeader().getWidth());
    }

    private void createFormHome() {
        home = new Home();
        home.addEventTour(new EventTour() {
            @Override
            public void openTour(ChuyenDuLich chuyenDuLich) {
                main.getContent().showForm(new TourInfo(chuyenDuLich));
                try {
                    write2File(chuyenDuLich);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void createFormSearch() {
        search = new Search();
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

    private void move(Component com, int o) {
        System.out.println(com.getX());
        com.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                yy = e.getY();
            }
        });
        com.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                if (getExtendedState() == MAXIMIZED_BOTH) {
                    bg.setBackground(new Color(18, 18, 18));
                    bg.setBorder(new EmptyBorder(10, 10, 10, 10));
                    setExtendedState(JFrame.NORMAL);
                    setLocation(x - xx - o, y - yy);
                }
                setLocation(x - xx - o, y - yy);
            }
        });
    }

    private static void write2File(ChuyenDuLich chuyenDuLich) throws FileNotFoundException {
        JsonReader jsonReader = Json.createReader(new FileReader("data/ChuyenDuLich.json"));
        JsonArray jsonArray = jsonReader.readArray();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder(jsonArray);
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        
        JsonObject jo = jsonObjectBuilder.add("maChuyenDi", chuyenDuLich.getMaChuyen()).build();
        jsonArray = jsonArrayBuilder.add(jo).build();
        try (PrintWriter out = new PrintWriter(new FileWriter("data/ChuyenDuLich.json"))) {
            out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new com.huyhoang.swing.panel.LayerPaneShadow();
        menu = new com.huyhoang.customer.gui.component.Menu();
        chat = new com.huyhoang.customer.gui.component.Chat();
        main = new com.huyhoang.customer.gui.component.Main();
        bottom = new com.huyhoang.customer.gui.component.Bottom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bg.setShadowOpacity(0.3F);
        bg.setShadowSize(10);
        bg.setLayout(new java.awt.BorderLayout());
        bg.add(menu, java.awt.BorderLayout.LINE_START);
        bg.add(chat, java.awt.BorderLayout.LINE_END);
        bg.add(main, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout bottomLayout = new javax.swing.GroupLayout(bottom);
        bottom.setLayout(bottomLayout);
        bottomLayout.setHorizontalGroup(
            bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1216, Short.MAX_VALUE)
        );
        bottomLayout.setVerticalGroup(
            bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        bg.add(bottom, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.panel.LayerPaneShadow bg;
    private com.huyhoang.customer.gui.component.Bottom bottom;
    private com.huyhoang.customer.gui.component.Chat chat;
    private com.huyhoang.customer.gui.component.Main main;
    private com.huyhoang.customer.gui.component.Menu menu;
    // End of variables declaration//GEN-END:variables
}
