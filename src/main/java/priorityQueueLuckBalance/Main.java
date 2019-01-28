package priorityQueueLuckBalance;

import java.util.*;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) {
        String str = "8 5\n" +
                "13 1\n" +
                "10 1\n" +
                "9 1\n" +
                "8 1\n" +
                "13 1\n" +
                "12 1\n" +
                "18 1\n" +
                "13 1";
        Scanner scanner = new Scanner(str);
        String line = scanner.nextLine();
        int[] param = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[param[0]][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(luckBalance(param[1], arr));
    }

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int luck = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 1) {
                priorityQueue.add(contests[i][0]);
            }
            luck += contests[i][0];
        }
        int size = priorityQueue.size() - k;
        for (int i = 0; i < size; i++) {
            luck -=priorityQueue.poll()*2;
        }
        return luck;
    }
}
