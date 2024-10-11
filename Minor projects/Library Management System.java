import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book\n2. Search Book by Title\n3. Display All Books\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 4) break;

            switch (choice) {
                case 1:
                    sc.nextLine();  // consume newline
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    library.add(new Book(title, author));
                    break;
                case 2:
                    sc.nextLine();  // consume newline
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine();
                    for (Book b : library) {
                        if (b.title.equalsIgnoreCase(searchTitle)) {
                            b.display();
                        }
                    }
                    break;
                case 3:
                    for (Book b : library) {
                        b.display();
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
