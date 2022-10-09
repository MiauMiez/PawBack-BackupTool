package miaumiez.data;

import miaumiez.backup;
import miaumiez.configManager;

import java.io.*;

import static miaumiez.main.config_path;
import static miaumiez.main.dcI;


public class Serialization {

    backup backup = new backup();

    public void serialize(){

        String path = config_path + dcI.name + ".ser";

        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(dcI);
            out.close();
            fileOut.close();

            System.out.printf("Serialized data is saved in " + path);

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deSerialization(String path){

       config_Info e = null;
        try {

            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            e = (config_Info) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException i) {
            i.printStackTrace();
            return;

        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }

        backup.backupConfig(e.name, e.path, e.end_location, e.zip);

    }
}



