package arrayAbsoluteDiference;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static arrayAbsoluteDiference.Main.minimumAbsoluteDifference;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testOne() {
        String str = "1 -3 71 68 17";
        String[] s = str.split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        Assert.assertEquals(minimumAbsoluteDifference(arr), 3);
    }


    @Test
    public void testTwo() {
        String str = "-59 -36 -13 1 -53 -92 -2 -96 -54 75";
        String[] s = str.split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        Assert.assertEquals(minimumAbsoluteDifference(arr), 1);
    }

}