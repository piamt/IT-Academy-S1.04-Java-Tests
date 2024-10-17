package org.example;

import java.util.ArrayList;
import java.util.List;

public class OutOfBoundsExercise {

    List<String> list = new ArrayList<>();

    public String execute(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= list.size()) throw new ArrayIndexOutOfBoundsException("this is an exception");
        return list.get(index);
    }
}
