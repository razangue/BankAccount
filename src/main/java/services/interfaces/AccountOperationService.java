package services.interfaces;

import entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountOperationService {
    void makeDeposit(Account account, BigDecimal amount);

    void makeWithdrawal(Account account, BigDecimal amount);

    List<String> getAccountOperationHistory(Account account);
}
