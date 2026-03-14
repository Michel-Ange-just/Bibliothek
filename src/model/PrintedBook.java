package model;

public class PrintedBook extends Book {
    Boolean printed;
    public PrintedBook(String isbn, String autor, String title, Integer erscheinungsJahr, String verlag) {
        super(isbn, autor, title, erscheinungsJahr, verlag);
        printed = true;
    }
}
