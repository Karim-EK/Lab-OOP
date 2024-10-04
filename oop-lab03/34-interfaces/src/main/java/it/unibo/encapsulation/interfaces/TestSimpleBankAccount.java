package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        AccountHolder andreaR = new AccountHolder("Andrea", "Rossi", 1);
        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        AccountHolder alexB = new AccountHolder("Alex", "Bianchi", 2);
        // 3) Creare i due SimpleBankAccount corrispondenti
        SimpleBankAccount andreaRAccount = new SimpleBankAccount(1, 47_869);
        SimpleBankAccount alexBAccount = new SimpleBankAccount(2, 11_643);
        // 4) Effettuare una serie di depositi e prelievi
        andreaRAccount.depositFromATM(1, 900);
        alexBAccount.withdrawFromATM(2, 600);
        andreaRAccount.deposit(1, 1200);
        alexBAccount.withdrawFromATM(2, 100);
        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */
        System.out.println(andreaRAccount.getBalance());
        System.out.println(alexBAccount.getBalance());
        // 6) Provare a prelevare fornendo un id utente sbagliato
        alexBAccount.withdrawFromATM(3, 10_000);
        // 7) Controllare nuovamente l'ammontare
        System.out.println(alexBAccount.getBalance());
    }
}
