import java.util.Scanner;

public class Librarian extends Library{
    private int employeeID;
    private String password;
    private Library library;
    private Scanner scanner = new Scanner(System.in);

    public Librarian(int employeeID, String password, Library library) {
        this.employeeID = employeeID;
        this.password = password;
        this.library = library;
    }
    public void addBook(){
        System.out.println("Enter Book Title");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter author");
        String author = scanner.nextLine();
        System.out.println("Enter category");
        String category = scanner.nextLine();
        Book book = new Book(Extra.getId(),bookTitle,author,category,true);
        library.addBooks(book);
    }
    public void removeBooks(int bookID){
        Book removeBook = null;
        for (Book book:library.getBooks()){
            if (book.getId()==bookID){
                removeBook = book;
            }
        }
        if (removeBook != null){
            library.getBooks().remove(removeBook);
        }
    }
    public void registerUser(){

        System.out.println("Enter user name");
        String name = scanner.nextLine();
        System.out.println("Enter user email");
        String email = scanner.nextLine();
        System.out.println("Enter user password");
        String password = scanner.nextLine();
        User user = new User(111, name, email, password);
        library.addUser(user);
    }
    public void generateReport(){
        System.out.println("Number of books "+library.getBooks().size());
        System.out.println("Number of users "+library.getUsers().size());
    }
    public void receiveBooks(){
        
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public String getPassword() {
        return password;
    }
}
