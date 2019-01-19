package sortItemGretherThenMediana;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    // Complete the activityNotifications function below.
    public static int activityNotifications(int[] expenditure, int d) {
        int countInMedian = d;
        int count = 0;
        int medianItemIndex = 0;
        int medianItem = expenditure[0];
        TreeMap<Integer, Integer> array = new TreeMap<>();
        for (int i = 0; i < expenditure.length; i++) {
//            if (medianItem == 101) {
//                System.out.println();
//            }
            if (i == 10000) {
                System.out.println();
            }
            int item = expenditure[i];
            if (d == 0) {
                //Initial median calculation
                int sum = 0;
                for (Integer mapItem : array.keySet()) {
                    sum += array.get(mapItem);
                    if (sum > countInMedian / 2) {
                        medianItem = mapItem;
                        medianItemIndex = array.get(mapItem) - (sum - countInMedian / 2) + 1;
                        break;
                    }
                }
                d = -1;
            }
            if (d > 0) {
                if (array.containsKey(item)) {
                    array.replace(item, array.get(item) + 1);
                } else {
                    array.put(item, 1);
                }
                d--;
            } else {
                System.out.print(medianItem + " ");
                if (medianItem * 2 <= item) {
                    count++;
                }
                //update array
                int intToDelete;
                intToDelete = expenditure[i - countInMedian];
                //delete element from MAP Array
                array.replace(intToDelete, array.get(intToDelete) - 1);
                //insert element to MAP Array
                if (array.containsKey(item)) {
                    array.replace(item, array.get(item) + 1);
                } else {
                    array.put(item, 1);
                }
                //Update median
                if (item != intToDelete) {
                    if (intToDelete <= medianItem && medianItem <= item) {
                        if (intToDelete != medianItem) {
                            medianItemIndex++;
                        }
                        if (medianItemIndex > array.get(medianItem)) {
                            do {
                                medianItem = array.ceilingKey(medianItem + 1);
                                medianItemIndex = array.get(medianItem);
                            } while (medianItemIndex == 0);
                            medianItemIndex = 1;
                        }
                    } else if (intToDelete >= medianItem && medianItem > item) {
                        medianItemIndex--;
                        while (medianItemIndex == 0) {
                            medianItem = array.floorKey(medianItem - 1);
                            medianItemIndex = array.get(medianItem);
                        }
                    }
                }
//                //Alternative median calculation
//                int sum = 0;
//                int medianNew = 0;
//                int medianIndexNew = 0;
//                for (Integer mapItem : array.keySet()) {
//                    sum += array.get(mapItem);
//                    if (sum > countInMedian / 2) {
//                        medianNew = mapItem;
//                        medianIndexNew = array.get(mapItem) - (sum - countInMedian / 2) + 1;
//                        break;
//                    }
//                }
//                if (medianItem != medianNew) {
//                    System.out.println();
//                }
//                if (medianIndexNew != medianItemIndex) {
//                    System.out.println();
//                }
            }
        }
        return count;
    }


    private static int activityNotificationsOld(int[] expenditure, int d) {
        int count = 0;
        int medianIndex = d / 2;
        int medianCurrent;
        Integer[] medianArray = new Integer[d];
        Queue<Integer> medianStack = new LinkedList();
        for (int item : expenditure) {
            if (d > 0) {
                medianStack.add(item);
                d--;
            } else {
                medianStack.toArray(medianArray);
                Arrays.sort(medianArray);
                medianCurrent = medianArray[medianIndex];
                System.out.print(medianCurrent + " ");
                if (medianCurrent * 2 <= item) {
                    count++;
                }
                medianStack.add(item);
                medianStack.poll();
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner;

        boolean readFromFile = true;
        if (readFromFile) {
            scanner = new Scanner(new File("src/main/java/sortItemGretherThenMediana/input/input.txt"));
        } else {
            String str = "5 3\n" +
                    "10 20 30 40 50";
            scanner = new Scanner(str);
        }
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }
//        for (int i = 10230; i < expenditure.length; i++) {
//            System.out.println("i=" + i);
            System.out.println("New one: " + activityNotifications(expenditure, d));
//            System.out.println("New one: " + activityNotifications(Arrays.copyOf(expenditure, i), d));
            System.out.println("Old one: " + activityNotificationsOld(expenditure, d));
//            System.out.println("Old one: " + activityNotificationsOld(Arrays.copyOf(expenditure, i), d));
//        }

//        System.out.println(result);

        scanner.close();
    }
}
