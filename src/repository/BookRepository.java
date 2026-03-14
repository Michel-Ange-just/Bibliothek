package repository;

import model.Book;
import util.Tuple;

import java.util.ArrayList;
import java.util.HashMap;

public class BookRepository {
    private final HashMap<String, Book> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book){
        if(!books.containsKey(book.getIsbn())){
            books.put(book.getIsbn(),book);
        }
        else{
            book.incrementBook();
            books.put(book.getIsbn(),book);
        }
    }

    public void removeBook(Book book){
        books.remove(book.getIsbn());
    }
}
