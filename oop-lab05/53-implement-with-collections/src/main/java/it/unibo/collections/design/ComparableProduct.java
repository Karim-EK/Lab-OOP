package it.unibo.collections.design;

import it.unibo.collections.design.api.Product;

public class ComparableProduct extends ProductImpl implements Comparable<Product> {

    public ComparableProduct(final String name, final int quantity) {
        super(name, quantity);
    }

    @Override
    public int compareTo(final Product o) {
        // if (this.getName().equals(o.getName())) {
        //     return 0;
        // } else {
            return this.getName().compareTo(o.getName());
        // }
    }
}
