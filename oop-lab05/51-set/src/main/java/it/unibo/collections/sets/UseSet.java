package it.unibo.collections.sets;

import java.util.Collection;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * Example class using {@link java.util.Set}.
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         *
         * 1) Builds a TreeSet containing Strings
         */
        final Collection<String> treeSet = new TreeSet<>();         
        /*
         * 2) Populates such Collection with all the Strings representing numbers ranging from "1" to
         * "20" (both included)
         */
        for(int i = 1; i <= ELEMS; i++) {
            treeSet.add(Integer.toString(i));
        }
        /*
         * 3) Prints its content
         */
        System.out.println(treeSet);
        /*
         * 4) Removes all those strings whose represented number is divisible by three.
         * Note: the method removeIf(Predicate) is not allowed.
         */
        for (final Iterator<String> iterator = treeSet.iterator(); iterator.hasNext();) {
            if (Integer.parseInt(iterator.next()) % 3 == 0) {
                iterator.remove();
            }
        }
        // Questa versione con il foreach e il metodo remove() di Collection non funziona
        // E' necessario utilizare l'Iterator
            // for (Object element : treeSet) {
            //     if (Integer.parseInt((String)element) % 3 == 0) {
            //         treeSet.remove(element);
            //     }
            // }
        /*
         * 5) Prints the content of the Set using a for-each construct
         */
        for (final String element: treeSet) {
            System.out.print(element + " ");
        }
        /*
         * 6) Verifies whether all the numbers left in the set are even
         */
        boolean allEven = true;
        for (final Iterator<String> iterator = treeSet.iterator(); allEven && iterator.hasNext();) {
            final var elememt = iterator.next();
            if (Integer.parseInt(elememt) % 2 != 0) {
                allEven = false;
                System.out.println("Found odd element: " + elememt);
            }
        }
        if (allEven) {
            System.out.println("All values in the collection are even");
        }
    }
}
