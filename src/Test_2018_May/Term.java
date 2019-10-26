package Test_2018_May;

public class Term {

  private int coeff;

  private int exp;

  /**
   * Skapar en polynomterm med koefficienten a och exponenten b. Koefficienten a antas vara skild
   * från noll, och exponenten b antas vara större än eller lika med noll.
   */
  Term(int a, int b) {
    if (a == 0) {
      throw new IllegalArgumentException("Coefficient of polynomial cannot be zero ");
    }
    this.coeff = a;

    if (b < 0) {
      throw new IllegalArgumentException("Exponent of poylnomial cannot be zero");
    }
    this.exp = b;
  }

  /**
   * Hämtar termens koefficient.
   */
  int coeff() {
    return this.coeff;
  }

  /**
   * Sätter termens koefficient till a. Parametern antas vara skild från noll.
   */
  void setCoeff(int a) {
    this.coeff = a;
  }

  /**
   * Hämtar termens exponent.
   */
  int exp() {
    return this.exp;
  }

  /**
   * Beräknar produkten av denna term och termen other. Produkten returneras som en ny term. Inget
   * av de båda faktorernas Term-objekt förändras.
   */
  Term times(Term other) {
    int coeffProduct = this.coeff * other.coeff;
    int expProduct = this.exp + other.exp;

    return new Term(coeffProduct, expProduct);
  }

  /**
   * Returnerar en strängbeskrivning av termen, exempelvis "5x2" (se anvisningar).
   */
  public String toString() {

    if (this.exp > 0) {
      if (this.exp == 1) {
        return this.coeff + "x";
      } else {
        return this.coeff + "x" + this.exp;
      }
    } else {
      return String.valueOf(coeff);
    }
  }

  public static void main(String[] args) {
    Term t1 = new Term(3, 3);
    Term t2 = new Term(9, 4);
    Term t4 = new Term(9, 0);
    Term t3 = t4.times(t2);
    System.out.println(t1.toString());
    System.out.println(t2.toString());
    System.out.println(t4.toString());
    System.out.println(t3.toString());
  }
}
