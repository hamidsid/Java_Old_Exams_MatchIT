package MyTask;

import java.util.ArrayList;

public class Car {
    private String regNbr;
    private ArrayList<ParkingEvent> parkingEvents;

    /**
     * Skapar en bil med registreringsnummer regNbr
     */
    Car(String regNbr) {
        this.regNbr = regNbr;
        parkingEvents = new ArrayList<>();
    }

    /**
     * Returnerar bilens registreringsnummer
     */
    String getRegNbr() {
        return this.regNbr;
    }

    /**
     * Returnerar bilens alla parkeringshändelser
     */
    ArrayList<ParkingEvent> getParkingEvents() {
        return new ArrayList<ParkingEvent>(parkingEvents);
    }

    /**
     * Bokför ett parkeringstillfälle p på bilen
     */
    void addParkingEvent(ParkingEvent p) {
        parkingEvents.add(p);


        //why this solution from the solution key
        /*int pos = parkingEvents.size() - 1;
        while (pos>=0 && parkingEvents.get(pos).compareTo(p)>0) {
            pos--;
        }
        parkingEvents.add(pos+1, p);*/
    }

    /**
     returns the parking lot for which the car was parked during the given date and time
     */
    ParkingLot parkedAt(String date, int h, int m) {
        for (ParkingEvent parkingEvent : parkingEvents) {
            if (parkingEvent.covers(date, h, m)){
                return parkingEvent.getParkingLot();
            }
        }
        return null;
    }
}
