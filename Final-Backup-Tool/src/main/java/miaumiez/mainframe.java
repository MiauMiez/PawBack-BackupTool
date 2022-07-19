package miaumiez;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static miaumiez.main.main_path;


public class mainframe implements ActionListener {

    static File file_toBackup;
    static File file_BackupLocation;

    private String shortcut_config;

    backup backupClass = new backup();

    public JFrame frame = new JFrame ("Backup Tool " + " 1.0-SNAPSHOT" );
    private JButton chooseFile_button;
    private JButton chooseBackupLocation_button;
    private JButton createBackup_button;
    private JButton quit_button;
    private JButton config_button;

    private JButton shortcut_one;
    private JButton shortcut_two;
    private JButton shortcut_three;


    mainframe()  {

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(82, 82, 82));
        frame.setLocationRelativeTo(null);
        frame.setVisible (true);
        frame.setResizable(false);
        frame.pack();
        //frame.setLocation(5, 350);


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


        shortcut_one = new JButton("empty");
        shortcut_two = new JButton("empty");
        shortcut_three = new JButton("empty");




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

        //Shortcut button stuff

        shortcut_one.setBounds(10, 10, 100, 20);
        shortcut_two.setBounds(10, 40, 100, 20);
        shortcut_three.setBounds(10, 70, 100,20);

        shortcut_one.setFocusable(false);
        shortcut_two.setFocusable(false);
        shortcut_three.setFocusable(false);

        shortcut_one.addActionListener(this);
        shortcut_two.addActionListener(this);
        shortcut_three.addActionListener(this);

        //adjust size and set layout
        frame.setSize(440,410);
        frame.setLayout(null);

        
       //add components
        frame.add(chooseFile_button);
        frame.add(chooseBackupLocation_button);
        frame.add(createBackup_button);
        frame.add(quit_button);
        frame.add(config_button);

        frame.add(shortcut_one);
        frame.add(shortcut_two);
        frame.add(shortcut_three);


        }


    @Override
    public void actionPerformed(ActionEvent e) {

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

    }

    public void AddShortcut(int button) throws IOException {

        int dialog_result = JOptionPane.showConfirmDialog(null, "Would you like to create a config shortcut?", "Add config shortcut", 2);

        if (dialog_result == JOptionPane.YES_NO_OPTION) {


            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(main.config_path));
            fileChooser.setDialogTitle("Select your config");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);


            int response_ = fileChooser.showOpenDialog(null); //select file to open

            if (response_ == JFileChooser.APPROVE_OPTION) {

                shortcut_config = String.valueOf(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                String name = String.valueOf(new File(fileChooser.getSelectedFile().getName()));
                System.out.println(shortcut_config);



            } else {

                System.out.println("[Error] No directory has been selected.");
            }

            saveShortcut(button);

        }
    }

    public void saveShortcut(int button) throws IOException {

        JSONObject jsob = new JSONObject();



        FileWriter file = new FileWriter("");
        try {

            file.write(String.valueOf(jsob));


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            file.flush();
            file.close();

        }
    }
    public void ChooseFiles(){

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("C:\\Users")); //sets current directory
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

        fileChooser.setCurrentDirectory(new File("C:\\Users")); //sets current directory
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
