package kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {
    private int accountNr;
    private BigDecimal balance = BigDecimal.ZERO;
    List<Operation> operations = new ArrayList<>();

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal amount) {
        this.balance = amount;
    }

    public void deposit(BigDecimal amount, String label) throws BankAccountException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new BankAccountException();
        }
        Deposit deposit = new Deposit(label, new Date(), amount);
        this.addOperation(deposit);
        calculateBalance(deposit);
    }

    public void withdraw(BigDecimal amount, String label) throws BankAccountException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new BankAccountException();
        }
        Withdraw withdraw = new Withdraw(label, new Date(), amount);
        this.addOperation(withdraw);
        calculateBalance(withdraw);
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void calculateBalance(Operation operation) {
        this.setBalance(this.getBalance().add(operation.amountOf()));
    }

    public String printBankStatement() {
        return this.toString();
    }

    @Override
    public String toString() {
        String operationString = operations.stream().map(x -> x.toString()).reduce("", (x, y) -> x.toString() + "\n" + y.toString());
        return " Account Number: " + accountNr + ", Balance: " + balance + ", Operations: \n" + operationString;
    }

    public void setAccountNr(int accountNr) {
        this.accountNr = accountNr;
    }
}
