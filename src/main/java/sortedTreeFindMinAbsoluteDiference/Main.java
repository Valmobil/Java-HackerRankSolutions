package sortedTreeFindMinAbsoluteDiference;

import org.apache.commons.lang3.ObjectUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String str = "-59 -36 -13 1 -53 -92 -2 -96 -54 75";
//        String str = "1 -3 71 68 17";
        String str = "-3 -3 71 68 17 -3";

        String[] s = str.split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        System.out.println(minimumAbsoluteDifference(arr));

    }


    static int minimumAbsoluteDifference(int[] arr) {
        int minDistance = Integer.MAX_VALUE;

        TreeSet<Integer> hashSet = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            Integer ceiling = ObjectUtils.defaultIfNull(hashSet.ceiling(arr[i] + 1), Integer.MIN_VALUE);
            Integer floor = ObjectUtils.defaultIfNull(hashSet.floor(arr[i]), Integer.MIN_VALUE);
            hashSet.add(arr[i]);
            minDistance = Math.min(minDistance, Math.min(Math.abs(arr[i] - ceiling), Math.abs(arr[i] - floor)));
        }
        return minDistance;
    }

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifferenceOne(int[] arr) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                minDistance = Math.min(minDistance, Math.abs(arr[i] - arr[j]));
            }
        }
        return minDistance;
    }
}
