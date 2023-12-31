package com.rll.model;

import java.util.List;

/**
 * Container class to work with account balance and list of transactions
 * for the account
 *
 */
public class AccountSnapshotContainer {
    
    private int accountId;
    private Long accountBalance;
    private List<Transaction> transactions;
    
    public AccountSnapshotContainer () {
        
    }

    public AccountSnapshotContainer(int accountId,
            Long accountBalance, List<Transaction> transactions) {
        super();
        this.accountId = accountId;
        this.accountBalance = accountBalance;
        this.transactions=transactions;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
