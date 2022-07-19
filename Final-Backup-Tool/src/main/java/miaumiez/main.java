package miaumiez;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class main {

    public static String user = System.getProperty("user.name");

    public static String main_path = "C:\\Users\\" + user + "\\Documents\\backup_tool\\";
    public static String config_path = "C:\\Users\\" + user + "\\Documents\\backup_tool\\configs";

    public static void main (String[] args) throws IOException {

        //Creating the necessary folders
        File main_folder = new File(config_path);
        if (!main_folder.exists()) {
            main_folder.mkdirs();
        }




        //Start
        mainframe mainframe = new mainframe();
    }
}





/* loading directory content into index

File directory = new File(main_path);
        File[] contentOfDirectory = directory.listFiles();

        for(File Object : contentOfDirectory){

            if(Object.isFile()){

                System.out.format("File name: %s%n ", Object.getName());
                Object.getPath();

            }
            if(Object.isDirectory()){

                System.out.format("Directory name: %s%n ", Object.getName());

            }

        }
 */