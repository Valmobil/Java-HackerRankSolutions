package sort11QuickSort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Random int(s) from 100 to 150
        int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100) + 50).limit(5).toArray();
//        int[] randomIntsArray = new int[]{5, 4, 3, 2, 1, 0};
//        int[] randomIntsArray = new int[]{5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(randomIntsArray));
        System.out.println(Arrays.toString(quickSort(randomIntsArray, 0, randomIntsArray.length - 1)));
    }

    private static int[] quickSort(int[] arr, int ind1, int ind2) {
        if (ind2 - ind1 < 2) {
            if (arr[ind1] <= arr[ind2]) {
                return arr;
            }
        }
        int pivot = arr[ind2];
        int leftIndex = ind1;
        int rightIndex = ind2;
        int i = ind1;
        ind2--;
        while (i < ind2) {
            if (arr[i] > pivot) {
                while (arr[ind2] >= pivot) {
                    ind2--;
                    if (i == ind2) {
                        break;
                    }
                }
                if (arr[ind2] < pivot && i != ind2) {
                    int temp = arr[ind2];
                    arr[ind2] = arr[i];
                    arr[i] = temp;
                }
            } else {
                i++;
            }
        }
        if (arr[i] > pivot) {
            arr[rightIndex] = arr[i];
            arr[i] = pivot;
        }
        quickSort(arr, leftIndex, i);
        quickSort(arr, i + 1, rightIndex);
        return arr;
    }
}
