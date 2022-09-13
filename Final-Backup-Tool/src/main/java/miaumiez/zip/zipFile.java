package miaumiez.zip;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class zipFile {

    public zipFile(String out_path, String...in_directory) {


        byte[] buffer = new byte[1024];

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(out_path));

            for (String f : in_directory) {
                File file = new File((f));
                ZipEntry entry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(entry);

                FileInputStream fis = new FileInputStream(file);
                int len;
                byte[] data = new byte[1024];

                while ((len = fis.read(data)) != -1) {
                    zipOutputStream.write(data, 0, len);
                }

                fis.close();
                zipOutputStream.closeEntry();

            }
            zipOutputStream.close();


            System.out.println(in_directory);
            try {
                Files.delete(
                        Paths.get(String.valueOf(in_directory)));
            } catch (NoSuchFileException e) {
                System.out.println(
                        "No such file/directory exists");
            } catch (DirectoryNotEmptyException e) {
                System.out.println("Directory is not empty.");
            } catch (IOException e) {
                System.out.println("Invalid permissions.");
            }

            System.out.println("Deletion successful.");




        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}