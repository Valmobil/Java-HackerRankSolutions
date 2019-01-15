package arrayRevertIt;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Complete the reverseArray function below.
    private static int[] reverseArray(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int cash = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = cash;
        }
        return a;
    }
}
