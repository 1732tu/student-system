package Game1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// 游戏面板类
public class DinosaurJumpGamePanel extends JPanel implements KeyListener {

    // 恐龙相关属性
    private JLabel dinosaurLabel;
    private int dinosaurX;
    private int dinosaurY;

    // 障碍物集合
    private ArrayList<JLabel> obstacleList = new ArrayList<>();
    //相关属性
    private int obstacleWidth = 50;
    private int obstacleHeight = 95;

    // 游戏状态相关变量
    private boolean isRunning = false;
    private boolean isPaused = false;

    // 记录恐龙跑了多少米
    private long distance = 0;

    //障碍物移动速度，以米每秒为单位
    private int speed = 14  ;

    public DinosaurJumpGamePanel() {
        // 设置面板布局大小
        //设置布局为空布局：不使用布局管理器，而是通过手动设置组件的位置和大小来安排界面的一种布局方式。
        setLayout(null);
        //上一级使用了布局管理器，本级需使用这种方法设置尺寸
        setPreferredSize(new Dimension(1000, 700));

        // 初始化恐龙
        dinosaurLabel = new JLabel();
        dinosaurLabel.setIcon(new ImageIcon("dinosaur.png")); // 恐龙图片路径
        dinosaurX = 50;
        dinosaurY = 290;
        dinosaurLabel.setBounds(dinosaurX, dinosaurY, 70, 360);
        add(dinosaurLabel);

        // 初始化一个障碍物，可以后续添加更多
        createObstacle(920, 400);

        // 添加键盘监听
        addKeyListener(this);
        //使能控件获得焦点
        setFocusable(true);
    }

    // 创建障碍物的方法
    private void createObstacle(int x, int y) {
        JLabel obstacleLabel = new JLabel();
        // 障碍物图片路径
        obstacleLabel.setIcon(new ImageIcon("cactus.png"));
        //设置位置大小
        obstacleLabel.setBounds(x, y, obstacleWidth, obstacleHeight);
        //添加
        obstacleList.add(obstacleLabel);
        add(obstacleLabel);
    }

    // 障碍物重新刷新出现，在游戏循环中调用（通过定时器模拟游戏循环）
    //定时器每次触发时要执行的具体动作。
    private void updateGame() {
        if (isRunning &&!isPaused) {
            // 移动障碍物
            //用于遍历obstacleList集合中的每个元素
            for (JLabel obstacle : obstacleList) {
                //获取每个障碍物当前的横坐标
                int currentX = obstacle.getX();
                obstacle.setLocation(currentX - speed, obstacle.getY());
                // 判断障碍物是否移出屏幕，如果移出则重置位置到屏幕右侧，模拟新的障碍物出现
                if (currentX < -obstacleWidth) {
                    obstacle.setLocation(920, 400 );
                    // 每移出一个障碍物，增加成绩距离
                    distance += 100;
                }
            }
            // 碰撞后的成绩显示
            //用于遍历obstacleList集合中的每个元素
            for (JLabel obstacle : obstacleList) {
                if (checkCollision(dinosaurLabel, obstacle)) {
                    isRunning = false;
                    //Swing中的方法，用于在主屏幕上显示弹出式对话框，可以向用户显示最终成绩信息。
                    JOptionPane.showMessageDialog(this, "游戏结束，恐龙跑了 " + (distance / 100.0) + " 米！");
                }
            }
        }
    }

    // 简单的碰撞检测方法，判断两个组件是否重叠
    private boolean checkCollision(JLabel component1, JLabel component2) {
        //获取组件component1的边界矩形，并将其赋值给变量rect1
        //getBounds()方法返回一个Rectangle对象，该对象包含了组件的边界信息，包括位置（x, y）和大小（width, height）。
        Rectangle rect1 = component1.getBounds();
        //获取组件component2的边界矩形，并将其赋值给变量rect2
        Rectangle rect2 = component2.getBounds();
        //判断两个矩形对象 rect1 和 rect2 是否相交。
        //用于检测游戏角色与障碍物之间是否发生碰撞
        return rect1.intersects(rect2);
    }

    //由 Swing 的绘图机制自动调用的，通常是在组件需要重绘时，比如窗口大小改变、组件被遮挡后重新显示等
    //paintComponent 方法不直接调用
    @Override
    protected void paintComponent(Graphics g) {
        //调用父类的paintComponent方法来清除旧的绘图
        super.paintComponent(g);
        // 添加绘制游戏背景等其他画面相关的
        g.drawString("已跑距离: " + (distance / 100.0) + " 米", 70, 50);
        //设置字体大小
        setFont(new Font("楷体", Font.BOLD, 25));
    }

    // 启动游戏的方法，可以通过外部调用或者按键触发
    public void startGame() {
        isRunning = true;
        //一个Lambda表达式，它定义了定时器触发时要执行的动作
        //创建一个定时器，该定时器每20毫秒触发一次，每次触发时执行updateGame()方法。
        Timer timer = new Timer(20, e -> updateGame());
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            startGame();
            System.out.println("游戏开始");
        } else if (keyCode == KeyEvent.VK_UP) {
            if (isRunning &&!isPaused) {
                // 恐龙跳跃逻辑，简单实现向上移动一段距离再回落
                //改变恐龙的Y轴位置并更新其显示位置，然后停止定时器，确保这个动作只执行一次。
                dinosaurY -=250;
                dinosaurLabel.setLocation(dinosaurX, dinosaurY);
                //定时器的时间间隔，单位是毫秒
                //一个Lambda表达式，它定义了定时器触发时要执行的动作
                //恐龙跳跃在空中停留的时间
                Timer jumpTimer = new Timer(350, jumpEvent -> {
                    //恐龙恢复原位
                    dinosaurY+= 250;
                    //更新恐龙标签的位置
                    dinosaurLabel.setLocation(dinosaurX, dinosaurY);
                    //停止了定时器，确保回落动作只执行一次，完成整个恐龙跳跃并回落的过程
                    ((Timer) jumpEvent.getSource()).stop();
                });
                //定时器会开始计时，并在350毫秒后触发Lambda表达式中定义的动作
                jumpTimer.start();
            }
        } else if (keyCode == KeyEvent.VK_W) {
            isPaused = true;
            System.out.println("游戏暂停");
        } else if (keyCode == KeyEvent.VK_A) {
            isPaused = false;
            System.out.println("游戏继续");
        } else if (keyCode == KeyEvent.VK_SPACE) {
            //获取当前组件所在的顶层窗口
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            //关闭窗口，并且释放窗口所占用的系统资源
            frame.dispose();
            System.out.println("退出游戏");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

