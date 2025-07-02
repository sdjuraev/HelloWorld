import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

       Library library = new Library();
       Librarian librarian = new Librarian(1111, "pass", library);
       User user = new User(111, "John", "john@", "pass");
       Book b0 = new Book(333, "Sariq Devni Minib","Hudoyberdi Tuhtaboyev", "Comedy", true);
       Book b1 = new Book(1, "1984", "George Orwell", "Dystopian", true);
       Book b2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", "Classic", true);
       Book b3 = new Book(3, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", false);
       Book b4 = new Book(4, "The Catcher in the Rye", "J.D. Salinger", "Classic", true);
       Book b5 = new Book(5, "Pride and Prejudice", "Jane Austen", "Romance", true);
       Book b6 = new Book(6, "The Hobbit", "J.R.R. Tolkien", "Fantasy", false);
       Book b7 = new Book(7, "Brave New World", "Aldous Huxley", "Dystopian", true);
       Book b8 = new Book(8, "Moby Dick", "Herman Melville", "Adventure", false);
       Book b9 = new Book(9, "The Alchemist", "Paulo Coelho", "Philosophical", true);
       Book b10 = new Book(10, "Jane Eyre", "Charlotte Brontë", "Gothic", true);

       library.addBooks(b0);
       library.addBooks(b1);
       library.addBooks(b2);
       library.addBooks(b3);
       library.addBooks(b4);
       library.addBooks(b5);
       library.addBooks(b6);
       library.addBooks(b7);
       library.addBooks(b8);
       library.addBooks(b9);
       library.addBooks(b10);
       library.addUser(user);
       library.addLibrarian(librarian);
       Scanner scanner = new Scanner(System.in);
       while (true) {
          System.out.println("Select user");
          System.out.println("1. Librarian");
          System.out.println("2. User");
          int select = scanner.nextInt();

          switch (select) {
             case 1:
                System.out.println("ID: ");
                int lID = scanner.nextInt();
                System.out.println("Password");
                String password = scanner.next();
                Librarian lib = library.loginLibrarian(lID, password);
                if (lib != null) {
                   System.out.println("Select menu");
                   System.out.println("1. Add Books");
                   System.out.println("2. Remove Books");
                   System.out.println("3. Issue Books");
                   System.out.println("4. Receive Books");
                   System.out.println("5. Register User");
                   System.out.println("6. Generate Report");
                   System.out.println("0. Exit");
                   select = scanner.nextInt();
                   switch (select) {
                      case 1:
                         lib.addBook();
                         library.printBooks();
                         break;
                      case 2:
                         System.out.println("Enter book ID");
                         int bookID = scanner.nextInt();
                         lib.removeBooks(bookID);
                         break;
                      case 5:
                         lib.registerUser();
                         library.printUsers();
                         break;
                      case 6:
                         lib.generateReport();
                         break;
                      case 0:
                         System.exit(0);
                   }
                }
                break;
             case 2:
                System.out.println("Login: ");
                String email = scanner.next();
                System.out.println("Password");
                String pass = scanner.next();
                User user1 = library.loginUser(email, pass);
                if (user1 != null) {
                   System.out.println("Welcome User");
                   System.out.println("1.Search Books");
                   System.out.println("2.Borrow Books");
                   System.out.println("3.Return Books");
                   System.out.println("4.Renew Books");
                   System.out.println("5.Reserve Books");
                   select = scanner.nextInt();
                   switch (select) {
                      case 1:
                         System.out.print("Enter Book Title");
                         scanner.nextLine();
                         String bookTitle = scanner.nextLine();
                         System.out.println("We are looking for " + bookTitle);
                         Book book = library.searchBook(bookTitle);
                         if (book!=null) {
                            System.out.println("Found this book");
                            System.out.println(book.getId() + " " + book.getBookTitle() + " " + book.getAuthor());
                         }
                         break;
                      case 2:
                         System.out.print("Enter Book Title");
                         scanner.nextLine();
                         bookTitle = scanner.nextLine();
                         Book found = library.searchBook(bookTitle);
                         if (found!=null){
                            if (found.isAvailable()) {
                               System.out.println("How many days do you want?");
                               int days = scanner.nextInt();
                               LocalDate issueDate = LocalDate.now();
                               LocalDate dueDate = LocalDate.now().plusDays(days);
                               found.issue(found.getId(),library.getBooks());
                               Loan loan = new Loan(issueDate, dueDate, null, user1, found);
                               library.getLoans().add(loan);
                            }else {
                               System.out.println("Book Borrowed Already");
                            }
                         }
                         library.printBorrowedBooks();

                   }
                }
                break;
          }
       }
    }
}
