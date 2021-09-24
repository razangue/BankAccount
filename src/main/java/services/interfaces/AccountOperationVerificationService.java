package services.interfaces;

import entities.Account;

import java.math.BigDecimal;

public interface AccountOperationVerificationService {
    boolean canMakeDeposit (Account account, BigDecimal amount);
    boolean canMakeWithdrawal (Account account, BigDecimal amount);
}
