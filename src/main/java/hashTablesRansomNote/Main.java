package hashTablesRansomNote;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        String magazin = "two times three is not four";
        String note = "two times is four";

        checkMagazine(magazin.split(" "), note.split(" "));
    }


    // Complete the checkMagazine function below.
    private static void checkMagazine(String[] magazine, String[] note) {
        //build hash table
        Hashtable<String, Integer> magTable = convertToHashTable(magazine);
        Hashtable<String, Integer> notTable = convertToHashTable(note);
        String result = "Yes";
        for (String s: notTable.keySet()) {
            if (magTable.containsKey(s)) {
                if (notTable.get(s) > magTable.get(s)) {
                    result = "No";
                    break;
                }
            } else {
                result = "No";
                break;
            }
        }
        System.out.println(result);
    }

    private static Hashtable<String, Integer> convertToHashTable(String[] arr) {
        Hashtable<String, Integer> magTable = new Hashtable<>();
        for (String s : arr) {
            if (magTable.containsKey(s)) {
                magTable.put(s, magTable.get(s) + 1);
            } else {
                magTable.put(s, 1);
            }
        }
        return magTable;
    }
}
