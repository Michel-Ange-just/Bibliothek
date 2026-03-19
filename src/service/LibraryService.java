package service;

import exception.BookException;
import exception.LoanException;
import exception.UserException;
import model.Book;
import model.EBook;
import model.Loan;
import model.User;
import repository.BookRepository;
import repository.LoanRepository;
import repository.UserRespository;
import util.IdGeneretor;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryService {


    private final UserRespository users;
    private final LoanRepository loans;
    private final BookRepository books;

    public LibraryService(UserRespository users, LoanRepository loans, BookRepository books) {

        this.users = users;
        this.loans = loans;
        this.books = books;
    }

    public void borrowWithObjts(User user, Book book) throws UserException, LoanException, BookException {
        if(!users.isUserExists(user) ){
            throw new UserException("User does not exist");
        }
        if(!books.isBookExists(book)){
            throw new BookException("Book does not exist");
        }
        Loan loan = new Loan(IdGeneretor.generate("LN", Loan.getNumberOfLoan()), user, book, LocalDate.now(),  LocalDate.now().plusDays(20) );
        loans.addLoan(loan);
        books.oneBookLess(book);
        System.out.println("Book borrowed");

    }

    public void borrow(String userName,String isbn) throws UserException, BookException {
        if(!users.isUserExists(userName)){
            throw new UserException("User does not exist");
        }
        if(!books.isBookExists(isbn)){
            throw new BookException("This Book does not exist");
        }

        Loan loan = new Loan(IdGeneretor.generate("LN",Loan.getNumberOfLoan()), users.findUserByName(userName), books.findByIsbn(isbn), LocalDate.now(), LocalDate.now().plusDays(20));
        loans.addLoan(loan);
        books.oneBookLess(isbn);
        System.out.println("Book borrowed");
    }

    public  String findIdLoanByBook(String isbn) throws BookException {
        Book book = books.findByIsbn(isbn);
        for(String str : loans.getLoansCopied().keySet()){
            if(loans.getLoansCopied().get(str).getBook().equals(book)){
                return str;
            }
        }

        throw new BookException("Book not found");
    }


    public void returnBook(String isbn) throws BookException {
        String idLoan = findIdLoanByBook(isbn);
        loans.removeLoan(idLoan);
        books.oneBookFree(isbn);
        System.out.println("Book returned");
    }


    public void deleteLoan(Loan loan){
        loans.removeLoan(loan);
    }

    public void start() throws UserException, BookException {

        int i = 0;
        while(i == 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose what you want to start");
            System.out.println("1- Create a new user\n" +
                    "2-Add a new Book\n" +
                    "3- Borrow a Book\n" +
                    "4- Return a Book\n");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter the username you want to create");
                    String userName = sc.nextLine();
                    users.addUser(userName);
                    break;
                case 2:
                    System.out.println("Enter the information about the book:"
                            +"1- The ISBN");
                    String isbn = sc.nextLine();
                    System.out.println("2- Enter the book name");
                    String bookName = sc.nextLine();
                    System.out.println("3- Enter the author name");
                    String author = sc.nextLine();
                    System.out.println("4- Enter the publishing house ");
                    String verlag =  sc.nextLine();
                    System.out.println("5- Enter the print year");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.println("6- Is the book an Ebook ? : 1- yes, 2-No");
                    String b = sc.nextLine();
                    if(b.equals("1")){
                        books.addBook(new EBook(isbn, author, bookName, year, verlag, 1 ));
                    }
                    break;
                case 3:
                    System.out.println("Enter the book's isbn: ");
                    String book = sc.nextLine();
                    System.out.println("Enter your username: ");
                    String user = sc.nextLine();
                    borrow(user,book);
                    break;
                case 4:
                    System.out.println("Enter the book name:");
                    String name = sc.nextLine();
                    returnBook(name);
                    break;
            }

            System.out.println("Will you continue? 1- yes, 2- No");
            String c =  sc.nextLine();
            if(c.equals("2")){
                i = 1;
                System.out.println("Ciao");
            }
        }

}

}
