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
        HashMap<Integer, Integer> listOfCosts = new HashMap();
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] < money) {
                int tempSum = money - cost[i];
                if (listOfCosts.containsKey(tempSum)) {
                    return String.format("%s %s", listOfCosts.get(tempSum) + 1, i + 1);
                } else {
                    listOfCosts.put(cost[i], i);
                }
            }
        }
        return "";
    }
}
