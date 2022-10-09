package miaumiez;

import java.io.File;
import java.io.FilenameFilter;

import static miaumiez.main.config_path;
import static miaumiez.mainframe.choice_config;

public class addChoices {
    addChoices(){

        try {

            File f = new File(config_path);

            //Filter for the files
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File f, String name) {

                    return name.endsWith(".ser");
                }
            };

            //File array list
            File[] files = f.listFiles(filter);

            //Getting all the files
            for (int i = 0; i < files.length; i++) {

                String name = files[i].getName();

                String fileName = name.substring(0, name.lastIndexOf('.'));
                choice_config.add(fileName);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
}
