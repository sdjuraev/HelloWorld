import java.util.*;

public class Main {
    public static void main(String[] args) {
       Loan loan = new Loan();
       Library library = new Library();
       Librarian librarian = new Librarian(1111,"pass", library);
       User user = new User(111, "John", "john@", "pass");
       library.addUser(user);
       library.addLibrarian(librarian);
       Scanner scanner = new Scanner(System.in);
       System.out.println("Select user");
       System.out.println("1. Librarian");
       System.out.println("2. User");
       int select = scanner.nextInt();
       switch (select){
          case 1:
             System.out.println("ID: ");
             int lID = scanner.nextInt();
             System.out.println("Password");
             String password = scanner.next();
             Librarian lib = library.loginLibrarian(lID, password);
             if (lib != null){
                System.out.println("Select menu");
                System.out.println("1. Add Books");
                System.out.println("2. Remove Books");
                System.out.println("3. Issue Books");
                System.out.println("4. Receive Books");
                System.out.println("5. Register User");
                System.out.println("6. Generate Report");
                select = scanner.nextInt();
                switch (select){
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
                }
             }
             break;
          case 2:
             System.out.println("Login: ");
             String email = scanner.next();
             System.out.println("Password");
             String pass = scanner.next();
             User user1  = library.loginUser(email, pass);
             if (user1 != null){
                System.out.println("Welcome User");
                System.out.println("1.Search Books");
                System.out.println("2.Borrow Books");
                System.out.println("3.Return Books");
                System.out.println("4.Renew Books");
                System.out.println("5.Reserve Books");
                select = scanner.nextInt();
                switch (select){
                   case 1:
                      System.out.print("Enter Book Title");
                      String bookTitle = scanner.nextLine();
                      library.searchBook(bookTitle);
                      break;
                   case 2:
                      System.out.print("Enter Book Title");
                      bookTitle = scanner.nextLine();
                      Book found = library.searchBook(bookTitle);
                      loan.addNewEnter(found, user1);
                }
             }
             break;
       }
    }
}
