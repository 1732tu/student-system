
package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


//游戏面板
public class GamePanel extends JLayeredPane {
    //JLayeredPane可以精准设置坐标，允许覆盖
    //JLabel本身具备居中的特点，不允许碰撞（重叠）

    //游戏初始化
    //恐龙
    JLabel Dinosaur;
    //仙人掌
    JLabel Cactus;
    //集合
    ArrayList<JLabel> cactusList = new ArrayList<>();
    //文字
    JLabel strLabel;

    //创建仙人掌
    public void CreatCactus() {
        //仙人掌
        Cactus = new JLabel();
        Cactus.setIcon(new ImageIcon("cactus.png"));
        //位置大小
        Cactus.setBounds(920, 400, 50, 95);
        //添加
        add(Cactus);
        //集合
        //游戏开始产生的第一个仙人掌
        cactusList.add(Cactus);

    }

    public GamePanel() {
        //恐龙
        Dinosaur = new JLabel();
        //添加图片
        Dinosaur.setIcon(new ImageIcon("dinosaur.png"));
        //位置大小
        Dinosaur.setBounds(30, 450, 70, 60);
        add(Dinosaur);

        //产生多个仙人掌
        CreatCactus();


        //文字
        strLabel = new JLabel();
        strLabel.setText("按enter键即可开始游戏");
        strLabel.setSize(400, 50);
        strLabel.setLocation(450, 50);
        //字体大小
        strLabel.setFont(new Font("楷体", Font.BOLD, 25));
        //把文字添加到容器
        add(strLabel);

        //给窗体添加键盘监听
        Game.GameFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            //检查是否有按键按下
            //e:监听程序返回的值
            @Override
            public void keyPressed(KeyEvent e) {
                //区分出回车键
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_ENTER) {
                    System.out.println("游戏开始");
                    //移动仙人掌
                    //1.创建子线程
                    //2.启动 start()
                    new Thread() {
                        @Override
                        public void run() {
                            while (true) {
                                //判断是否发生碰撞，如果发生碰撞仙人掌就不用移动
                                boolean b = isOver();
                                if (b) {
                                    break;
                                }

                                try {
                                    //不能一下子移动所以一段休眠时间 缓慢
                                    sleep(10);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                                //仙人掌获取当前坐标并向左边移动
                                //集合中所有的仙人掌都要移动 循环
                                for (int i = 0; i < cactusList.size(); i++) {
                                    cactusList.get(i).setLocation(cactusList.get(i).getX() - 10, cactusList.get(i).getY());

                                }
                            }
                        }
                    }.start();
                } else if (code == KeyEvent.VK_UP||code==KeyEvent.VK_SPACE) {
                    //创建线程单独控制恐龙移动
                    new Thread() {
                        @Override
                        public void run() {
                             //按一次跳一次
                            //恐龙跳动
                            Dinosaur.setLocation(Dinosaur.getX(), Dinosaur.getY() - 120);
                            //恐龙停留0.3秒钟
                            try {
                                sleep(300);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            //恐龙回到原位
                            Dinosaur.setLocation(Dinosaur.getX(), Dinosaur.getY() + 120);

                        }
                    }.start();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    //碰撞 true结束，false继续
    public boolean isOver() {
        Dinosaur.getX();
        //恐龙后方距离加上自身的宽
        int dx = Dinosaur.getX();
        int dw = Dinosaur.getWidth();
        //跳动时
        int dy = Dinosaur.getY();
        int dh = Dinosaur.getHeight();
        int cx = Cactus.getX();
        int cw = Cactus.getWidth();
        int cy = Cactus.getY();
        int ch = Cactus.getHeight();
        //判断前后距离
        //仙人掌在右边，仙人掌在左边，恐龙在上方，恐龙在下方
        if (dx + dw < cx || cx + cy < dx || dy + dh < cy || cy + ch < dy) {
            //没有发生碰撞
            return false;
        } else {
            //发生碰撞
            System.out.println("撞到了，游戏结束");
            return true;
        }

    }

}



