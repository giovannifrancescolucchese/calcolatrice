package it.euris;

import it.euris.exceptions.CalculatorException;

public class Calcolatrice {
    public Calcolatrice() {}

    public int add(int a, int b) throws CalculatorException {
        if (a>=0 && b>=0 && a+b<0) throw new CalculatorException("WRAP ROUNDING SOMMA");
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int mul(int a, int b) throws CalculatorException {
        int result=0;
        for (int i=1;i<=b;i++)
            try {
        result=this.add(result,a);
        } catch (CalculatorException ex) {
        throw new CalculatorException("WRAP ROUNDING MOLTIPLICAZIONE");
            }
         return result;
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

    public int el(int a, int b) throws CalculatorException {
        if (a==0 && b<0)
            throw new CalculatorException("CALCOLATORE elevemaneto a potenza di 0");
        else
        return (int) Math.pow(a,b);
    }

    public int sqrt(int a) throws CalculatorException {
        if (a<0)
            throw new CalculatorException("CALCOLATORE radice quadrata di numero negativo");
        else
        return (int) Math.sqrt(a);
    }





}
