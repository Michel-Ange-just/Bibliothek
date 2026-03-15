package repository;

import exception.BookException;
import model.Book;
import util.Tuple;

import java.util.ArrayList;
import java.util.HashMap;

public class BookRepository {
    private final HashMap<Book,Integer> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book){
        if(!books.containsKey(book)){
            books.put(book,1);
        }
        else{
            book.incrementBook();
            books.put(book,books.get(book)+1);
        }
    }

    public Integer removeBook(Book book){
        return books.remove(book);
    }

    public boolean isBookExists(Book book){
        return books.containsKey(book);
    }

    public boolean isBookExists(String isbn){
        for(Book book:books.keySet()){
            if(book.getIsbn().equals(isbn)){
                return true;
            }
        }
        return false;
    }

    public Book getBook(String isbn) throws BookException { //get the book corresponding to the isbn
        for(Book book:books.keySet()){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        throw new BookException("This book does not exist");
    }
}
