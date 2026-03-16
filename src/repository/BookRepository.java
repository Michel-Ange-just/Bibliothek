package repository;

import exception.BookException;
import model.Book;

import java.util.HashMap;

public class BookRepository {
    private final HashMap<String,Book> books; //der erster Eintrag speichert die isbn und der zweiter das entsprechende Buch

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book){
        if(!books.containsKey(book.getIsbn())){
            books.put(book.getIsbn(), book);
            System.out.println("book added");
        }
        else{
            book.incrementBook();
            books.put(book.getIsbn(), book);
            System.out.println("book one more time added");
        }
    }

    public void oneBookFree(Book book){
        books.get(book.getIsbn()).incrementBook();
    }

    public void oneBookFree(String isbn) throws BookException {
        books.get(isbn).incrementBook();
    }

    public void oneBookLess(Book book){
        books.get(book.getIsbn()).decrementBook();
    }

    public void oneBookLess(String isbn) throws BookException {
        books.get(isbn).decrementBook();
    }


    public void removeAllBook(Book book){
        books.clear();
        System.out.println("All books removed");
    }

    public void removeBook(Book book) throws BookException {
        if (isBookExists(book)) {
            book.decrementBook();
            System.out.println("book removed");
        }
        throw new BookException("This book does not exist");
    }

    public boolean isBookExists(Book book){
        return books.containsKey(book.getIsbn());
    }

    public boolean isBookExists(String isbn){
        return books.containsKey(isbn);
    }

    public Book findByIsbn(String isbn) throws BookException { //get the book corresponding to the isbn
        if(books.containsKey(isbn)){
            return books.get(isbn);
        }
        throw new BookException("This book does not exist");
    }

    public Book findByTitle(String title) throws BookException {
        for(Book book : books.values()){
            if(book.getTitle().equals(title)){
                return book;
            }
        }

        throw new BookException("This book does not exist");
    }

    public void printBookList(){
        for(Book book : books.values()){
            System.out.println(book.getTitle());
        }
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }
}
