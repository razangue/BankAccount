package entities;

import enums.OperationType;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OperationTest {

    @Test
    public void createOperation() {

        BigDecimal amount = new BigDecimal(20);
        BigDecimal balanceAfterOperation = new BigDecimal(430);
        LocalDateTime now = LocalDateTime.now();
        Operation operation = new Operation(OperationType.WITHDRAWAL, amount, balanceAfterOperation, now);
        Assert.assertEquals(OperationType.WITHDRAWAL, operation.getOperationType());
        Assert.assertEquals(amount, operation.getAmount());
        Assert.assertEquals(balanceAfterOperation, operation.getBalanceAfterOperation());
        Assert.assertEquals(now, operation.getOperationDate());
    }
}
