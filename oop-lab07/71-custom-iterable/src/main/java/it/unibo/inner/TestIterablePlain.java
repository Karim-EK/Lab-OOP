package it.unibo.inner;

import it.unibo.inner.api.IterableWithPolicy;

import java.util.List;

import static it.unibo.inner.test.Assertions.assertContentEqualsInOrder;

public class TestIterablePlain {

    private TestIterablePlain() {}

    private static <T> IterableWithPolicy<T> getIterableWithPolicy(T[] elements) {
<<<<<<< HEAD
        return null; // TODO: return the implementation of IterableWithPolicy
=======
        return new IterableWithPolicyImpl<>(elements);
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
    }

    public static void main(final String[] args) {
        String[] test1 = { "pippo", "pluto", "paperino" };

        IterableWithPolicy<String> evenIterable = getIterableWithPolicy(test1);
        assertContentEqualsInOrder(evenIterable, List.of("pippo", "pluto", "paperino"));

        String[] test2 = {};

        IterableWithPolicy<String> emptyIterable = getIterableWithPolicy(test2);
        assertContentEqualsInOrder(emptyIterable, List.of());

        String[] test3 = { "foo" };

        IterableWithPolicy<String> oneIterable = getIterableWithPolicy(test3);
        assertContentEqualsInOrder(oneIterable, List.of("foo"));
    }
}
