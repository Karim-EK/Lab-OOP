package it.unibo.collections.design;

import java.util.Set;
import java.util.TreeSet;;

public class OrderedWarehouse extends WarehouseImpl<ComparableProduct> {

    @Override
    public Set<ComparableProduct> allProducts() {
        final Set<ComparableProduct> defensiveCopy = new TreeSet<>(this.getProductSet());
        System.out.println(defensiveCopy);
        return  defensiveCopy;
    }
}
