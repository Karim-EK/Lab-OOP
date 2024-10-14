package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Square implements Polygon {

    final static int EDGE_NUMBER = 4;
    final double side;

    public Square(final double side) {
        this.side = side;
    }

    @Override
    public double getPerimeter() {
        return EDGE_NUMBER * side; 
    }

    @Override
    public double getSurface() {
        return side * side;
    }

    @Override
    public int getEdgeCounts() {
        return EDGE_NUMBER;
    }

    @Override
    public String toString() {
        return "Square [edge=" + side + ", getPerimeter()=" + getPerimeter() + ", getSurface()=" + getSurface()
                + ", getEdgeCounts()=" + getEdgeCounts() + "]";
    }
}
