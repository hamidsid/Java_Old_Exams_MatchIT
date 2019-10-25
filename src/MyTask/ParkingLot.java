package MyTask;

public class ParkingLot {
    private int id;
    private String name;
    private int[] hours;


    /**
     * Creates a parking space with ID number id and name name.
     * The parking price / hour for all 24 hours of the day in hours [0..23] * /
     */
    ParkingLot(int id, String name, int[] hours) {
        this.id = id;
        this.name = name;
        this.hours = hours;

    }

    /**
     * Returnerar parkeringsplatsens id
     */
    int getId() {
        return this.id;
    }

    /**
     * Returnerar parkeringsplatsens namn
     */
    String getName() {
        return this.name;
    }

    /**
     * Returnerar parkeringspriset/timme under timme h
     */
    int getHourCost(int h) {
        return hours[h];
    }

    /**
     * / ** Returns the cost of a parking at h: m, and how long(min) the car was parked * /
     */
    int cost(int h, int m, int len) {
        double sum = 0;
        int startMin = h * 60 + m;
        int stopMin = startMin + len;
        for (int min = startMin; min < stopMin; min++) {
            sum += hours[min / 60] / 60.0;
        }

        return (int) Math.round(sum);
    }
}
