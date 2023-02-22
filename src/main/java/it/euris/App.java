package it.euris;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Calcolatrice calcolatrice=new Calcolatrice();
        int somma=calcolatrice.add(1,1);
        boolean testResult=somma==2;
        if (testResult)
            System.out.println("il risultato ottenuto è ugale a quello atteso ... OK");
        else
            System.out.println("il risultato ottenuto non rispecchia le aspettative ... KO");
    }
}
