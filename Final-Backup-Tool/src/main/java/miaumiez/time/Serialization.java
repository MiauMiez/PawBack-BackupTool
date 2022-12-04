package miaumiez.time;


import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static miaumiez.main.time_config_path;

public class Serialization {

    public int time_option;


    public void jsonManager(String config_path, String auto_time, String name) {

        //Format the String to numbers for better reading
        switch (auto_time) {
            case "every day":
                time_option = 0;
                break;
            case "every week":
                time_option = 1;
                break;
            case "every month":
                time_option = 2;
                break;
            default:
        }

        //get a readable timestamp
        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());

        try {
            jsonGenerator(config_path, time_option, timeStamp, name);
        }catch (IOException e){e.printStackTrace();}
    }

    public void jsonGenerator(String config_path, int auto_time, String timestamp, String name) throws IOException {

        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        String filename = name + " " + uuidAsString + ".json";

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("time", "15.15.2015");
        jsonObject.put("config_path", config_path);
        jsonObject.put("auto_time_option", auto_time);

        FileWriter fileWriter = new FileWriter(new File( time_config_path + filename));
        fileWriter.write(jsonObject.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}

