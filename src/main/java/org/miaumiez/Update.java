package org.miaumiez;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;


public class Update {
    boolean dev = true;

    //MAJOR.MINOR.PATCH
    public static String VER;
    public String GIT_VER;

    public final String GIT_VER_LINK = "https://raw.githubusercontent.com/MiauMiez/update_manager/main/pawBack/version";
    public final String GIT_DOWNLOAD = "";

    public Update(){
        try {

            VER = getClientVersion();
            GIT_VER = getCloudVersion();

            System.out.println("------VERSION------");
            System.out.println("Client: " + VER + "\nGITHUB: " + GIT_VER);

            if (!VER.equals(GIT_VER)){
                System.out.println("They are not the same, starting download");
                //  utils.sendErrorMessage("A new version has been released! Starting the download...", "Outdated client: " + VER + " new: " + GIT_VER );

                if (!dev){
                    System.out.println("Starting download for new version!" + "Client: " + VER + " GITHUB: " + GIT_VER);
                    downloadNewVersion();
                }
            }
        } catch (IOException e) {

        }

    }

    public void downloadNewVersion() throws IOException {

        File file = null;

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setDialogTitle("Please enter search for a path, where to save the new version!");

        int response = jFileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            file = new File(jFileChooser.getSelectedFile() + "\\PawBack.jar");
            System.out.println(file.getPath());

            URL link = new URL(GIT_DOWNLOAD);
            InputStream input = link.openStream();

            String path = String.valueOf(file.toPath());

            FileOutputStream output = new FileOutputStream(String.valueOf(path));

            System.out.println(path);
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
            }

            input.close();
            output.close();


            sendErrorMessage("New file has been downloaded!" , "Download successful");
        }
    }

    public String getCloudVersion() throws IOException {


        URL github_url = new URL(GIT_VER_LINK );
        HttpsURLConnection git_connection = (HttpsURLConnection) github_url.openConnection();
        Map<String, List<String>> gitHeader = git_connection.getHeaderFields();

        for (String header : gitHeader.get(null)){
            if (header.contains(" 404 ")){
                sendErrorMessage("Github servers could not be reached! Unable to check for updates" , header.toString());
            }
        }

        InputStream gitStream = git_connection.getInputStream();
        String github_response = getStringFromStream(gitStream);

        return github_response;
    }

    public String getStringFromStream(InputStream gitStream) throws IOException{

        String stringver;
        if (gitStream != null) {
            try {
                stringver = new BufferedReader(
                        new InputStreamReader(gitStream, StandardCharsets.UTF_8))
                        .lines()
                        .collect(Collectors.joining("\n"));
            } finally {
                gitStream.close();
            }
            return stringver;
        } else {
            sendErrorMessage("Github server had no content!" , "No content");
            return "No Contents";
        }

    }

    public String getClientVersion() throws IOException {

        InputStream resourceAsStream = Update.class.getClassLoader().getResourceAsStream("data.properties");
        Properties prop = new Properties();

        prop.load(resourceAsStream);
        String actuallVersion = prop.getProperty("database.version");
        System.out.println(actuallVersion);

        return actuallVersion;
    }

    public static void sendErrorMessage(String reason, String title) {

        JOptionPane.showMessageDialog(null, reason, title, 1);
    }

}
