package miaumiez;

import java.io.File;
import java.io.FilenameFilter;

import static miaumiez.main.config_path;

public class configList {

        String[] path_names;

        File list_file = new File(config_path);

        configList(){

            path_names = list_file.list();

            for(String pathname : path_names){

             if(pathname.endsWith(".btc")){

                System.out.println(pathname);

             }
            }
        }
}
