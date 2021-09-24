package services.implementations;

import entities.Account;
import entities.Operation;
import enums.OperationType;
import services.interfaces.AccountOperationService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccountOperationServiceImpl implements AccountOperationService {
    private AccountOperationVerificationServiceImpl accountOperationVerificationService;

    public AccountOperationServiceImpl(AccountOperationVerificationServiceImpl accountOperationVerificationService) {
        this.accountOperationVerificationService = accountOperationVerificationService;
    }

    public void makeDeposit(Account account, BigDecimal amount) {
        if (this.accountOperationVerificationService.canMakeDeposit(account, amount)) {
            BigDecimal balanceAfterOperation = account.getBalance().add(amount);
            Operation depositOperation = new Operation(OperationType.DEPOSIT, amount, balanceAfterOperation, LocalDateTime.now());
            this.addOperationAndUpdateBalanceAccount(account, depositOperation, balanceAfterOperation);
        }
    }

    public void makeWithdrawal(Account account, BigDecimal amount) {
        if (this.accountOperationVerificationService.canMakeWithdrawal(account, amount)) {
            BigDecimal balanceAfterOperation = account.getBalance().subtract(amount);
            Operation depositOperation = new Operation(OperationType.WITHDRAWAL, amount, balanceAfterOperation, LocalDateTime.now());
            this.addOperationAndUpdateBalanceAccount(account, depositOperation, balanceAfterOperation);
        }
    }

    private void addOperationAndUpdateBalanceAccount(Account account, Operation operation, BigDecimal balanceAfterOperation) {
        account.setBalance(balanceAfterOperation);
        account.getOperations().add(operation);
    }

    public List<String> getAccountOperationHistory(Account account) {
        List<String> accountHistory = new ArrayList<String>();
        if (account != null) {
            account.getOperations().forEach(operation -> {
                accountHistory.add(this.createAccountHistoryLineByOperation(operation));
            });
        }
        return accountHistory;
    }

    private String createAccountHistoryLineByOperation(Operation operation) {
        StringBuilder historyLineBuilder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
        historyLineBuilder.append("Operation type: ");
        historyLineBuilder.append(operation.getOperationType());
        historyLineBuilder.append(" Operation date ");
        historyLineBuilder.append(operation.getOperationDate().format(formatter));
        historyLineBuilder.append(" Amount: ");
        historyLineBuilder.append(String.valueOf(operation.getAmount()));
        historyLineBuilder.append(",  Balance after operation : ");
        historyLineBuilder.append(String.valueOf(operation.getBalanceAfterOperation()));
        historyLineBuilder.append("\n ");
        return historyLineBuilder.toString();
    }

}
