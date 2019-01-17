package dictionaryFrequencyQueuery;

import static arrayChangeArrayLength.arrayChangeArrayLength.arrayLengthChangeLowerBorder;
import static arrayChangeArrayLength.arrayChangeArrayLength.arrayLengthChangeUpperBorder;
import static java.util.stream.Collectors.joining;
import static rearInputFromString.rearInputFromString.convertString;

import java.io.*;
import java.util.*;

public class dictionaryFrequencyQueuery {
    public static void main(String[] args) {
        String str = "1000000\n" +
                "2 800117487\n" +
                "2 800117487\n" +
                "2 557532215\n" +
                "3 500250645\n" +
                "2 724521532\n" +
                "2 429271873\n" +
                "2 996800398\n" +
                "1 576598549\n" +
                "3 810692203\n" +
                "1 711969245\n" +
                "1 649255227\n" +
                "2 243728960\n" +
                "3 474467917\n" +
                "1 599562754\n" +
                "3 732623633\n" +
                "2 744039580\n" +
                "2 151800620\n" +
                "2 346333663\n" +
                "1 818719701\n" +
                "2 343410320\n" +
                "2 662633260\n" +
                "3 870941181\n" +
                "2 843937228\n" +
                "3 918908857\n" +
                "1 203600711";

        List<Object> list = convertString(str, true, 1, 2);
        int[][] body = (int[][]) list.get(1);
        long startTime = System.currentTimeMillis();
        System.out.println(freqQuery(body));
        long endTime = System.currentTimeMillis();
        System.out.printf("Time spend: %s ms", (endTime - startTime));
        System.out.println();
        startTime = System.currentTimeMillis();
        System.out.println(freqQueryHashMap(body));
        endTime = System.currentTimeMillis();
        System.out.printf("Time spend: %s ms", (endTime - startTime));
    }

    public static int[] arrayMinMaxIndexAmmendement(int[] list, int[] arrIndex, int newChallenge) {
        //Change low border of array
        if (newChallenge < arrIndex[0]) {
            System.out.println("Change border down:");
            System.out.printf("Min: %s Max: %s", arrIndex[0],arrIndex[1]);
            System.out.println();
            System.out.printf("Challange: %s", newChallenge);
            System.out.println();
            arrIndex[0] = Math.max(Math.min(newChallenge - 1000, arrIndex[0]), 0);
            list = arrayLengthChangeLowerBorder(list, arrIndex[1] - arrIndex[0]);
        }
        //Change upper border of array
        if (newChallenge - arrIndex[0] > list.length) {
            System.out.println("Change border up:");
            System.out.printf("Min: %s Max: %s", arrIndex[0],arrIndex[1]);
            System.out.println();
            System.out.printf("Challange: %s", newChallenge);
            System.out.println();
            arrIndex[1] = newChallenge + 1000;
            list = arrayLengthChangeUpperBorder(list, arrIndex[1] - arrIndex[0]);
        }
        return list;
    }

    public static List<Integer> freqQuery(int[][] queries) {
        int[] arrIndex = new int[2];
        arrIndex[0] = Math.max(0,queries[0][1] - 1000);
        arrIndex[1] = queries[0][1] + 1000;
        int minIndex = arrIndex[0];
        int[] list = new int[arrIndex[1] - arrIndex[0]];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            list = arrayMinMaxIndexAmmendement(list, arrIndex, queries[i][1]);
            minIndex = arrIndex[0];
            if (queries[i][0] == 1) {
                //Add element
                list[queries[i][1] - minIndex]++;
            } else if (queries[i][0] == 2) {
                //delete element
                if (list[queries[i][1] - minIndex] > 0) {
                    list[queries[i][1] - minIndex]--;
                }
            } else {
                int intToFind = queries[i][1];
                Integer intStream = (Integer) Arrays.stream(list)
                        .filter(x -> x == intToFind)
                        .findFirst()
                        .orElse(0);
                if (intStream > 0) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }
        return result;
    }


    public static List<Integer> freqQueryHashMap(int[][] queries) {
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
