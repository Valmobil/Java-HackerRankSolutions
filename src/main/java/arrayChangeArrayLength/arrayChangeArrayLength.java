package arrayChangeArrayLength;

import java.util.Arrays;

public class arrayChangeArrayLength {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.deepToString(new int[][]{arr}));
        arr = arrayLengthChangeUpperBorder(arr,10);
        System.out.println(Arrays.deepToString(new int[][]{arr}));

    }

    public static int[] arrayLengthChangeUpperBorder(int[] arr, int newLength) {
        int[] arrNew = new int[newLength];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        return arrNew;
    }
    public static int[] arrayLengthChangeLowerBorder(int[] arr, int newLength) {
        int change = newLength - arr.length;
        int[] arrNew = new int[newLength];
        System.arraycopy(arr, 0, arrNew, change, arr.length);
        return arrNew;
    }
}
