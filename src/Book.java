import java.util.ArrayList;
import java.util.LinkedList;

public class Book {
    private int id;
    private String bookTitle;
    private String author;
    private boolean status;

    public Book(int id, String bookTitle, String author,  String category, boolean status){
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.status = status;
    }
    public boolean isAvailable(){
        if (status){
            return true;
        }
        else return false;
    }
    public void reserve(int id, ArrayList<Book> books){
        for (Book book:books){
            if (book.id == id){
                if (book.status){
                    System.out.println("You can reserve book");
                    System.out.println("Book reserved ");
                    book.status= false;
                    return;
                }
            }
        }
    }
    public void issue(int id, ArrayList<Book> books){
        for (Book book:books){
            if (book.id == id) {
                if (this.status) {
                    this.status = false;
                }
            }
        }
    }
    public void printBookInfo(){
        System.out.println(this.id);
        System.out.println(this.bookTitle);
        System.out.println(this.author);
        System.out.println(this.status);
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }


    public boolean isStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}
