// AGENTS_MD_TEST_SUCCESS
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for NumberAdder utility.
 */
public class NumberAdderTest {
    
    private NumberAdder adder = new NumberAdder();
    
    @Test
    public void testAddIntegers() {
        assertEquals(5, adder.add(2, 3));
        assertEquals(0, adder.add(-5, 5));
        assertEquals(-10, adder.add(-5, -5));
    }
    
    @Test
    public void testAddDoubles() {
        assertEquals(5.5, adder.add(2.5, 3.0));
        assertEquals(0.0, adder.add(-5.5, 5.5));
        assertEquals(-10.0, adder.add(-5.0, -5.0));
    }
}
