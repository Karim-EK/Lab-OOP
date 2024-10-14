package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {

    private final int id;
    private double balance;
    
    private int transactions;
    
    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGMENT_FEE = 5;
    private static final double TRANSACTIONS_FEE = 0.1;
    
    public StrictBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;
        this.transactions = 0;
    }

    @Override
    public void withdraw(final int id, final double amount) {
        if (canWithdraw(amount) && hasSameId(id)) {
            this.balance = this.balance - amount;
            increaseOperations();
        }
    }

    @Override
    public void deposit(final int id, final double amount) {
        if (hasSameId(id)) {
            this.balance = this.balance + amount;
            increaseOperations();
        }
    }

    @Override
    public void depositFromATM(final int id, final double amount) {
        deposit(id, amount);
        payATMFees();
    }

    @Override
    public void withdrawFromATM(final int id, final double amount) {
        withdraw(id, amount);
        payATMFees();
    }

    @Override
    public void chargeManagementFees(final int id) {
        if (hasSameId(id)) {
            this.balance = this.balance - MANAGMENT_FEE + (transactions * TRANSACTIONS_FEE);
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