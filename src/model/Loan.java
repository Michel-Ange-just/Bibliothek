package model;

import java.time.LocalDate;

public class Loan {
    private final String loanId;
    private final User user;
    private final Book book;
    private final LocalDate loanDate;
    private final LocalDate dateToReturnBook;
    private static int numberOfLoan = 0;

    public Loan(String loanId, User user, Book book, LocalDate loanDate, LocalDate dateToReturnBook) {
        this.loanId = loanId;
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.dateToReturnBook = dateToReturnBook;
        numberOfLoan++;
    }

    public static int getNumberOfLoan(){return numberOfLoan;}

    public String getLoanId() {
        return loanId;
    }
}
