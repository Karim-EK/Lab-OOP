package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount {

    private static double TRANSACTION_FEE = 0.1;

    public ExtendedStrictBankAccount(int id, double balance) {
        super(id, balance);
    }
    
    @Override
    public void withdraw(final int id, final double amount) {
        if (isWithdrawAllowed(amount)) {
            super.withdraw(id, amount);
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.getBalance() >= amount;
    }

    @Override
    public void withdrawFromATM(final int id, final double amount) {
        if (isWithdrawAllowed(amount)) {
            super.withdrawFromATM(id, amount);
        }
    }

    @Override
    public void chargeManagementFees(final int id) {
        final double transactionFee = TRANSACTION_FEE * getTransactionsCount();
        resetTransactions();
        super.chargeManagementFees(id);
        setBalance(getBalance() - transactionFee);
    }
}
