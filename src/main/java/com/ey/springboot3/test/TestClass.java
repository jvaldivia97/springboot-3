package com.ey.springboot3.test;

public class TestClass {

    public static void main(String[] args) {

        String typeLanguage = "";

        switch (args[0]){
            case "Java":
            case "Scala":
            case "Kotlin":
                typeLanguage = "Static type";
                break;
            case "Groovy":
            case "Javascript":
                typeLanguage = "Dynamic Typed";
                break;
            default: typeLanguage = "...";
        }

        String langType = switch (args[0]){
            case "Java", "Scala", "Kotlin" -> "Static Typed";
            case "Groovy", "Javascript" -> "Dynamic Typed";
            default -> {
                System.out.println("por defecto ...");
                yield "...";
            }
        };

    }

    public void prueba(Object o){
        if(o instanceof String s){
            System.out.println(s);
            //Do something
        }

    }


}
