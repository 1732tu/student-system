
package Game;
import javax.swing.*;
public class Game {
    //对象共享
    public static JFrame GameFrame;
    public static void main(String[] args) {
        //创建窗体
        GameFrame=new JFrame();
        //设置窗体大小
        GameFrame.setSize(1000,700);
        //设置显示位置为屏幕居中
        GameFrame.setLocationRelativeTo(null);
        //标题
        GameFrame.setTitle("小游戏");
        //添加容器
        GameFrame.add(new GamePanel());
        //可视化
        GameFrame.setVisible(true);
    }
}


