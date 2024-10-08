package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Triangle implements Polygon {

    private final static int EDGE_NUMBER = 3;
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2) {
        this(side1, side2, side2);
    }

    public Triangle(double side1) {
        this(side1, side1, side1);
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    private double getSemiPerimeter() {
        return getPerimeter() / 2;
    }

    @Override
    public double getSurface() {
        return Math.sqrt(getSemiPerimeter() * (getSemiPerimeter() - side1) 
        * (getSemiPerimeter() - side2) * (getSemiPerimeter() - side3));
    }

    @Override
    public int getEdgeCounts() {
        return EDGE_NUMBER;
    }

    @Override
    public String toString() {
        return "Triangle [l1=" + side1 + ", l2=" + side2 + ", l3=" + side3 + ", getPerimeter()=" + getPerimeter()
                + ", getSurface()=" + getSurface() + ", getEdgeCounts()=" + getEdgeCounts() + "]";
    }
}
