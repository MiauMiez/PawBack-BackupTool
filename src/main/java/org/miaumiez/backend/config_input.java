package org.miaumiez.backend;

import org.json.JSONObject;

import org.miaumiez.gui.manage_config;

import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


import static org.miaumiez.Main.app_home;

public class config_input {

    //                                            1                   2                   3           4
    public static int[] check_input_for_errors(String location, String backup_location, String name, int backup_mode){
        int[] errors = new int[4];

        if(backup_mode != 1 && backup_mode != 2 && backup_mode != 3) {
            errors[0] = 1;
        } else { errors[0] = 0;}

        if(name.equals("Enter a name") || name == null || name.isEmpty()) {
            errors[1] = 1;
        } else { errors[1] = 0;}

        if(location == null) {
            errors[2] = 1;
        } else { errors[2] = 0;}

        if(backup_location == null) {
            errors[3] = 1;
        } else { errors[3] = 0;}

        return errors;
    }

    public static void write_config(String location, String backup_location, String name, int backup_mode, String original_name, String file_name){

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);

        try {
            JSONObject jsonObject = new JSONObject();

            //PUt variables in json object
            jsonObject.put("name", name);
            jsonObject.put("backup_location", backup_location);
            jsonObject.put("folder_file_location", location);
            jsonObject.put("backup_mode", backup_mode);
            jsonObject.put("next_date", calculate_next_date(formattedDate, backup_mode));
            jsonObject.put("created", formattedDate);

            // Write updated JSON object to file with random ID
            FileWriter fileWriter = null;
            if (Objects.isNull(original_name)){

                fileWriter = new FileWriter(app_home + "\\" + name + UUID.randomUUID() + ".json");
                System.out.println("Saving new config.");

            } else {

                //Little bit more code here because I just want to update the name and not the uuid
                String result = file_name.substring(original_name.length());
                fileWriter = new FileWriter(app_home + "\\" + name + result);
                File old_file = new File(app_home + "\\" + original_name + result);
                old_file.delete();
                System.out.println("Saving changes.");
            }

            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
            fileWriter.close();

            System.out.println("Successfully wrote to JSON file.");
            manage_config.initTable();
            manage_config.load_items();
        } catch (Exception e) {
            System.out.println("An error happend while writing to JSON file: " + e.getMessage());
        }
    }

    public static String calculate_next_date(String formattedDate, int mode) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal_ = Calendar.getInstance();
        cal_.setTime(sdf.parse(formattedDate));

        switch (mode){
            case 1:
                cal_.add(Calendar.DAY_OF_MONTH, 1);
                break;

            case 2:
                cal_.add(Calendar.DAY_OF_MONTH, 7);
                break;

            case 3:
                cal_.add(Calendar.MONTH, 1);
                break;
            default:
        }

        return sdf.format(cal_.getTime());
    }
}
