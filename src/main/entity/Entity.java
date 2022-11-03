package main.entity;

import main.graphic.CcVector;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    // 属性
    public CcVector pos; // 位置
    public CcVector box; // 大小
    public BufferedImage img; // 图片

    /**
     * 绘制角色图形
     */
    public void draw(Graphics2D g2) {

        g2.drawImage(img, (int)pos.x, (int)pos.y, (int)box.x, (int)box.y, null);
    }
}
