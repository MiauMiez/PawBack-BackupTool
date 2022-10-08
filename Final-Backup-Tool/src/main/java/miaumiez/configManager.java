package miaumiez;

import miaumiez.data.Serialization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static miaumiez.main.dcI;

public class configManager implements ActionListener{

   public JFrame frame = new JFrame("Backup Tool " + " CONFIGMANAGER");

    Serialization serialize = new Serialization();

    String config_path = main.config_path;

    private JButton c_back_button;
    private JButton c_add_config;
    private JButton c_load_config;
    private JButton c_delete_config;

    public String c_name;
    public String c_path;
    public File c_path_file;
    public Boolean zip_file;

    public String c_backup_location;
    public File c_backup_location_file;

    public String c_load_config_string;
    public File c_load_config_file;

    public configManager(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new java.awt.Color(82, 82, 82));
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setLayout (null);
        frame.pack();

        frame.setLocation(500, 350);

        //Add Text
        c_back_button = new JButton ("back");
        c_add_config = new JButton("add config");
        c_load_config = new JButton("config info");
        c_delete_config = new JButton("delete config");

        //Position and Size
        c_back_button.setBounds (10, 335, 85, 20);
        c_add_config.setBounds(245, 335, 130,20 );

        c_load_config.setBounds(245, 265, 130, 20);
        c_delete_config.setBounds(245, 300, 130,20);

        //Other settings
        c_back_button.setFocusable(false);
        c_add_config.setFocusable(false);
        c_load_config.setFocusable(false);
        c_delete_config.setFocusable(false);


        //Action Listener
        c_back_button.addActionListener(this);
        c_add_config.addActionListener(this);
        c_load_config.addActionListener(this);
        c_delete_config.addActionListener(this);

        //Add buttons to the frame
        frame.add(c_back_button);
        frame.add(c_add_config);
        frame.add(c_load_config);
        frame.add(c_delete_config);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //back button
        if(e.getSource() == c_back_button){

            mainframe mainframe = new mainframe();
            frame.dispose();

        }

        //add button
        if(e.getSource() == c_add_config){

            try {
                addConfig_getConfigInfo();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

        if(e.getSource() == c_load_config){


            loadConfig();

        }

        if(e.getSource() == c_delete_config){


            deleteConfigFile();

        }
    }

    public void addConfig_getConfigInfo() throws IOException {

        //get the name of the config
        c_name = showInputDialog(null, "Enter the name for your config", "CONFIG name", 1);
        System.out.println("Config name: " + c_name);

        //show introduction Dialog
        JOptionPane.showMessageDialog(null, "Select the folder that you want to backup in the future.", "CONFIG path", 1);

        //get path for the config
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("C:\\Users\\" + main.user + "Alexander\\Desktop\\")); //sets current directory
        fileChooser.setDialogTitle("!Select a directory/file that you want to backup");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int response = fileChooser.showOpenDialog(null); //select file to open

        if(response == JFileChooser.APPROVE_OPTION) {

            c_path_file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.println( "Config path: " + c_path_file);

        }else{

            System.out.println("[Error] No directory has been selected." );
        }

        //show introduction dialog
        JOptionPane.showMessageDialog(null, "Select the folder for your future backups.", "CONFIG backup-location", 1);

        //get backup location for the config
        JFileChooser fileChooser_ = new JFileChooser();

        fileChooser_.setCurrentDirectory(new File("C:\\Users\\" + main.user + "Alexander\\Desktop\\")); //sets current directory
        fileChooser_.setDialogTitle("!Select a directory/file that you want to backup");
        fileChooser_.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int response_ = fileChooser_.showOpenDialog(null); //select file to open

        if(response_ == JFileChooser.APPROVE_OPTION) {

            c_backup_location_file = new File(fileChooser_.getSelectedFile().getAbsolutePath());
            System.out.println( "Config backup location: " + c_backup_location_file);

        }else{

            System.out.println("[Error] No directory has been selected." );
        }

        //Do you want to zip the files in the future?
        int dialog_result = JOptionPane.showConfirmDialog(null, "Do you want to zip the files in future?", "Config Manager", 2);

        if (dialog_result == JOptionPane.YES_NO_OPTION) {

            zip_file = true;

        } else {

            zip_file = false;
        }
        //
        c_path = c_path_file.getAbsolutePath();
        c_backup_location = c_backup_location_file.getAbsolutePath();

        dcI.end_location = c_backup_location;
        dcI.name = c_name;
        dcI.path = c_path;
        dcI.zip = zip_file;
        serialize.serialize();

    }

    public void loadConfig(){

        //get the config
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File(config_path));
        fileChooser.setDialogTitle("Select your config");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int response_ = fileChooser.showOpenDialog(null); //select file to open

        if(response_ == JFileChooser.APPROVE_OPTION) {

            c_load_config_string = String.valueOf(new File(fileChooser.getSelectedFile().getAbsolutePath()));
            System.out.println(c_load_config_string);


            serialize.deSerialization(c_load_config_string);


        }else{

            System.out.println("[Error] No directory has been selected." );
        }

    }

    public void deleteConfigFile() {

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File(config_path));
        fileChooser.setDialogTitle("Select your config to delete");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int response_ = fileChooser.showOpenDialog(null); //select file to open
        if (response_ == JFileChooser.APPROVE_OPTION) {

            int dialog_result = JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete \"" + fileChooser.getSelectedFile().getName() + " \"", "Config Manager", 2);

            if (dialog_result == JOptionPane.YES_NO_OPTION) {

                fileChooser.getSelectedFile().delete();
            }
        }
    }
}