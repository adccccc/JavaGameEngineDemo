package main.entity;

import main.graphic.CcVector;
import main.system.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player {

    // 属性
    public CcVector pos; // 位置
    public CcVector box; // 大小
    public BufferedImage img; // 图片

    // 控件
    public GamePanel gp;

    public Player(GamePanel gp) {

        this.gp = gp;
        initPlayer();
    }

    // 初始化角色属性
    private void initPlayer() {

        // 初始坐标和角色大小
        pos = new CcVector(100, 100);
        box = new CcVector(32,32);

        // 加载角色图片
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/stand01.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘制角色图形
     */
    public void draw(Graphics2D g2) {

        g2.drawImage(img, (int)pos.x, (int)pos.y, (int)box.x, (int)box.y, null);
    }

}
