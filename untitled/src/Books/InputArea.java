
package Books;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class InputArea extends JPanel implements ActionListener {
    File f=null;
    Box baseBox,boxV1,boxV2;
    JTextField bookname;
    JTextField author;
    JTextField press;
    JTextField IBSN;
    JTextField price;
    JButton button;
    LinkedList<Books>bookslist;
    InputArea(File f){
        this.f=f;
        bookslist=new LinkedList<Books>();
        bookname=new JTextField(12);
        author=new JTextField(12);
        press=new JTextField(12);
        IBSN=new JTextField(12);
        price=new JTextField(12);
        button=new JButton("录入");
        button.addActionListener(this);
        boxV1=Box.createVerticalBox();
        boxV1.add(new JLabel("输入名称"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("输入作者"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("输入出版日期"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("输入编号"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("输入价格"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("单击录入"));
        boxV2=Box.createVerticalBox();
        boxV2.add(bookname);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(author);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(press);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(IBSN);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(price);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(button);
        baseBox=Box.createHorizontalBox();
        baseBox.add(boxV1);
        baseBox.add(Box.createHorizontalStrut(10));
        baseBox.add(boxV2);
        add(baseBox);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (f.exists()){
            try{
                FileInputStream fi=new FileInputStream(f);
                ObjectInputStream oi=new ObjectInputStream(fi);
                bookslist =(LinkedList<Books>) oi.readObject();
                fi.close();
                oi.close();
                Books books=new Books();
                books.setBookname(bookname.getText());
                books.setAuthor(author.getText());
                books.setIBSN(IBSN.getText());
                books.setPress(press.getText());
                books.setPrice(price.getText());
                bookslist.add(books);
                FileOutputStream fo=new FileOutputStream(f);
                ObjectOutputStream out=new ObjectOutputStream(fo);
                out.writeObject(bookslist);
                out.close();

            }
            catch (Exception ee){}

        }
        else {
            try {
                f.createNewFile();
                Books books=new Books();
                books.setBookname(bookname.getText());
                books.setAuthor(author.getText());
                books.setIBSN(IBSN.getText());
                books.setPress(press.getText());
                books.setPrice(price.getText());
                bookslist.add(books);
                FileOutputStream fo=new FileOutputStream(f);
                ObjectOutputStream out=new ObjectOutputStream(fo);
                out.writeObject(bookslist);
                out.close();

            }
            catch (Exception ee){}
          }
        }

    }

/*


package Books;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import javax.swing.*;

public class InputArea extends JPanel implements ActionListener {
    private File file;
    private Box baseBox, boxV1, boxV2;
    private JTextField bookname, author, press, IBSN, price;
    private JButton button;
    private LinkedList<Books> bookslist;

    InputArea(File file) {
        this.file = file;
        bookslist = new LinkedList<>();

        bookname = new JTextField(12);
        author = new JTextField(12);
        press = new JTextField(12);
        IBSN = new JTextField(12);
        price = new JTextField(12);

        button = new JButton("录入");
        button.addActionListener(this);

        boxV1 = Box.createVerticalBox();
        boxV1.add(new JLabel("输入名称"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("输入作者"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("输入出版日期"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("输入编号"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("输入价格"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("单击录入"));

        boxV2 = Box.createVerticalBox();
        boxV2.add(bookname);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(author);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(press);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(IBSN);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(price);
        boxV2.add(Box.createVerticalStrut(8));
        boxV2.add(button);

        baseBox = Box.createHorizontalBox();
        baseBox.add(boxV1);
        baseBox.add(Box.createHorizontalStrut(10));
        baseBox.add(boxV2);

        add(baseBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Books book = new Books();
        book.setBookname(bookname.getText());
        book.setAuthor(author.getText());
        book.setIBSN(IBSN.getText());
        book.setPress(press.getText());

        // 验证价格输入是否合法
        try {
            double priceValue = Double.parseDouble(price.getText());
            book.setPrice(priceValue);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "价格输入格式不正确，请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (file.exists()) {
            try {
                loadBooksFromFile();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        bookslist.add(book);

        try {
            writeBooksToFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadBooksFromFile() throws IOException, ClassNotFoundException {
        try (FileInputStream fi = new FileInputStream(file);
             ObjectInputStream oi = new ObjectInputStream(fi)) {
            bookslist = (LinkedList<Books>) oi.readObject();
        }
    }

    private void writeBooksToFile() throws IOException {
        try (FileOutputStream fo = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fo)) {
            out.writeObject(bookslist);
        }
    }
}
*/

