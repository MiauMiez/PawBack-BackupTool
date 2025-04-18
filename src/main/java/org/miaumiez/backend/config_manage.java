//Diese Klasse ist verantwortlich dafür das managen von den configs
package org.miaumiez.backend;

import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.miaumiez.Main.app_home;

public class config_manage {

    //Returns an Array of all config_files
    public static File[] get_items(){

        File directoryPath = new File(app_home.toURI());
        FilenameFilter jsonFilefilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".json")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        String filesList[] = directoryPath.list(jsonFilefilter);
        File[] files = new File[filesList.length];
        for (int i = 0; i < filesList.length; i++) {
            files[i] = new File(directoryPath.getPath() + "/" + filesList[i]);
        }

        return files;
    }

    public static String[] get_content(String key){

        String[] content = new String[get_items().length];
        File[] arr = get_items();

        for (int i = 0; i < arr.length; i++){
            String name = read(new File(arr[i].toURI()), key);
            content[i] = name;
        }

        return content;
    }

    public static String read(File config, String key){
        try {

            byte[] bytes = Files.readAllBytes(Path.of(config.toURI()));
            String json_content = new String(bytes);

            JSONObject jsonObject = new JSONObject(json_content);

              String content = null;
              if (key ==  "backup_mode"){
                  content = String.valueOf(jsonObject.getInt(key));
              } else {
                 content =  jsonObject.getString(key);
              }

          return content;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean filenameStartsWith(String filename, String match) {
        String prefix = match.toLowerCase();
        if (filename.toLowerCase().startsWith(prefix)){
            System.out.println("match! File found!" );
            return true;
        }
        return false;
    }

    public static String getSelectedRowFirstColumn(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        TableModel model = table.getModel();
        return (String) model.getValueAt(selectedRow, 0);
    }



}
