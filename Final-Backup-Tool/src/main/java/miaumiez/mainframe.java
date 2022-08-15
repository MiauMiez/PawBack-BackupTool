package miaumiez;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static miaumiez.main.json;
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

    private JButton config_one_button;

    mainframe()  {
        config_one_button = new JButton("Backup 1");
        config_one_button.setBounds(30, 30, 100, 60);
        config_one_button.setFocusable(false);
        config_one_button.addActionListener(this);


        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(82, 82, 82));
        frame.setLocationRelativeTo(null);
        frame.setVisible (true);
        frame.setResizable(false);
        frame.pack();
        frame.setLocation(500, 350);


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

        
       //add components
        frame.add(chooseFile_button);
        frame.add(chooseBackupLocation_button);
        frame.add(createBackup_button);
        frame.add(quit_button);
        frame.add(config_button);

        frame.add(config_one_button);
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

        if(e.getSource() == config_one_button){


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

            //saving the name or path or direct content
            //It would be better to save the name
            //


        }
    }

    public void saveShortcut(int button) throws IOException {

        JSONObject jsob = new JSONObject();



        FileWriter file = new FileWriter(json);
        try {

            file.write(String.valueOf(jsob));


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            file.flush();
            file.close();

        }
    }

//DO NOT CHANGE ANYTHING HERE ***************************************************************************************************************************************************************************************************************************

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
