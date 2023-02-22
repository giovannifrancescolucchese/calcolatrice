package it.euris;

import it.euris.exceptions.CalculatorException;

public class Calcolatrice {
    public Calcolatrice() {}

    public int add(int a, int b) {
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int mul(int a, int b) {
        return a*b;
    }

    public int div(int a, int b) throws CalculatorException {

        try {
            return a/b;
        }
        catch (ArithmeticException e) {
            System.out.println("Catturata eccezione: "+e.getMessage());
            throw new CalculatorException("ECCEZIONE CALCOLATORE DIVISIONE PER 0");
        }
    }

    public int el(int a, int b) {
        return (int) Math.pow(a,b);
    }

    public int sqrt(int a) {
        return (int) Math.sqrt(a);
    }





}
