package repository;

import model.Loan;

import java.util.HashMap;

public class LoanRepository {
    HashMap<String, Loan> loans = new HashMap<>();
    public LoanRepository() {
        this.loans = new HashMap<>();
    }

    public void addLoan(Loan loan){
        loans.put(loan.getLoanId(),loan);
    }

    public void removeLoan(Loan loan){
        loans.remove(loan.getLoanId());
    }

    public void removeLoan(String loanId){
        loans.remove(loanId);
    }


    public HashMap<String, Loan> getLoansCopied(){
        return (HashMap<String, Loan>) loans.clone();
    }
}
