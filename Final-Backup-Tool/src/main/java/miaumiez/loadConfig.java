package miaumiez;

import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class loadConfig {

    String main_path = main.main_path;
    String _config_path = main.config_path;
    public String load_config;

    static String configFile_path;
    static String config_name;
    static String config_path;
    static String config_backuplocation;


    loadConfig() {
        //get the config
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File(_config_path));
        fileChooser.setDialogTitle("Select your config");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);


        int response_ = fileChooser.showOpenDialog(null); //select file to open

        if (response_ == JFileChooser.APPROVE_OPTION) {

            load_config = String.valueOf(new File(fileChooser.getSelectedFile().getAbsolutePath()));
            System.out.println(load_config);

            configFile_path  = load_config;

        } else {

            System.out.println("[Error] No directory has been selected.");
        }



        //read it
        try {

            String jsonText = new String((Files.readAllBytes(Paths.get(load_config))));
            JSONObject o = new JSONObject(jsonText);


            config_path = (String) o.get("path");
            config_backuplocation = (String) o.get("backupLocation");
            config_name = (String) o.get("name");


        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Something went wrong :/");
        }
    }


}


