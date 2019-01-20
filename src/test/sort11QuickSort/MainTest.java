package sort11QuickSort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static sort11QuickSort.Main.quickSort;

public class MainTest {
    @Test
    public void testAscending() {
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, Arrays.stream( quickSort(new int[]{0, 1, 2, 3, 4, 5}, 0, 5) ).boxed().toArray( Integer[]::new ));
    }

    @Test
    public void testDescending() {
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, Arrays.stream( quickSort(new int[]{5, 4, 3, 2, 1, 0}, 0, 5) ).boxed().toArray( Integer[]::new ));
    }
    @Test
    public void testRandom() {
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, Arrays.stream( quickSort(new int[]{3, 1, 2, 5, 0, 4}, 0, 5) ).boxed().toArray( Integer[]::new ));
    }
}