package org.miaumiez.gui;

import org.miaumiez.backend.config_manage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;

import static org.miaumiez.Main.app_home;

public class manage_config extends javax.swing.JFrame {

    private int initialX, initialY;

    public manage_config() {

        initComponents();
        load_items();
    }

    // <editor-fold defaultstate="collapsed" desc="Window Stuff">
    public static void initTable(){

        int size = config_manage.get_items().length;
        String[] columnNames = {"Name", "created/edited"};
        Object[][] data = new Object[size][2];
        for (int i = 0; i < size; i++) {
            data[i][0] = null;
            data[i][1] = null;
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        table = new javax.swing.JTable(model);
        table.setBackground(new Color(102, 102, 102));


        table.setSelectionBackground(new Color(102, 0, 204));
        table.setSelectionForeground(new Color(0, 51, 51));
        table_area.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
        }

    }

    public void initComponents() {

        main_panel = new JPanel();
        table_area = new JScrollPane();

        title_panel = new JPanel();
        title_text = new JLabel();
        button_panel1 = new JPanel();
        edit_btn = new JButton();
        delete_btn = new JButton();
        back_btn = new JButton();
        button_panel2 = new JPanel();
        update_btn = new JButton();


        setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        main_panel.setBackground(new Color(39, 43, 47));

        table_area.setBackground(new Color(153, 153, 153));

        initTable();

        title_panel.setBackground(new Color(37, 41, 44));

        title_text.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        title_text.setForeground(new Color(204, 204, 204));
        title_text.setHorizontalAlignment(SwingConstants.CENTER);
        title_text.setText("Config Editor");

        GroupLayout title_panelLayout = new GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
                title_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, title_panelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(title_text, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157))
        );
        title_panelLayout.setVerticalGroup(
                title_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(title_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title_text, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                .addContainerGap())
        );

        button_panel1.setBackground(new Color(37, 41, 44));

        edit_btn.setBackground(new Color(155, 56, 255));
        edit_btn.setForeground(new Color(255, 255, 255));
        edit_btn.setText("edit");
        edit_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                edit_btnActionPerformed(evt);
            }
        }
        );

        delete_btn.setBackground(new Color(51, 51, 51));
        delete_btn.setForeground(new Color(255, 255, 255));
        delete_btn.setText("delete");
        delete_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        update_btn.setBackground(new Color(155, 56, 255));
        update_btn.setForeground(new Color(255, 255, 255));
        update_btn.setText("update");
        update_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        GroupLayout button_panel1Layout = new GroupLayout(button_panel1);
        button_panel1.setLayout(button_panel1Layout);
        button_panel1Layout.setHorizontalGroup(
                button_panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, button_panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(delete_btn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(update_btn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_btn)
                                .addContainerGap())
        );
        button_panel1Layout.setVerticalGroup(
                button_panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(button_panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(button_panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(edit_btn)
                                        .addComponent(delete_btn)
                                        .addComponent(update_btn))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        button_panel2.setBackground(new Color(37, 41, 44));

        back_btn.setBackground(new Color(56, 56, 56));
        back_btn.setForeground(new Color(255, 255, 255));
        back_btn.setText("back");
        back_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        GroupLayout button_panel2Layout = new GroupLayout(button_panel2);
        button_panel2.setLayout(button_panel2Layout);
        button_panel2Layout.setHorizontalGroup(
                button_panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(button_panel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(back_btn)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        button_panel2Layout.setVerticalGroup(
                button_panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(button_panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(back_btn)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout main_panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(title_panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, main_panelLayout.createSequentialGroup()
                                .addContainerGap(76, Short.MAX_VALUE)
                                .addGroup(main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(table_area, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, main_panelLayout.createSequentialGroup()
                                                .addComponent(button_panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(button_panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(52, 52, 52))
        );
        main_panelLayout.setVerticalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(main_panelLayout.createSequentialGroup()
                                .addComponent(title_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(table_area, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(main_panelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(button_panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(button_panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(57, 57, 57))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(main_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(main_panel, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void update_btnActionPerformed(ActionEvent evt) {
        initTable();
        load_items();
    }

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {

        String rowData = config_manage.getSelectedRowFirstColumn(table);
        if (rowData == null) {
            System.out.println("No row is selected");
            return;
        } else {
            System.out.println("Selected row data: " + rowData);
        }

        File[] files = config_manage.get_items();
        File to_delete = null;

        for (int i  = 0; i < config_manage.get_items().length; i++){
            if (config_manage.filenameStartsWith(files[i].getName(), rowData)){
                to_delete = files[i];

                System.out.println(files[i]);
            }
        }

        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                to_delete.delete();
            } finally {

                initTable();
                load_items();
            }
        }
    }

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt){

        String rowData = config_manage.getSelectedRowFirstColumn(table);
        if (rowData == null) {
            System.out.println("No row is selected!");
            return;
        } else {
            System.out.println("Selected row data: " + rowData);
        }

        File[] files = config_manage.get_items();
        File to_edit = null;

        for (int i  = 0; i < config_manage.get_items().length; i++){
            if (config_manage.filenameStartsWith(files[i].getName(), rowData)){
                to_edit = files[i];

                System.out.println(files[i]);
            }
        }

        //OPEN WINDOW WITH DATA OF OLD CONFIG
        create_config.stat(to_edit);

        update_btnActionPerformed(null);


    }

    //DISPOSE
    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    public static void load_items(){

        TableModel model = table.getModel();
        int size = config_manage.get_items().length;
        String[] name_arr = config_manage.get_content("name");
        String[] created_arr = config_manage.get_content("created");

        for (int i = 0; i < size; i++){

            model.setValueAt(name_arr[i], i, 0); //name
            model.setValueAt(created_arr[i], i, 1);   //edit/created

        }
    }

    public static void stat() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(manage_config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manage_config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manage_config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage_config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_config().setVisible(true);
            }
        });
    }

    private javax.swing.JButton back_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton edit_btn;
    private javax.swing.JButton update_btn;
    private javax.swing.JLabel title_text;
    private javax.swing.JPanel button_panel1;
    private javax.swing.JPanel button_panel2;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel title_panel;
    public static javax.swing.JScrollPane table_area;
    public static javax.swing.JTable table;

}
