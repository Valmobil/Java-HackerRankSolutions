package hillscalculation;


public class Main {
    public static void main(String[] args) {
        String path = "UDDDUDUU";
        System.out.println(countingValleys(path.length(),path ));
    }


    private static int countingValleys(int n, String s) {
        int altitude = 0;
        int valleysQty = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == "U".charAt(0)) {
                altitude ++;
            } else {
                if (altitude == 0) {
                    valleysQty++;
                }
                altitude--;
            }

        }
        return valleysQty;
    }
}