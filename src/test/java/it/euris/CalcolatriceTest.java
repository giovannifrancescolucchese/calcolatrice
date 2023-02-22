package it.euris;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcolatriceTest {

    @Test
    @DisplayName("1 + 1 = 2")
    void addTwoNumbers() {
        Calcolatrice calcolatrice=new Calcolatrice();
        assertEquals(2, calcolatrice.add(1,1),"1 +1 should be 2");
    }

}