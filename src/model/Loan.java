package model;

public class Loan {
    private final String loanId;
    private final User user;
    private final String isbn;

    public Loan(String loanId, User user, String isbn) {
        this.loanId = loanId;
        this.user = user;
        this.isbn = isbn;
    }
}
