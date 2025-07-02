import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Loan {
    private static int loadID = 0;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private User user;
    private Book book;

    public Loan(LocalDate issueDate, LocalDate dueDate, LocalDate returnDate, User user, Book book) {
        loadID++;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.user = user;
        this.book = book;
    }

    public static int getLoadID() {
        return loadID;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }
}
