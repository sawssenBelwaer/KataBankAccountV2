import kata.BankAccount;
import kata.BankAccountException;
import kata.Operation;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OperationTest {
    @Test
    public void should_see_history_operations() throws BankAccountException {
        BankAccount account = new BankAccount();
        account.deposit(new BigDecimal(50), "dépôt");

        account.withdraw(new BigDecimal(30), "retrait");
        List<Operation> operations = account.getOperations();
        assertEquals(2, operations.size());
        assertEquals(new BigDecimal(50), operations.get(0).getAmount());
    }
}
