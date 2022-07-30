package miaumiez;

//comment
import org.apache.commons.io.FileUtils;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class backup {

    public void Backup() {

        //Gets the Name of file_BackupLocation
        String backup_file_name = mainframe.file_toBackup.getName();

        //Gets Current Time and date
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(" dd.MM.yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        //Sets Folder name
        String backup_folder_name = backup_file_name + formattedDate;
        System.out.println("Backup-folder name: " + backup_folder_name);

        //new path
        String end_path = mainframe.file_BackupLocation + "\\" + backup_folder_name;
        //Create Folder
        File theDir = new File(end_path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }



        //Clone Files
        File endFile = new File(end_path);

        try {
            FileUtils.copyDirectory(mainframe.file_toBackup, new File(end_path));

        } catch (IOException ex) {
            System.out.println("[Error] while copying the files: ");
            throw new RuntimeException(ex);
        }
    }
}

