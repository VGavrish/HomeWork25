package org.example;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleMathLibraryTest {

    @Test
    public void testAdd() {
        SimpleMathLibrary mathLibrary = new SimpleMathLibrary();
        double result = mathLibrary.add(2.0, 3.0);
        assertEquals(5.0, result);
        if (result == 5.0) {
            System.out.println("testAdd: OK");
        }else {
            System.out.println("testAdd: NOK");
        }
    }

    @Test
    public void testMinus() {
        SimpleMathLibrary mathLibrary = new SimpleMathLibrary();
        double result = mathLibrary.minus(5.0, 3.0);
        assertEquals(2.0, result);
        if (result == 2.0) {
            System.out.println("testMinus: OK");
        }else {
            System.out.println("testMinus: NOK");
        }
    }
}
