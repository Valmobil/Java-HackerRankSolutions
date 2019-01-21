package sort22MergeSort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int[] arr;
        arr = IntStream.generate(() -> new Random().nextInt(100) + 50).limit(20).toArray();
//        arr = new int[]{0, 1, 2, 3, 4, 5};
//        arr = new int[]{5, 4, 3, 2, 1, 0};
//        arr = new int[]{3, 1, 2, 5, 0, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    static void mergeSort(int[] arr, int start, int end) {
        //Recursion Exit conditions
        if (start == end) {
            return;
        } else {
            if (end - start == 1 && arr[end] >= arr[start]) {
                return;
            }
        }
        //Split on two parts
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        //Merge two parts
        int i = start;
        int j = mid + 1;
        int[] tempArr = new int[end - start + 1];
        for (int k = 0; k < tempArr.length; k++) {
            if (arr[i] <= arr[j]) {
                tempArr[k] = arr[i];
                i++;
            } else {
                tempArr[k] = arr[j];
                j++;
            }
            if (i == mid+1) {
                for (int l = j; l <= end; l++) {
                    k++;
                    tempArr[k] = arr[j];
                    j++;
                }
                break;
            }
            if (j == end + 1) {
                for (int l = i; l < mid+1 ; l++) {
                    k++;
                    tempArr[k] = arr[i];
                    i++;
                }
                break;
            }
        }
        System.arraycopy(tempArr,0,arr,start,end-start+1);
    }
}
