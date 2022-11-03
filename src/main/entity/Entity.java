package main.entity;

import main.graphic.CcPolygon;
import main.graphic.CcVector;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    // 属性
    public CcVector pos; // 位置
    public CcVector box; // 大小
    public CcVector speed; // 速度
    public BufferedImage img; // 图片

    // 物体形状 0-多边形 1-圆形
    public int shape = 0;
    // 凸多边形端点列表，两两相连，围成物体的撞检测区域
    // 端点坐标为物体坐标(左上角)的相对坐标，一般情况均为正数
    public CcPolygon collisionPoly;
    // 圆形碰撞半径
    public double collisionRadius;

    /**
     * 绘制角色图形
     */
    public void draw(Graphics2D g2) {

        g2.drawImage(img, (int)pos.x, (int)pos.y, (int)box.x, (int)box.y, null);
    }
}
