package services;

import entities.Account;
import entities.Operation;
import enums.OperationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.implementations.AccountOperationServiceImpl;
import services.implementations.AccountOperationVerificationServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class AccountOperationServiceTest {
    private boolean isInit = false;
    private Account account;
    private AccountOperationVerificationServiceImpl accountOperationVerificationService;
    private AccountOperationServiceImpl accountOperationService;

    @Before
    public void init() {
        this.account = new Account(1051983L);
        if (!isInit) {
            this.accountOperationVerificationService = new AccountOperationVerificationServiceImpl();
            this.accountOperationService = new AccountOperationServiceImpl(this.accountOperationVerificationService);
            isInit = true;
        }
    }

    @Test
    public void makeDepositOKTest() {
        this.account.setBalance(new BigDecimal(4530));
        this.accountOperationService.makeDeposit(this.account, new BigDecimal(300));

        Assert.assertEquals(new BigDecimal(4830), this.account.getBalance());
        Assert.assertEquals(1, this.account.getOperations().size());

        Operation operation = this.account.getOperations().get(0);
        Assert.assertEquals(OperationType.DEPOSIT, operation.getOperationType());
        Assert.assertEquals(new BigDecimal(300), operation.getAmount());
        Assert.assertEquals(new BigDecimal(4830), operation.getBalanceAfterOperation());
        Assert.assertNotNull(operation.getOperationDate());
    }

    @Test
    public void makeDepositKOAmountTest() {
        this.account.setBalance(new BigDecimal(300));
        this.accountOperationService.makeDeposit(this.account, new BigDecimal(-600));
        Assert.assertEquals(new BigDecimal(300), this.account.getBalance());
        Assert.assertTrue( this.account.getOperations().isEmpty());
    }

    @Test
    public void makeWithdrawalOKTest() {
        this.account.setBalance(new BigDecimal(500));
        this.accountOperationService.makeWithdrawal(this.account, new BigDecimal(100));
        Assert.assertEquals(new BigDecimal(400), this.account.getBalance());
        Assert.assertEquals(1, this.account.getOperations().size());

        Operation operation = this.account.getOperations().get(0);
        Assert.assertEquals(OperationType.WITHDRAWAL, operation.getOperationType());
        Assert.assertEquals(new BigDecimal(100), operation.getAmount());
        Assert.assertEquals(new BigDecimal(400), operation.getBalanceAfterOperation());
        Assert.assertNotNull(operation.getOperationDate());
    }

    @Test
    public void makeWithdrawalKOAmountTest() {
        this.account.setBalance(new BigDecimal(300));
        this.accountOperationService.makeWithdrawal(this.account, new BigDecimal(-100));
        Assert.assertEquals(new BigDecimal(300), this.account.getBalance());
        Assert.assertTrue(this.account.getOperations().isEmpty());
    }

    @Test
    public void makeWithdrawalKOBalanceTest() {
        this.account.setBalance(new BigDecimal(100));
        this.accountOperationService.makeWithdrawal(this.account, new BigDecimal(1000));
        Assert.assertEquals(new BigDecimal(100), this.account.getBalance());
        Assert.assertTrue( this.account.getOperations().isEmpty());
    }

    @Test
    public void getAccountOperationHistoryTest() {
        this.accountOperationService.makeDeposit(this.account, new BigDecimal(700));
        this.accountOperationService.makeDeposit(this.account, new BigDecimal(400));
        this.accountOperationService.makeWithdrawal(this.account, new BigDecimal(100));
        this.accountOperationService.makeDeposit(this.account, new BigDecimal(50));
        this.accountOperationService.makeWithdrawal(this.account, new BigDecimal(100));

        List<String> accountHistory = this.accountOperationService.getAccountOperationHistory(this.account);
        Assert.assertEquals(5, this.account.getOperations().size());
        Assert.assertTrue(accountHistory.get(0).contains(OperationType.DEPOSIT.toString()));
        Assert.assertTrue(accountHistory.get(0).contains("700"));
        Assert.assertTrue(accountHistory.get(4).contains(OperationType.WITHDRAWAL.toString()));
        Assert.assertTrue(accountHistory.get(4).contains("100"));
    }
}
