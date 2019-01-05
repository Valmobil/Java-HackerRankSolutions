package hashMapFindTripleIndex;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {


//        System.out.println(factorial(100000L));


//        String test = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
//        String test = "1 2 2 2 3 4 8";
//        String test = "1 1 1 1 1 2 2 2 2 2";
//        String[] arr = test.split(" ");
        long[] arrInt = new long[100000];
        Arrays.fill(arrInt, 1);
//        List<Long> longList = Stream.of(arr).map(Long::valueOf).collect(Collectors.toList());
        List<Long> longList = Arrays.stream(arrInt).boxed().collect(Collectors.toList());
//        List<Long> longList = Arrays.asList(arrInt);
        System.out.println(countTriplets(longList, 1L));
        System.out.println(countTripletsOld(longList, 1L));

    }


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        int numberOfLevels = 3;
        long count = 0;
        Map<Long, Long> arrLevel1 = new LinkedHashMap<>();
        Map<Long, Long> arrLevel2 = new LinkedHashMap<>();
        Map<Long, Long> arrLevel3 = new LinkedHashMap<>();
//        Long curMinValueLevel = Long.MIN_VALUE;
        for (Long element : arr) {
            //Level 1
            if (arrLevel1.containsKey(element)) {
                arrLevel1.put(element, arrLevel1.get(element) + 1);
            } else {
                arrLevel1.put(element, 1L);
            }
            //Level 2
            for (Map.Entry<Long, Long> entryLevel1 : arrLevel1.entrySet()) {
                if (entryLevel1.getKey() * r == element) {
                    if (arrLevel2.containsKey(element)) {
                        arrLevel2.put(element, arrLevel2.get(element) + 1);
                    } else {
                        arrLevel2.put(element, 1L);
                    }
                }
            }
            //Level 3
            for (Map.Entry<Long, Long> entryLevel2 : arrLevel2.entrySet()) {
                if (entryLevel2.getKey() * r == element) {
                    if (arrLevel3.containsKey(element)) {
                        arrLevel3.put(element, arrLevel3.get(element) + 1);
                    } else {
                        arrLevel3.put(element, 1L);
                    }
                }
            }
        }
        //Count Calculation

        for (Map.Entry<Long, Long> entryLevel1 : arrLevel1.entrySet()) {
            Long entryValueLevel2 = arrLevel2.get(entryLevel1.getKey() * r);
            if (entryValueLevel2 == null) entryValueLevel2 = 0L;
            Long entryValueLevel3 = arrLevel3.get(entryLevel1.getKey() * r * r);
            if (entryValueLevel3 == null) entryValueLevel3 = 0L;
            if (entryLevel1.getValue().equals(entryValueLevel2) && entryValueLevel2.equals(entryValueLevel3)) {
                count = (factorial(entryLevel1.getValue()).divide(factorial(entryLevel1.getValue() - numberOfLevels).multiply(factorial((long) numberOfLevels)))).longValue();
            } else {
                count += entryValueLevel3 * entryValueLevel2 * entryLevel1.getValue();
            }
        }
        return count;
    }


    public static BigInteger factorial(Long number) {
        String value;

        BigInteger result = new BigInteger("" + 1);

        for (long factor = 2; factor <= number; factor++) {
            result = result.multiply(new BigInteger("" + factor));
        }

        return result;
    }

    static long countTripletsOld(List<Long> arr, long r) {
        List<Long> arrList = new ArrayList(arr);
        long count = 0;
        long resLevel = 0;
        for (int i = 0; i < arrList.size(); i++) {
            for (int j = i + 1; j < arrList.size(); j++) {
                resLevel = arrList.get(i) * r;
                if (resLevel < arrList.get(j)) break;
                if (resLevel == arrList.get(j)) {
                    for (int k = j + 1; k < arrList.size(); k++) {
                        resLevel = arrList.get(j) * r;
                        if (resLevel < arrList.get(k)) break;
                        if (resLevel == arrList.get(k)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}