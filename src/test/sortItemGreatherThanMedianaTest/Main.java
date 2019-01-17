package sortItemGreatherThanMedianaTest;

import org.junit.Assert;
import org.junit.Test;

import static sortItemGretherThenMediana.Main.activityNotifications;

public class Main {

    @Test
    public void testOne() {

        int count = 5;
        int[] arr = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int answer = 2;
        Assert.assertEquals(activityNotifications(arr,count),answer);
    }
}
