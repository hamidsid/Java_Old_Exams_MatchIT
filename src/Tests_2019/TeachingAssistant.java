package Tests_2019;

import java.util.ArrayList;

public class TeachingAssistant {

    private final String name;
    private final String personalIdNbr;
    private ArrayList<WorkShift> workShifts = new ArrayList<>();

    /**
     * Skapar en ny labbhandledare med namnet name och personnumret personalIdNbr
     */
    TeachingAssistant(String name, String personalIdNbr) {
        this.name = name;
        this.personalIdNbr = personalIdNbr;
    }

    /**
     * Lägger till ett nytt arbetspass för denna handledare. Arbetspasset ska bli
     * ett hemarbetspass om isAtHome är true (annars salsarbetspass) och passet
     * arbetades dagen date från kl from till klockan to
     */
    void addShift(boolean isAtHome, String date, int from, int to) {


        int pos = 0;    //keep track of workshift untill its right place
        WorkShift ws = new WorkShift(isAtHome, date, from, to);

        while (pos < workShifts.size() &&
                ws.getDateAsString().compareTo(workShifts.get(pos).getDateAsString()) > 0) {
            pos++;  //increment index until right place for work shift is found
        }
        workShifts.add(pos, ws);
    }

    /**
     * Returnerar en lista med de hemarbetspass som denna labbhandledare arbetat i
     * månad monthNbr, sorterade i datumordning.
     * Om inga sådana pass arbetats returneras en tom lista
     */
    ArrayList<WorkShift> getHomeShiftsForMonth(int monthNbr) {
        ArrayList<WorkShift> result = new ArrayList<>();
        for (WorkShift ws : workShifts) {
            if (ws.isAtHome()) {
                if (ws.getMonth() == monthNbr) {
                    result.add(ws);
                }
            }
        }
        return result;
    }

    /**
     * Returnerar en lista med de salsarbetspass som denna labbhandledare arbetat i
     * månad monthNbr, sorterade i datumordning.
     * Om inga sådana pass arbetats returneras en tom lista
     */
    ArrayList<WorkShift> getTeachingShiftsForMonth(int monthNbr) {

        ArrayList<WorkShift> result = new ArrayList<>();
        for (WorkShift ws : workShifts) {
            if (!ws.isAtHome()) {
                if (ws.getMonth() == monthNbr) {
                    result.add(ws);
                }
            }
        }
        return result;
    }

    /**
     * Räknar ut hur många olika dagar labbhandledaren har arbetat under månaden med
     * nummer monthNbr. En dag räknas som arbetad om det, oavsett längd, finns minst
     * ett arbetspass registrerat för dagen
     */
    int getNbrOfDaysForMonth(int monthNbr) {

        int totalDays = 0;
        for (WorkShift ws : workShifts) {
            if (ws.getMonth() == monthNbr) {
                totalDays++;
            }
        }
        return totalDays;
    }

    /**
     * Returnerar handledarens totala lön (baserat på arbetade pass, typ av pass
     * samt aktuell timlön) för månad monthNbr
     */
    double getTotalPaymentForMonth(int monthNbr) {

        double tp = 0.0;
        for (WorkShift ws : workShifts) {
            if (ws.getMonth() == monthNbr) {
                if (ws.isAtHome()) {
                    tp += ws.getLength() * PaymentGenerator.HOME_SALARY;
                } else {
                    tp += ws.getLength() * PaymentGenerator.TEACHING_SALARY;
                }
            }
        }
        return tp;
    }

    public String getStringForMonth(int monthNbr) {
        StringBuilder sb = new StringBuilder();
        sb.append("Löneutbetalning för: " + name).append("\n");
        sb.append("Hemarbete:").append("\n");
        ArrayList<WorkShift> home = getHomeShiftsForMonth(monthNbr);
        for (WorkShift workShift : home) {
            sb.append("\t" + workShift).append("\n");
        }
        sb.append("Salsarbete:").append("\n");
        ArrayList<WorkShift> teach = getTeachingShiftsForMonth(monthNbr);
        for (WorkShift workShift : teach) {
            sb.append("\t" + workShift).append("\n");
        }
        sb.append("Totalt arbetade dagar: " + getNbrOfDaysForMonth(monthNbr)).append("\n");
        sb.append("Total lön: " + getTotalPaymentForMonth(monthNbr)).append("\n");
        return sb.toString();
    }

}
