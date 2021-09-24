package entities;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class AccountTest {
    @Test
    public void createAccount() {
        Account account = new Account(1051983L);
        Assert.assertNotNull(account);
        Assert.assertEquals(new Long(1051983), account.getAccountNumber());
        Assert.assertEquals(new BigDecimal(0), account.getBalance());
        Assert.assertTrue(account.getOperations().isEmpty());
        Assert.assertTrue(account.getHolders().isEmpty());
    }
}
