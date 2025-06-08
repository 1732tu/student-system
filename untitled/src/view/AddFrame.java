//package view;
/*
import javax.swing.*;
import java.awt.*;

public void main(String[] args) {
    new AddFrame().setVisible(true);
}
public class AddFrame extends JFrame{
        public AddFrame() {
            initFrame();
            initComp();
        }
     public void initComp(){
        //设置字体颜色和大小
        Font font=new Font("黑体", Font.BOLD,15);
        //学生姓名
        JLabel name=new JLabel("学生姓名:");
        name.setFont(font);
        name.setBounds(30,30,80,30);
        add(name);

        //文本输入框
        JTextField nameFld=new JTextField();
        nameFld.setBounds(150,30,180,30);
        add(nameFld);

        //学生年龄
        JLabel age=new JLabel("学生年龄:");
        age.setFont(font);
        age.setBounds(30,80,80,30);
        add(age);

        //文本输入框
        JTextField ageFld=new JTextField();
        ageFld.setBounds(150,80,180,30);
        add(ageFld);

        //学生邮箱
        JLabel email=new JLabel("电子邮箱:");
        email.setFont(font);
        email.setBounds(30,130,80,30);
        add(email);

        //文本输入框
        JTextField emailFld=new JTextField();
        emailFld.setBounds(150,130,180,30);
        add(emailFld);

        //学生手机号码
        JLabel phoneNumber=new JLabel("手机号码:");
        phoneNumber.setFont(font);
        phoneNumber.setBounds(30,180,80,30);
        add(phoneNumber);

        //文本输入框
        JTextField phoneNumberFld=new JTextField();
        phoneNumberFld.setBounds(150,180,180,30);
        add(phoneNumberFld);

        //学生性别
         JLabel sex=new JLabel("学生性别:");
         sex.setFont(font);
         sex.setBounds(30,230,80,30);
         add(sex);

         //单按钮
         JRadioButton maleRadioBtn=new JRadioButton("男");
         maleRadioBtn.setBounds(150,230,50,30);
         add(maleRadioBtn);

         JRadioButton femaleRadioBtn=new JRadioButton("女");
         femaleRadioBtn.setBounds(230,230,50,30);
         add(femaleRadioBtn);
         //把两个按钮放入同一个按钮组以实现只能单选
         //创建按钮组
         ButtonGroup group=new ButtonGroup();
         group.add(maleRadioBtn);
         group.add(femaleRadioBtn);

         //学生所属学校
         JLabel schoolName=new JLabel("所属学校:");
         schoolName.setFont(font);
         schoolName.setBounds(30,230,80,30);
         add(schoolName);
         //下拉选择框
         JComboBox<String>schoolCombox=new JComboBox<>();
         schoolCombox.setBounds(140,280,80,30);
         add(schoolCombox);
         //添加下拉选项
         schoolCombox.addItem("请选择学校");
         schoolCombox.addItem("梧州学院");
         schoolCombox.addItem("广西大学");
         schoolCombox.addItem("贺州学院");

         //添加按钮
         JButton okBtn=new JButton("保存添加");
         okBtn.setBounds(30,330,130,30);
         add(okBtn);

         JButton cancleBtn=new JButton("取消添加");
         cancleBtn.setBounds(200,330,130,30);
         add(cancleBtn);


     }
    //初始化窗体
    private void initFrame(){
        //设置窗体大小
        setSize(400,450);
        setTitle("添加学生信息");
        //设置显示位置为屏幕居中
        setLocationRelativeTo(null);
        //设置窗体关闭时退出系统JVM
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //取消布局管理，设置为绝对布局，默认布局
        setLayout(null);
    }

}
*/