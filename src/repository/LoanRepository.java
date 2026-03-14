package repository;

import model.Loan;
import model.User;

import java.util.HashMap;

public class LoanRepository {
    HashMap<String, Loan> loans = new HashMap<>();
    public LoanRepository() {
        this.loans = new HashMap<>();
    }
}
