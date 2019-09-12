package library;
import java.io.*;
public class Books {
    Book ob[] = new Book[50];
    static int k;
    InputStreamReader read = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(read);

    int compare(Book a, Book b) {
        if (a.num == b.num) {
            System.out.println("Book of this ID already exists!");
            return 0;
        }
        return 1;
    }

    void add(Book x) {
        for (int i = 0; i < k; i++) {
            if (this.compare(x, this.ob[i]) == 0) {
                return;
            }
        }

        if (k < 20) {
            ob[k] = x;
            k++;
        } else {
            System.out.println("Library Full!");
        }
    }

    void search() throws IOException {
        int n;
        System.out.println("Enter Book ID:");
        n = Integer.parseInt(in.readLine());
        int f = 0;
        System.out.println("Book ID\t\tBook Name\t\tAvailable Quantity\t\tTotal Quantity");
        for (int i = 0; i < k; i++) {
            if (n == ob[i].num) {
                System.out.println(ob[i].num + "\t\t" + ob[i].bookname + "\t\t" + ob[i].qty1 + "\t\t" + ob[i].qty);
                f++;
                return;
            }
        }
        if (f == 0) {
            System.out.println("No Book exists for Book ID: " + n);
        }
    }

    void showbooks() {
        System.out.println("ALL BOOKS:");
        System.out.println("Book ID\t\tBook Name\t\t\tAvailable Quantity\t\t\tTotal Quantity");
        for (int i = 0; i < k; i++) {
            System.out.println(ob[i].num + "\t\t" + ob[i].bookname + "\t\t\t" + ob[i].qty1 + "\t\t\t" + ob[i].qty);
        }
    }

    void updateqty() throws IOException
    {
        System.out.println("UPDATE QUANTITY OF BOOK");
        System.out.println("Enter Serial Number of Book:");
        int p=Integer.parseInt(in.readLine());
        for (int i=0;i<k;i++)
        {
            if (p==ob[i].num)
            {
                System.out.println("Enter number of books to be added:");
                int add=Integer.parseInt(in.readLine());
                ob[i].qty=ob[i].qty+add;
                ob[i].qty1=ob[i].qty1=add;
                return;
            }
        }
    }

    void menu()
    {
        System.out.println("-----------------------------------LIBRARY SYSTEM-----------------------------------");
        System.out.println("1) Add new book\n" +
                "2) Upgrade Quantity\n" +
                "3) Search by Book ID\n" +
                "4) Show all books\n" +
                "5) Register Student\n" +
                "6) Show all Registered Students\n" +
                "7) Return Book\n" +
                "8) Issue Book\n" +
                "Press 0 to exit program");
        System.out.println("------------------------------------------------------------------------------------");
    }

    int available(int u)
    {
        for (int i=0;i<k;i++)
        {
            if(u==ob[i].num)
            {
                if(ob[i].qty1>0)
                {
                    System.out.println("Book Available!");
                    return i;
                }
                else
                {
                    System.out.println("Book Unavailable!");
                    return -1;
                }
            }
        }
        System.out.println("No Book for this Book ID.");
        return -1;
    }

    Book issue() throws IOException {
        System.out.println("Enter Book ID of book to be issued:");
        int q=Integer.parseInt(in.readLine());
        int av=available(q);
        if(av!=-1)
        {
            ob[av].qty1--;
            return ob[av];
        }
        return null;
    }

    void returnbook(Book b)
    {
        for (int i=0;i<k;i++)
        {
            if (b.equals(ob[i]))
            {
                ob[i].qty1++;
                return;
            }
        }
    }
}
