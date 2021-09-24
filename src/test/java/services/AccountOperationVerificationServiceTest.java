package services;

import entities.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.implementations.AccountOperationVerificationServiceImpl;

import java.math.BigDecimal;

public class AccountOperationVerificationServiceTest {
    private Account account;
    private AccountOperationVerificationServiceImpl accountOperationVerificationService;

    @Before
    public void init() {
        this.account = new Account(1051983L);
        if (this.accountOperationVerificationService == null) {
            this.accountOperationVerificationService = new AccountOperationVerificationServiceImpl();
        }
    }

    @Test
    public void canMakeDepositOKTest(){
        Assert.assertTrue(this.accountOperationVerificationService.canMakeDeposit(this.account, new BigDecimal(430)));
    }

    @Test
    public void canMakeDepositKOAmountTest(){
        Assert.assertFalse(this.accountOperationVerificationService.canMakeDeposit(this.account, new BigDecimal(-430)));
    }

    @Test
    public void canMakeDepositKONullAccountTest(){
        Assert.assertFalse(this.accountOperationVerificationService.canMakeDeposit(null, new BigDecimal(430)));
    }

    @Test
    public void canMakeWithdrawalOKTest(){
        this.account.setBalance(new BigDecimal(780));
        Assert.assertTrue(this.accountOperationVerificationService.canMakeWithdrawal(this.account, new BigDecimal(430)));
    }

    @Test
    public void canMakeWithdrawalKOAmountTest(){
        this.account.setBalance(new BigDecimal(780));
        Assert.assertFalse(this.accountOperationVerificationService.canMakeWithdrawal(this.account, new BigDecimal(1330)));
    }
}
