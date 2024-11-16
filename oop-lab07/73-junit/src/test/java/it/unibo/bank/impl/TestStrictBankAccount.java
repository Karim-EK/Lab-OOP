<<<<<<< HEAD
    package it.unibo.bank.impl;
=======
package it.unibo.bank.impl;
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
=======

import static org.junit.jupiter.api.Assertions.fail;
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76

/**
 * Test class for the {@link StrictBankAccount} class.
 */
class TestStrictBankAccount {

    // Create a new AccountHolder and a StrictBankAccount for it each time tests are executed.
    private AccountHolder mRossi;
    private BankAccount bankAccount;

    /**
     * Prepare the tests.
     */
    @BeforeEach
    public void setUp() {
<<<<<<< HEAD
        mRossi = new AccountHolder("Mario", "Rossi", 0);
        bankAccount = new StrictBankAccount(mRossi, 0);
=======
        fail("To be implemented");
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
    }

    /**
     * Test the initial state of the StrictBankAccount.
     */
    @Test
    public void testInitialization() {
<<<<<<< HEAD
        assertEquals(0, bankAccount.getTransactionsCount());
        assertEquals(0, bankAccount.getBalance());
        assertEquals(0, bankAccount.getAccountHolder().getUserID());
=======
        fail("To be implemented");
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
    }

    /**
     * Perform a deposit of 100€, compute the management fees, and check that the balance is correctly reduced.
     */
    @Test
    public void testManagementFees() {
<<<<<<< HEAD
        bankAccount.deposit(0, 100);
        assertEquals(100, bankAccount.getBalance());
=======
        fail("To be implemented");
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
    }

    /**
     * Test that withdrawing a negative amount causes a failure.
     */
    @Test
    public void testNegativeWithdraw() {
<<<<<<< HEAD
        assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                bankAccount.withdraw(0, -200);
            }
            
        });
=======
        fail("To be implemented");
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
    }

    /**
     * Test that withdrawing more money than it is in the account is not allowed.
     */
    @Test
    public void testWithdrawingTooMuch() {
<<<<<<< HEAD
        assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                bankAccount.withdraw(0, 200);
            }
            
        });
=======
        fail("To be implemented");
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
    }
}
