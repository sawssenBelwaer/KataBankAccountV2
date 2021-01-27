import kata.BankAccount;
import kata.BankAccountException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test
    public void should_add_deposit() throws BankAccountException {
        BankAccount account = new BankAccount();

        account.deposit(new BigDecimal(100), "dépôt");

        assertEquals(new BigDecimal(100), account.getBalance());
    }

    @Test
    public void should_withdraw() throws BankAccountException {
        BankAccount account = new BankAccount();

        account.withdraw(new BigDecimal(50), "retrait");

        assertEquals(new BigDecimal(-50), account.getBalance());
    }

    @Test(expected = BankAccountException.class)
    public void should_throw_exception_when_amount_to_deposit_is_negative() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.deposit(new BigDecimal(-50), "dépôt");
    }

    @Test(expected = BankAccountException.class)
    public void should_throw_exception_when_amount_to_withdraw_is_negative() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.withdraw(new BigDecimal(-50), "retrait");
    }

    @Test
    public void should_update_balance_when_operation_added() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.deposit(new BigDecimal(10), "dépôt");
        assertEquals(new BigDecimal(10), account.getBalance());
    }

    @Test
    public void should_update_balance_when_2_deposit_added() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.deposit(new BigDecimal(10), "dépôt");
        account.deposit(new BigDecimal(300), "dépôt");
        assertEquals(new BigDecimal(310), account.getBalance());
    }

    @Test
    public void should_update_balance_when_2_withdraw_added() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.withdraw(new BigDecimal(10), "retrait");
        account.withdraw(new BigDecimal(300), "retrait");
        assertEquals(new BigDecimal(-310), account.getBalance());
    }

    @Test
    public void should_update_balance_when_1_deposit_and_1_withdraw_added() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.deposit(new BigDecimal(50), "dépôt");
        account.withdraw(new BigDecimal(100), "retrait");
        assertEquals(new BigDecimal(-50), account.getBalance());
    }

    @Test
    public void should_print_account_statement() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.setAccountNr(123);
        account.deposit(new BigDecimal(50), "dépôt");
        account.withdraw(new BigDecimal(100), "retrait");
        System.out.println(account.toString());
    }

}
