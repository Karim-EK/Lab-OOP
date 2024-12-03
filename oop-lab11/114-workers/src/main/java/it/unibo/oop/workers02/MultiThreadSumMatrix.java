package it.unibo.oop.workers02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiThreadSumMatrix implements SumMatrix {

    private final int nWorkers;
    private List<Worker> workers;
    public MultiThreadSumMatrix(int n) {
        this.nWorkers = n;
        this.workers = new ArrayList<>();
    }

    @Override
    public double sum(double[][] matrix) {
        double[] flattenArray = Arrays.stream(matrix)
            .flatMapToDouble(x -> Arrays.stream(x))
            .toArray();
        var size = flattenArray.length;
        var elementsPerThread = size / nWorkers;
        var surplus = size % nWorkers;
        
        for (long i = 0; i < nWorkers - 1; i++) {
            workers.add(new Worker(flattenArray, i * elementsPerThread, (i + 1) * elementsPerThread -1));
        }
        workers.add(new Worker(flattenArray, (nWorkers - 1) * elementsPerThread, (nWorkers * elementsPerThread) + surplus -1));

        for (var w: workers) {
            w.start();
        }
        double sum = 0;
        for (var w: workers) {
            try {
                w.join();
                sum += w.getResult();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
        return sum;
    }
    
    private class Worker extends Thread {
        
        private double[] flatMatrix;
        private final long start;
        private final long end;
        private double result;

        public Worker(double[] matrix, long start, long end) {
            super();
            this.flatMatrix = matrix;
            this.start = start;
            this.end = end;
            this.result = 0;
        }
        
        @Override
        public void run() {
            for (long i = this.start; i <=  this.end; i++) {
                this.result = this.result + flatMatrix[(int) i];
            }
        }

        public double getResult() {
            return this.result;
        }
    }
    public static void main(String[] args) {
        var app = new MultiThreadSumMatrix(3);
        var multi = new double[][] {
            { 1, 1, 1 },
            { 1, 1, 1 },
            { 1, 1, 1, 9 }
          };
        System.out.println(app.sum(multi));
    }
}
