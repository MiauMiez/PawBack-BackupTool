package miaumiez;

import miaumiez.config_data.config_Info;
import miaumiez.time.timeManager;

import java.io.File;
import java.io.IOException;

public class main {

    public static config_Info dcI = new config_Info();

    public static boolean zipFiles;

    public static String user = System.getProperty("user.name");

    public static String main_path = "C:\\Users\\" + user + "\\Documents\\backup_tool\\";
    public static String config_path = "C:\\Users\\" + user + "\\Documents\\backup_tool\\configs\\";
    public static String time_config_path = config_path + "\\time\\";

    public static String json =  main_path + "config.json";

    public static void main (String[] args) throws IOException {

        //Creating the necessary folders
        File main_folder = new File(config_path);
        if (!main_folder.exists()) {
               main_folder.mkdirs();
        }

        File time_path = new File(time_config_path);
            if (!time_path.exists()) {
                    time_path.mkdirs();
            }


        //Testing for auto backups
        timeManager timeManager = new timeManager();

        //Start
        mainframe mainframe = new mainframe();


    }
}