package hashMapUnMergeShufleWord;

import org.junit.Test;

import static hashMapUnMergeShufleWord.Main.reverseShuffleMerge;
import static org.junit.Assert.*;

public class MainTest {


   String input = "bdabaceadaedaaaeaecdeadababdbeaeeacacaba"; //answer aaaaaabaaceededecbdb

    @Test
   public void testOne() {
            assertEquals("egg", reverseShuffleMerge("eggegg"));
    }

    @Test
    public void testTwo() {
        assertEquals("aeiou", reverseShuffleMerge("aeiouuoiea"));
    }

    @Test
    public void testThree() {
        assertEquals("agfedcb", reverseShuffleMerge("abcdefgabcdefg"));
    }

    @Test
    public void testFour() {
        assertEquals("aaaaaabaaceededecbdb", reverseShuffleMerge("bdabaceadaedaaaeaecdeadababdbeaeeacacaba"));
    }

    @Test
    public void testFive() {
        String input = "sbcnzxqnrygkocahxjebvueaawwcythjdrhvizqsshgtwdolmillxpshxpxqrywkivceufclhydhshrklkphajbftuapiocjlcthfirhgaohfysqjolssbzhbovdstbyqdpnjbpfmgqrzfctcwcrztvgbegunarvecseoulabaonguckqbtrvuagreyclyjytpvozqdnhldlnsocenuzksawirgsbjobpldjdlrxbricrauuksbmecvvwagnnacaqghmjpzrlsvlpbbcuaddgvlhvuvkxexjcfhxrodmcwlrzyyiksuksshhonahsyzbbprwuitmoyoqurtqsaslevgvpfbzkkhgcnpjdpseuiylluvdetsqssbrxpiclxxvosuqipsqvvwsezhl";
        String result = "aaaaaavvcembskuabxddlpbbsgiaskucosdlhndqzovpjlcyerauvrbcugnbluescevrnubgvtzrcwccfzrqgmfpbjnpdqybtsdvobhzsslojqsyfhoghrifhtclcoiputjhpklkrhsdyhlcuevikwyrqxpxhspxllimlowtghssqzivhrjtywweuvejxokgyrnqxzns";
        assertEquals(result, reverseShuffleMerge(input));
    }



}

