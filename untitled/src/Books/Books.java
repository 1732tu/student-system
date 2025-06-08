package Books;

public class Books implements java.io.Serializable {
    String bookname;
    String author;
    String press;
    String IBSN;
    String price;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getIBSN() {
        return IBSN;
    }

    public void setIBSN(String IBSN) {
        this.IBSN = IBSN;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
