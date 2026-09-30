package com.example.oop;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {
    private final String accountNo;
    private BigDecimal balance;
    private boolean frozen;

    public BankAccount(String accountNo, BigDecimal initialBalance) {
        this.accountNo = Objects.requireNonNull(accountNo, "cocountNo");
        if (initialBalance == null || initialBalance.signum() < 0) {
            throw new IllegalArgumentException("initial balance must be larger than 0");
        }
        this.balance = initialBalance;
        this.frozen = false;
    }

    // 查询
    public String getAccountNo(){return accountNo;}
    public BigDecimal getBalance() {return balance;}
    public boolean isFrozen() {return frozen;}

    // 业务方法
    public void deposit(BigDecimal amount) {
        ensureNotFrozen();
        ensurePositive(amount);
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        ensureNotFrozen();
        ensurePositive(amount);
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("insufficient balance");
        }
        balance = balance.subtract(amount);
    }

    public void freeze() {
        if (frozen) {
            throw new IllegalStateException("already frozen");
        }
        frozen = true;
    }

    public void unfreeze() {
        if (!frozen) {
            throw new IllegalStateException("not frozen");
        }
        frozen = false;
    }

    // 私有校验
    private void ensureNotFrozen() {
        if (frozen) {
            throw new IllegalStateException("account is frozen: "+accountNo);
        }
    }

    private static void ensurePositive(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("amount must be larget than 0");
        }
    }

    @Override 
    public String toString() {
        return "BankAccount{" +
                "accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                ", frozen=" + frozen +
                '}';
    }
}