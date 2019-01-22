package sortCountInversions;

import org.junit.Test;

import static org.junit.Assert.*;
import static sortCountInversions.Main.countInversions;

public class MainTest {
    @Test
    public void testAscending() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5};
        assertEquals(0L, countInversions(arr));
    }

    @Test
    public void testDescending() {
        int[] arr = new int[]{5, 4, 3, 2, 1, 0};
        assertEquals(15L, countInversions(arr));
    }

    @Test
    public void testRandom() {
        int[] arr = new int[]{3, 1, 2, 5, 0, 4};
        assertEquals(7L, countInversions(arr));
    }

}