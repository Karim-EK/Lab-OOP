package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount {

    public ClassicBankAccount(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    protected boolean isWithdrawAllowe(double amount) {
        return true;
    }

    @Override
    protected double cumputeFee() {
        return super.getManagementFee();
    } 
}
