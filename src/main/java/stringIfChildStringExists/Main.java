package stringIfChildStringExists;

import com.sun.corba.se.spi.ior.TaggedProfileTemplate;

import java.util.Collections;
import java.util.HashSet;

import static javafx.scene.input.KeyCode.T;

public class Main {
    public static void main(String[] args) {
//        System.out.println(commonChild("HARRY", "SALLY"));
//        System.out.println(commonChild("AA", "BB"));
//        System.out.println(commonChild("SHINCHAN", "NOHARAAA"));
        System.out.println(commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",  "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
    }

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int maxString = 0;

        //calculate max binary
        int maxBinary = (int) Math.pow(2, s1.length()) - 1;

        //Create dictionary from first string
        HashSet<String>[] hashSet = new HashSet[s1.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            hashSet[i] = new HashSet();
        }
        for (int i = 0; i < maxBinary; i++) {
            String str = Integer.toBinaryString(i + maxBinary + 1);
            StringBuilder sb = new StringBuilder(s1);
            for (int j = s1.length() - 1; j >= 0; j--) {
                if (str.charAt(j + 1) == '1') {
                    sb.delete(j, j + 1);
                }
            }
            hashSet[sb.length()].add(sb.toString());
        }
        //Parse second string and check if exists in hashSet
        for (int i = 0; i < maxBinary; i++) {
            String str = Integer.toBinaryString(i + maxBinary + 1);
//            System.out.println(str);
            StringBuilder sb = new StringBuilder(s2);
            for (int j = s1.length() - 1; j >= 0; j--) {
                if (str.charAt(j + 1) == '1') {
                    sb.delete(j, j + 1);
                }
            }
            if (sb.length() > maxString) {
                if (hashSet[sb.length()].contains(sb.toString())) {
                    maxString = Math.max(maxString, sb.length());
                    System.out.println(sb);
                }
            }
        }
        return maxString;
    }
}
