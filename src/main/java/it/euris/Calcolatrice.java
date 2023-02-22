package it.euris;

import it.euris.exceptions.CalculatorException;

public class Calcolatrice {

    public Calcolatrice() {}

    public int add(int a, int b) throws CalculatorException {
        try {
        return Math.addExact(a,b);
        }
        catch (ArithmeticException e) {
            System.out.println(String.format("Catturata eccezione: %d + %d => %s",a,b,e.getMessage()));
            throw new CalculatorException(String.format("ECCEZIONE CALCOLATORE OVERFLOW/UNDERFLOW: %d + %d",a,b));
        }
    }

    public int sub(int a, int b) throws CalculatorException {
        try {
        return Math.subtractExact(a,b);
        }
        catch (ArithmeticException e) {
            System.out.println(String.format("Catturata eccezione: %d - %d => %s",a,b,e.getMessage()));
            throw new CalculatorException(String.format("ECCEZIONE CALCOLATORE OVERFLOW/UNDERFLOW: %d - %d",a,b));
        }
    }

    public int mul(int a, int b) throws CalculatorException {
        try {
        return Math.multiplyExact(a,b);
        }
        catch (ArithmeticException e) {
            System.out.println(String.format("Catturata eccezione: %d * %d => %s",a,b,e.getMessage()));
            throw new CalculatorException(String.format("ECCEZIONE CALCOLATORE OVERFLOW/UNDERFLOW: %d * %d",a,b));
        }
    }

    public int div(int a, int b) throws CalculatorException {

        try {
            return a/b;
        }
        catch (ArithmeticException e) {
            System.out.println(String.format("Catturata eccezione: %d / %d => %s",a,b,e.getMessage()));
            throw new CalculatorException("ECCEZIONE CALCOLATORE DIVISIONE PER 0");
        }
    }

    public int el(int a, int b) {
        return (int) Math.pow(a,b);
    }

    public int sqrt(int a) throws CalculatorException {
        if (a<0) {
            System.out.println(String.format("Catturata eccezione: sqrt(%d) => %s",a,"richiesta radice di numero negativo"));
            throw new CalculatorException("CALCOLATORE radice quadrata di numero negativo");
            }
        else
        return (int) Math.sqrt(a);
    }





}
