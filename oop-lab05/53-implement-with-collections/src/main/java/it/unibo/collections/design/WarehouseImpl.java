package it.unibo.collections.design;

import java.util.Set;

import it.unibo.collections.design.api.Product;
import it.unibo.collections.design.api.Warehouse;
import java.util.Collection;
import java.util.LinkedHashSet;


public class WarehouseImpl<T extends Product> implements Warehouse<T>{

    private final Collection<T> productSet;

    
    public WarehouseImpl() {
        this.productSet = new LinkedHashSet<>();
    }

    @Override
    public void addProduct(final T p) {
        this.productSet.add(p);
    }

    @Override
    public Set<String> allNames() {
        final Set<String> namesSet = new LinkedHashSet<>();
        for (final Product product : this.productSet) {
            namesSet.add(product.getName());
        }
        return namesSet;
    }

    @Override
    // Non ritorno il riferimento alla Collection originale, 
    // ma ritorno una copia difensiva.
    public Set<T> allProducts() {
        final Set<T> defensiveCopy = new LinkedHashSet<>(this.productSet);
        return  defensiveCopy;
    }

    @Override
    public boolean containsProduct(final T p) {
        return this.productSet.contains(p);
    }

    @Override
    public double getQuantity(final String name) {
        for (final var product : this.productSet) {
            if (product.getName().equals(name)) {
                return product.getQuantity();
            }
        }
        return 0.0;
    }

    public Collection<T> getProductSet() {
        return this.productSet;
    }
    
}
