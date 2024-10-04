package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Square implements Polygon {

    final static int EDGE_NUMBER = 4;
    final double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double getPerimeter() {
        return EDGE_NUMBER * edge; 
    }

    @Override
    public double getSurface() {
        return edge * edge;
    }

    @Override
    public int getEdgeCounts() {
        return EDGE_NUMBER;
    }

    @Override
    public String toString() {
        return "Square [edge=" + edge + ", getPerimeter()=" + getPerimeter() + ", getSurface()=" + getSurface()
                + ", getEdgeCounts()=" + getEdgeCounts() + "]";
    }
}
