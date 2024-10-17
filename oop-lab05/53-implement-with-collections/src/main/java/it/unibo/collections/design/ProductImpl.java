package it.unibo.collections.design;

import it.unibo.collections.design.api.Product;

public class ProductImpl implements Product {

    private final String name;
    private int quantity;

    public ProductImpl(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getQuantity() {
        return this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductImpl other = (ProductImpl) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductImpl [name=" + name + "]";
    }
    
}
