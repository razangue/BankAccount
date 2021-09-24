package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Long accountNumber;
    private BigDecimal balance;
    private List<Holder> holders;
    private List<Operation> operations;

    public Account(Long accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal(0);
        this.holders = new ArrayList<Holder>();
        this.operations = new ArrayList<Operation>();
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Holder> getHolders() {
        return holders;
    }

    public void setHolders(List<Holder> holders) {
        this.holders = holders;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
