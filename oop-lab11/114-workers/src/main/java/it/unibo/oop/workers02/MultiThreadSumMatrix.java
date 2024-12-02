package it.unibo.oop.workers02;

import java.util.Arrays;
import java.util.List;

public class MultiThreadSumMatrix implements SumMatrix {

    private final int nWorkers;
    private List<Worker> workers;
    public MultiThreadSumMatrix(int n) {
        this.nWorkers = n;
    }

    @Override
    public double sum(double[][] matrix) {
        var nElements = Arrays.stream(matrix)
            .flatMapToDouble(Arrays :: stream)
            .count();
            var elementsPerThread = nWorkers / nElements;
            var surplus = nWorkers % nElements;

        for (long i = 0; i < nWorkers - 1; i++) {
            workers.add(new Worker(i * elementsPerThread - 1, (i + 1) * elementsPerThread -1));
        }
        workers.add(new Worker((nWorkers - 1) * elementsPerThread, (nWorkers * elementsPerThread) + surplus -1));

        for (var w: workers) {
            w.start();
        }
        var sum;
        for (var w: workers) {
            try {
                w.join();
                sum += w.getResult();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
    
    private class Worker extends Thread {
    
        private final long start;
        private final long end;

        public Worker(long start, long end) {
            super();
            this.start = start;
            this.end = end;
        }
        
        @Override
        public void run() {
        
        }
    }
}
