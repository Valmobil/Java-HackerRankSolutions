package arrayListIceCreamParlor;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String string = "1 4 5 3 2";
        int[] arr = Arrays.stream(string.split(" ")).mapToInt(Integer::parseInt).toArray();
        whatFlavors(arr, 4);
    }

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {

        //Sort list of flowers
        ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> listOfCosts = new ArrayList<>();
        for (int i = 0; i < cost.length; i++) {
            int oneCost = cost[i];
            listOfCosts.add(new AbstractMap.SimpleEntry<>(oneCost, i));
        }

        listOfCosts.sort(Comparator.comparingInt(AbstractMap.SimpleEntry::getKey));

        for (int i = 0; i < listOfCosts.size(); i++) {
            if (listOfCosts.get(i).getKey() > money) {
                break;
            }
            for (int j = i + 1; j < listOfCosts.size(); j++) {
                if (listOfCosts.get(j).getKey() > money) {
                    break;
                }
                if (listOfCosts.get(i).getKey() + listOfCosts.get(j).getKey() == money) {
                    int indexOne = listOfCosts.get(i).getValue() + 1;
                    int indexTwo = listOfCosts.get(j).getValue() + 1;

                    if (indexOne < indexTwo) {
                        System.out.printf("%s %s%n", indexOne, indexTwo);
                    } else {
                        System.out.printf("%s %s%n", indexTwo, indexOne);
                    }
                    return;
                }
            }
        }
    }
}
