package it.unibo.arrays;

class MyCircularArray {

    int[] array;
    int lastElementIndex = 0;
    int size;

    MyCircularArray() {
        this(10);
    }

    MyCircularArray(int size) {
        this.array = new int[size];
        this.size = array.length;
    }

    void add(final int elem) {
        if (lastElementIndex == this.size){
            this.lastElementIndex = 0;
        }
        this.array[lastElementIndex] = elem;
        this.lastElementIndex++;
    }

    void reset() {
        for (int i = 0; i < this.size; i++){
            this.array[i] = 0;
            this.lastElementIndex = 0;
        }
    }

    void printArray() {
        System.out.print("[");
        for (int i = 0; i < this.array.length - 1; i++) {
            System.out.print(this.array[i] + ",");
        }
        System.out.print(this.array[this.array.length - 1] + "]");
    }

    public static void main(final String[] args) {

        // 1) Creare un array circolare di dieci elementi

        MyCircularArray defaultArray = new MyCircularArray();

        // 2) Aggiungere gli elementi da 1 a 10 e stampare il contenuto
        // dell'array circolare

        for (int i = 1; i <= 10; i ++){
            defaultArray.add(i);
        }

        defaultArray.printArray();

        // 3) Aggiungere gli elementi da 11 a 15 e stampare il contenuto
        // dell'array circolare

        for (int i = 11; i <= 15; i ++){
            defaultArray.add(i);
        }

        defaultArray.printArray();

        // 4) Invocare il metodo reset

        defaultArray.reset();

        // 5) Stampare il contenuto dell'array circolare

        defaultArray.printArray();

        // 6) Aggiungere altri elementi a piacere e stampare il contenuto
        // dell'array circolare

        for (int i = 11; i <= 15; i ++){
            defaultArray.add(20);
        }

        defaultArray.printArray();
    }
}
