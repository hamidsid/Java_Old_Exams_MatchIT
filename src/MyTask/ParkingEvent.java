package MyTask;

public class ParkingEvent {

    private ParkingLot p;
    private String date;
    private int h, m, len;

    /**
    * Creates a parking event in the parking lot p at
    * time date, hour and minute with length of len (minutes)
    */
    ParkingEvent(ParkingLot p, String date, int h, int m, int len) {
        this.p = p;
        this.date = date;
        this.h = h;
        this.m = m;
        this.len = len;
    }

    public ParkingLot getParkingLot() {
        return this.p;
    }

    /**
    * Returns if the date date, hour and minute is within the parking time
    */
    public boolean covers(String date, int h, int m) {
        return this.date.equals(date) && this.h * 60 + this.m <= h * 60 + m && h * 60 + m < this.h * 60 + this.m + len;
    }

    /**
    * Stops the parking event in advance at the time date: h: m (ie changes its ending if the time is within the parking time,
    * otherwise nothing happens)
    */
    public void stop(String date, int h, int m) {

        if (this.covers(date, h, m)) {
            len = h * 60 + m - (this.h * 60 + this.m);
        }
    }

    /**
     * Compare start time of this parking event with start time of other parking event and return
     * < 0 if this parking event starts earlier than others
     *   0 if this parking event starts simultaneously with other
     * > 0 if this parking event starts later than others
     */
    public int compareTo(ParkingEvent other) {
        int deltaDate = date.compareTo(other.date);
        if (deltaDate == 0) {
            int deltaTime = (this.h * 60 + this.m) - (other.h * 60 + other.m);
            return deltaTime;
        } else {
            return deltaDate;
        }
    }

    /**
     * Returns a description of the parking event in two rows
     * as an example:
     * Name of parkingLot 2017-01-09
     * 7:30-13:30 24kr
     */
    public String toString() {
        int stopM = this.h * 60 + len;
        int stopH = stopM * 60;
        stopM = stopM - stopH / 60;
        StringBuilder sb = new StringBuilder();
        sb.append(p.getName() + " " + date + "\n");
        if (m < 10) {
            sb.append(h + ":0" + m + "-");
        } else {
            sb.append(h + ":" + m + "-");
        }
        if (stopM < 10) {
            sb.append(stopH + ":0" + stopM);
        } else {
            sb.append(stopH + ":" + stopM);
        }
        sb.append(" " + p.cost(h, m, len) + "kr");

        return sb.toString();
    }
}
