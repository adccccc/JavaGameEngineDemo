package main;


import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("My 2D Game");

        window.pack();  // show window
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
