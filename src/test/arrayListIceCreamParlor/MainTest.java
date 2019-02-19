package arrayListIceCreamParlor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static arrayListIceCreamParlor.Main.whatFlavorsForTest;

public class MainTest {

    @Test
    public void test01() {
        String string = "1 4 5 3 2";
        int[] arr = Arrays.stream(string.split(" ")).mapToInt(Integer::parseInt).toArray();
        Assert.assertEquals("1 4", whatFlavorsForTest(arr, 4));
    }

}