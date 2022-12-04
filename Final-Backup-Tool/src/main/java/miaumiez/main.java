package miaumiez;

import miaumiez.data.config_Info;
import miaumiez.time.timeManager;

import java.io.File;
import java.io.IOException;

public class main {

    public static config_Info dcI = new config_Info();

    public static boolean zipFiles;

    public static String user = System.getProperty("user.name");

    public static String main_path = "C:\\Users\\" + user + "\\Documents\\backup_tool\\";
    public static String config_path = "C:\\Users\\" + user + "\\Documents\\backup_tool\\configs\\";
    public static String time_config_path = config_path + "time\\";



    public static void main (String[] args) throws IOException {

        //Creating the necessary folders
        File main_folder = new File(config_path);
        if (!main_folder.exists()) {
               main_folder.mkdirs();
        }

        //File time_path = new File(time_config_path);
        File time_folder = new File(time_config_path);
        if (!time_folder.exists()) {
            time_folder.mkdirs();

        }


        //Testing for auto backups
        new timeManager();


        //Start
        mainframe mainframe = new mainframe();


    }
}