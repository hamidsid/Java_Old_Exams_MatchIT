package Tests_2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("shifts.txt"));
        } catch (FileNotFoundException e) {
            System.out.print("Filen finns inte, programmet avslutas");
            System.exit(0);
        }
        PaymentGenerator pay = new PaymentGenerator(scan);
        //Fråga användaren vilken månads lönelista som ska genereras.
        System.out.println("Enter a month within range 1-12 !");
        Scanner inputFromUser = new Scanner(System.in);
        int month = inputFromUser.nextInt();

        //Se till så att inmatat månadsnummer är korrekt, annars fråga igen tills det är korrekt

        while (month > 13 || month < 0) {
            System.out.println("Invalid month. Enter a month within range 1-12 ! ");
            month = inputFromUser.nextInt();
        };
        //Skriv ut lönelistorna för inmatad månad
        pay.printShiftsForMonth(month);
    }
}
