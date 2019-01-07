package hashMapFindTripleIndex;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static readInputFromFile.ReadFromFile.readFromFile;

public class Main {


    public static void main(String[] args) {


        //Manual input
//        String test = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
//        String test = "1 2 2 2 3 4 8";
//        String test = "1 1 1 1 1 2 2 2 2 2";
//        String[] arrString = test.split(" ");
//        long[] arrInt = new long[100000];
//        Arrays.fill(arrInt, 1);
//        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
//        List<Long> longList = Arrays.stream(arrInt).boxed().collect(Collectors.toList());
//        List<Long> longList = Arrays.asList(arrInt);

        //Input From File
        List<Long> arr = readFromFile("src/hashMapFindTripleIndex/input/input4.txt");

        System.out.println(countTriplets(arr, 3L));
//        System.out.println(countTripletsOld(arr, 1L));
    }


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
//        int numberOfLevels = 3;
        long count = 0;
        Map<Long, long[]> arrLevel1 = new LinkedHashMap<>();
//        Long curMinValueLevel = Long.MIN_VALUE;
        long prevValue = 0L;
        long repetitiveCount = 0L;
        for (Long element : arr) {
            if (element.equals(prevValue)) {
                repetitiveCount++;
                continue;
            } else {
                if (repetitiveCount > 0) {
                    addElement(prevValue, repetitiveCount, r, arrLevel1);
                    repetitiveCount = 0L;
                }
                addElement(element, 1L, r, arrLevel1);
                prevValue = element;
            }
//            if (arrLevel1.size() > 100) {
//                System.out.println();
//            }
        }
        if (repetitiveCount > 0) {
            addElement(prevValue, repetitiveCount, r, arrLevel1);
        }
        //Count Calculation

        for (Map.Entry<Long, long[]> entryLevel1 : arrLevel1.entrySet()) {
            Long entryValueLevel1 = entryLevel1.getValue()[0];
            Long entryValueLevel2 = entryLevel1.getValue()[1];
            Long entryValueLevel3 = entryLevel1.getValue()[2];
            if (entryValueLevel1.equals(entryValueLevel2) && entryValueLevel2.equals(entryValueLevel3)) {
                count += (entryValueLevel1 * (entryValueLevel1 - 1) * (entryValueLevel1 - 2)) / 6;
            } else {
                count += entryValueLevel3 * entryValueLevel2 * entryValueLevel1;
            }
        }
        return count;
    }

    public static void addElement(Long element, Long repetitiveCount, Long r, Map<Long, long[]> arrLevel1) {
        //Possible improvement:
        //remove 2 maps
        //Level 1
        if (arrLevel1.containsKey(element)) {
            long[] tempArr = arrLevel1.get(element);
            tempArr[0]+=repetitiveCount;
        } else {
            arrLevel1.put(element, new long[]{1L, 0L, 0L});
        }
        //Level 2
        Long elementMinus1 = element / r;
        if (arrLevel1.containsKey(elementMinus1) && elementMinus1*r == element) {
            long[] tempArr = arrLevel1.get(elementMinus1);
            tempArr[1]+=repetitiveCount;
        }
        //Level 3
        Long elementMinus2 = elementMinus1 / r;
        if (arrLevel1.containsKey(elementMinus2) && elementMinus2*r == elementMinus1) {
            long[] tempArr = arrLevel1.get(elementMinus2);
            tempArr[2]+=repetitiveCount;
        }
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