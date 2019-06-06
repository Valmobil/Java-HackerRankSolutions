package loopsForI;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int baseValue = scanner.nextInt();
    for (int i = 1; i <= 10 ; i++) {
      System.out.printf("%d x %d = %d", baseValue, i, baseValue*i);
      System.out.println();
    }
  }
}
