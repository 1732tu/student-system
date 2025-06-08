//package StringTest1;

import javax.swing.*;
/*
public class StringTest extends JFrame{
        public StringTest() {
            initComp();
            initFrame();

        }
        private void initComp(){
            //添加按钮
            JButton addBtn=new JButton("添加学生");
            addBtn.setBounds(30,330,130,30);
            add(addBtn);
        }

        //初始化窗体
        private void initFrame(){
            //设置窗体大小
            setSize(400,500);
            setTitle("管理员管理操作界面");
            //设置显示位置为屏幕居中
            setLocationRelativeTo(null);
            //设置窗体关闭时退出系统JVM
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            //取消布局管理，设置为绝对布局，默认布局
            setLayout(null);
        }

        public static void main(String[] args) {
           new StringTest().setVisible(true);
        }
    }

*/

/*
import java.awt.*;

public static void main(String[] args) {
    new StringTest().setVisible(true);//实例化实现窗口
}
//登录界面
public static class StringTest extends JFrame{
    //构造方法
    StringTest(){
        initFrame();
        initComp();
    }
    //初始化窗体
    private void initFrame() {
        //设置窗体大小
        setSize(470,350);
        setTitle("管理员登录");
        //设置显示位置为屏幕居中
        setLocationRelativeTo(null);
        //设置窗体关闭时退出系统JVM
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //取消布局管理，设置为绝对布局，默认布局
        setLayout(null);

    }

    //初始化组件
    public void initComp(){
        //字体
        Font font=new Font("黑体",Font.BOLD,30);
        //标题
        JLabel title=new JLabel("欢迎使用学生管理系统");
        title.setFont(font);//给文本设置字体
        title.setHorizontalAlignment(SwingConstants.CENTER);//设置位置居中
        title.setBackground(Color.cyan);//设置背景颜色
        title.setOpaque(true);//设置非透明实现可视化
        title.setForeground(Color.RED);//设置字体颜色
        title.setBounds(0,30,getWidth(),60);
        add(title);

        //添加输入框
        //创建输入框对象
        JTextField unameTfd=new JTextField();
        unameTfd.setBounds(180,120,200,30);//设置位置大小
        add(unameTfd);//添加到窗体中

        //文本标签
        JLabel unameLbl=new JLabel("管理员账号：");
        unameLbl.setBounds(30,120,100,30);
        add(unameLbl);

        //创建输入框对象
        JPasswordField upassTfd=new JPasswordField();
        upassTfd.setBounds(180,180,200,30);//设置位置大小
        add(upassTfd);//添加到窗体

        //文本标签
        JLabel upassLbl=new JLabel("管理员登录密码：");
        upassLbl.setBounds(30,180,100,30);//设置位置大小
        add(unameLbl);//添加到窗体

        //登录按钮和取消按钮
        JButton okBtn=new JButton("登录");
        okBtn.setBounds(50,230,120,30);
        add(okBtn);

        JButton cancelBtn=new JButton("取消登录");
        cancelBtn.setBounds(260,230,120,30);
        add(cancelBtn);

    }
}
*/



/*
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
    // 障碍物相关属性
    private ArrayList<JLabel> obstacleList = new ArrayList<>();
    private int obstacleWidth = 50;
    private int obstacleHeight = 50;
    // 游戏状态相关变量
    private boolean isRunning = false;
    private boolean isPaused = false;
    private long distance = 0; // 记录恐龙跑了多少米，以像素为单位
    // 游戏速度相关变量
    private int speed = 5; // 障碍物移动速度，可根据需要调整

    public DinosaurJumpGamePanel() {
        // 设置面板布局和基本属性
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));

        // 初始化恐龙
        dinosaurLabel = new JLabel();
        dinosaurLabel.setIcon(new ImageIcon("dinosaur.png")); // 替换为你的恐龙图片路径
        dinosaurX = 50;
        dinosaurY = 400;
        dinosaurLabel.setBounds(dinosaurX, dinosaurY, 70, 60);
        add(dinosaurLabel);

        // 初始化一个障碍物作为示例，可以后续添加更多
        createObstacle(800, 400);

        // 添加键盘监听
        addKeyListener(this);
        setFocusable(true);
    }

    // 创建障碍物的方法
    private void createObstacle(int x, int y) {
        JLabel obstacleLabel = new JLabel();
        obstacleLabel.setIcon(new ImageIcon("obstacle.png")); // 替换为你的障碍物图片路径
        obstacleLabel.setBounds(x, y, obstacleWidth, obstacleHeight);
        obstacleList.add(obstacleLabel);
        add(obstacleLabel);
    }

    // 游戏逻辑更新方法，在游戏循环中调用（这里通过定时器模拟游戏循环）
    private void updateGame() {
        if (isRunning &&!isPaused) {
            // 移动障碍物
            for (JLabel obstacle : obstacleList) {
                int currentX = obstacle.getX();
                obstacle.setLocation(currentX - speed, obstacle.getY());
                // 判断障碍物是否移出屏幕，如果移出则重置位置到屏幕右侧，模拟新的障碍物出现
                if (currentX < -obstacleWidth) {
                    obstacle.setLocation(800, (int) (Math.random() * 300 + 100));
                    distance += 800; // 每移出一个障碍物，增加距离
                }
            }
            // 碰撞检测逻辑（简单示例，可根据实际情况完善）
            for (JLabel obstacle : obstacleList) {
                if (checkCollision(dinosaurLabel, obstacle)) {
                    isRunning = false;
                    JOptionPane.showMessageDialog(this, "游戏结束，你跑了 " + (distance / 100.0) + " 米！");
                }
            }
        }
    }

    // 简单的碰撞检测方法，判断两个组件是否重叠（可根据实际情况优化）
    private boolean checkCollision(JLabel component1, JLabel component2) {
        Rectangle rect1 = component1.getBounds();
        Rectangle rect2 = component2.getBounds();
        return rect1.intersects(rect2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 在这里可以添加绘制游戏背景等其他画面相关的代码
        g.drawString("已跑距离: " + (distance / 100.0) + " 米", 50, 30);
    }

    // 启动游戏的方法，可以通过外部调用或者按键触发
    public void startGame() {
        isRunning = true;
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
        } else if (keyCode == KeyEvent.VK_UP) {
            if (isRunning &&!isPaused) {
                // 恐龙跳跃逻辑，简单实现向上移动一段距离再回落
                dinosaurY -= 100;
                dinosaurLabel.setLocation(dinosaurX, dinosaurY);
                Timer jumpTimer = new Timer(200, jumpEvent -> {
                    dinosaurY += 100;
                    dinosaurLabel.setLocation(dinosaurX, dinosaurY);
                    ((Timer) jumpEvent.getSource()).stop();
                });
                jumpTimer.start();
            }
        } else if (keyCode == KeyEvent.VK_W) {
            isPaused = true;
        } else if (keyCode == KeyEvent.VK_A) {
            isPaused = false;
        } else if (keyCode == KeyEvent.VK_SPACE) {
            // 获取游戏窗口并关闭
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("恐龙跳一跳游戏");
        DinosaurJumpGamePanel gamePanel = new DinosaurJumpGamePanel();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


 */
