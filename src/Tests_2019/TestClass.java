package Tests_2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("shifts.txt"));
        PaymentGenerator paymentGenerator = new PaymentGenerator(scan);
        paymentGenerator.printShiftsForMonth(6);



    }
}
