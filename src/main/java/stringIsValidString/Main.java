package stringIsValidString;

import com.google.common.base.Strings;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] str = new String[]{"aabbcd", "aabbccddeefghi", "abcdefghhgfedecba", "aaaabbcc"};
//        String[] str = new String[]{ "aaaabbcc"};
//        String[] str = new String[]{"aaaabbcc", "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"};

        Arrays.stream(str).forEach(p -> startMeth(p));
    }

    private static void startMeth(String s) {
        System.out.println(isValid(s));
    }

    // Complete the isValid function below.
    static String isValid(String s) {
        //Calculate q-ty of chars
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char chr : s.toCharArray()) {
            if (hashMap.containsKey(chr)) {
                hashMap.replace(chr, hashMap.get(chr) + 1);
            } else {
                hashMap.put(chr, 1);
            }
        }
        //Analize char quantity
        Map<Integer, Integer> res = new HashMap<>();
        for (Integer value : hashMap.values()) {
            if (res.containsKey(value)) {
                res.replace(value, res.get(value) + 1);
            } else {
                res.put(value, 1);
            }
            if (res.size() > 2) {
                return "NO";
            }
        }
        if (res.size() == 1) {
            return "YES";
        }


        Object[] keys = res.keySet().toArray();
        if (((int) keys[0] == 1 && res.get(keys[0]) == 1) || ((int) keys[1] == 1 && res.get(keys[1]) == 1)) {
            return "YES";
        } else if ((int) keys[0] - (int) keys[1] == 1 && res.get(keys[0]) == 1) {
            return "YES";
        } else if ((int) keys[1] - (int) keys[0] == 1 && res.get(keys[1]) == 1) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
