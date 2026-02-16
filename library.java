package scenario;
import java.util.ArrayList;
class Book{
    private String title;
    private String isbn;
    private String author;

    public Book(String title, String author,String isbn){
        this.title=title;
        this.author= author;
        this.isbn = isbn;
    }
    public String getTitle(){
        return title;
    }
    public void displayBook(){
        System.out.println("Title : " +title);
        System.out.println("Author: "+ author);
        System.out.println("ISBN: " + isbn);
        System.out.println("-------------------");
    }
}
class Library{
    private ArrayList<Book> books = new ArrayList<> ();
    public void addBook(Book book){
        books.add(book);
    }
    public Book searchbytitle(String title){
        for(Book b : books){
            if(b.getTitle().equalsIgnoreCase(title)){
                return b;
            }
        }
        return null;
    }
    public void displayAllBooks(){
        for(Book b: books){
            b.displayBook();
        }
    }
}

public class library {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Java Programming","James Gosling","101"));
        library.addBook(new Book("Data Structures", "Mark Allen", "102"));
        library.addBook(new Book("Operating Systems", "Galvin", "103"));
        System.out.println("All Books:");
        library.displayAllBooks();
        System.out.println("Searching for Data Structures...");
        Book found = library.searchbytitle("Data Structures");
        if (found != null) {
            System.out.println("Book Found:");
            found.displayBook();
        } else {
            System.out.println("Book not found.");
        }
    }
    
}
