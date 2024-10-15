package org.example;

import org.example.CalculoDNI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static javax.swing.text.html.HTML.Attribute.N;

public class CalculoDNITest {

    CalculoDNI calculadora = new CalculoDNI();

    @ParameterizedTest
    @ValueSource(strings = {"47875705D", "47875704P", "53311673L", "02302823V", "02317715M", "48157988J", "50331776W", "50471166N", "50489678D", "50501313Y"})
    void getLetter(String dni) {
        String number = dni.substring(0, dni.length()-1);
        char letter = dni.charAt(dni.length()-1);
        Assertions.assertEquals(calculadora.getLetter(number), letter);
    }
}