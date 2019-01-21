package sort22MergeSort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static sort22MergeSort.Main.mergeSort;

public class MainTest {
    @Test
    public void testAscending() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5};
        mergeSort(arr, 0, 5);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, Arrays.stream( arr ).boxed().toArray( Integer[]::new ));
    }
    @Test
    public void testDescending() {
        int[] arr = new int[]{5, 4, 3, 2, 1, 0};
        mergeSort(arr, 0, 5);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, Arrays.stream( arr ).boxed().toArray( Integer[]::new ));
    }
    @Test
    public void testRandom() {
        int[] arr = new int[]{3, 1, 2, 5, 0, 4};
        mergeSort(arr, 0, 5);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, Arrays.stream( arr ).boxed().toArray( Integer[]::new ));
    }
}