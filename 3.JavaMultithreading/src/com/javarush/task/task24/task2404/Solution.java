package com.javarush.task.task24.task2404;

/* 
Рефакторинг Rectangle
*/
public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
       // System.out.println(getHeight(rectangle));
        //System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(getHeight(rectangle.castToHasHeight()));
        System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(HasHeight rectangle) {
        return rectangle.getHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.getWidth();
    }


    public static class Rectangle {
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        public HasHeight castToHasHeight() {

            class HasHeight implements com.javarush.task.task24.task2404.HasHeight {
                @Override
                public double getHeight() {
                    return Math.abs(point2.getY()-point1.getY());
                }
            }
            return new HasHeight();
        }

        public HasWidth castToHasWidth() {

            class HasWidth implements com.javarush.task.task24.task2404.HasWidth{
                @Override
                public double getWidth() {
                    return Math.abs(point2.getX()-point1.getX());
                }
            }

            return new HasWidth();
        }
    }
}
