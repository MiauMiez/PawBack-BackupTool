package miaumiez;

import org.apache.commons.io.FileUtils;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class backup {

    public void Backup() {

        //Variables
        boolean isFile = false;
        File file_or_directory = mainframe.file_toBackup;

        //Test if it is a file or directory
        if (file_or_directory.isFile()) {
            isFile = true;
        }

        System.out.println("[Debug] " + file_or_directory.getName() + "  " + isFile);

        //Get the size of the file that you want to back up
        try {
            long size = Files.size(Path.of(mainframe.file_toBackup.getPath()));
            System.out.println("[Info] + Size of " + mainframe.file_toBackup.getName() + " is " + size + " bytes");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Gets the Name of file_BackupLocation
        String backup_file_name = mainframe.file_toBackup.getName();

        //Gets Current Time and date
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(" dd.MM.yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        //Sets Folder name
        String backup_folder_name = backup_file_name + formattedDate;
        System.out.println("[Info] Backup-folder name: " + backup_folder_name);

        //new path
        String new_path = mainframe.file_BackupLocation + "\\" + backup_folder_name;

        //Create Folder
        File theDir = new File(new_path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        File endDestination = new File(new_path);

        //Clone files
        try {
            if (isFile) {

                FileUtils.copyFileToDirectory(mainframe.file_toBackup, new File((new_path)));
                sendSuccessMessage();

            } else {

                FileUtils.copyDirectory(mainframe.file_toBackup, new File(new_path));
                sendSuccessMessage();
            }

        } catch (IOException ex) {
            System.out.println("[Error] while copying the files: ");
            throw new RuntimeException(ex);
        }

    }

    public void sendSuccessMessage(){
        JOptionPane.showMessageDialog(null, "Loading Complete...!!! All files have been successfully copied!");

    }
}