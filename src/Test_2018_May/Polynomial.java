package Test_2018_May;

import java.util.ArrayList;

public class Polynomial {

  private ArrayList<Term> terms;

  public Polynomial() {
    terms = new ArrayList<Term>();
  }

  public void add(Term t) { // 9p

    for (int i = 0; i < terms.size(); i++) {

      Term term = terms.get(i);

      //if exponents are equal
      if (t.exp() == term.exp()) {
        int c = term.coeff() + t.coeff();
        if (c == 0) {
          terms.remove(term);
        } else {
          term.setCoeff(c);
        }
        return;
      }

      //if the given polynomial exponent is higher
      else if (t.exp() > term.exp()) {
        terms.add(i, t);
        return;
      }
    }
    terms.add(t);
  }

  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    if (terms.isEmpty()) {
      return "0";
    }
    for (int i = 0; i < terms.size(); i++) {
      Term term = terms.get(i);
      if (i > 0 && term.coeff() > 0) {
        stringBuilder.append('+');
      }
      stringBuilder.append(term.toString());
    }
    return stringBuilder.toString();
  }

  /**
   * Beräknar produkten av detta polynom och polynomet other. Produkten returneras som ett nytt
   * polynom. Inget av de båda faktorernas Polynomial-objekt förändras.
   */
  Polynomial times(Polynomial other) {
    Polynomial product = new Polynomial();

    for (int i = 0; i < this.terms.size(); i++) {
      Term term1 = this.terms.get(i);
      for (int j = 0; j < other.terms.size(); j++) {
        Term term2 = other.terms.get(j);
        product.add(term1.times(term2));
      }
    }
    return product;
  }



  public static void main(String[] args) {

    //question 2 main test
    Polynomial poly = new Polynomial();
    poly.add(new Term(5, 1));
// 5x
    poly.add(new Term(-4, 0)); // -4
    poly.add(new Term(4, 2));
// 4x2
    poly.add(new Term(-5, 1)); // -5x
    poly.add(new Term(-1, 2)); // -1x2
    System.out.println(poly.toString());

    //question 3 main test

    Polynomial p1 = new Polynomial();
    p1.add(new Term(4, 1)); // 4x
    p1.add(new Term(3, 0)); // 3

    Polynomial p2 = new Polynomial();
    p2.add(new Term(3, 2)); //3x2
    p2.add(new Term(2, 1)); //2x
    p2.add(new Term(1, 0));//1
    Polynomial product = p1.times(p2);
    System.out.println(product.toString());
  }
}
