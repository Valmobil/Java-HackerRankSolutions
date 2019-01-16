package dictionaryFrequencyQueueryTest;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dictionaryFrequencyQueuery.dictionaryFrequencyQueuery.freqQuery;
import static rearInputFromString.rearInputFromString.convertString;

public class dictionaryFrequencyQueueryTest {
    @Test
    public void testOne() {
        String str = "8\n" +
                "1 5\n" +
                "1 6\n" +
                "3 2\n" +
                "1 10\n" +
                "1 10\n" +
                "1 6\n" +
                "2 5\n" +
                "3 2";

        List<Integer> answer = new ArrayList<>(Arrays.asList(0, 1));

        List<Object> list = convertString(str, true, 1, 2);
        int[][] body = (int[][]) list.get(1);
        List<Integer> result = freqQuery(body);

        Assert.assertTrue(answer .equals(result));
    }
}