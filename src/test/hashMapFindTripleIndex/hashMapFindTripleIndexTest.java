package hashMapFindTripleIndex;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static hashMapFindTripleIndex.Main.countTriplets;

public class hashMapFindTripleIndexTest {

    @Test
    public void testSimpleOne() {
        String test = "1 2 1 2 4";
        int r = 2;
        int answer = 3;
        String[] arrString = test.split(" ");
        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
        Assert.assertEquals(answer, countTriplets(arr, r));
    }

    @Test
    public void testSimpleSecond() {
        String test = "1 2 3 4";
        int r = 2;
        int answer = 1;
        String[] arrString = test.split(" ");
        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
        Assert.assertEquals(answer, countTriplets(arr, r));
    }


    @Test
    public void testSimpleThird() {
        String test = "1 2 4 2 4 8 1 2 4 8";
        int r = 2;
        int answer = 16;
        String[] arrString = test.split(" ");
        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
        Assert.assertEquals(answer, countTriplets(arr, r));
    }

    @Test
    public void testSimpleFourth() {
        String test = "1 1 1 1 1";
        int r = 1;
        int answer = 10;
        String[] arrString = test.split(" ");
        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
        Assert.assertEquals(answer, countTriplets(arr, r));
    }


       @Test
    public void testSimpleFifth() {
        String test = "1 5 5 25 125";
        int r = 5;
        int answer = 4;
        String[] arrString = test.split(" ");
        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
        Assert.assertEquals(answer, countTriplets(arr, r));
    }

    @Test
    public void testSimpleSixth() {
        String test = "6 2 18 6 2";
        int r = 3;
        int answer = 0;
        String[] arrString = test.split(" ");
        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
        Assert.assertEquals(answer, countTriplets(arr, r));
    }


}
