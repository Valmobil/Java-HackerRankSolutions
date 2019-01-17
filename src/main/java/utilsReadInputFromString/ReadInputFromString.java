package utilsReadInputFromString;

import java.util.ArrayList;
import java.util.List;

public class ReadInputFromString {


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
        System.out.println(convertString(str, true, 1, 2));
    }

    public static List<Object> convertString(String str, Boolean newLine, int leadingParameters, int arraySizeInBody) {
        List list = new ArrayList<>();
        int leadingInput = 0;
        //For parameters
        if (leadingParameters > 0) {
            list.add(new int[leadingParameters]);
        }
        //for body
        //create int array with initial size 10 ana increase size each 10 items
        int arrayStepIncreaseSize = 5;
        int[][] body1 = new int[arrayStepIncreaseSize][arraySizeInBody];
        int[][] body2;
        int[][] bodyArray = body1;
        int arraySize = 0;
        if (newLine) {
            for (String s : str.split("\\n")) {
                if (leadingInput < leadingParameters) {
                    int[] tempArr = (int[]) list.get(0);
                    tempArr[leadingInput] = Integer.parseInt(s);
                    leadingInput++;
                } else {
                    //for body
                    if (bodyArray.length <= arraySize) {
                        body2 = body1;
                        body1 = new int[body2.length + arrayStepIncreaseSize][];
                        for (int i = body2.length; i < body2.length + arrayStepIncreaseSize; i++) {
                            body1[i] = new int[]{0, 0};
                        }
                        System.arraycopy(body2, 0, body1, 0, body2.length);
                        bodyArray = body1;
                    }
                    String txt[] = s.split(" ");
                    for (int i = 0; i < arraySizeInBody; i++) {
                        bodyArray[arraySize][i] = Integer.parseInt(txt[i]);
                    }
                    arraySize++;
                }
            }
            body1 = new int[arraySize][];
            System.arraycopy(bodyArray, 0, body1, 0, arraySize);
            list.add(body1);
        }
        return list;
    }
}

