package MyTask;

import java.util.ArrayList;

public class ParkingController {

    private ArrayList<Car> allCars;
    private ArrayList<ParkingLot> allParkingLots;

    public ParkingController() {
        allCars = new ArrayList<>();
        allParkingLots = new ArrayList<>();
    }

    /**
     * Parkerar bilen regNbr på parkeringsplatsen med id parkingNbr vid
     * tidpunkten date:h:m under len minuter. Returnerar false om bilen
     * eller parkeringsplatsen inte finns, annars true
     */
    public boolean park(String regNbr, int parkingNbr, String date,
                        int h, int m, int len) {

        //find the parkingLot with given id
        for (ParkingLot parkingLot : allParkingLots) {
            if (parkingLot.getId() == parkingNbr) {

                //search every car in this parkingLot with corresponding id
                for (Car car : allCars) {
                    if (car.getRegNbr().equals(regNbr)) {

                        //once car is found in that parkingLot, create a parkingEvent for that car
                        ParkingEvent parkingEvent = new ParkingEvent(parkingLot, date, h, m, len);
                        car.addParkingEvent(parkingEvent);
                        return true;


                    }
                }


            }

        }

        return false;
    }

    /**
     * Returnerar alla parkeringsplatser bilen regNbr parkerats på
     */
    public ArrayList<ParkingLot> parkingLotList(String regNbr) {

        ArrayList<ParkingLot> tempList = new ArrayList<>();

        //find the car with the corressponding id
        for(Car car: allCars){

            if(car.getRegNbr().equals(regNbr)){

                //find all parking events for this car
                ArrayList<ParkingEvent> parkingEvents = car.getParkingEvents();

                //once all parking events is found, then get parkingLot info from parking event
                for(ParkingEvent pe: parkingEvents){
                    ParkingLot pl = pe.getParkingLot();

                    //add the parking lot to the list if it doesnt contain it already
                    if (!tempList.contains(pl)){
                        tempList.add(pl);
                    }
                }

            }
        }

        return tempList;
    }
}
