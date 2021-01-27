import kata.BankAccount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test
    public void should_add_deposit() {
        BankAccount account = new BankAccount();
        BigDecimal amount;

        account.deposit(new BigDecimal(100));

        assertEquals(new BigDecimal(100), account.getBalance());
    }
}
