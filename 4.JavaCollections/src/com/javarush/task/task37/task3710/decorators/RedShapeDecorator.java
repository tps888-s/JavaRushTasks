package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Circle;
import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {


    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    private void setBorderColor(Shape shape){
        System.out.println("Setting the border color for "+ shape.getClass().getSimpleName() +" to red.");
    }

    @Override
    public void draw() {
        setBorderColor(this.decoratedShape);
        super.draw();
    }
}
