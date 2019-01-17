package hashMapFindTripleIndex;

import java.util.*;

import static utilsReadInputFromFile.ReadFromFile.readFromFile;

public class Main {


    public static void main(String[] args) {


        //Manual input
//        String test = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
//        String test = "1 2 4 2 4 8 1 2 4 8";
//        String test = "1 2 2 4";

//        String[] arrString = test.split(" ");
        int r = 3;
//        long[] arrInt = new long[100000];
//        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
//        List<Long> longList = Arrays.stream(arrInt).boxed().collect(Collectors.toList());

        //Input From File
        List<Long> arr = readFromFile("src/main/java/hashMapFindTripleIndex/input/input4.txt");
        System.out.println(countTriplets(arr, r));
    }


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Map<Long, Long[]> arrLevel = new LinkedHashMap<>();
        long prevValue = 0L;
        long repetitiveCount = 0L;
        for (Long element : arr) {
            if (element.equals(prevValue)) {
                repetitiveCount++;
            } else {
                if (repetitiveCount > 0) {
                    addElement(prevValue, repetitiveCount, r, arrLevel);
                    repetitiveCount = 0L;
                }
                addElement(element, 1L, r, arrLevel);
                prevValue = element;
            }
        }
        if (repetitiveCount > 0) {
            addElement(prevValue, repetitiveCount, r, arrLevel);
        }

        //Count Calculation
        for (Map.Entry<Long, Long[]> entryLevel1 : arrLevel.entrySet()) {
            Long entryValueLevel1 = entryLevel1.getValue()[0];
            Long entryValueLevel3 = entryLevel1.getValue()[2];
            if (r == 1) {
                count += (entryValueLevel1 * (entryValueLevel1 - 1) * (entryValueLevel1 - 2)) / 6;
            } else {
                count += entryValueLevel3;
            }
        }
        return count;
    }


    static void addElement(Long element, Long repetitiveCount, Long r, Map<Long, Long[]> arrLevel) {
        //Level 1
        if (arrLevel.containsKey(element)) {
            Long[] tempArr = arrLevel.get(element);
            tempArr[0] += repetitiveCount;
        } else {
            arrLevel.put(element, new Long[]{repetitiveCount, 0L, 0L});
        }
        //Level 2
        Long elementMinus1 = element / r;
        if (arrLevel.containsKey(elementMinus1) && elementMinus1 * r == element) {
            Long[] tempArr = arrLevel.get(elementMinus1);
            tempArr[1] += repetitiveCount * tempArr[0];
        }
        //    Level 3
        Long elementMinus2 = elementMinus1 / r;
        if (arrLevel.containsKey(elementMinus2) && elementMinus2 * r *r == element) {
            Long[] tempArr = arrLevel.get(elementMinus2);
//            if (elementMinus2 == 2) {
//                System.out.println();
//            }
            tempArr[2] += repetitiveCount * tempArr[1];
        }
    }


    static long countTripletsOld(List<Long> arr, long r) {
        List<Long> arrList = new ArrayList(arr);
        long count = 0;
        long resLevel = 0;
        for (int i = 0; i < arrList.size(); i++) {
            for (int j = i + 1; j < arrList.size(); j++) {
                resLevel = arrList.get(i) * r;
//              if (resLevel < arrList.get(j)) break;
                if (resLevel == arrList.get(j)) {
                    for (int k = j + 1; k < arrList.size(); k++) {
                        resLevel = arrList.get(j) * r;
//                      if (resLevel < arrList.get(k)) break;
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