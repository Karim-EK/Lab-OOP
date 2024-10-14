package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount {

    public RestrictedBankAccount(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    protected boolean isWithdrawAllowed(double amount) {
        return this.getBalance() > amount;
    }

    @Override
    protected double cumputeFee() {
        return AbstractBankAccount.getManagementFee() + AbstractBankAccount.getTransactionsFee() * this.getTransactionsCount();
    }
}
