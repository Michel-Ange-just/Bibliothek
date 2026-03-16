package model;

public class EBook extends Book {
    Boolean printed;

    public EBook(String isbn, String autor, String title, Integer erscheinungsJahr, String verlag, Integer anzahl) {
        super(isbn, autor, title, erscheinungsJahr, verlag,anzahl);
        this.printed = false;
    }

    public EBook(String isbn) {
        super(isbn);
        this.printed = false;
    }
}
