//Diese Klasse ist für das erstellen von einem neuen Config verantwortlich.

package org.miaumiez.gui;

import org.miaumiez.backend.config_input;
import org.miaumiez.backend.config_manage;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class create_config extends JFrame {

    private int initialX, initialY;
    public static String location;
    public static String backup_place;
    public static int backup_mode;
    public static boolean edit = false;
    public static String orig_name;
    public static String orig_file_name;

    public create_config() {
        initComponents();
    }

    private void initComponents() {

        buttonGroup = new ButtonGroup();
        main_panel = new JPanel();
        title_panel = new JPanel();
        main_display_name_jLabel = new JLabel();
        u_nameField = new JTextField();
        button_panel = new JPanel();
        day_btn = new JToggleButton();
        week_btn = new JToggleButton();
        month_btn = new JToggleButton();
        create_backup_text = new JLabel();
        enter_name_text = new JLabel();
        backup_loc_btn = new JButton();
        backup_place_btn = new JButton();
        what_text = new JLabel();
        where_text = new JLabel();
        bottom_panel = new JPanel();
        continue_btn = new JButton();
        cancel_btn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
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
        main_panel.setForeground(new Color(255, 255, 255));

        title_panel.setBackground(new Color(37, 41, 44));

        main_display_name_jLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        main_display_name_jLabel.setForeground(new Color(153, 153, 153));
        main_display_name_jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        main_display_name_jLabel.setText("New config");
        main_display_name_jLabel.setHorizontalTextPosition(SwingConstants.CENTER);


        GroupLayout title_panelLayout = new GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
                title_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(title_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(main_display_name_jLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        title_panelLayout.setVerticalGroup(
                title_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, title_panelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(main_display_name_jLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        u_nameField.setBackground(new Color(102, 0, 204));
        u_nameField.setForeground(new Color(242, 242, 242));
        u_nameField.setHorizontalAlignment(JTextField.CENTER);
        u_nameField.setText("Enter a name");

        button_panel.setBackground(new Color(37, 41, 44));
        button_panel.setPreferredSize(new Dimension(300, 49));

        day_btn.setBackground(new Color(102, 0, 204));
        buttonGroup.add(day_btn);
        day_btn.setForeground(new Color(255, 255, 255));
        day_btn.setText("day");

        week_btn.setBackground(new Color(102, 0, 204));
        buttonGroup.add(week_btn);
        week_btn.setForeground(new Color(255, 255, 255));
        week_btn.setText("week");

        month_btn.setBackground(new Color(102, 0, 204));
        buttonGroup.add(month_btn);
        month_btn.setForeground(new Color(255, 255, 255));
        month_btn.setText("month");

        GroupLayout button_panelLayout = new GroupLayout(button_panel);
        button_panel.setLayout(button_panelLayout);
        button_panelLayout.setHorizontalGroup(
                button_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(button_panelLayout.createSequentialGroup()
                                .addComponent(day_btn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(week_btn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month_btn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        button_panelLayout.setVerticalGroup(
                button_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(button_panelLayout.createSequentialGroup()
                                .addGroup(button_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(day_btn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(week_btn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(month_btn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        create_backup_text.setForeground(new Color(153, 153, 153));
        create_backup_text.setText(" Create a Backup every...");

        enter_name_text.setForeground(new Color(153, 153, 153));
        enter_name_text.setText("Enter a name...");

        backup_loc_btn.setBackground(new Color(102, 0, 204));
        backup_loc_btn.setForeground(new Color(255, 255, 255));
        backup_loc_btn.setText("choose a file or folder");
        backup_loc_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backup_location_btnActionPerformed(evt);
            }
        });

        backup_place_btn.setBackground(new Color(102, 0, 204));
        backup_place_btn.setForeground(new Color(255, 255, 255));
        backup_place_btn.setText("choose a location");
        backup_place_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backup_place_btnActionPerformed(evt);
            }
        });

        what_text.setForeground(new Color(153, 153, 153));
        what_text.setText("What to backup?");

        where_text.setForeground(new Color(153, 153, 153));
        where_text.setText("Where to backup?");

        bottom_panel.setBackground(new Color(37, 41, 44));

        continue_btn.setBackground(new Color(155, 56, 255));
        continue_btn.setForeground(new Color(255, 255, 255));
        continue_btn.setText("continue");
        continue_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                continue_btnActionPerformed(evt);
            }
        });

        cancel_btn.setBackground(new Color(51, 51, 51));
        cancel_btn.setForeground(new Color(255, 255, 255));
        cancel_btn.setText("cancel");
        cancel_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        GroupLayout bottom_panelLayout = new GroupLayout(bottom_panel);
        bottom_panel.setLayout(bottom_panelLayout);
        bottom_panelLayout.setHorizontalGroup(
                bottom_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, bottom_panelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancel_btn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(continue_btn, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
        );
        bottom_panelLayout.setVerticalGroup(
                bottom_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, bottom_panelLayout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(bottom_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(continue_btn)
                                        .addComponent(cancel_btn))
                                .addContainerGap())
        );

        GroupLayout main_panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(title_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(main_panelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(u_nameField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_panel, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(create_backup_text, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enter_name_text, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backup_loc_btn, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backup_place_btn, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(what_text, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(where_text, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(bottom_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        main_panelLayout.setVerticalGroup(
                main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(main_panelLayout.createSequentialGroup()
                                .addComponent(title_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(enter_name_text)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_nameField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(create_backup_text)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(what_text)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backup_loc_btn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(where_text)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backup_place_btn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(bottom_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(main_panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(main_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        //Listener needed to update the title of create_config to the current enterd thing - u_nameField is the area for the user to input the name
        u_nameField.getDocument().addDocumentListener(new MyDocumentListener());
        u_nameField.getDocument().putProperty("name", "Text");

        u_nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (u_nameField.getText().length() >= 24 ) // limit to 24
                    e.consume();
            }
        });

        //Day week month
        day_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                day_btnActionPerformed(evt);
            }
        });

        week_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                week_btnActionPerformed(evt);
            }
        });

        month_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                month_btnActionPerformed(evt);
            }
        });


    }// </editor-fold>

    private void month_btnActionPerformed(ActionEvent evt) {
        backup_mode = 3;
    }
    private void week_btnActionPerformed(ActionEvent evt) {
        backup_mode = 2;
    }
    private void day_btnActionPerformed(ActionEvent evt) {
        backup_mode = 1;
    }

    private void continue_btnActionPerformed(ActionEvent evt) {
        //Continue;
        System.out.println("Trying to safe the config:");
        //reset values
        create_backup_text.setForeground(new Color(153, 153, 153));
        enter_name_text.setForeground(new Color(153, 153, 153));
        what_text.setForeground(new Color(153, 153, 153));
        where_text.setForeground(new Color(153, 153, 153));

        //handle errors
        int[] err = config_input.check_input_for_errors(location, backup_place, u_nameField.getText(), backup_mode);
        boolean allFailed = true;

        if (err[0] == 1){
            create_backup_text.setForeground(Color.red);
            allFailed = false;
        }

        if (err[1]== 1){
            enter_name_text.setForeground(Color.red);
            allFailed = false;
        }

        if (err[2] == 1){
            what_text.setForeground(Color.red);
            allFailed = false;
        }

        if (err[3] == 1){
            where_text.setForeground(Color.red);
            allFailed = false;
        }

        if (allFailed){
            dispose();
            System.out.println(backup_mode);
            if (edit){
                config_input.write_config(location, backup_place, u_nameField.getText(), backup_mode, null, null);
            } else  {
               config_input.write_config(location, backup_place, u_nameField.getText(), backup_mode, orig_name, orig_file_name);
            }
            System.out.println("Completed");
        }

    }

    private void cancel_btnActionPerformed(ActionEvent evt) {
        //Close the current window
        this.dispose();
    }                     

    private void backup_location_btnActionPerformed(ActionEvent evt) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e){}

        //Pick location of the file that you want to backup in the future
        JFileChooser jf = new JFileChooser();

        jf.setDialogTitle("Select a file or directory that you might want to backup in the future!");
        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int response_ = jf.showOpenDialog(null);

        if(response_ == JFileChooser.APPROVE_OPTION) {
            if (!jf.getSelectedFile().getAbsolutePath().equals(backup_place)){
                location = jf.getSelectedFile().getAbsolutePath();
            } else {
                JOptionPane.showMessageDialog(null, "Your file/folder equals the backup location please change your input.");
            }

        }
    }

    private void backup_place_btnActionPerformed(ActionEvent evt) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e){}

        //Pick location for the file/folder to be backed up in the future
        JFileChooser jf = new JFileChooser();

        jf.setDialogTitle("Select a folder where the files should be saved in!");
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int response_ = jf.showOpenDialog(null);

        if(response_ == JFileChooser.APPROVE_OPTION) {
            if(!jf.getSelectedFile().getAbsolutePath().equals(location)) {
                backup_place = jf.getSelectedFile().getAbsolutePath();
            } else {
                JOptionPane.showMessageDialog(null, "Your backup location equals the file/folder location please change your input.");
            }
        }
    }

    public static void stat(File to_edit) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(create_config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(create_config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(create_config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(create_config.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new create_config().setVisible(true);
                //Important because we can call this window to load a file or to create a new
                if (!Objects.isNull(to_edit)){
                    load_config_for_edit(to_edit);}
            }
        });
    }

    public static void load_config_for_edit(File to_edit){

        //Headline
        String name = config_manage.read(to_edit, "name");
        u_nameField.setText(name);

        //Backup mode
        int mode = Integer.parseInt(Objects.requireNonNull(config_manage.read(to_edit, "backup_mode")));
        switch (mode){
            case 1:     backup_mode = mode; day_btn.setSelected(true);  break;

            case 2:     backup_mode = mode;  week_btn.setSelected(true); break;

            case 3:     backup_mode = mode;  month_btn.setSelected(true); break;

            default:
                throw new IllegalStateException("Unexpected value at backup_mode: " + mode);
        }

        //Input Locations
        location = config_manage.read(to_edit, "folder_file_location");
        backup_place = config_manage.read(to_edit, "backup_location");
        orig_name = name;
        orig_file_name = to_edit.getName();

    }

    //Vars:
    // <editor-fold>
    // Variables declaration
    private JButton backup_loc_btn;
    private JButton backup_place_btn;
    private JPanel bottom_panel;
    public ButtonGroup buttonGroup;
    private JPanel button_panel;
    private JButton cancel_btn;
    private JButton continue_btn;
    private JLabel create_backup_text;
    public static JToggleButton day_btn;
    private JLabel enter_name_text;
    public static JLabel main_display_name_jLabel;
    private JPanel main_panel;
    public static JToggleButton month_btn;
    private JPanel title_panel;
    public static JTextField u_nameField;
    public static JToggleButton week_btn;
    private JLabel what_text;
    private JLabel where_text;
    // End of variables declaration
    // </editor-fold> Variables

    //Needed so that the title of the create_config shows what you type in the name field
    class MyDocumentListener implements DocumentListener {

        public void removeUpdate(DocumentEvent e) {
            Document doc = (Document)e.getDocument();
            StringBuilder sb = null;
            try {
                sb = new StringBuilder(doc.getText(0, doc.getLength()));
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
            main_display_name_jLabel.setText(String.valueOf(sb));
        }
        public void changedUpdate(DocumentEvent e) {
        } //not needed

        @Override
        public void insertUpdate(DocumentEvent e) {
            Document doc = (Document)e.getDocument();
            StringBuilder sb = null;
            try {
                sb = new StringBuilder(doc.getText(0, doc.getLength()));
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
            main_display_name_jLabel.setText(String.valueOf(sb));
        }
    }
}
