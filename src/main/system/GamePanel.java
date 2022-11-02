package main.system;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public final int screenWidth = 800, screenHeight = 640; // 窗体大小(分辨率)：800 x 640px
    public static final int FPS = 50; // 上限50帧

    Thread gameThread;

    public GamePanel() {

        try {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true); // 双缓冲绘图，提升性能
            this.setFocusable(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void setupGame() {

        // 游戏线程启动
        (gameThread = new Thread(this)).start();
    }

    @Override
    public void run() {

        double drawInterval = 1000d / FPS; // 20ms
        double delta = 0;
        long currentTime, lastTime = System.currentTimeMillis();

        while (gameThread != null) {

            currentTime = System.currentTimeMillis();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) { // 可以画下一帧了

                // 1. 更新游戏内容信息
                update();

                // 2. 重新绘制游戏画面
                repaint();

                delta--;
            }
        }
    }


    public void update() {

    }

    /**
     * 重新绘制所有内容
     * 背景层 -> 物体层 -> 角色层 -> UI层
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.dispose();
    }

}
