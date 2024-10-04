package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;
import it.unibo.inheritance.api.BankAccount;

abstract class AbstractBankAccount implements BankAccount {

    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    private final AccountHolder holder;
    private double balance;
    private int transactions;

    
    public AbstractBankAccount(AccountHolder holder, double balance) {
        this.holder = holder;
        this.balance = balance;
        this.transactions = 0;
    }

    public void chargeManagementFees(int id){
        if (isSameId(id)) {
            this.balance = this.balance - this.cumputeFee();
            this.resetTransactions();
        }
    }

    public void deposit(int id, double amount){
        if (isSameId(id)) {
            this.balance = this.balance + amount;
            this.incrementTransactions();
        }
    }

    public void depositFromATM(int id, double amount){
        if (isSameId(id)) {
            this.deposit(id, amount);
            this.chargeATMFEES();
            this.incrementTransactions();
        }
    }

    public AccountHolder getAccountHolder(){
        return this.holder;
    }

    public double getBalance(){
        return this.balance;
    }

    public int getTransactionsCount(){
        return this.transactions;
    }

    public void withdraw(final int id, final double amount){
        if (isSameId(id)) {
            this.balance = this.balance - amount;
            this.incrementTransactions();
        }
    }

    public void withdrawFromATM(final int id, final double amount){
        if (isSameId(id)) {   
            this.withdraw(id, amount);
            this.chargeATMFEES();
            this.incrementTransactions();
        }
    }

    private void chargeATMFEES() {
        this.balance = this.balance - ATM_TRANSACTION_FEE;
    }

    private boolean isSameId (final int id) {
        return this.holder.getUserID() == id;
    }

    private void incrementTransactions() {
        this.transactions++;
    }

    private void resetTransactions() {
        this.transactions = 0;
    }

    protected static double getManagementFee() {
        return MANAGEMENT_FEE;
    }

    protected static double getTransactionsFee() {
        return TRANSACTION_FEE;
    }

    protected abstract boolean isWithdrawAllowe(double amount);

    protected abstract double cumputeFee();

}
