import exception.BookException;
import exception.UserException;
import model.EBook;
import repository.BookRepository;
import repository.LoanRepository;
import repository.UserRespository;
import service.LibraryService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws BookException, UserException {
        UserRespository users = new UserRespository();
        LoanRepository loans = new LoanRepository();
        BookRepository books = new BookRepository();

        LibraryService lib = new LibraryService(users,loans,books);
        lib.start();



    }
}