package Test_2018_May;

import java.util.Scanner;

public class PolyMul {

  private static Polynomial readPolynomial(Scanner scan) {
    Polynomial p = new Polynomial();
    int degree = scan.nextInt();
    for (int i = degree; i >= 0; i--) {
      int coeff = scan.nextInt();
      if (coeff != 0) {
        p.add(new Term(coeff, i));
      }
    }
    return p;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Polynomial p1 = readPolynomial(scan);
    System.out.println(p1.toString());
  }


}