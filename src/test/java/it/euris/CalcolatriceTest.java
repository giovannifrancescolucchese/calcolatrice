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
    void givenBoth1AddWhenAddThenReturn2() throws CalculatorException {
        assertEquals(2, calcolatrice.add(1,1),"1 +1 should be 2");
    }

    @Test
    @DisplayName("precondition=>a=4 AND b=5, sut=>Calcolatrice.add, postcondition=>a+b=9")
    void givenA4AndB5WhenAddThenReturn9() throws CalculatorException {
        assertEquals(9, calcolatrice.add(4,5),"4 +5 should be 9");
    }

    @Test
    @DisplayName("precondition=>a=100 AND b=150, sut=>Calcolatrice.add, postcondition=>a+b=250")
    void givenA100AndB150WhenAddThenReturn250() throws CalculatorException {
        //arrange
        int a=100;
        int b=150;
        int expectedResult=250;
        //acts
        int result=calcolatrice.add(a,b);
        //assert
        assertEquals(expectedResult, result,"100 +150 should be 250");
    }


    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.div, postcondition=>Exception")
    void givenDivWhenA4AndB0ThenCalculatorException() {
        assertThrows(CalculatorException.class, () -> calcolatrice.div(9,0));
    }


    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.el, postcondition=>4^0=1")
    void givenElWhenA4AndB0ThenReturn1() throws CalculatorException {
        assertEquals(1, calcolatrice.el(4,0),"4^0 should be 1");
    }

    @Test
    @DisplayName("precondition=>a=4 AND b=0, sut=>Calcolatrice.el, postcondition=>4^0!=0")
    void givenElWhenA4AndB0ThenNotReturn0() throws CalculatorException {
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
            "-50, 50,  0"
    })
    void addWithBvaValues(int first, int second, int expectedResult) throws CalculatorException {
        assertEquals(expectedResult, calcolatrice.add(first,second), ()->String.format("%d + %d should equals %d", first,second,expectedResult));
    }


    @ParameterizedTest(name="GivenFirstArgument {0} AndSecondArgument {1} WhenMulThenShouldReturn {2}")
    @CsvSource({
            "0,  1,  0",
            "0, -1, 0",
            "-50, 50,  -2500"
    })
    void mulWithBvaValues(int first, int second, int expectedResult) throws CalculatorException {
        assertEquals(expectedResult, calcolatrice.mul(first,second), ()->String.format("%d + %d should equals %d", first,second,expectedResult));
    }


    @ParameterizedTest(name="GivenFirstArgument {0} AndSecondArgument {1} WhenElAforBThenShouldReturn {2}")
    @CsvSource({
            "0,  0,  1",
            //"0, -1, 0", errore
            "1, 1,  1",
            "1, 0,  1",
            "-5, 3, -125"
    })
    void elWithBvaValues(int first, int second, int expectedResult) throws CalculatorException {
        assertEquals(expectedResult, calcolatrice.el(first,second), ()->String.format("%d el %d should equals %d", first,second,expectedResult));
    }


    @Test
    @DisplayName("precondition (given) a=MaxValue and b=MaxValue when a for b then CalculatorException - Multiplication")
    void mulWithException() {
        //arrange
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        //act all'interno dell'assert
        //assert
        assertThrows(CalculatorException.class,()->calcolatrice.mul(a,b));
    }

    @Test
    @DisplayName("precondition (given) a=MaxValue and b=MaxValue when a for b then CalculatorException - Multiplication")
    void mulWithException2() {
        //arrange
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        //act
        CalculatorException ex=null;
        try {
            calcolatrice.mul(a,b);
        }
        catch (CalculatorException ce) {
            ex=ce;
        }
        //assert
        assertEquals(ex.getDescription(),"WRAP ROUNDING MOLTIPLICAZIONE ");
    }


    @Test
    @DisplayName("precondition (given) a=0 and b=-1 when elevation a for b then CalculatorException")
    void elWithException() {
        //arrange
        int a=0;
        int b=-1;
        //act all'interno dell'assert
        //assert
        assertThrows(CalculatorException.class,()->calcolatrice.el(a,b));
    }


}