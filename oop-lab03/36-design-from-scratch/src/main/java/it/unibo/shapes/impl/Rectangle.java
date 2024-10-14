package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Rectangle implements Polygon {

    private final static int EDGE_NUMBER = 4;
    private final double side1;
    private final double side2;

    public Rectangle(final double side1, final double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2); 
    }

    @Override
    public double getSurface() {
        return side1 * side2;
    }

    @Override
    public int getEdgeCounts() {
        return EDGE_NUMBER;
    }

    @Override
    public String toString() {
        return "Rectangle [l1=" + side1 + ", l2=" + side2 + ", getPerimeter()=" + getPerimeter() + ", getSurface()="
                + getSurface() + ", getEdgeCounts()=" + getEdgeCounts() + "]";
    }
}
