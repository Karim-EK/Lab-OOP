package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int CORRECT_INDEXING = -1;
    private static final int ADD_TO_LIST_TEST = 100_000;
    private static final int READ_TEST = 1_000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String[] args) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        // NB: ho tipato l'array ad ArrayList<> invece che Collection<> perchè avere il tipo di una superclasse concede
        //     molti meno metodi; più sotto viene richiesto il metodo get(), ma Collection non ne dispone
        final List<Integer> arrayList = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            arrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        // NB: anche per LinkedList si applica lo stesso ragionamento, il metodo è addFirst()
        final LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int temporary = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.set(arrayList.size() - 1, temporary);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final var integer: arrayList) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        System.out.println("Adding " + ADD_TO_LIST_TEST + " to an ArrayList...");
        final var array = startCounting();
        for (int i = 0; i <= ADD_TO_LIST_TEST; i++) {
            arrayList.add(0, i);
        }
        terminateTest(array);

        System.out.println("Now the Linked List...");
        final var linked = startCounting();
        for (int i = 0; i <= ADD_TO_LIST_TEST; i++) {
            linkedList.addFirst(i); 
        }
        terminateTest(linked);       
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        System.out.println("");
        System.out.println("Reading " + READ_TEST + " elements from the middle of ArrayList...");
        final var readArray = startCounting();
        for (int i = 0; i <= READ_TEST; i++) {
            arrayList.get((arrayList.size() + CORRECT_INDEXING) / 2);
        }
        terminateTest(readArray);

        System.out.println("Now LinkedList...");
        final var readLinked = startCounting();
        for (int i = 0; i <= READ_TEST; i++) {
            linkedList.get((linkedList.size() + CORRECT_INDEXING) / 2);
        }
        terminateTest(readLinked);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String,Long> worldMap = new HashMap<>();
        worldMap.put("Africa", 1_110_635_000L);
        worldMap.put("Americas", 972_005_000L);
        worldMap.put("Antartica", 0L);
        worldMap.put("Asia", 4_298_723_000L);
        worldMap.put("Europe", 742_452_000L);
        worldMap.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long totalPopulation = 0;
        for (final var continent : worldMap.values()) {
            totalPopulation = totalPopulation + continent;
        }
        System.out.println("Total population: " + totalPopulation);
    }
    
    private static long startCounting() {
            return System.currentTimeMillis();
    }

    private static void terminateTest(final long start) {
        System.out.println("Time passed: " + (startCounting() - start) + "ms");
    }
}
