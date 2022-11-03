package main.system;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    // 输入控件标记状态
    public boolean leftPressed, rightPressed;
    public boolean jumpPressed, jumpReleased;

    GamePanel gp;

    public KeyHandler(GamePanel gp) {

        this.gp = gp;
    }

    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) { // 向左
            leftPressed = true;
        } else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) { // 向右
            rightPressed = true;
        } else if (code == KeyEvent.VK_SPACE || code == KeyEvent.VK_SHIFT) { // 跳跃
            jumpPressed = true;
            jumpReleased = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        } else if (code == KeyEvent.VK_SPACE || code == KeyEvent.VK_SHIFT) {
            jumpPressed = false;
            jumpReleased = true;
        }
    }

}
