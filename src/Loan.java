import java.util.HashMap;

public class Loan {
    private HashMap<Book, User> borrowedBooks;
    Loan(){
        borrowedBooks = new HashMap<>();
    }
    public void addNewEnter(Book book, User user){
        borrowedBooks.put(book, user);
    }




}
