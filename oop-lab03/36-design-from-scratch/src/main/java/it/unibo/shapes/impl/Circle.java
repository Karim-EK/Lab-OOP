package it.unibo.shapes.impl;

import it.unibo.shapes.api.Shape;

public class Circle implements Shape {

    private final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getSurface() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", getPerimeter()=" + getPerimeter() + ", getSurface()=" + getSurface()
                + "]";
    }
}
