package sortItemGretherThenMediana;

import java.util.*;

public class Main {

    // Complete the activityNotifications function below.
    public static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        int medianIndex = d / 2;
        int medianCurrent = 0;
        Integer[] medianArray = new Integer[d];
        Queue medianStack = new LinkedList();
        for (int item : expenditure) {
            if (d > 0) {
                medianStack.add(item);
                d--;
            } else {
                medianStack.toArray(medianArray);
                Arrays.sort(medianArray);
                medianCurrent = medianArray[medianIndex];
                if (medianCurrent * 2 <= item) {
                    count++;
                }
                medianStack.add(item);
                medianStack.poll();
            }
        }
        return count;
    }

    public static void main(String[] args) {

        String str = "9 5\n" +
                "2 3 4 2 3 6 8 4 5";
        Scanner scanner = new Scanner(str);
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        scanner.close();
    }
}
