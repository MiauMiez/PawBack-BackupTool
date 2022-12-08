package miaumiez.time;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static miaumiez.main.time_config_path;

public class timeManager {

        int file_index;
        int max_file_index;

        public timeManager() throws IOException {
            mainManager();
        }

        public void mainManager() throws IOException {

            File folder = new File(time_config_path);

            File[] listOfFiles = folder.listFiles();

            int length = listOfFiles.length;
            max_file_index = length;
            System.out.println(max_file_index);

            if (length == 0) {
                closeAPP();
            }

            for (int i = 0; i < length; i++) {
                if (listOfFiles[i].getName().endsWith(".json")) {
                    try {
                        read_json_file(listOfFiles[i]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        public void read_json_file (File the_file) throws IOException {

            String time;
            int backup_mode;

            String fileContent;
            String filePath = the_file.getPath();

            byte[] bytes = Files.readAllBytes(Paths.get(filePath));

            fileContent = new String(bytes);
            JSONObject jsonObject = new JSONObject(fileContent);

             time = (String) jsonObject.get("time");
             backup_mode = (int) jsonObject.get("auto_time_option");

            check_time(time, backup_mode, the_file);
        }

        public void check_time (String time,int mode, File time_config){

            file_index++;

            if (file_index == max_file_index){
                //closeAPP();
            }

            //Make mode to time

            //Addiere mode_time to lastbackup time

            //if the time matches or was in the past backup.config

            //and change the config to current date


        }

        private void closeAPP () {
            System.exit(0);
        }
}

//remember sout