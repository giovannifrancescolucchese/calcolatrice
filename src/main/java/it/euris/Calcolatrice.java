package it.euris;

public class Calcolatrice {
    public Calcolatrice() {}

    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    public Integer sub(Integer a, Integer b) {
        return a-b;
    }

    public Integer mul(Integer a, Integer b) {
        return a*b;
    }

    public Integer div(Integer a, Integer b) {
        Integer result=null;
        try {
            result=a/b;
        }
        catch (ArithmeticException e) {
            System.out.println("Catturata eccezione: "+e.getMessage());
        }
        return result;
    }



}
