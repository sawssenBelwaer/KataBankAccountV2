package kata;

import java.math.BigDecimal;
import java.util.Date;

public class Deposit extends Operation {
    public Deposit(String label, Date date, BigDecimal amount) {
        super(label, date, amount);
    }

    @Override
    public BigDecimal amountOf() {
        return getAmount();
    }
}
