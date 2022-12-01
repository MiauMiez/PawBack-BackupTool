package miaumiez.time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miaumiez.addChoices;

public class frame implements ActionListener {

    JFrame frame = new JFrame("Auto-backup-manager");

    public static Choice config_choice = new Choice();
    public Choice time_choice = new Choice();
    public JButton confirm_add = new JButton();

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

        //add components
        frame.add(config_choice);
        frame.add(time_choice);
        frame.add(confirm_add);
    }


    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == confirm_add){

            confirm_add();

        }
    }


    public void confirm_add(){

        String message = "Config: " + config_choice.getSelectedItem() + "\n" + "Time: " +  time_choice.getSelectedItem();
        int dialog_result = JOptionPane.showConfirmDialog(null, "Confirm the Action:\n" + message, "Continue?", 2);

        if (dialog_result == JOptionPane.YES_NO_OPTION) {

            System.out.println("User has confirmed the action!");


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
