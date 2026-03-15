package repository;

import model.Loan;
import model.User;

import java.util.HashMap;

public class LoanRepository {
    HashMap<String, Loan> loans = new HashMap<>();
    public LoanRepository() {
        this.loans = new HashMap<>();
    }

    public void addLoan(Loan loan){
        loans.put(loan.getLoanId(),loan);
    }

    public Loan removeLoan(Loan loan){
        return loans.remove(loan.getLoanId());
    }
}
