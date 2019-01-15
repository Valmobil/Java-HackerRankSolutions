package arraySortBySwapping;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

public class Main {
    public static void main(String[] args) {
        String str = "1 3 5 2 4 6 7";
//        System.out.println(str);
        String[] arrStr = str.split(" ");
        int[] arr = Arrays.stream(arrStr).mapToInt(Integer::parseInt).toArray();

        System.out.println(minimumSwaps(arr));
    }

    // Complete the minimumSwaps function below.
    private static int minimumSwaps(int[] arr) {
        int count = 0;

        //Create sorted array
        int[] arrTemp;
        int sortedArrLengt = arr.length + 1;
        int[] arrSorted = new int[sortedArrLengt];
        Arrays.fill(arrSorted, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > sortedArrLengt) {
                sortedArrLengt = arr[i];
                arrTemp = arrSorted.clone();
                arrSorted = new int[sortedArrLengt + 1];
                Arrays.fill(arrSorted, -1);
                System.arraycopy(arrTemp, 0, arrSorted, 0, arrTemp.length);
            }
            arrSorted[arr[i]] = i;
        }
        //Swap array elements based on SortedArray
        int lastMin = Integer.MIN_VALUE;
        int arrIndex = 0;
        for (int i = 0; i < arrSorted.length - 1; i++) {
            if (arrSorted[i] != -1) {
                if (i != arr[arrIndex]) {
                    int tempIndex = arr[arrIndex];
                    swapTwoElements(arr, arrIndex, arrSorted[i]);
                    swapTwoElements(arrSorted, i, tempIndex);
                    count++;
                }
                arrIndex++;
            }
        }
//        System.out.println(Arrays.toString(arr));
        return count;
    }

    private static void swapTwoElements(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}