package utilsReadInputFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReadFromFile {

    public static List<Long> readFromFile(String pathPlusFileName, int parameterQty) {
        Scanner scanner = null;
        try {
//            scanner = new Scanner(new File("src/arraySumRows/input/input3.txt"));
            scanner = new Scanner(new File(pathPlusFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] parameters = new int[parameterQty];
        String[] nm = Objects.requireNonNull(scanner).nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int n = Integer.parseInt(nm[0]);
//        int m = Integer.parseInt(nm[1]);
//        long[] arr = new long[m];

//        for (int i = 0; i < m; i++) {
//        String[] queriesRowItems = scanner.nextLine().split(" ");
        List<Long> arr = new ArrayList<>();
        for (int i = 1; i < nm.length; i++) {
            long queriesItem = Long.parseLong(nm[i]);
            arr.add(queriesItem);
        }
        return arr;
    }

}
