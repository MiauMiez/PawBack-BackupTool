package miaumiez;

import miaumiez.data.Serialization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import static miaumiez.main.*;

public class mainframe implements ActionListener {

    static File file_toBackup;
    static File file_BackupLocation;

    private String shortcut_config;

    backup backupClass = new backup();
    Serialization serialize = new Serialization();


    public JFrame frame = new JFrame ("Backup Tool " + " 1.0-SNAPSHOT" );
    private JButton chooseFile_button;
    private JButton chooseBackupLocation_button;
    private JButton createBackup_button;
    private JButton quit_button;
    private JButton config_button;
    private JButton time_manager_button;

    private JButton load_config_button;
    public static Choice choice_config;

    public JCheckBox checkboxZip= new JCheckBox("Zip-Files? ");

    public mainframe()  {

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(34, 40, 49));
        //frame.setLocationRelativeTo(null);
        frame.setVisible (true);
        frame.setResizable(false);
        frame.pack();
        //frame.setLocation(500, 350);


        //construct components
        chooseFile_button = new JButton ("Chose Directory");
        chooseBackupLocation_button = new JButton ("Choose Backup ");
        createBackup_button = new JButton ("Create Backup");
        quit_button = new JButton ("Quit");
        config_button = new JButton("Configs");

        //set component bounds (only needed by Absolute Positioning)
        chooseFile_button.setBounds (115, 275, 150, 25);
        chooseBackupLocation_button.setBounds (115, 300, 150, 25);

        createBackup_button.setBounds (115, 345, 200, 20);
        quit_button.setBounds (10, 345, 100, 20);
        config_button.setBounds(320,345, 90,20);

        //Button Settings
        chooseFile_button.setFocusable(false);
        chooseBackupLocation_button.setFocusable(false);
        createBackup_button.setFocusable(false);
        quit_button.setFocusable(false);
        config_button.setFocusable(false);

        //ActionListener
        chooseFile_button.addActionListener(this);
        chooseBackupLocation_button.addActionListener(this);
        createBackup_button.addActionListener(this);
        quit_button.addActionListener(this);
        config_button.addActionListener(this);

        //adjust size and set layout
        frame.setSize(440,410);
        frame.setLayout(null);

        //Backup config button
        load_config_button = new JButton("Backup Config");
        load_config_button.setBounds(290, 100, 120, 20);
        load_config_button.setFocusable(false);
        load_config_button.addActionListener(this);

        //Zip-Checkbox
        checkboxZip.setBounds(115, 200, 100, 40);
        checkboxZip.setOpaque(false);
        checkboxZip.addActionListener(this);

        //config choice
        choice_config = new Choice();
        choice_config.setFocusable(false);
        choice_config.setBounds(80,100,200,20);

        //add time-manager button
        time_manager_button = new JButton("auto-backup");
        time_manager_button.setOpaque(false);
        time_manager_button.setFocusable(false);
        time_manager_button.setBounds(300,310, 110,20);
        time_manager_button.addActionListener(this);

        frame.add(time_manager_button);

        //add components
        frame.add(chooseFile_button);
        frame.add(chooseBackupLocation_button);
        frame.add(createBackup_button);
        frame.add(quit_button);
        frame.add(config_button);
        frame.add(load_config_button);
        frame.add(choice_config);
        frame.add(checkboxZip);

        new addChoices();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == time_manager_button){

            new miaumiez.time.frame();
            frame.dispose();

        }
        if (e.getSource() == checkboxZip){

            zipFiles = checkboxZip.isSelected();
            System.out.println(zipFiles);

        }

        //Quit Interaction
        if(e.getSource() == quit_button){

            System.exit(0);
        }

        //Choose Backup Files
        if(e.getSource() == chooseFile_button){

           ChooseFiles();

        }

        //Choose Backup Location
        if(e.getSource() == chooseBackupLocation_button){

            ChooseBackupLocation();

        }

        //Backup
        if(e.getSource() == createBackup_button){

          backupClass.Backup();

        }

        //Config
        if (e.getSource() == config_button) {

            configManager configs = new configManager();
            frame.dispose();

        }

        //Backup config files button
        if(e.getSource() == load_config_button){

            String path = config_path + choice_config.getItem(choice_config.getSelectedIndex()) + ".ser";
            System.out.println(path);


            serialize.deSerialization(path, true);
            System.out.println("I have been called");

        }
    }


    public void ChooseFiles(){

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("C:\\Users\\Alexander\\Desktop")); //sets current location
        fileChooser.setDialogTitle("!Select a directory/file that you want to backup");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int response = fileChooser.showOpenDialog(null); //select file to open

        if(response == JFileChooser.APPROVE_OPTION) {

            file_toBackup = new File(String.valueOf(fileChooser.getSelectedFile()));
            System.out.println( "[Info] " + file_toBackup);

        }else{

            System.out.println("[Error] No directory has been selected." );
        }
    }

    public void ChooseBackupLocation(){

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("C:\\Users\\Alexander\\Desktop")); //sets current location
        fileChooser.setDialogTitle("!Select a Backup directory for your files");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int response = fileChooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){

            file_BackupLocation = new File(String.valueOf(fileChooser.getSelectedFile()));
            System.out.println("[Info] " + file_BackupLocation);


        }else{

            System.out.println("[Error] No directory has been selected." );

        }

    }
}
