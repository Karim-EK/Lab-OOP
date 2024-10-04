package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Triangle implements Polygon {

    final static int EDGE_NUMBER = 3;
    final double l1;
    final double l2;
    final double l3;

    public Triangle(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public Triangle(double l1, double l2) {
        this(l1, l2, l2);
    }

    public Triangle(double l1) {
        this(l1, l1, l1);
    }

    @Override
    public double getPerimeter() {
        return l1 + l2 + l3;
    }

    private double getSemiPerimeter() {
        return getPerimeter() / 2;
    }

    @Override
    public double getSurface() {
        return Math.sqrt(getSemiPerimeter() * (getSemiPerimeter() - l1) 
        * (getSemiPerimeter() - l2) * (getSemiPerimeter() - l3));
    }

    @Override
    public int getEdgeCounts() {
        return EDGE_NUMBER;
    }

    @Override
    public String toString() {
        return "Triangle [l1=" + l1 + ", l2=" + l2 + ", l3=" + l3 + ", getPerimeter()=" + getPerimeter()
                + ", getSurface()=" + getSurface() + ", getEdgeCounts()=" + getEdgeCounts() + "]";
    }
}
