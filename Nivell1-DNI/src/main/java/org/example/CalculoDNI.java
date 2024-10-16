package org.example;

public class CalculoDNI {

    static final String characters="TRWAGMYFPDXBNJZSQVHLCKE";

    public char getLetter(String dni)
    {
        int intDNI = Integer.parseInt(dni);
        int module= intDNI % 23;
        return characters.charAt(module);
    }
}
