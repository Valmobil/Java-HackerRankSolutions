package dictionaryFrequencyQueuery;

import static java.util.stream.Collectors.joining;
import static rearInputFromString.rearInputFromString.convertString;

import java.io.*;
import java.sql.Time;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dictionaryFrequencyQueuery {
    public static void main(String[] args) {
        String str = "10\n" +
                "1 3\n" +
                "2 3\n" +
                "3 2\n" +
                "1 4\n" +
                "1 5\n" +
                "1 5\n" +
                "1 4\n" +
                "3 2\n" +
                "2 4\n" +
                "3 2";
        List<Object> list = convertString(str, true, 1, 2);
        int[][] body = (int[][]) list.get(1);
        long startTime = System.currentTimeMillis();
        System.out.println(freqQuery(body));
        long endTime = System.currentTimeMillis();
        System.out.printf("Time spend: %s ms", (endTime - startTime) );
    }

    public static List<Integer> freqQuery(int[][] queries) {
        Map<Integer, Integer> list = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 1) {
                //Add element
                if (list.containsKey(queries[i][1])) {
                    list.replace(queries[i][1], list.get(queries[i][1]) + 1);
                } else {
                    list.put(queries[i][1], 1);
                }
            } else if (queries[i][0] == 2) {
                //delete element
                Integer value = list.get(queries[i][1]);
                if (value != null) {
                    if (value == 1) {
                        list.remove(queries[i][1]);
                    } else {
                        list.replace(queries[i][1], list.get(queries[i][1]) - 1);
                    }
                }
            } else {
                if (list.containsValue(queries[i][1])) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }

        }
        return result;
    }

    public static void boilerPlate(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }

            List<Integer> ans = freqQuery(queries);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(joining("\n")) + "\n");
            }
        }
    }
}
