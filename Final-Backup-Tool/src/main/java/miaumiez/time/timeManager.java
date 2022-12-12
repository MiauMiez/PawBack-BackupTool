package miaumiez.time;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;

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

        public void check_time (String time,int mode, File time_config) {

            file_index++;

            if (file_index == max_file_index) {
                //closeAPP();
            }

            long time_long = Long.parseLong(time);
            Timestamp ts = new Timestamp(time_long);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            String file_time = formatter.format(ts);
            String current_time = get_Time();

            System.out.println("This is the time from json file: " + file_time);
            System.out.println("This is the current time: " + current_time);

            Timestamp ts1 = Timestamp.valueOf(file_time + " 00:00:00");
            Timestamp ts2 = Timestamp.valueOf(current_time + " 00:00:00");

            int compare = ts1.compareTo(ts2);

            if(compare==0){
                System.out.println("Both values are equal");
            }
             else if(compare>0){
                System.out.println("TimeSpan1 value is greater");
            }
            else{
                System.out.println("TimeSpan2 value is greater");
            }



            //Addiere mode_time to lastbackup time

            //if the time matches or was in the past backup.config

            //and change the config to current date

        }

        private String get_Time(){

            Date date = new Date();
            Timestamp ts=new Timestamp(date.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String stamp = formatter.format(ts);

            return stamp;
        }

        private void closeAPP () {
            System.exit(0);
        }
}

//remember sout