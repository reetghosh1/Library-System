package library;
import java.io.*;

public class Book
{
    int num;
    String bookname;
    int qty;
    int qty1;
    Book() throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("Enter Book ID:");
        this.num=Integer.parseInt(in.readLine());
        System.out.println("Enter Book Name:");
        this.bookname=in.readLine();
        System.out.println("Enter Quantity of Books:");
        this.qty=Integer.parseInt(in.readLine());
        qty1=this.qty;
    }
}
