package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {

    private final int id;
    private double balance;
    
    private int transactions;
    
    static final double ATM_TRANSACTION_FEE = 1;
    static final double MANAGMENT_FEE = 5;
    
    public StrictBankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.transactions = 0;
    }

    @Override
    public void withdraw(int id, double amount) {
        if (canWithdraw(amount) && hasSameId(id)) {
            this.balance = this.balance - amount;
            increaseOperations();
        }
    }

    @Override
    public void deposit(int id, double amount) {
        if (hasSameId(id)) {
            this.balance = this.balance + amount;
            increaseOperations();
        }
    }

    @Override
    public void depositFromATM(int id, double amount) {
        deposit(id, amount);
        payATMFees();
    }

    @Override
    public void withdrawFromATM(int id, double amount) {
        withdraw(id, amount);
        payATMFees();
    }

    @Override
    public void chargeManagementFees(int id) {
        if (hasSameId(id)) {
            this.balance = this.balance - MANAGMENT_FEE + (transactions * 0.1);
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public int getTransactionsCount() {
        return this.transactions;
    }

    private boolean canWithdraw(final double amount) {
        return this.balance >= amount;
    }

    private boolean hasSameId(final int id) {
        return this.id == id;
    } 

    private void increaseOperations() {
        this.transactions++;
    }

    private void payATMFees() {
        this.balance = this.balance - ATM_TRANSACTION_FEE;
    }
}