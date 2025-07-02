import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Librarian> librarians;
    private ArrayList<Loan> loans;
    Library(){
        books  = new ArrayList<>();
        users = new ArrayList<>();
        librarians = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public Book searchBook(String title){
        for (Book book:books){
            if (book.getBookTitle().toLowerCase().equals(title.toLowerCase())){
                return book;
            }
        }
        return null;
    }
    public void addUser(User user){
        for (User user1:users){
            if (user1.getEmail().equals(user.getEmail())){
                System.out.println("User with this email exist");
                return;
            }
        }
        users.add(user);
    }
    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
    }

    public void addBooks(Book book){
        books.add(book);
    }
    public void printUsers(){
        for (User user:users){
            user.printUser();
        }
    }
    public void printBooks(){
        for (Book b: books){
            System.out.println(b.getId() + " " +b.getBookTitle());
        }
    }

    public User loginUser(String email, String password){
        for (User user:users){
            if (user.getEmail().equals(email) &&
                    user.getPassword().equals(password)){
                System.out.println("Login successful");
                return user;
            }
        }
        return null;
    }
    public Librarian loginLibrarian(int id, String password){
        for (Librarian lib:librarians){
            if (lib.getEmployeeID()==id && lib.getPassword().equals(password)){
                System.out.println("Login successful");
                return lib;
            }
        }
        return null;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }
    public void printBorrowedBooks(){
        for (Loan loan:loans){
            System.out.println(loan.getUser().getEmail() +": "+ loan.getBook().getBookTitle() +" " + loan.getIssueDate().toString() +" "+ loan.getDueDate().toString());
        }
    }
}
