package kata;

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal amount = BigDecimal.ZERO;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void deposit(BigDecimal amount) {
        this.setAmount(this.getAmount().add(amount));
    }

    public BigDecimal getBalance() {
        return this.getAmount();
    }
}
