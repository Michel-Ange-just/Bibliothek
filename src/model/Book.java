package model;
import repository.BookRepository;

public abstract class Book {
    private String isbn;
    private String autor = null;
    private String title = null;
    private Integer erscheinungsJahr = null;
    private String verlag = null;
    private Integer anzahl = 0;


    public Book(String isbn, String autor, String title, Integer erscheinungsJahr, String verlag, Integer Anzahl) {
        this.isbn = isbn;
        this.autor = autor;
        this.title = title;
        this.erscheinungsJahr = erscheinungsJahr;
        this.verlag = verlag;
        this.anzahl = anzahl;
    }
    public Integer getAnzahl(){return this.anzahl; }
    public void incrementBook(){this.anzahl++;}
    public void decrementBook(){this.anzahl--;}


    public Book(String isbn){
        this.isbn = isbn;
    }

    public Integer getErscheinungsJahr() {
        return erscheinungsJahr;
    }

    public void setErscheinungsJahr(Integer erscheinungsJahr) {
        this.erscheinungsJahr = erscheinungsJahr;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public String getIsbn() {
        return isbn;
    }


}
