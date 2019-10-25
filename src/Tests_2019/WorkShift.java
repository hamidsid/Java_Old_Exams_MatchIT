package Tests_2019;

public class WorkShift {

    private boolean isAtHome;
    private String date;
    private int from;
    private int to;

    public WorkShift(boolean isAtHome, String date, int from, int to) {
        this.isAtHome = isAtHome;
        this.date = date;
        this.from = from;
        this.to = to;
    }

    /**
     * Returnerar true om passet är ett hemarbetespass, false annars
     */
    boolean isAtHome() {

        return this.isAtHome;
    }

    public String pureDate() {
        return  this.date.replaceAll("[^a-zA-Z0-9]", "");
    }


    /**
     * Returnerar numret på den dag (1-31) då passet arbetades
     */
    public int getDay() {
        String day = pureDate().substring(6, 8);
        return Integer.parseInt(day);
    }

    /**
     * Returnerar numret på den månad (1-12) då passet arbetades
     */
    public int getMonth() {
        String month = pureDate().substring(4, 6);
        return Integer.parseInt(month);
    }

    /**
     * Returnerar arbetspassets längd i timmar
     */
    public int getLength() {
        return to - from;
    }

    /**
     * Returnerar arbetspassets datum på formen yyyy-mm-dd
     */
    public String getDateAsString() {
        String date = pureDate();
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);


        return year + "-" + month + "-" + day;
    }

    /**
     * Returnerar en läsbar representation av detta arbetspass.
     * Retursträngen kommer följa följande format:
     * 2019-06-24 kl 10-12 (2 timmar)
     */
    public String toString() {
        return getDateAsString() + " kl " + from + "-" + to;

    }
}
