package main.entity;

import main.graphic.CcVector;
import main.system.GamePanel;
import main.system.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {

    // 属性
    double vSpeed = 3.0; // 角色水平移动速度, 单位为像素每帧
    double jumpSpeed = -8.5; // 起跳的初速度(向上为负)
    double jumpReleaseCoefficient = 0.45; // 跳跃键释放后的上升速度系数

    // 状态
    boolean canJump = true; // 跳跃键未释放时的标记，此时不能重复跳跃

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
        speed = new CcVector(0, 0);

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

        moveCheck(); // 水平移动
        jumpCheck(); // 跳跃

        // 重力加速度修正竖直速度
        double G = 0.4;
        speed.y += G;

        // 重新计算物体位置
        pos.x += speed.x;
        pos.y += speed.y;
    }

    private void moveCheck() {

        speed.x = 0;
        if (keyHandler.leftPressed)
            speed.x = -vSpeed;
        if (keyHandler.rightPressed)
            speed.x = vSpeed;
    }

    private void jumpCheck() {

        // 跳跃速度设置
        if (keyHandler.jumpPressed && canJump) {
            speed.y = jumpSpeed; // 给一个竖直向上的初速度
            canJump = false; // 不能连着起跳
        }

        // 跳跃键释放
        if (keyHandler.jumpReleased) {
            canJump = true; // 可以再跳了
            keyHandler.jumpReleased = false;
        }
        // 释放跳跃键后减速：向上时的速度需要 * 系数
        // 实现：按得越久，跳的越高的效果
        if (speed.y < 0 && !keyHandler.jumpPressed)
            speed.y *= jumpReleaseCoefficient;
    }

}
