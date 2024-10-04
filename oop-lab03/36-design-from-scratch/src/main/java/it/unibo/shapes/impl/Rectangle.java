package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Rectangle implements Polygon{

    final static int EDGE_NUMBER = 4;
    final double l1;
    final double l2;

    public Rectangle(double l1, double l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public double getPerimeter() {
        return 2 * l1 + 2 * l2;
    }

    @Override
    public double getSurface() {
        return l1 * l2;
    }

    @Override
    public int getEdgeCounts() {
        return EDGE_NUMBER;
    }

    @Override
    public String toString() {
        return "Rectangle [l1=" + l1 + ", l2=" + l2 + ", getPerimeter()=" + getPerimeter() + ", getSurface()="
                + getSurface() + ", getEdgeCounts()=" + getEdgeCounts() + "]";
    }
}
