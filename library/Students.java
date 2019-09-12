package library;
import java.io.*;
public class Students {
    InputStreamReader read = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(read);
    Student s[] = new Student[30];
    static int k = 0;

    void addstud(Student a) {
        for (int i = 0; i < k; i++) {
            if (a.reg == s[i].reg) {
                System.out.println("Already Registered!");
            }
        }

        if (k < 30) {
            s[k] = a;
            k++;
        } else {
            System.out.println("System Full! No more students can be registered.");
        }
    }

    void show() {
        System.out.println("Student Name\t\tReg No.");
        for (int i = 0; i < k; i++) {
            System.out.println(s[i].name + "\t\t" + s[i].reg);
        }
    }

    int check() throws IOException {
        System.out.println("Enter Registration Number:");
        int regno = Integer.parseInt(in.readLine());
        for (int i = 0; i < k; i++) {
            if (s[i].reg == regno) {
                return i;
            }
        }
        System.out.println("Not Registered, get registered first!");
        return -1;
    }

    void checkout(Books x) throws IOException
    {
        int st = this.check();
        if (st != -1)
        {
            System.out.println("ISSUING");
            x.showbooks();
            Book a = x.issue();
            if (a != null) {
                if (s[st].count <= 5) {
                    System.out.println("Adding Book:");
                    s[st].x[s[st].count] = a;
                    s[st].count++;
                    return;
                } else {
                    System.out.println("Book limit reached!");
                    return;
                }
            }
            System.out.println("Book not available!");
        }
    }

    void checkin(Books z) throws IOException
    {
        int st=this.check();
        if(st!=-1)
        {
            System.out.println("Book ID\t\tBook Name");
            Student v=s[st];
            for (int i=0;i<v.count;i++)
            {
                System.out.println(v.x[i].num+"\t\t"+v.x[i].bookname);
            }
            System.out.println("Enter Book Id of book you wish to return:");
            int t=Integer.parseInt(in.readLine());
            for(int i=0;i<v.count;i++)
            {
                if(t==v.x[i].num)
                {
                    z.returnbook(v.x[i]);
                    v.x[i]=null;
                    return;
                }
            }
            System.out.println("Book ID: "+t+" not found!");
        }
    }
}
