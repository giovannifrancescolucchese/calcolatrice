package it.euris;

import it.euris.exceptions.CalculatorException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalcolatriceTest {
    static private Calcolatrice calcolatrice;


    @BeforeAll
    //@BeforeEach
    static void initializeCalcolatrice() {
        calcolatrice=new Calcolatrice();
    }

    @Test
    @DisplayName("precondition=>a=1 AND b=1, sut=>Calcolatrice.add, postcondition=>a+b=2")
    void givenAddWhenBoth1ThenReturn2() {
        assertEquals(2, calcolatrice.add(1,1),"1 +1 should be 2");
    }

    @Test
    @DisplayName("precondition=>a=4 AND b=5, sut=>Calcolatrice.add, postcondition=>a+b=9")
    void givenAddWhenA4AndB5ThenReturn9() {
        assertEquals(9, calcolatrice.add(4,5),"4 +5 should be 9");
    }

    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.div, postcondition=>Exception")
    void givenDivWhenA4AndB0ThenCalculatorException() {
        assertThrows(CalculatorException.class, () -> calcolatrice.div(9,0));
    }


    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.el, postcondition=>4^0=1")
    void givenElWhenA4AndB0ThenReturn1() {
        assertEquals(1, calcolatrice.el(4,0),"4^0 should be 1");
    }

    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.el, postcondition=>4^0!=0")
    void givenElWhenA4AndB0ThenNotReturn0() {
        assertNotEquals(0, calcolatrice.el(4,0),"4^0 should not be 0");
    }


    @Test
    @DisplayName("precondition=>a=10 , sut=>Calcolatrice.sqrt, postcondition=>sqrt(10)==3")
    void givenSqrtWhenMin10ThenReturnCalculatorException() {
        assertThrows(CalculatorException.class,()->calcolatrice.sqrt(-10));
    }

    @Test
    @DisplayName("precondition=>a=10 , sut=>Calcolatrice.sqrt, postcondition=>sqrt(10)==3")
    void givenSqrtWhen10ThenReturn3() throws CalculatorException {
        assertEquals(3, calcolatrice.sqrt(10),"sqrt 10 sould be 3");
    }

    @ParameterizedTest(name="GivenFirstArgument {0} AndSecondArgument {1} WhenAddThenShouldReturn {2}")
    @CsvSource({
            "0,  1,  1",
            "0, -1, -1",
            "-50, 50,  0",
            Integer.MAX_VALUE+", "+ Integer.MAX_VALUE+", -2"
    })
    void addWithBvaValues(int first, int second, int expectedResult) {
        assertEquals(expectedResult, calcolatrice.add(first,second), ()->String.format("%d + %d should equals %d", first,second,expectedResult));
    }

}