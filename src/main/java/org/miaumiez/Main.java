package org.miaumiez;

import org.miaumiez.gui.main;

import java.io.File;

public class Main {

    public static File app_home = new File(System.getProperty("user.home") + "\\pawback\\");

        public static void main(String[] args) {

            init_folder(); //CREATING app_home
            create_main(); //START FRAME

        }

        public static void init_folder() {
            if (!app_home.exists()){
                try {
                    app_home.mkdir();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        public static void create_main(){

            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new main().setVisible(true);
                }
            });

        }

}