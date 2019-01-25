package stringSpecialPalindromeAgain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "aaba";
        System.out.println(substrCount(str.length(), str));
    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long count;
        List<Poindrom> list = new ArrayList<>();
        List<Poindrom> listNew = new ArrayList<>();

        //One letter is polindrom
        count = s.length();
        for (char chr : s.toCharArray()) {
            //for all not closed palindrome
            for (Poindrom el : list) {
                if (el.getFirsLetter() == chr) {
                    if (el.getSecondLetter() == null) {
                        listNew.add(new Poindrom(el.getFirsLetter(), el.getFirstLetterQty(), el.getFirsLetter()));
                        listNew.add(new Poindrom(el.getFirsLetter(), el.getFirstLetterQty(), el.getFirsLetter(), el.getFirsLetter(), 1));
                        //Update palindrome where first n chars are same
                        el.setFirstLetterQty(el.firstLetterQty + 1);
                    } else {
                        el.setThirdLetter(chr);
                        el.setThirdLetterQty(el.getThirdLetterQty() + 1);
                    }
                } else {
                    if (el.getSecondLetter() == null) {
                        el.setSecondLetter(chr);
                    } else {
                        el.setThirdLetter(chr);
                    }
                }
            }
            //Add seed for new palindrome
            listNew.add(new Poindrom(chr, 1));

            //check if palindrome already present in list
            for (Iterator<Poindrom> it = list.iterator(); it.hasNext(); ) {
                Poindrom el = it.next();
                if (el.getFirsLetter() != el.getThirdLetter() && el.getThirdLetter() != null ) {
                    it.remove();
                }
                if (el.getFirstLetterQty() == el.getThirdLetterQty()) {
                    count++;
                    it.remove();
                }
            }
            //check if palindrome already present in newList
            for (Poindrom el : listNew) {
                if (el.getFirstLetterQty() == el.getThirdLetterQty()) {
                    count++;
                    listNew.remove(el);
                }
            }
            list.addAll(listNew);
            listNew.clear();

        }
        return count;
    }

    static class Poindrom {
        private Character firsLetter;
        private int firstLetterQty;
        private Character secondLetter;
        private Character thirdLetter;
        private int thirdLetterQty;

        Poindrom(Character firsLetter, int firstLetterQuantity) {
            this.firsLetter = firsLetter;
            this.firstLetterQty = firstLetterQuantity;
        }

        Poindrom(Character firsLetter, int firstLetterQty, Character secondLetter) {
            this.firsLetter = firsLetter;
            this.firstLetterQty = firstLetterQty;
            this.secondLetter = secondLetter;
        }

        Poindrom(Character firsLetter, int firstLetterQty, Character secondLetter, Character thirdLetter, int thirdLetterQty) {
            this.firsLetter = firsLetter;
            this.firstLetterQty = firstLetterQty;
            this.secondLetter = secondLetter;
            this.thirdLetter = thirdLetter;
            this.thirdLetterQty = thirdLetterQty;
        }

        Character getFirsLetter() {
            return firsLetter;
        }

        public void setFirsLetter(Character firsLetter) {
            this.firsLetter = firsLetter;
        }

        public int getFirstLetterQty() {
            return firstLetterQty;
        }

        public void setFirstLetterQty(int firstLetterQty) {
            this.firstLetterQty = firstLetterQty;
        }

        public Character getSecondLetter() {
            return secondLetter;
        }

        public void setSecondLetter(Character secondLetter) {
            this.secondLetter = secondLetter;
        }

        public Character getThirdLetter() {
            return thirdLetter;
        }

        public void setThirdLetter(Character thirdLetter) {
            this.thirdLetter = thirdLetter;
        }

        public int getThirdLetterQty() {
            return thirdLetterQty;
        }

        public void setThirdLetterQty(int thirdLetterQty) {
            this.thirdLetterQty = thirdLetterQty;
        }
    }
}
