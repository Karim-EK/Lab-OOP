package it.unibo.shapes.test;

import it.unibo.shapes.impl.Circle;
import it.unibo.shapes.impl.Rectangle;
import it.unibo.shapes.impl.Square;
import it.unibo.shapes.impl.Triangle;

public class WorkWithShapes {

    public static void main(final String args[]){
        Circle circle = new Circle(5);
        circle.getPerimeter();
        circle.getSurface();
        System.out.println(circle.toString());
        System.out.println();

        Square square = new Square(5);
        square.getPerimeter();
        square.getSurface();
        System.out.println(square.toString());
        System.out.println();

        Rectangle rectangle = new Rectangle(5,4);
        rectangle.getPerimeter();
        rectangle.getSurface();
        System.out.println(rectangle.toString());
        System.out.println();
        
        Triangle triangle = new Triangle(5);
        triangle.getPerimeter();
        triangle.getSurface();
        System.out.println(triangle.toString());
        System.out.println();
    }
}
