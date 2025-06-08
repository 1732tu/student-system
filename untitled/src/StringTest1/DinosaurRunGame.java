/*
package StringTest1;

import Game.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class Dinosaur {
    private int x;
    private int y;
    private int width;
    private int height;
    private final int jumpStrength = 15;  // 跳跃力度
    private boolean isJumping;
    private int jumpStep;

    public Dinosaur(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isJumping = false;
        this.jumpStep = 0;
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            jumpStep = 0;
        }
    }

    public void update() {
        if (isJumping) {
            // 简单的抛物线跳跃模拟，这里可以进一步优化物理效果
            y -= jumpStrength - jumpStep;
            jumpStep += 2;
            if (y >= 200) {  // 回到地面
                y = 200;
                isJumping = false;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
class Obstacle {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;

    public Obstacle(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void update() {
        x -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isOutOfScreen() {
        return x + width < 0;
    }
}
public class DinosaurRunGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dinosaur Run Game");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gamePanel.setName("11");
    }
}

 */

