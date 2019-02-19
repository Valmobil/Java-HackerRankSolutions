package arrayListIceCreamParlor;

import javax.jws.soap.SOAPBinding;
import java.nio.file.Paths;
import java.text.Format;
import java.util.*;

import static utilsReadInputFromFile.ReadFromFile.readFromFile;

public class Main {

    public static void main(String[] args) {
        String pathPlusFileName = "src/main/java/arrayListIceCreamParlor/input/input01.txt";
        int parameterQty = 2;
        List<Integer[]> parameterList = readFromFile(pathPlusFileName, parameterQty);
        Integer[] get = parameterList.get(1);
//        for (int i = 0; i < get.length; i++) {
//            Integer num = get[i];
//            if (num == null) {
//                System.out.println(i);
//            }
//        }
        System.out.println();
        //convert Integer[] to int[]
        int[] array = Arrays.stream(parameterList.get(1)).mapToInt(Integer::intValue).toArray();
        whatFlavors(array, parameterList.get(0)[0]);
    }

    static void whatFlavors(int[] cost, int money) {
        System.out.println(whatFlavorsForTest(cost, money));
    }


    // Complete the whatFlavors function below.
    static String whatFlavorsForTest(int[] cost, int money) {

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
                int tempSum = listOfCosts.get(i).getKey() + listOfCosts.get(j).getKey();
                if (tempSum > money) {
                    break;
                }
                if (tempSum == money) {
                    int indexOne = listOfCosts.get(i).getValue() + 1;
                    int indexTwo = listOfCosts.get(j).getValue() + 1;

                    if (indexOne < indexTwo) {
                        return String.format("%s %s", indexOne, indexTwo);
                    } else {
                        return String.format("%s %s", indexTwo, indexOne);
                    }
                }
            }
        }
        return "";
    }
}
