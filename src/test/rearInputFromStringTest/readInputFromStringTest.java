package rearInputFromStringTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static utilsReadInputFromString.ReadInputFromString.convertString;

public class readInputFromStringTest {

    @Test
    public void testStrinConvertion() {

        //String Sourth looks like
        String str = "8\n" +
                "1 5\n" +
                "1 6\n" +
                "3 2\n" +
                "1 10\n" +
                "1 10\n" +
                "1 6\n" +
                "2 5\n" +
                "3 2";

        List list = convertString(str, true, 1, 2);
        //read parameters
        int[] param = (int[]) list.get(0);
        Assert.assertEquals(param[0],8);

        //read body
        int[][] body = (int[][]) list.get(1);

        //check body array size
        Assert.assertEquals(body.length, 8);

        //check body array body
        Assert.assertArrayEquals(body, new int[][]{{1,5},{1,6},{3,2},{1,10},{1,10},{1,6},{2,5},{3,2}});
    }
}
