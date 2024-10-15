package org.example;

public class Main {
    public static void main(String[] args) {
        CalculoDNI calculadora = new CalculoDNI();
        char letter = calculadora.getLetter("53311673");

        System.out.println(letter);
    }


}