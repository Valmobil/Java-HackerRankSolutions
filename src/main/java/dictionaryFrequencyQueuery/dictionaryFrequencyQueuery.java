package dictionaryFrequencyQueuery;

import static rearInputFromString.rearInputFromString.convertString;

import java.util.ArrayList;
import java.util.List;

public class dictionaryFrequencyQueuery {
    public static void main(String[] args) {
        String str = "8\n" +
                "1 5\n" +
                "1 6\n" +
                "3 2\n" +
                "1 10\n" +
                "1 10\n" +
                "1 6\n" +
                "2 5\n" +
                "3 2";
        List<Object> list = convertString(str, true, 1, 2);
        List<List<Integer>> queries = new ArrayList<>();
        int[][] body = (int[][]) list.get(1);
        for (int i = 0; i < body.length ; i++) {
            queries.add(new ArrayList<>())
        }
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {


    }
}
