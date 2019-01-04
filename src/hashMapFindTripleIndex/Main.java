package hashMapFindTripleIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        String test = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
        String test = "1 1 1 1 1";
        String[] arr = test.split(" ");
        List<Long> longList = Stream.of(arr).map(Long::valueOf).collect(Collectors.toList());
        System.out.println(countTriplets(longList, 1L));
    }


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        List<Long> arrList = new ArrayList(arr);
        long count = 0;
        long resLevel = 0;
        for (int i = 0; i < arrList.size(); i++) {
            for (int j = i + 1; j < arrList.size(); j++) {
                resLevel = arrList.get(i) * r;
                if (resLevel < arrList.get(j)) break;
                if (resLevel == arrList.get(j)) {
                    for (int k = j + 1; k < arrList.size(); k++) {
                        resLevel = arrList.get(j) * r;
                        if (resLevel < arrList.get(k)) break;
                        if (resLevel == arrList.get(k)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
