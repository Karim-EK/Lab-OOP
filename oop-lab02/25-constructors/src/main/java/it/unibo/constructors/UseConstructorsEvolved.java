package it.unibo.constructors;

class UseConstructorsEvolved {

    public static void main(final String[] args) {
        // 1) Creare un treno con numero di posti di default, come nel caso
        // precedente (serve a verificare la nuova implementazione di Train()).

        Train defaultTrain = new Train();
        defaultTrain.printTrainInfo();

        // 2) Creare i seguenti treni usando il costruttore Train(int nFCSeats, int
        // nSCSeats)
        // - nFCSeats = 20; nSCSeats= 200;
        // - nFCSeats = 35; nSCSeats= 165;

        Train testTrain1 = new Train(20,200);
        Train testTrain2 = new Train(35, 165);
        
        testTrain1.printTrainInfo();
        testTrain2.printTrainInfo();
    }
}
