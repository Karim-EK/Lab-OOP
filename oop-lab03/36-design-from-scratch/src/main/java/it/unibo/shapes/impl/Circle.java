package it.unibo.shapes.impl;

import it.unibo.shapes.api.Shape;

public class Circle implements Shape {

    final double radius;
    final static double PI = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public double getSurface() {
        return PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", getPerimeter()=" + getPerimeter() + ", getSurface()=" + getSurface()
                + "]";
    }
}
