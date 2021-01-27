import kata.BankAccount;
import kata.BankAccountException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test
    public void should_add_deposit() throws BankAccountException {
        BankAccount account = new BankAccount();

        account.deposit(new BigDecimal(100));

        assertEquals(new BigDecimal(100), account.getBalance());
    }

    @Test
    public void should_withdraw() throws BankAccountException {
        BankAccount account = new BankAccount();

        account.withdraw(new BigDecimal(50));

        assertEquals(new BigDecimal(-50), account.getBalance());
    }

    @Test(expected = BankAccountException.class)
    public void should_throw_exception_when_amount_to_deposit_is_negative() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.deposit(new BigDecimal(-50));
    }

    @Test(expected = BankAccountException.class)
    public void should_throw_exception_when_amount_to_withdraw_is_negative() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.withdraw(new BigDecimal(-50));
    }
}
