package service;

import exception.BookException;
import exception.LoanException;
import exception.UserException;
import model.Book;
import model.Loan;
import model.User;
import repository.BookRepository;
import repository.LoanRepository;
import repository.UserRespository;
import util.IdGeneretor;

import java.time.LocalDate;

public class LoanService {

    private final UserRespository users;
    private final LoanRepository loans;
    private final BookRepository books;

    public LoanService(UserRespository users, LoanRepository loans, BookRepository books) {

        this.users = users;
        this.loans = loans;
        this.books = books;
    }

    public void createLoanWithObjts(User user, Book book) throws UserException, LoanException, BookException {
        if(!users.isUserExists(user) ){
            throw new UserException("User does not exist");
        }
        if(!books.isBookExists(book)){
            throw new BookException("Book does not exist");
        }
        Loan loan = new Loan(IdGeneretor.generate("LN", Loan.getNumberOfLoan()), user, book, LocalDate.now(),  LocalDate.now().plusDays(20) );
        loans.addLoan(loan);

    }

    public void createLoan(String userName,String isbn) throws UserException, BookException {
        if(!users.isUserExists(userName)){
            throw new UserException("User does not exist");
        }
        if(!books.isBookExists(isbn)){
            throw new BookException("This Book does not exist");
        }

        Loan loan = new Loan(IdGeneretor.generate("LN",Loan.getNumberOfLoan()), users.getUser(userName), books.getBook(isbn), LocalDate.now(), LocalDate.now().plusDays(20));
        loans.addLoan(loan);
    }
}
