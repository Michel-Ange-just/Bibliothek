package repository;

import model.Book;
import util.Tuple;

import java.util.ArrayList;
import java.util.HashMap;

public class BookRepository {
    private final HashMap<String, Tuple<Book,Integer>> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book){
        if(!books.containsKey(book.getIsbn())){
            books.put(book.getIsbn(),new Tuple<>(book,1));
        }
        else{
            books.put(book.getIsbn(),new Tuple<>(books.get(book.getIsbn()).getFirst(),books.get(book.getIsbn()).getSecond()+1));
        }
    }

    public void removeBook(Book book){
        books.remove(book);
    }
}
