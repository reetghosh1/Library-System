package library;
import java.io.*;
public class Testing
{
    public static void main(String args[]) throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("------------------------------------------------------------------------------------");
        Books ob=new Books();
        Students ob1=new Students();
        int ch;
        do {
            ob.menu();
            ch=Integer.parseInt(in.readLine());
            switch (ch)
            {
                case 1:
                {
                    Book q=new Book();
                    ob.add(q);
                    break;
                }
                case 2:
                {
                    ob.updateqty();
                    break;
                }
                case 3:
                {
                    ob.search();
                    break;
                }
                case 4:
                {
                    ob.showbooks();
                    break;
                }
                case 5:
                {
                    Student s=new Student();
                    ob1.addstud(s);
                    break;
                }
                case 6:
                {
                    ob1.show();
                    break;
                }
                case 7:
                {
                    ob1.checkin(ob);
                    break;
                }
                case 8:
                {
                    ob1.checkout(ob);
                    break;
                }
                default:
                {
                    System.out.println("Invalid Choice!");
                }
            }
        }while(ch!=0);
    }
}
