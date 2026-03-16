package model;

public abstract class Book {
    private String isbn;
    private String author = null;
    private String title = null;
    private Integer erscheinungsJahr = null;
    private String verlag = null;
    private Integer anzahl = 0;


    public Book(String isbn, String author, String title, Integer erscheinungsJahr, String verlag, Integer Anzahl) {
        if(isbn.equals(null)){
            throw new IllegalArgumentException("ISBN can not be null");
        }
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.erscheinungsJahr = erscheinungsJahr;
        this.verlag = verlag;
        this.anzahl = anzahl;
    }
    public Integer getAnzahl(){return this.anzahl; }
    public void incrementBook(){
        this.anzahl++;
    }
    public void decrementBook(){
        this.anzahl--;
    }


    public Book(String isbn){
        this.isbn = isbn;
    }



    public Integer getErscheinungsJahr() {
        return this.erscheinungsJahr;
    }

    public void setErscheinungsJahr(Integer erscheinungsJahr) {
        this.erscheinungsJahr = erscheinungsJahr;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVerlag() {
        return this.verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public String getIsbn() {
        return this.isbn;
    }


}
