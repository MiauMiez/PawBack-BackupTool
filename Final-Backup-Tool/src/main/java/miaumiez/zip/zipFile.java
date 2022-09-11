package miaumiez.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class zipFile {

    public zipFile(String out_path, String...in_directory) {


        byte[] buffer = new byte[1024];

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(out_path));

            for (String f : in_directory ){
                File file = new File((f));
                ZipEntry entry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(entry);

                FileInputStream fis = new FileInputStream(file);
                int len;
                byte[] data = new byte[1024];

                while((len = fis.read(data)) != -1){
                    zipOutputStream.write(data, 0, len);
                }

                fis.close();
                zipOutputStream.closeEntry();

            }
        zipOutputStream.close();

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}