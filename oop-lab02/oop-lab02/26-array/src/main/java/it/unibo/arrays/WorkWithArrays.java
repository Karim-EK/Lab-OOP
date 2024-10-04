package it.unibo.arrays;

import java.util.Arrays;

class WorkWithArrays {

    static int countOccurrencies(final int[] array, final int element) {
        int occurrencies = 0;
        for (final int currentElement : array) {
            if (currentElement == element) {
                occurrencies++;
            }
        }
        return occurrencies;
    }

    static int[] evenElements(final int[] array) {
        // Compute the actual array size ex-post
        int[] even = new int[array.length/2 + (array.length % 2 == 0 ? 0 : 1)];
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if(i % 2 == 0){
                even[j] = array[i];
                j++;
            }
        }
        return even;
    }

    static int[] oddElements(final int[] array) {
        int[] odd = new int[array.length/2];
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if(i % 2 != 0){
                odd[j] = array[i];
                j++;
            }
        }
        return odd;
    }

    static int mostRecurringElement(final int[] array) {
        int maxCounter = 0; // Il numero massimo di occorrenze
        int mostRecurringElement = array[0]; // Elemento più ricorrente inizialmente impostato al primo elemento

        // Ciclo esterno per esaminare ciascun elemento
        for (int i = 0; i < array.length; i++) {
            int currentCounter = 0;
            
            // Ciclo interno per contare le occorrenze dell'elemento corrente
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    currentCounter++;
                }
            }

            // Aggiorna l'elemento più ricorrente se è stato trovato un conteggio maggiore
            if (currentCounter > maxCounter) {
                maxCounter = currentCounter;
                mostRecurringElement = array[i];
            }
        }

        return mostRecurringElement;
    }

    static int[] sortArray(final int[] array, final boolean isDescending) {
        if (!isDescending){
            int temp;
            boolean hasBeenModified = false;
            do {
                hasBeenModified = false;
                for (int i = 0; i < array.length-1; i++){
                    final boolean shouldSwap = isDescending
                        ? array[i] < array[i+1]
                        : array[i] > array[i+1];
                    if(shouldSwap){
                        hasBeenModified = true;
                        temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                    }
                }
            } while (hasBeenModified);
        }
        return array;
    }

    static double computeVariance(final int[] array) {
        double media;
        double tot = 0;

        for (int element : array){
            tot += element;
        }
        media = tot/array.length;

        double[] diff = new double[array.length];
        int i = 0;
        tot = 0;
        for (int element : array){
            diff[i] = (media - element) * (media - element);
            tot += diff[i];
            i++;
        }
        return tot/array.length;
    }

    static int[] revertUpTo(final int[] array, final int element) {
        int[] reverted = new int[array.length];

        int j = 0;
        int firstOccurenceIndex = 0;
        for (; firstOccurenceIndex < array.length && array[firstOccurenceIndex] != element; firstOccurenceIndex++);
        for (int i = firstOccurenceIndex; i >= 0; i--){
            reverted[j] = array[i];
            j++;
        }

        for (int i = firstOccurenceIndex + 1; i < array.length; i++){
            reverted[j] = array[i];
            j++;
        }
        
        return reverted;
    }

    static int[] duplicateElements(final int[] array, final int times) {
        final int[] returnValue = new int[array.length * times];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < times; j++) {
                returnValue[i * times + j] = array[i];
            }
        }
        return returnValue;
    }

    /** Testing methods **/

    /* Utility method for testing countOccurr method */
    static boolean testCountOccurrencies() {
        return countOccurrencies(new int[] { 1, 2, 3, 4 }, 1) == 1
            && countOccurrencies(new int[] { 0, 2, 3, 4 }, 1) == 0
            && countOccurrencies(new int[] { 7, 4, 1, 9, 3, 1, 5 }, 2) == 0
            && countOccurrencies(new int[] { 1, 2, 1, 3, 4, 1 }, 1) == 3
            && countOccurrencies(new int[] {1,2,3,4,5,6,7,8}, 7) == 1;
    }

    /* Utility method for testing evenElems method */
    static boolean testEvenElements() {
        return Arrays.equals(evenElements(new int[] { 1, 2, 3, 4 }), new int[] { 1, 3 })
            && Arrays.equals(evenElements(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }), new int[] { 1, 3, 5, 7, 9 })
            && Arrays.equals(evenElements(new int[] { 4, 6, 7, 9, 1, 5, 23, 11, 73 }), new int[] { 4, 7, 1, 23, 73 })
            && Arrays.equals(
                evenElements(new int[] { 7, 5, 1, 24, 12, 46, 23, 11, 54, 81 }),
                new int[] { 7, 1, 12, 23, 54 }
        );
    }

    /* Utility method for testing oddElems method */
    static boolean testOddElements() {
        return Arrays.equals(oddElements(new int[] { 1, 2, 3, 4 }), new int[] { 2, 4 })
            && Arrays.equals(oddElements(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }), new int[] { 2, 4, 6, 8 })
            && Arrays.equals(oddElements(new int[] { 4, 6, 7, 9, 1, 5, 23, 11, 73 }), new int[] { 6, 9, 5, 11 })
            && Arrays.equals(
                oddElements(new int[] { 7, 5, 1, 24, 12, 46, 23, 11, 54, 81 }),
                new int[] { 5, 24, 46, 11, 81 }
            );
    }

    /* Utility method for testing getMostRecurringElem method */
    static boolean testMostRecurringElement() {
        return mostRecurringElement(new int[] { 1, 2, 1, 3, 4 }) == 1
            && mostRecurringElement(new int[] { 7, 1, 5, 7, 7, 9 }) == 7
            && mostRecurringElement(new int[] { 1, 2, 3, 1, 2, 3, 3 }) == 3
            && mostRecurringElement(new int[] { 5, 11, 2, 11, 7, 11 }) == 11;
    }

    /* Utility method for testing sortArray method */
    static boolean testSortArray() {
        return Arrays.equals(sortArray(new int[] { 3, 2, 1 }, false), new int[] { 1, 2, 3 })
            && Arrays.equals(sortArray(new int[] { 1, 2, 3 }, true), new int[] { 3, 2, 1 })
            && Arrays.equals(
                sortArray(new int[] { 7, 4, 1, 5, 9, 3, 5, 6 }, false),
                new int[] { 1, 3, 4, 5, 5, 6, 7, 9 }
            );
    }

    /* Utility method for testing computeVariance method */
    static boolean testComputeVariance() {
        return computeVariance(new int[] { 1, 2, 3, 4 }) == 1.25
            && computeVariance(new int[] { 1, 1, 1, 1 }) == 0
            && computeVariance(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }) == 8.25;
    }

    /* Utility method for testing revertUpTo method */
    static boolean testRevertUpTo() {
        return
            Arrays.equals(
                revertUpTo(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5),
                new int[] { 5, 4, 3, 2, 1, 6, 7, 8, 9, 10 }
            )
            && Arrays.equals(
                revertUpTo(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 3),
                new int[] { 3, 2, 1, 4, 5, 6, 7, 8, 9, 10 }
            )
            && Arrays.equals(
                revertUpTo(new int[] { 1, 2, 3 }, 3),
                new int[] { 3, 2, 1 }
            );
    }

    /* Utility method for testing dupElems method */
    static boolean testDuplicateElements() {
        return Arrays.equals(duplicateElements(new int[] { 1, 2, 3 }, 2), new int[] { 1, 1, 2, 2, 3, 3 })
            && Arrays.equals(duplicateElements(new int[] { 1, 2 }, 5), new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 });
    }

    public static void main(final String[] args) {
        System.out.println("testCountOccurr: " + testCountOccurrencies());
        System.out.println("testEvenElems: " + testEvenElements());
        System.out.println("testOddElems: " + testOddElements());
        System.out.println("testGetMostRecurringElem: " + testMostRecurringElement());
        System.out.println("testSortArray: " + testSortArray());
        System.out.println("testComputeVariance: " + testComputeVariance());
        System.out.println("testRevertUpTo: " + testRevertUpTo());
        System.out.println("testDupElems: " + testDuplicateElements());
    }
}
