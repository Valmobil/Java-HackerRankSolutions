package arrayAbsoluteDiference;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String str = "-59 -36 -13 1 -53 -92 -2 -96 -54 75";
        String str = "1 -3 71 68 17";

        String[] s = str.split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        System.out.println(minimumAbsoluteDifference(arr));

    }

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                minDistance = Math.min(minDistance,Math.abs(arr[i] - arr[j]));
            }
        }
        return minDistance;
    }
}
