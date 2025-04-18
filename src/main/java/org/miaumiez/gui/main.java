package org.miaumiez.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import static org.miaumiez.Main.app_home;

public class main extends javax.swing.JFrame {

    private int initialX, initialY;

    public main() {
        initComponents();

    }

    private void initComponents() {

        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point mouseLocation = pointerInfo.getLocation();
        setLocation(mouseLocation.x, mouseLocation.y);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialX = e.getX();
                initialY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int newX = getLocation().x + e.getX() - initialX;
                int newY = getLocation().y + e.getY() - initialY;
                setLocation(newX, newY);
            }
        });

        sidepanel = new javax.swing.JPanel();
        sidebar_home_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sidebar_setting_panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sidebar_config_panel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sidebar_help_panel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        logo_text = new javax.swing.JLabel();
        main_panel = new javax.swing.JPanel();
        panel_config = new javax.swing.JPanel();
        manage_configs_btn = new javax.swing.JButton();
        new_config_btn = new javax.swing.JButton();
        panel_home = new javax.swing.JPanel();
        logs_btn = new javax.swing.JButton();
        panel_setting = new javax.swing.JPanel();
        dev_panel = new javax.swing.JPanel();
        open_apppath_btn = new javax.swing.JButton();
        dev_text = new javax.swing.JLabel();
        open_autoStr_btn = new javax.swing.JButton();

        home_screen_text1 = new javax.swing.JLabel();
        home_screen_text2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PawBack");
        setBackground(new java.awt.Color(67, 73, 80));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(this.getClass().getResource("/images/main_logo_2.png")).getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        sidepanel.setBackground(new java.awt.Color(37, 41, 44));
        sidepanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        sidebar_home_panel.setBackground(new java.awt.Color(67, 73, 80));
        sidebar_home_panel.setForeground(new java.awt.Color(204, 204, 204));
        sidebar_home_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                home_panelMousePressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/images/home_ico.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Home");

        javax.swing.GroupLayout home_panelLayout = new javax.swing.GroupLayout(sidebar_home_panel);
        sidebar_home_panel.setLayout(home_panelLayout);
        home_panelLayout.setHorizontalGroup(
                home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(home_panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        home_panelLayout.setVerticalGroup(
                home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidebar_setting_panel.setBackground(new java.awt.Color(41, 45, 50));
        sidebar_setting_panel.setForeground(new java.awt.Color(204, 204, 204));
        sidebar_setting_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                setting_panelMousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/images/setting_ico.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Settings");

        javax.swing.GroupLayout setting_panelLayout = new javax.swing.GroupLayout(sidebar_setting_panel);
        sidebar_setting_panel.setLayout(setting_panelLayout);
        setting_panelLayout.setHorizontalGroup(
                setting_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(setting_panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        setting_panelLayout.setVerticalGroup(
                setting_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidebar_config_panel.setBackground(new java.awt.Color(41, 45, 50));
        sidebar_config_panel.setForeground(new java.awt.Color(204, 204, 204));
        sidebar_config_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                config_panelMousePressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/images/plus.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Configs");

        javax.swing.GroupLayout config_panelLayout = new javax.swing.GroupLayout(sidebar_config_panel);
        sidebar_config_panel.setLayout(config_panelLayout);
        config_panelLayout.setHorizontalGroup(
                config_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(config_panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        config_panelLayout.setVerticalGroup(
                config_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidebar_help_panel.setBackground(new java.awt.Color(39,44,47));
        sidebar_help_panel.setForeground(new java.awt.Color(204, 204, 204));
        sidebar_help_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit_panel(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Exit");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout help_panelLayout = new javax.swing.GroupLayout(sidebar_help_panel);
        sidebar_help_panel.setLayout(help_panelLayout);
        help_panelLayout.setHorizontalGroup(
                help_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        help_panelLayout.setVerticalGroup(
                help_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        logo.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/images/main_logo.png"))); // NOI18N

        logo_text.setForeground(new java.awt.Color(204, 204, 204));
        logo_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo_text.setText("PawBack");
        logo_text.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout sidepanelLayout = new javax.swing.GroupLayout(sidepanel);
        sidepanel.setLayout(sidepanelLayout);
        sidepanelLayout.setHorizontalGroup(
                sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_help_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logo_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sidepanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(logo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidepanelLayout.createSequentialGroup()
                                .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sidebar_setting_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sidebar_config_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sidebar_home_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        sidepanelLayout.setVerticalGroup(
                sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sidepanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logo_text)
                                .addGap(19, 19, 19)
                                .addComponent(sidebar_home_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sidebar_setting_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sidebar_config_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sidebar_help_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        main_panel.setBackground(new java.awt.Color(255, 13, 13));
        main_panel.setLayout(new java.awt.CardLayout());

        panel_config.setBackground(new java.awt.Color(39, 43, 47));

        manage_configs_btn.setBackground(new java.awt.Color(102, 0, 204));
        manage_configs_btn.setForeground(new java.awt.Color(242, 242, 242));
        manage_configs_btn.setText("Manage configs...");
        manage_configs_btn.setBorder(null);
        manage_configs_btn.setBorderPainted(false);
        manage_configs_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_configs_btnActionPerformed(evt);
            }
        });

        new_config_btn.setBackground(new java.awt.Color(102, 0, 204));
        new_config_btn.setForeground(new java.awt.Color(242, 242, 242));
        new_config_btn.setText("<html>\n<p>\nAdd new config...\n</p>\n</html>\n");
        new_config_btn.setBorder(null);
        new_config_btn.setBorderPainted(false);
        new_config_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new_config_btnMouseEntered(evt);
            }
        });
        new_config_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_config_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_configLayout = new javax.swing.GroupLayout(panel_config);
        panel_config.setLayout(panel_configLayout);
        panel_configLayout.setHorizontalGroup(
                panel_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_configLayout.createSequentialGroup()
                                .addContainerGap(72, Short.MAX_VALUE)
                                .addComponent(manage_configs_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(new_config_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
        );
        panel_configLayout.setVerticalGroup(
                panel_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_configLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(panel_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(new_config_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                        .addComponent(manage_configs_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(159, Short.MAX_VALUE))
        );

        main_panel.add(panel_config, "panel_config");

        panel_home.setBackground(new java.awt.Color(39, 43, 47));

        logs_btn.setBackground(new java.awt.Color(102, 0, 204));
        logs_btn.setForeground(new java.awt.Color(242, 242, 242));
        logs_btn.setText("Open logs...");
        logs_btn.setBorder(null);
        logs_btn.setBorderPainted(false);
        logs_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logs_btnMouseEntered(evt);
            }
        });
        logs_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logs_btnActionPerformed(evt);
            }
        });



        home_screen_text1.setText("Welcome to PawBack!");
        home_screen_text1.setForeground(new java.awt.Color(242, 242, 242));
        home_screen_text1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));


        home_screen_text2.setText("You may create a new config or manage your existing configs");
        home_screen_text2.setForeground(new java.awt.Color(242, 242, 242));
        home_screen_text2.setFont(new java.awt.Font("Arial", Font.PLAIN, 15));


        javax.swing.GroupLayout panel_homeLayout = new javax.swing.GroupLayout(panel_home);
        panel_home.setLayout(panel_homeLayout);
        panel_homeLayout.setHorizontalGroup(
                panel_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_homeLayout.createSequentialGroup()
                                .addGroup(panel_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel_homeLayout.createSequentialGroup()
                                                .addGap(125) // left gap for home_screen_text1
                                                .addComponent(home_screen_text1))
                                        .addGroup(panel_homeLayout.createSequentialGroup()
                                                .addGap(90) // shorter left gap for home_screen_text2
                                                .addComponent(home_screen_text2)))
                                .addContainerGap(100, Short.MAX_VALUE))
        );

        panel_homeLayout.setVerticalGroup(
                panel_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_homeLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(home_screen_text1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(home_screen_text2)
                                .addContainerGap(100, Short.MAX_VALUE))
        );


        main_panel.add(panel_home, "panel_home");

        panel_setting.setBackground(new java.awt.Color(39, 43, 47));

        dev_panel.setBackground(new java.awt.Color(102, 0, 204));

        open_apppath_btn.setBackground(new java.awt.Color(51, 51, 51));
        open_apppath_btn.setForeground(new java.awt.Color(242, 242, 242));
        open_apppath_btn.setText("Open StartUp Path");
        open_apppath_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                open_apppath_btnActionPerformed(evt);
            }
        });

        dev_text.setForeground(new java.awt.Color(255, 255, 255));
        dev_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dev_text.setText("Developer");

        open_autoStr_btn.setBackground(new java.awt.Color(39, 43, 47));
        open_autoStr_btn.setForeground(new java.awt.Color(242, 242, 242));
        open_autoStr_btn.setText("Open appilication Path");
        open_autoStr_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_autoStr_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dev_panelLayout = new javax.swing.GroupLayout(dev_panel);
        dev_panel.setLayout(dev_panelLayout);
        dev_panelLayout.setHorizontalGroup(
                dev_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dev_panelLayout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addGroup(dev_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dev_text, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(open_autoStr_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(open_apppath_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31))
        );
        dev_panelLayout.setVerticalGroup(
                dev_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dev_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dev_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(open_apppath_btn)
                                .addGap(18, 18, 18)
                                .addComponent(open_autoStr_btn)
                                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout panel_settingLayout = new javax.swing.GroupLayout(panel_setting);
        panel_setting.setLayout(panel_settingLayout);
        panel_settingLayout.setHorizontalGroup(
                panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_settingLayout.createSequentialGroup()
                                .addContainerGap(207, Short.MAX_VALUE)
                                .addComponent(dev_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159))
        );
        panel_settingLayout.setVerticalGroup(
                panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_settingLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(dev_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(110, Short.MAX_VALUE))
        );

        main_panel.add(panel_setting, "panel_setting");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sidepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        CardLayout card = (CardLayout) main_panel.getLayout();
        card.show(main_panel, "panel_home"); // oder "panel_config", je nach gewünschtem Start

        pack();
    }// </editor-fold>

    private void exit_panel(java.awt.event.MouseEvent evt) {
        System.exit(1);
    }

    private void home_panelMousePressed(java.awt.event.MouseEvent evt) {
        setColor(sidebar_home_panel);
        resetColor(sidebar_config_panel);
        resetColor(sidebar_setting_panel);

        CardLayout card = (CardLayout)main_panel.getLayout();
        card.show(main_panel, "panel_home");
    }

    private void setting_panelMousePressed(java.awt.event.MouseEvent evt) {
        setColor(sidebar_setting_panel);
        resetColor(sidebar_home_panel);
        resetColor(sidebar_config_panel);

        CardLayout card = (CardLayout)main_panel.getLayout();
        card.show(main_panel, "panel_setting");
    }

    private void config_panelMousePressed(java.awt.event.MouseEvent evt) {
        setColor(sidebar_config_panel);
        resetColor(sidebar_home_panel);
        resetColor(sidebar_setting_panel);

        CardLayout card = (CardLayout)main_panel.getLayout();
        card.show(main_panel, "panel_config");
    }

    private void manage_configs_btnActionPerformed(java.awt.event.ActionEvent evt) {
        manage_config.stat();
    }


    private void new_config_btnMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void new_config_btnActionPerformed(java.awt.event.ActionEvent evt) {
        create_config.stat(null);
    }

    private void logs_btnMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void logs_btnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void open_apppath_btnActionPerformed(java.awt.event.ActionEvent evt) {
        String userHome = System.getProperty("user.home");
        String autostartPath = userHome + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";

        try {
            Desktop.getDesktop().open(new File(autostartPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void open_autoStr_btnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Desktop.getDesktop().open(app_home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void resetColor(JPanel p){
        p.setBackground(new Color(41,45,50));
    }

    void setColor(JPanel p){
        p.setBackground(new Color(67,73,80));
    }


    // Variables declaration - do not modify
    private javax.swing.JPanel sidebar_config_panel;
    private javax.swing.JPanel sidebar_help_panel;
    private javax.swing.JPanel sidebar_home_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo_text;
    private javax.swing.JButton logs_btn;
    private javax.swing.JPanel main_panel;
    private javax.swing.JButton manage_configs_btn;
    private javax.swing.JButton new_config_btn;
    private javax.swing.JPanel panel_config;
    private javax.swing.JPanel panel_home;
    private javax.swing.JPanel panel_setting;
    private javax.swing.JPanel sidebar_setting_panel;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JButton open_apppath_btn;
    private javax.swing.JButton open_autoStr_btn;
    private javax.swing.JLabel dev_text;
    private javax.swing.JPanel dev_panel;

    private javax.swing.JLabel home_screen_text1;
    private javax.swing.JLabel home_screen_text2;

    // End of variables declaration


}