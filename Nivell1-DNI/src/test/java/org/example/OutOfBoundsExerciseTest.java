package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutOfBoundsExerciseTest {

    @Test
    void execute() {
        OutOfBoundsExercise object = new OutOfBoundsExercise();

        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, object::execute);

        String expectedMessage = "this is an exception";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }
}