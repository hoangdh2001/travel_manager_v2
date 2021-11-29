package com.huyhoang.customer.gui;

import com.huyhoang.customer.gui.dialog.DialogBookTour;
import com.huyhoang.customer.gui.form.Home;
import com.huyhoang.customer.gui.form.Search;
import com.huyhoang.customer.gui.form.TourInfo;
import com.huyhoang.model.ChuyenDuLich;
import com.huyhoang.model.KhachHang;
import com.huyhoang.swing.event.EventMenuSelected;
import com.huyhoang.swing.event.EventTour;
import com.huyhoang.swing.panel.ProgressGlassPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

public class MainFrame extends javax.swing.JFrame {

    private int xx;
    private int yy;
    private boolean show;
    private Animator start;
    private Home home;
    private Search search;
    private TourInfo tourInfo;
    private final List<Component> historyComponent = new ArrayList<>();
    private int currentIndex = -1;
    public static KhachHang khachHang;
    private ProgressGlassPane waitPanel;

    public MainFrame() {
        this.khachHang = new KhachHang();
        initComponents();
        btrang.setVisible(false);
        jPanel1.setVisible(true);
        setGlassPane(waitPanel = new ProgressGlassPane());
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
        createFormTourInfo();
    }

    private void createMenu() {
        menu.initMenu((int index) -> {
            if (index == 0) {
                main.getContent().showForm(home);
                waitPanel.setVisible(true);
                addHistory(home);
            } else if (index == 1) {
                main.getContent().showForm(search);
                addHistory(search);
            }
        });
        move(menu.getjPanel1(), 0);
    }

    private void createHeader() {
        main.getHeader().addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void menuSelected(int index) {
                switch (index) {
                    case 0:
                        System.out.println("Open hồ sơ");
                        break;
                    case 1:
                        System.out.println("Open cài đặt");
                        break;
                    case 2:
                        System.out.println("Đăng xuất");
                        break;
                    default:
                        break;
                }
            }
        });
        main.getHeader().addEventBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(currentIndex > 0) {
                    currentIndex--;
                    Component com = historyComponent.get(currentIndex);
                    if(com instanceof Home) {
                        menu.setSelectedIndex(0);
                    } else if(com instanceof Search) {
                        menu.setSelectedIndex(1);
                    } else {
                        menu.unSelectedAll();
                    }
                    main.getContent().showForm(com);
                    main.getHeader().getBtnNext().setEnabled(true);
                    if(currentIndex == 0) {
                        main.getHeader().getBtnBack().setEnabled(false);
                    }
                }
            }
        });
        main.getHeader().addEventNext(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(currentIndex < historyComponent.size()) {
                    currentIndex++;
                    Component com = historyComponent.get(currentIndex);
                    if(com instanceof Home) {
                        menu.setSelectedIndex(0);
                    } else if(com instanceof Search) {
                        menu.setSelectedIndex(1);
                    } else {
                        menu.unSelectedAll();
                    }
                    main.getContent().showForm(com);
                    main.getHeader().getBtnBack().setEnabled(true);
                    if(currentIndex == (historyComponent.size() - 1)) {
                        main.getHeader().getBtnNext().setEnabled(false);
                    }
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
        historyComponent.add(home);
        currentIndex++;
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
                tourInfo.setChuyenDuLich(chuyenDuLich);
                main.getContent().showForm(tourInfo);
                menu.unSelectedAll();
                addHistory(tourInfo);
//                try {
//                    write2File(chuyenDuLich);
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });
    }

    private void createFormSearch() {
        search = new Search();
    }
    
    private void createFormTourInfo() {
        tourInfo = new TourInfo();
        tourInfo.addEventLike(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                int state = arg0.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    khachHang.themChuyenDiDaThich(tourInfo.getChuyenDuLich());
                    main.showMessage("Đã lưu vào thư viện");
                } else {
                    main.showMessage("Đã xóa khỏi thư viện");
                    khachHang.getChuyenDiDaThich().remove(tourInfo.getChuyenDuLich());
                }
            }
        });
        tourInfo.addEventTour(new EventTour() {
            @Override
            public void openTour(ChuyenDuLich chuyenDuLich) {
                tourInfo.setChuyenDuLich(chuyenDuLich);
                main.getContent().showForm(tourInfo);
                menu.unSelectedAll();
                addHistory(tourInfo);
            }
        });
        tourInfo.addEventBookTour(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                DialogBookTour bookTour = new DialogBookTour(MainFrame.this, tourInfo.getChuyenDuLich());
                btrang.setVisible(true);
                bookTour.setVisible(true);
                if(bookTour.isThem()) {
                    main.showMessage("Đã đặt thành công");
                } else {
                    main.showMessage("Đặt thất bại");
                }
                btrang.setVisible(false);
            }
        });
    }
    
    private void addHistory(Component com) {
        if(currentIndex < (historyComponent.size() - 1)) {
            for (int i = (currentIndex + 1); i < historyComponent.size(); i++) {
                historyComponent.remove(i);
            }
            main.getHeader().getBtnNext().setEnabled(false);
        }
        historyComponent.add(com);
        currentIndex++;
        main.getHeader().getBtnBack().setEnabled(true);
        main.getScrollPaneCustom1().getVerticalScrollBar().setValue(0);
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
        btrang = new com.huyhoang.swing.panel.PanelTransparent();
        jPanel1 = new javax.swing.JPanel();
        bottom = new com.huyhoang.customer.gui.component.Bottom();
        menu = new com.huyhoang.customer.gui.component.Menu();
        chat = new com.huyhoang.customer.gui.component.Chat();
        main = new com.huyhoang.customer.gui.component.Main();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bg.setShadowOpacity(0.3F);
        bg.setShadowSize(10);
        bg.setLayout(new java.awt.CardLayout());

        btrang.setBackground(new java.awt.Color(0, 0, 0));
        btrang.setAlpha(0.5F);
        bg.setLayer(btrang, javax.swing.JLayeredPane.POPUP_LAYER);
        bg.add(btrang, "card2");

        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(bottom, java.awt.BorderLayout.PAGE_END);
        jPanel1.add(menu, java.awt.BorderLayout.LINE_START);
        jPanel1.add(chat, java.awt.BorderLayout.LINE_END);
        jPanel1.add(main, java.awt.BorderLayout.CENTER);

        bg.add(jPanel1, "card3");

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.huyhoang.swing.panel.LayerPaneShadow bg;
    private com.huyhoang.customer.gui.component.Bottom bottom;
    private com.huyhoang.swing.panel.PanelTransparent btrang;
    private com.huyhoang.customer.gui.component.Chat chat;
    private javax.swing.JPanel jPanel1;
    private com.huyhoang.customer.gui.component.Main main;
    private com.huyhoang.customer.gui.component.Menu menu;
    // End of variables declaration//GEN-END:variables
}
