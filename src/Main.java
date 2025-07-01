import java.util.*;

public class Main {
    public static void main(String[] args) {
       Library library = new Library();
       Librarian librarian = new Librarian(1111,"pass", library);
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
                System.out.println("5. Register Books");
                System.out.println("6. Generate Report");
                select = scanner.nextInt();
                switch (select){
                   case 1:
                      lib.addBook();
                      library.printBooks();
                      break;
                }
             }
             break;
          case 2:
             System.out.println("Login: ");
             String email = scanner.next();
             System.out.println("Password");
             String pass = scanner.next();
             break;
       }
    }
}
