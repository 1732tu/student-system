package view;
/*
import javax.swing.*;
import java.awt.*;

public static void main(String[] args) {
    new LoginFrame().setVisible(true);//实例化实现窗口
}
//登录界面
public class LoginFrame extends JFrame{
    //构造方法
    LoginFrame(){
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

