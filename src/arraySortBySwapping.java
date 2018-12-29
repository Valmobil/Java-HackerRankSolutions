import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class arraySortBySwapping {
    public static void main(String[] args) {
        String str = "1 3 5 2 4 6 8";
        String[] arrStr = str.split(" ");
        int[] arr = Arrays.stream(arrStr).mapToInt(num -> Integer.parseInt(num)).toArray();
        System.out.println(minimumSwaps(arr));
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != i+1) {
                Integer finalI = i+1;
                int index = IntStream.range(0, arr.length).filter(t -> arr[t] == finalI).findFirst().orElse(-1);
                swapTwoElements(arr,i,index);
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return count;
    }

    private static void swapTwoElements(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index ] = temp;
    }
}