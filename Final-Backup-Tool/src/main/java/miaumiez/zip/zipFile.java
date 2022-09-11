package miaumiez.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class zipFile {

    public zipFile(File directory){

        byte[] buffer = new byte[1024];

        String zipFileName = directory.getPath() + ".zip";
        String FilePath = directory.getPath();


        try {

            FileOutputStream fos = new FileOutputStream(zipFileName);//Output file name
            ZipOutputStream zos = new ZipOutputStream(fos);

            ZipEntry zipEntry = new ZipEntry("C:\\Users\\Alexander\\Desktop");
            zos.putNextEntry(zipEntry);

            FileInputStream in = new FileInputStream(FilePath);


            int len;
            while ((len = in.read(buffer)) > 0){
                zos.write(buffer, 0,len);

            }

            in.close();
            zos.closeEntry();
            zos.close();

            System.out.println("+++++++++++ Everything should be fine to go!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}