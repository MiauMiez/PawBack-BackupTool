package miaumiez.time;
import miaumiez.mainframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showInputDialog;
import static miaumiez.main.config_path;

public class frame implements ActionListener {

    JFrame frame = new JFrame("Auto-backup-manager");

    public static Choice config_choice = new Choice();
    public Choice time_choice = new Choice();
    public JButton confirm_add = new JButton();
    public JButton back_button;
    public JButton debug_open_file;

    public frame(){

        buildFrame();
        buildGUI();
        add_time_choice();

    }

    public void buildGUI (){

        config_choice.setFocusable(false);
        config_choice.setBounds(80,100,200,20);

        time_choice.setFocusable(false);
        time_choice.setBounds(80,130, 200,20);

        confirm_add.setFocusable(false);
        confirm_add.setBounds(80, 160, 200, 20);
        confirm_add.addActionListener(this);

        back_button = new JButton ("back");
        back_button.setBounds (10, 335, 85, 20);
        back_button.setFocusable(false);
        back_button.addActionListener(this);

        debug_open_file = new JButton("Open Explorer");
        debug_open_file.setBounds(10, 200, 100, 20);

        //add components
        frame.add(config_choice);
        frame.add(time_choice);
        frame.add(confirm_add);
        frame.add(back_button);
        frame.add(debug_open_file);
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == confirm_add){

            confirm_add();

        }

        if(e.getSource() == back_button){

            mainframe mainframe = new mainframe();
            frame.dispose();

        }

        if (e.getSource() == debug_open_file){



        }
    }

    public void confirm_add(){

        String message = "Config: " + config_choice.getSelectedItem() + "\n" + "Time: " +  time_choice.getSelectedItem();
        int dialog_result = JOptionPane.showConfirmDialog(null, "Confirm the Action:\n" + message, "Continue?", 2);

        if (dialog_result == JOptionPane.YES_NO_OPTION) {

             String config = config_path + config_choice.getSelectedItem() + ".ser";
             String autoTime = time_choice.getSelectedItem();
             String name = config_choice.getSelectedItem();

             Serialization ser = new Serialization();
             ser.jsonManager(config, autoTime, name);

            }
        }

    public void add_time_choice(){

        time_choice.add("every day");
        time_choice.add("every week");
        time_choice.add("every month");

    }

    public void buildFrame(){

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(34, 40, 49));
        frame.setVisible (true);
        frame.setResizable(false);
        frame.pack();

        frame.setSize(440,410);
        frame.setLayout(null);


    }
}
