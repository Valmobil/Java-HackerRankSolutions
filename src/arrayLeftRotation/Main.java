package arrayLeftRotation;

import java.io.BufferedWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int rotationNumber = 2;
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(rotLeft(arr, rotationNumber)));

        int[] result = rotLeft(arr, rotationNumber);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

    }
    static int[] rotLeft(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            int tempInt = a[0];
            for (int j = 0; j < a.length-1; j++) {
                a[j] = a[j+1];
            }
            a[a.length-1] = tempInt;
        }
        return a;
    }
}
