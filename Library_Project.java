import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    public String name, author, subject;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book {" + " name= '" + name + '\'' + ",author='" + author + '\'' + '}'+"\n";
    }
    
}

class Library {
    public ArrayList<Book> books;

    public Library(ArrayList<Book> book) {
        this.books = book;
    }

    public void addBook(Book book1) {
        System.out.println("The book has been added to the Library");
        this.books.add(book1);
    }

    public void issueBook(Book book2, String issued_to) {
        System.out.println("The book has been issued from the library to " + issued_to);
        this.books.remove(book2);
        System.out.println();
    }

    public void returnBook(Book book3) {
        System.out.println("The book has been returned");
        this.books.add(book3);
    }

    public void bookAvlable() {
        if (this.books.size() == 0) {
            System.out.println("You do not have any book!..");
        } else {
            this.books.forEach(n -> System.out.println(n + "\t"));
        }
    }
}


public class Library_Project {
    public static void main(String[] args) throws IOException {
        ArrayList<Book> bk = new ArrayList<>();

        // preserving data initially.

        Book ob1 = new Book("c language", "abcd");
        bk.add(ob1);
        Book ob2 = new Book("java language", "defg");
        bk.add(ob2);
        
        Library l = new Library(bk);

        String usser, password;
        int choice;
        File file = new File("login.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. FOR USSER MODE\n2. FOR ADMIN MODE");
        choice = sc.nextInt();
        if (choice == 1) {
            FileWriter fw = new FileWriter("login.txt");
            sc.nextLine();
            System.out.print("ENTER USSER NAME: ");
            usser = sc.nextLine();
            sc.nextLine();
            fw.write(usser);
            System.out.println("ENTER PASSWORD: ");
            password = sc.nextLine();
            fw.write(password);
            fw.close();
        } else if (choice == 2) {
            sc.nextLine();
            System.out.println("ENTER THE PASSWORD: ");
            String pass = sc.nextLine();
            sc.nextLine();
            Scanner sc1 = new Scanner(file);
            String readPass = sc1.nextLine();

            if (readPass.endsWith(pass)) {
                boolean choice1 = true;
                outer: do {
                    System.out.println("\n****WELCOME TO THE LIBRARY SYSTEM****");
                    sc.nextLine();
                    System.out.println("1. FOR ADD NEW BOOK");
                    System.out.println("2. FOR ISSUE BOOK");
                    System.out.println("3. RETURN BOOK");
                    System.out.println("4. DISPLAY AVLAIBLE BOOK");
                    System.out.println("5. EXIT");
                    int temp;
                    temp = sc.nextInt();
                    switch (temp) {
                        case 1:
                            sc.nextLine();
                            System.out.print("Enter The Name of The Book: ");
                            String bName = sc.nextLine();
                            System.out.print("Enter the Name of The Author: ");
                            String bAuthor = sc.nextLine();
                            Book b = new Book(bName, bAuthor);
                            l.addBook(b);
                            System.out.println("YOU HAVE ENTERED THE BOOK TO THE LIBRARY SUCCESSFULLY...");
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.print("Enter The Name of The book which you want to issue: ");
                            String iName = sc.nextLine();
                            System.out.print("Enter the Name of The Author: ");
                            String iAuthor = sc.nextLine();
                            Book b1 = new Book(iName, iAuthor);
                            l.issueBook(ob1, "Pappu Kumar");
                            break;
                        case 3:
                            sc.nextLine();
                            System.out.print("Enter The Name of The book which you want to return: ");
                            String rName = sc.nextLine();
                            System.out.print("Enter the Name of The Author: ");
                            String rAuthor = sc.nextLine();
                            Book b2 = new Book(rName, rAuthor);
                            l.returnBook(b2);
                            break;
                        case 4:
                            System.out.println("ABLABILS BOOKS IN THE LIBRARY ARE..");
                            System.out.println("Book Name\t\tAuthor Name\n");
                            System.out.println(l.books);
                            System.out.println("\n");
                            break;

                        case 5:
                            System.out.println("***************\nTHANK YOU!\nHAVE A GREAT DAY\n***************");
                            break outer;
                        default:
                            System.out.println("You have entered wronge choice..try again..");
                            break;
                    }
                    sc.nextLine();
                    System.out.println("IF you Want to continue then:\nThan Enter true Either false: ");
                    choice1 = sc.nextBoolean();
                } while (choice1);
            } else {
                System.out.println("WONGRE PASSWORD");
            }
            sc1.close();

        } else {
            System.out.println("YOU HAVE SELECTED WRONGE CHOICE\nPLS TRY AGAIN......");

        }



        sc.close();
    }
}
