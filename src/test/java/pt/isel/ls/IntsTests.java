package pt.isel.ls;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntsTests {

    @Test
    public void max_returns_greatest(){
        assertEquals(1, Ints.max(1, -2));
        assertEquals(1, Ints.max(-2,1));
        assertEquals(-1, Ints.max(-1,-2));
        assertEquals(-1, Ints.max(-2,-1));
    }

    @Test
    public void indexOfBinary_returns_negative_if_not_found(){
        // Arrange
        int[] v = {1,2,3};

        // Act
        int ix = Ints.indexOfBinary(v,0,3,4);

        // Assert
        assertTrue(ix < 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void indexOfBinary_throws_IllegalArgumentException_if_indexes_are_not_valid(){
        // Arrange
        int[] v = {1,2,3};

        // Act
        int ix = Ints.indexOfBinary(v, 2, 1, 4);

        // Assert
        assertTrue(ix < 0);
    }

    @Test
    public void indexOfBinary_right_bound_parameter_is_exclusive(){
        int[] v = {2,2,2};
        int ix = Ints.indexOfBinary(v, 1, 1, 2);
        assertTrue(ix < 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void indexOfBinary_throws_IllegalArgumentException_if_empty_array(){
        int[]v = {};
        int ix = Ints.indexOfBinary(v,0,2,4);
        assertTrue(ix<0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void indexOfBinary_throws_IllegalArgumentException_if_right_bound_exceeds_length(){
        int[]v = {1,2,3};
        int ix = Ints.indexOfBinary(v,0,10,1);
        assertTrue(ix<0);
    }

    @Test
    public void indexOfBinary_returns_positive_on_even_array(){
        int[]v = {0,1,2,3};
        int ix= Ints.indexOfBinary(v,0,v.length,1);
        assertEquals(1,ix);
    }
}