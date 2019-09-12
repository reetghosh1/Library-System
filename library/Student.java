package library;
import java.io.*;
public class Student
{
    String name;
    int reg;
    Book x[]=new Book[5];
    int count=0;
    InputStreamReader read=new InputStreamReader(System.in);
    BufferedReader in=new BufferedReader(read);

    Student() throws IOException
    {
        System.out.println("Enter Name:");
        this.name=in.readLine();
        System.out.println("Enter Registration Number:");
        this.reg=Integer.parseInt(in.readLine());
    }
}
