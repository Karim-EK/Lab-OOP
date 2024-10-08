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
        
        Triangle equilater = new Triangle(5);
        Triangle scalen = new Triangle(2,5,6);
        Triangle isoscele = new Triangle(1,5);

        scalen.getPerimeter();
        scalen.getSurface();
        System.out.println(scalen.toString());
        System.out.println();

        equilater.getPerimeter();
        equilater.getSurface();
        System.out.println(equilater.toString());
        System.out.println();

        isoscele.getPerimeter();
        isoscele.getSurface();
        System.out.println(isoscele.toString());
        System.out.println();
    }
}
