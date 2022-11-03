package main.entity;

import main.graphic.CcVector;
import main.system.GamePanel;
import main.system.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {

    // 控件
    public GamePanel gp; // 画板
    public KeyHandler keyHandler; // 按键监听器

    public Player(GamePanel gp, KeyHandler keyHandler) {

        this.gp = gp;
        this.keyHandler = keyHandler;
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
     * 更新角色状态
     */
    public void update() {

        // 角色移动速度, 单位为像素每帧
        double speed = 3.0;

        // 根据移动指令，修改角色位置
        if (keyHandler.leftPressed)
            pos.x -= speed;
        if (keyHandler.rightPressed)
            pos.x += speed;
        if (keyHandler.topPressed)
            pos.y -= speed;
        if (keyHandler.downPressed)
            pos.y += speed;
    }

}
