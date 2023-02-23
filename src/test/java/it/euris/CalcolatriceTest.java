package it.euris;

import it.euris.exceptions.CalculatorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class CalcolatriceTest {

    @Test
    @DisplayName("precondition=>a=1 AND b=1, sut=>Calcolatrice.add, postcondition=>a+b=2")
    void addTwoNumbers() {
        Calcolatrice calcolatrice=new Calcolatrice();
        assertEquals(2, calcolatrice.add(1,1),"1 +1 should be 2");
    }

    @Test
    @DisplayName("precondition=>a=4 AND b=5, sut=>Calcolatrice.add, postcondition=>a+b=9")
    void addTwoNumbers_2() {
        Calcolatrice calcolatrice=new Calcolatrice();
        assertEquals(9, calcolatrice.add(4,5),"4 +5 should be 9");
    }

    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.div, postcondition=>Exception")
    void divTwoNumbers() {
        Calcolatrice calcolatrice=new Calcolatrice();
        assertThrows(CalculatorException.class, () -> calcolatrice.div(9,0));
    }



    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.el, postcondition=>4^0=1")
    void elTwoNumbers() {
        Calcolatrice calcolatrice=new Calcolatrice();
        assertEquals(1, calcolatrice.el(4,0),"4^0 should be 1");
    }

    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.el, postcondition=>4^0!=0")
    void elTwoNumbersNot() {
        Calcolatrice calcolatrice=new Calcolatrice();
        assertNotEquals(0, calcolatrice.el(4,0),"4^0 should not be 0");
    }


    @Test
    @DisplayName("precondition=>a=10 , sut=>Calcolatrice.sqrt, postcondition=>sqrt(10)==3")
    void sqrtNumber() {
        Calcolatrice calcolatrice=new Calcolatrice();
        assertThrows(CalculatorException.class,()->calcolatrice.sqrt(-10));
    }

    @Test
    @DisplayName("precondition=>a=10 , sut=>Calcolatrice.sqrt, postcondition=>sqrt(10)==3")
    void sqrtNumber_2() throws CalculatorException {
        Calcolatrice calcolatrice=new Calcolatrice();
        assertEquals(3, calcolatrice.sqrt(10),"sqrt 10 sould be 3");
    }

}