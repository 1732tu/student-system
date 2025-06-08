package Game1;
import javax.swing.*;
import java.awt.*;

public class Game_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("跳一跳");
        DinosaurJumpGamePanel gamePanel = new DinosaurJumpGamePanel();
        frame.add(gamePanel);

        // 获取屏幕尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // 获取窗口尺寸
        frame.pack();
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();

        // 计算窗口居中的坐标位置
        int x = (screenWidth - windowWidth) / 2;
        int y = (screenHeight - windowHeight) / 2;

        // 设置窗口位置使其居中
        frame.setLocation(x, y);
        //用于设置JFrame窗口的默认关闭操作
        //表示当用户尝试关闭窗口时，应用程序应该终止
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
