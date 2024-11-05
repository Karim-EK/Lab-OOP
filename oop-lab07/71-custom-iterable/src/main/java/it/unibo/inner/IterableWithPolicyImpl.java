package it.unibo.inner;
import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private T[] array;
    private Predicate<T> predicate;

    public IterableWithPolicyImpl(final T[] array) {
        this.array = array;
        this.predicate = new Predicate<T>() {

            @Override
            public boolean test(final T elem) {
                return true;
            }    
        };
    }

    public IterableWithPolicyImpl(final T[] array, final Predicate<T> predicate) {
        this(array);
        this.predicate = predicate;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    @Override
    public void setIterationPolicy(final Predicate<T> filter) {
        this.predicate = filter;
    }

    private class InnerIterator implements Iterator<T> {

        private int current;

        public InnerIterator() {
        this.current = 0;
        }

        @Override
        public boolean hasNext() {
            while (current < IterableWithPolicyImpl.this.array.length) {
                if (IterableWithPolicyImpl.this.predicate.test(IterableWithPolicyImpl.this.array[current])) {
                    return true;
                } 
                current ++;
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return IterableWithPolicyImpl.this.array[current++];
            }
            throw new NoSuchElementException();
        }
   }
}