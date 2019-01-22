package utilsReadInputFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReadFromFile {

    public static List<Objects> readFromFile(String pathPlusFileName, int parameterQty) {
        Scanner scanner = null;
        try {
//            scanner = new Scanner(new File("src/arraySumRows/input/input3.txt"));
            scanner = new Scanner(new File(pathPlusFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] parameters = new int[parameterQty];
        for (int i = 0; i < parameterQty; i++) {
            String nm = Objects.requireNonNull(scanner).nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            parameters[i] = Integer.parseInt(nm);
        }
        int[] arr = new int[parameters[parameterQty-1]];
        String[] nm = Objects.requireNonNull(scanner).nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 1; i < nm.length; i++) {
            arr[i] = Integer.parseInt(nm[i]);
        }
        List result = new ArrayList<>();
        result.add(parameters);
        result.add(arr);

        return result;
    }
}

