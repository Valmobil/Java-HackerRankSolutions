package hashMapFindTripleIndex;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {


        //Manual input
//        String test = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
//        String test = "1 2 2 2 3 4 8";
//        String test = "1 1 1 1 1 2 2 2 2 2";
        String test = "1 2 4 2 4 8 1 2 4 2";
        String[] arrString = test.split(" ");
//        long[] arrInt = new long[100000];
//        Arrays.fill(arrInt, 1);
        List<Long> arr = Stream.of(arrString).map(Long::valueOf).collect(Collectors.toList());
//        List<Long> longList = Arrays.stream(arrInt).boxed().collect(Collectors.toList());
//        List<Long> longList = Arrays.asList(arrInt);

        //Input From File
//        List<Long> arr = readFromFile("src/hashMapFindTripleIndex/input/input4.txt");

        System.out.println(countTriplets(arr, 2L));
//        System.out.println(countTripletsOld(arr, 1L));
    }


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
//        int numberOfLevels = 3;
        long count = 0;
        Map<Long, List<long[]>> arrLevel = new LinkedHashMap<>();
//        Long curMinValueLevel = Long.MIN_VALUE;
        long prevValue = 0L;
        long repetitiveCount = 0L;
        for (Long element : arr) {
            if (element.equals(prevValue)) {
                repetitiveCount++;
                continue;
            } else {
                if (repetitiveCount > 0) {
                    addElement(prevValue, repetitiveCount, r, arrLevel);
                    repetitiveCount = 0L;
                }
                addElement(element, 1L, r, arrLevel);
                prevValue = element;
            }
//            if (arrLevel1.size() > 100) {
//                System.out.println();
//            }
        }
        if (repetitiveCount > 0) {
            addElement(prevValue, repetitiveCount, r, arrLevel);
        }
        //Count Calculation

//        for (Map.Entry<Long, long[]> entryLevel1 : arrLevel.entrySet()) {
//            Long entryValueLevel1 = entryLevel1.getValue()[0];
//            Long entryValueLevel2 = entryLevel1.getValue()[1];
//            Long entryValueLevel3 = entryLevel1.getValue()[2];
//            if (entryValueLevel1.equals(entryValueLevel2) && entryValueLevel2.equals(entryValueLevel3)) {
//                count += (entryValueLevel1 * (entryValueLevel1 - 1) * (entryValueLevel1 - 2)) / 6;
//            } else {
//                count += entryValueLevel3 * entryValueLevel2 * entryValueLevel1;
//            }
//        }
        return count;
    }

    public static void addElement(Long element, Long repetitiveCount, Long r, Map<Long, List<long[]>> arrLevel) {
        //Level 1
        boolean needCreateNewLine;
        long level1Index;
        if (arrLevel.containsKey(element)) {
            List<long[]> tempArr = arrLevel.get(element);
            needCreateNewLine = true;
            level1Index = 0;
            for (int i = 0; i < tempArr.size(); i++) {
                if (level1Index != tempArr.get(i)[3] && needCreateNewLine ) {
                    tempArr.add(i, new long[]{repetitiveCount, 0L, 0L, level1Index});
                    i++;
                    needCreateNewLine = true;
                }
                if (tempArr.get(i)[1] == 0) {
                    tempArr.get(i)[0] += repetitiveCount;
                    needCreateNewLine = false;
                }
                level1Index = tempArr.get(i)[3];
            }
        } else {
            arrLevel.put(element, new ArrayList<long[]>());
            arrLevel.get(element).add(new long[]{repetitiveCount, 0L, 0L, 0L});
        }
//        //Level 2
//        Long elementMinus1 = element / r;
//        needCreateNewLineLastQty = 0;
//        if (arrLevel.containsKey(elementMinus1) && elementMinus1 * r == element) {
//            List<long[]> tempArr = arrLevel.get(elementMinus1);
////            needCreateNewLine = true;
//            for (int i = 0; i < tempArr.size(); i++) {
//                needCreateNewLineLastQty = tempArr.get(i)[0];
//                if (tempArr.get(i)[2] == 0) {
//                    tempArr.get(i)[1] += repetitiveCount;
////                    needCreateNewLine = false;
//                }
//            }
////            if (needCreateNewLine) {
////                tempArr.add(new long[]{needCreateNewLineLastQty, repetitiveCount, 0L});
//        }
//    }
//
////    Level 3
//    Long elementMinus2 = elementMinus1 / r;
//        if(arrLevel.containsKey(elementMinus2)&&elementMinus2 *r ==elementMinus1)
//
//    {
//        List<long[]> tempArr = arrLevel.get(elementMinus2);
//
//        for (int i = 0; i < tempArr.size(); i++) {
//            tempArr.get(i)[2] += repetitiveCount;
//        }
    }


//    static long countTripletsOld(List<Long> arr, long r) {
//        List<Long> arrList = new ArrayList(arr);
//        long count = 0;
//        long resLevel = 0;
//        for (int i = 0; i < arrList.size(); i++) {
//            for (int j = i + 1; j < arrList.size(); j++) {
//                resLevel = arrList.get(i) * r;
//                if (resLevel < arrList.get(j)) break;
//                if (resLevel == arrList.get(j)) {
//                    for (int k = j + 1; k < arrList.size(); k++) {
//                        resLevel = arrList.get(j) * r;
//                        if (resLevel < arrList.get(k)) break;
//                        if (resLevel == arrList.get(k)) {
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }
}