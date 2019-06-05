package javaIfElse;

import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    System.out.println(resultOfConditionCheck(n));
    scanner.close();
  }

  private static String resultOfConditionCheck(int n) {
    if (n % 2 == 1) {
      return "Weird";
    }
    if (2 <= n && n <= 5) {
      return "Not Weird";
    }
    if (6 <= n && n <= 20) {
      return "Weird";
    }
    if (n > 20) {
      return "Not Weird";
    }
    return "Werd";
  }
}
