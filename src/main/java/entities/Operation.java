package entities;

import enums.OperationType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operation {
    private OperationType operationType;
    private BigDecimal amount;
    private BigDecimal balanceAfterOperation;
    private LocalDateTime operationDate;

    public Operation(OperationType operationType, BigDecimal amount, BigDecimal balanceAfterOperation, LocalDateTime operationDate) {
        this.operationType = operationType;
        this.amount = amount;
        this.balanceAfterOperation = balanceAfterOperation;
        this.operationDate = operationDate;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalanceAfterOperation() {
        return balanceAfterOperation;
    }

    public void setBalanceAfterOperation(BigDecimal balanceAfterOperation) {
        this.balanceAfterOperation = balanceAfterOperation;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }
}
