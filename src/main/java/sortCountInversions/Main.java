package sortCountInversions;

import java.util.Arrays;
import java.util.List;

import static utilsReadInputFromFile.ReadFromFile.readFromFile;

public class Main {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{2, 1, 3, 1, 2};

//        List readFromFile = readFromFile("src/main/java/sortCountInversions/input/input1.txt", 2);
//        arr = (int[]) readFromFile.get(1);
        System.out.println(countInversions(arr));
    }

    static long countInversions(int[] arr) {
        long[] count = new long[]{0L};
        mergeSort(arr, count);
        return count[0];
    }

    private static int[] mergeSort(int[] arr, long[] count) {
        //exit from
        if (arr.length == 1) {
            return arr;
        } else {
            if (arr.length == 2 && arr[0] < arr[1]) {
                return arr;
            }
        }

        //split into two parts
        int mid = arr.length / 2;
        int[] arrLeft = mergeSort(Arrays.copyOfRange(arr, 0, mid), count);
        int[] arrRight = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), count);

        //Merge two parts
        return mergeSortingTwoArrays(arrLeft, arrRight, count);
    }

    private static int[] mergeSortingTwoArrays(int[] arr1, int[] arr2, long[] count) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                result[k] = arr2[j];
                j++;
                count[0] += arr1.length - i;
            } else {
                result[k] = arr1[i];
                i++;
            }
            k++;
        }
        for (int l = i; l < arr1.length; l++) {
            result[k] = arr1[l];
            k++;
        }
        for (int l = j; l < arr2.length; l++) {
            result[k] = arr2[l];
            k++;
        }
        return result;
    }


    // Complete the countInversions function below.
    static long countInversionsOld(int[] arr) {
        long count = 0;
        int minValue = arr[0];
        int minIndex = 0;
        int i = 1;
        while (i < arr.length) {
            while (i > 0 && arr[i] < arr[i - 1]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                count++;
                i--;
            }
            i++;
        }
        return count;
    }
}
