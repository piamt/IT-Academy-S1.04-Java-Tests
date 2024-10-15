package org.example;

public class CalculoDNI {

    static final String characters="TRWAGMYFPDXBNJZSQVHLCKE";

    public char getLetter(String dni) throws NumberFormatException
    {
        try {
            int intDNI = Integer.parseInt(dni);
            int module= intDNI % 23;
            return characters.charAt(module);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer");
            throw e;
        }
    }
}
