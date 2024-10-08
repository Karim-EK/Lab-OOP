package it.unibo.arrays;

class SeqRecognizer {

    /*
     * Recognizes: {1}{2|3}.
     */
    static boolean checkSeq1(final int[] array) {
        int i = 0;
        for (; i < array.length && array[i] == 1; i++);
        for (; i < array.length && (array[i] == 2 || array[i] == 3); i++);
        return i == array.length;
    }

    /*
     * Recognizes: 1{2}3.
     */
    static boolean checkSeq2(final int[] array) {
        if (array.length < 2) {
            return false;
        }
        int i = 0;
        for (; i < array.length && array[i] == 1; i++);
        if (i == 0){
            return false;
        }
        for (; i < array.length && array[i] == 2; i++);
        if(i == array.length){
            return false;
        }
        for (; i < array.length && array[i] == 3; i++);

        return i == array.length;
    }

    /*
     * Recognizes: 1{2}3{4}[5].
     */
    static boolean checkSeq3(final int[] array) {
        int i = 0;
        //Check for 1
        if (array[i] == 1) {
            i++;
        } else {
            return false;
        }
        //Check for 2
        for (; i < array.length && array[i] == 2; i++){
            i++;
        }
        //Check for 3
        if (array[i] == 3) {
            i++;
        } else {
            return false;
        }
        //Check for 4
        for (; i < array.length && array[i] == 4; i++){
            i++;
        }
        //Check for 5
        return i == array.length || i == array.length -1 && array[i] == 5;
    }

    /*
     * Recognizes: [2|3]{4}5.
     */
    static boolean checkSeq4(final int[] array) {

        int i = 0;

        if (array.length == 0){
            return false;
        }

        if (array[array.length-1] != 5){
            return false;
        }

        for (; i < array.length && (array[i] == 2 || array[i] == 3); i++);

        int j = 0;
        for (; i < array.length && array[i] == 4; i++){
            j++;
        }

        for (; i < array.length && array[i] == 5; i++);

        if (i == j+2 || i == j+1){
            return true;
        }
        
        return false;
    }

    /** Testing methods **/

    /* Utility method for testing checkSeq1 method */
    static boolean testCheckSeq1() {
        return checkSeq1(new int[] { 1, 1 })
                && checkSeq1(new int[] { 1, 1, 1, 2 })
                && checkSeq1(new int[] { 1, 1, 1, 2, 3, 2, 3 })
                && !checkSeq1(new int[] { 1, 1, 1, 2, 3, 1, 3 })
                && !checkSeq1(new int[] { 3, 2, 1, 1 });
    }

    /* Utility method for testing checkSeq2 method */
    static boolean testCheckSeq2() {
        return checkSeq2(new int[] { 1, 3 })
                && checkSeq2(new int[] { 1, 2, 3 })
                && checkSeq2(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 })
                && !checkSeq2(new int[] { 1, 2, 2 })
                && !checkSeq2(new int[] { 2, 2, 2, 2, 3 });
    }

    /* Utility method for testing checkSeq3 method */
    static boolean testCheckSeq3() {
        return checkSeq3(new int[] { 1, 3 })
                && checkSeq3(new int[] { 1, 3, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 })
                && checkSeq3(new int[] { 1, 2, 3, 4, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 3, 4, 4, 4, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 2, 3 })
                && !checkSeq3(new int[] { 1, 2, 2, 2 })
                && !checkSeq3(new int[] { 2, 2, 3, 4, 4, 4 })
                && !checkSeq3(new int[] { 1, 2, 2, 3, 4, 4, 4, 5, 6 });
    }

    static boolean testCheckSeq4() {
        return checkSeq4(new int[] { 2, 5 })
            && checkSeq4(new int[] { 5 })
            && checkSeq4(new int[] { 3, 5 })
            && checkSeq4(new int[] { 4, 5 })
            && checkSeq4(new int[] { 2, 4, 4, 4, 4, 4, 5 })
            && checkSeq4(new int[] { 3, 4, 5 })
            && checkSeq4(new int[] { 3, 4, 4, 4, 4, 4, 5 })
            && checkSeq4(new int[] { 4, 4, 4, 4, 4, 5 })
            && !checkSeq4(new int[] { })
            && !checkSeq4(new int[] { 2 })
            && !checkSeq4(new int[] { 3 })
            && !checkSeq4(new int[] { 3, 4 })
            && !checkSeq4(new int[] { 2, 4 })
            && !checkSeq4(new int[] { 4, 4, 4 });
    }

    public static void main(final String[] args) {
        System.out.println("testCheckSeq1: " + testCheckSeq1());
        System.out.println("testCheckSeq2: " + testCheckSeq2());
        System.out.println("testCheckSeq3: " + testCheckSeq3());
        System.out.println("testCheckSeq4: " + testCheckSeq4());
    }
}
