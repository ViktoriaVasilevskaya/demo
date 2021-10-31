package com.ifmo.lesson5;

public class Main {

    public static void main(String[] args) {
        Shape [] shapes = {new Square(2), new Rectangle(3,3),
        new Circle(5),new Oval(5,3),new Triangle(2,3),
        new SquareTriangle(4,4)};
        for (Shape shape: shapes){
            System.out.println(shape.area());
        }
    }
   /* private static void printAreas(Shape...shapes){// тип ... - переменное количество аргументов
        for (Shape shape: shapes){
            System.out.println(shape.area());
        }
    }*/
}
