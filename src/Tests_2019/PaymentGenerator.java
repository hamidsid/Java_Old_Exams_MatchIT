package Tests_2019;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentGenerator {
    public static final double TEACHING_SALARY = 264;
    public static final double HOME_SALARY = 130;

    ArrayList<TeachingAssistant> teachingAssistants = new ArrayList<>();

    public PaymentGenerator(Scanner scan) {
        readShiftsFromFile(scan);
    }

    private void readShiftsFromFile(Scanner scan) {
        TeachingAssistant ta = null;

        while (scan.hasNext()) {
            String firstChar = scan.next();

            //if line starts with # then get name
            if (firstChar.equals("#")) {
                //remove spaces and put each2 word in a an array
                String name = scan.next() + " " + scan.next();
                String idNbr = scan.next();
                ta = new TeachingAssistant(name, idNbr);
                teachingAssistants.add(ta);
            } else {
                boolean isAtHome = false;
                String date = scan.next();
                int from = Integer.parseInt(scan.next());
                int to = Integer.parseInt(scan.next());

                if (firstChar.equals("H")) {
                    isAtHome = true;
                }
                ta.addShift(isAtHome, date, from, to);
            }
        }
    }

    public void printShiftsForMonth(int monthNbr) { // 6p
        boolean found = false;
        for (TeachingAssistant ta : teachingAssistants) {
            if (ta.getNbrOfDaysForMonth(monthNbr) > 0) {
                found = true;
                System.out.print(ta.getStringForMonth(monthNbr));
                System.out.print("\n\n");
            }
        }
        if (!found) {
            System.out.println("Inga registrerade pass hittades för månad " + monthNbr);
        }
    }

}
