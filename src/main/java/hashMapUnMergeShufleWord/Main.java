package hashMapUnMergeShufleWord;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        String input = "eggegg";
//        String input = "aeiouuoiea";
//        String input = "abcdefgabcdefg";
//        String input = "bdabaceadaedaaaeaecdeadababdbeaeeacacaba"; //answer aaaaaabaaceededecbdb
        String input ="ppzpzzzjzrzbzzpriirbbzizirbzrbpbzbbrzpjepzrzbbiibezbjeiebzebpjzerzpipbiezizzebeipzbrpbrzrbrzebipiziizrzbrebzrpezeerbzzejripebiibzpizrzpzzbrpbzezbzerjjjeipzirzzzeizbzjpzbijzeirepizpeizbzepjjzjiezbrbeziippzezbpezepzebzprziiiipbjepizzpipbzbziriibeieerrzzbeberebirrzzpiiebbpreijirzzzbepzbijizijzpepbepbiizezebbbbpbzrzizbbeibjpjiizbzeibizbzipzpzejizprbezbijbibepjbpbjezzirjizbbzpizzpbzbbrepbzzzzbreezipiizrrbzeepzppreeiijipbzrzjpiipeiizejzzzbibzbrjppjrzzzbbbbbbiizjeeeipjbrzibizzrejpzezjzzebzzjbbrjjrpeeiizjizzijzeziejeeeeireiebrrppzibbzizrzbiiizbjebeibzejpbizrziibbpiiezpjirjpjjizbbzbbbbizpbzibjirizzprirepziibbibiibzbezeezipjrbzeizjpepeibrzizeebbpjbibibizezzbrrbepzbippbipebbbrejeprierbzebrjbzrzzzbrebpbzrjiejzizbbrbbzbzzibbjzipbbpzzpbezerzzebbpibrijzrezizrezerbeirzbpbrbeiirpjzipziiirbziirizbzzbizzizjpjibzbijbrripziibbzjbibjzeizjjrbzjbibjzebzebijzpirbizizpbiibbjebiiiiebzbbzzrezezjizibiejzibjrbpribbbbbzzrpzjrrbbjibjprbieiezjbibpzbbzzibipzrebbizezibbbpizipbbrbzpieppzpiprrezeiprrbrbbibiebbbiiizzjzbezzrebeibzbzijbzzpzirirpiiiiezizbjbbzzbiizizjijzzzbbeizzzzzzbbebieijbzjizbbpzzizpeezbeeiribzizzeepzpbzziibjpeebijzizibzrzezbirirepzzzriipbibjirizzpjrzzjiizpejjjiberpzejijrjrzrzbbrjpzjbiebjzbbbzzjbbzepzrpizrrizzpzeeiieijbeiizzibbibjpbbippizijziirzrpeberrzezjrprpbrbbizipjzipjbbzbzpiirpjzbzbrzeizrzjzzjjebrzrizirzzieibpzbibeizbepbirbiibirjeibzizbzpzpzrrzzbpzzzpiziijizripbezipprrjbiejzzbjpepbjiirpipijiebibbbbijjpbiizpezrizibjzzrerjezepzeiijibriziizpizbzipberzbppjibipezbrbbrbijbeibzzzezizbipiiirpzippzejbiiijjjijrziribberzjzrebizijiiierzbjbrzrijrjrzrzzrbzjezzjjrzrjbrjiiiijepzijjbrzbbbbbpijjrjbzjjeiipipizbjijpzzbibjizipibeiizrbzpbbrreirjzzbiizzbezibjzjprzriijrprjbjezribiiriipibzppjeiiizbjbbjiezzjbibrizpjebjreerbrpjbrieejbbizjirizbrpijbjirbzjrezpzzbiijzrbzzbrerizpepzrjzzijzibejpjzppijpjrbpzzribbzzibrjzzrizzrzbbpirirpzzzzibbjibiijeiizipjbzejiijezzbijzbijbjbbpbezeijzbrebbepjbbbjprrrpebzrzizjziizrjiziiipiebpppjjipzziizbbrejzpzrrrbiziiiiiipjrbiebbijiibzizbbpzzizijjjirzzibejzijbzbjirpzpiriizppzpzeejizizbizzbbpjebzibbpbrbebzbzejiipezzeirieerrzirzbriirrrzjzibpziiribbejbjbepjbezipzzijbjzzrzrpieizbeizzzrizrripjzbjbzjziziiizzibziiijipziejbjjibjjzjzrzibpzzziipiijzjrrzzjbbrpbepipejezeibzezzjzezjzeeiepjbzjbzbjzbbieirbiriezzzbirirpizzzibbebjierjzipejbzerzizjpzbpbiiijiriizriiiepzpzirzbirerbrzebjibizizrbzjizbeeizibpbrrrbjrizizjbziebizijjpppibziezzrpirpbpbizpijpjeiizjibzebpbbrrziiizebbbibzpieipbepzbierbebzzbirbpbzbibiijbrbrzzbizjirzbzzbprizbjpzezpbzjzieiirbiiezezzjzpziijirjieeezbzzpzppjrzzpjzbibrrbbrbzzezbrpibrrbeeezirbzierrzebzjpjzbzbibipjbebejijziepzzizbizrzpziiiebebiireiebbzzzpeebbzizriiiibbbiibizprrjbibezzrbpzppirrpiireirrzbjperjzbjzeeejzzbeebiizibbeibbiribjibjjreepzrezijrbrzibzzjijipbbzzpbrzjzrjzzbziizripbjzzipebpzzebpjipbijrrrizbrppizbzbibbzbjpiepizrbpzzbpbprbzezpzirrbrzrbjzizijpzppjzirizrizbziberrziijebrrepribpjibbbpizibbijjzzipjirzrzepzirizbzzzijpzjierpiezbjjjpiiirppibzrbibzbppziiribbiejzebibjjzrzrjzzrzjibrzzibirjbpbpbiiiiiiizpbiiiebzjrziieezzzzizzirzzzibjbrzbirzzziprrjiibeizrjbiebzizzbizbpizziziipjibippiizzzpzrirjjiejjzejbipjibzbiiejiribjebrpirrrpiijpzizbeiezzrjbbbbjzbbbzibjrbbrrzzbbzrjrzzjbrjpzrjirjjrijrpieebrezipbebririiiiizeeiepbjbbbbbrrzbibbbibpizzppziiizeriipjizijrreprbijibrjejbzrzrzzziizbeirpreiizrbbirpjzjzzjrrzeibbbpzjijipizipzzbbebjzijbeziieizieieiebzrejzpzezizeizzpzeebzzziziibzepbbzzbiiriibrbzribejbjzbziiziezibibbzpizjzzizbzebieierpzebzijpizpbzzbbzzjpzizbrjziripbizzjijbjbrrzziiezzrirbjzzbiiibrizejiiiepjipbzbbbzzijjzziezejzberjzizzbzbbzepeibejjjpieibrpzpezrzbzzbprirrjzpjrbibjizppzbizzzrjrjerrrejibiezpzrbizbjzbbzjbjpirzrrizrpbpriiipbirbijprizzzziipbbbeijzpbzbebebbbbreizbebrrzbbjrzijiizpiijbribjbzzzzpzbzzbrbzezpiprjrpzbeezbzizezebjbbbizbjirpbziebbiibbeibzieezipjpbipzjbziiijpijijrzbzppiziiijrizibzzbzrzrjpzbibbjrzjbbiebzprzibbiebrzezpjzjbibrerbebzjzpbieijirzzbbrjezzrirzrirzzbjrpizbpebibebjezzbzjeieieizzbiezziziiripizizrrjiirbzjzbiiieebzpjpbiezzpbjpjzrpjbejpjzjbjieirizzbizpzerzzbiiiiibreijiibepezebrjbzrbbpbibzrijjbrpzzrjppiipjzpzippzeiipiizzzeibbzziebzzzipijijbrb";
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbiibijrrriirbrirreeirieeiibbbrbbbibejbbzibzizijeezpzppziiripzprijbzbjizjbizzrijjjizizzbbziziijieirjiiiiiizirrrzpzjerziizzijjeiiiizijrziizjzizrzeprrrjjeerzjiezejjizjizzejiijezjpiziiejiiijizzzzpriripzrzzirzzjrizzirzzprjpjippzjpjeizjizzjrzpepzirerzzrzjiizzpzerjzrijjiprzirijzijeeirjprreerjejpzirijzzeijjziiiejppzipiiriiirzejjrprjiirzrpjzjizezziizzjrierrpzrziieipizijizzpjijzipipiiejjzjrjjipzrjjizpejiiiijrjrzrjjzzejzrzzrzrjrjirzrjzreiiijizierzjzreirizrjijjjiiijezppizpriiipizizezzziejirrzepiijppzrepizzipziizirijiiezpezejrerzzjizirzepziipjjiieijipipriijpepjzzjeijrrppizepirzijiizipzzzpzzrrzpzpzziziejriiiripezieizpieizzrizirzrejjzzjzrziezrzzjpriipzzjpizjpizirprprjzezrreeprzriizjizippipjiizziiejieiieezpzzirrziprzpezjzzzjeijzpjrzrzrjrjijezpreijjjepziijzzrjpzzirijipiirzzzperirizezrzizizjieepjiizzpzpeezzizirieezeepzizzpzijzjieiezzzzzziezzzjijziziizzjzizeiiiipririzpzzjizzieerzzezjzziiieiirrrpiezerrpipzppeipzrpizipizezierzpiizzzpijzeieirpjijrrjzprzzirprjizjeiizijzezerzzzeiiiiejiipziziripzjiezezjijzrjjziezjijziizpirrjizijpjzizzizzziriizriiizpizjpriierpzrierezerzizerzjiripezzrezepzzppizjizzzrzizjeijrzperzzzrzjrezreirpejerepippizperrzzeziiijpeezizriepepjziezrjpizeezeziiiiizperirpzzirijizpzizzijjpjrijpzeiipiizrzipjezieejziiizrzizizpprreierieeeejeizezjizzijziieeprjjrjzzezzjzezpjerzziizrjpieeejziizzzrjppjrzizzzjeziiepiipjzrzpijiieerppzpeezrrziipizeerzzzzperzpzzipzzijrizzejpjpeijizerpzijezpzpizziiezziijpjiezizrzpezeziipepepzjizijizpezzzrijierpeiipzzrriereezzrreeieiirizzpipzzipejpiiiizrpzezpezepzezppiizerzeijzjjpezziepziperiezjizpjzziezzzrizpiejjjrezzezprzzpzrzipziiepirjezzrzprzrzrziizipizrrzrprzpizzizipipzrzjpzijziizrzpjpzrzprzrizizriirpzzzrzjzzzpzpp");
        System.out.println(reverseShuffleMerge(input));
    }

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        final int strLenght = s.length() / 2;
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                hashMap.replace(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        hashMap.replaceAll((k, v) -> v / 2);

        for (int i = s.length() - 1; i >= 0; i--) {
            //remove letters already in result
            HashMap<Character, Integer> hashMapCurrentQty = new HashMap<>(hashMap);
            for (char ch : result.toString().toCharArray()) {
                hashMapCurrentQty.replace(ch, hashMapCurrentQty.get(ch) - 1);
            }
            //calculate skipped letters
            HashMap<Character, Integer> hashMapSkipped = new HashMap<>(hashMap);
            for (int j = s.length() - 1; j > i; j--) {
                hashMapSkipped.replace(s.charAt(j), hashMapSkipped.get(s.charAt(j)) - 1);
            }
            //calculate next letter
            char curChar = s.charAt(i);
            while (hashMapCurrentQty.get(curChar) < 1 && i>0) {
                hashMapSkipped.replace(curChar, hashMapSkipped.get(curChar) - 1);
                i--;
                curChar = s.charAt(i);
            }
            if (hashMapSkipped.get(curChar) - hashMapCurrentQty.get(curChar) + hashMap.get(curChar) > 0) {
                hashMapSkipped.replace(curChar, hashMapSkipped.get(curChar) - 1);
                for (int j = i - 1; j > strLenght - result.length() - 1; j--) {
                    char ch = s.charAt(j);
                    if (hashMapCurrentQty.get(ch) > 0) {
                        if (ch < curChar) {
                            curChar = ch;
                            i = j;
                            if (hashMapSkipped.get(ch) - hashMapCurrentQty.get(ch) + hashMap.get(ch) < 1) {
                                break;
                            }

                        } else {
                            if (hashMapSkipped.get(ch) - hashMapCurrentQty.get(ch) + hashMap.get(ch) < 1) {
                                break;
                            }
                        }
                    }
                    hashMapSkipped.replace(s.charAt(j), hashMapSkipped.get(s.charAt(j)) - 1);
                }
            }
            if (result.length() < strLenght) {
                result.append(curChar);
                hashMapCurrentQty.replace(curChar, hashMapCurrentQty.get(curChar) - 1);
            }
        }
        return result.toString();
    }
}
