package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {



        return new ExceptionFactory().getClass();
    }

    public static void main(String[] args) {
        //System.out.println(ExceptionFactory.getException(null));

    }

    static class ExceptionFactory{

        static Throwable getException(Enum e){

            if (e == null) return  new IllegalArgumentException();

            if (e.getClass().getSimpleName().equals("ApplicationExceptionMessage")){
                String message = e.name().toLowerCase().replace("_", " ");
                message = message.substring(0,1).toUpperCase() + message.substring(1);
                return new Exception(message);
            }

            if (e.getClass().getSimpleName().equals("DatabaseExceptionMessage")){
                String message = e.name().toLowerCase().replace("_", " ");
                message = message.substring(0,1).toUpperCase() + message.substring(1);
                return new RuntimeException(message);
            }

            if (e.getClass().getSimpleName().equals("UserExceptionMessage")){
                String message = e.name().toLowerCase().replace("_", " ");
                message = message.substring(0,1).toUpperCase() + message.substring(1);
                return new Error(message);
            }
            return new IllegalArgumentException();
        }

    }
}