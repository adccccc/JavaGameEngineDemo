package main;


import main.system.GamePanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("My 2D Game");

        GamePanel gp = new GamePanel();
        gp.setupGame(); // 启动游戏主线程

        window.add(gp); // 游戏内容绘制到窗口
        window.pack();  // show window
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
