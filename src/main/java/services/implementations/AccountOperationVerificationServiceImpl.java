package services.implementations;

import entities.Account;
import services.interfaces.AccountOperationVerificationService;

import java.math.BigDecimal;

public class AccountOperationVerificationServiceImpl implements AccountOperationVerificationService {
    public boolean canMakeDeposit(Account account, BigDecimal amount) {
        return account != null && amount != null && amount.compareTo(BigDecimal.ZERO) >= 0;
    }

    public boolean canMakeWithdrawal(Account account, BigDecimal amount) {
        return canMakeDeposit(account, amount) && account.getBalance() != null
                && account.getBalance().compareTo(amount) >= 0;
    }
}
