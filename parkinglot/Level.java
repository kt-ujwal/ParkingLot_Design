package parkinglot;

import parkinglot.vehicletype.VehicleType;
import parkinglot.vehicletype.Vehicle;
import java.util.*;

public class Level {

    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numSpots){
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);

        double spotForBikes = 0.50;
        double spotforCars = 0.40;

        int numBikes = (int) (numSpots * spotForBikes);
        int numCars = (int)(numSpots * spotforCars);

        for(int i=1;i<=numBikes;i++){
            parkingSpots.add(new ParkingSpot(i,VehicleType.MOTORBIKE));
        }
        for(int i=1+numBikes;i<=numCars+numBikes;i++){
            parkingSpots.add(new ParkingSpot(i,VehicleType.CAR));
        }
        for(int i=1+numCars+numBikes;i<=numSpots;i++){
            parkingSpots.add(new ParkingSpot(i,VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot: parkingSpots){
            if(spot.isAvailable() && vehicle.getType() == spot.getVehicleType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public  synchronized boolean unparkVehicle(Vehicle vehicle){
        for(ParkingSpot spot: parkingSpots){
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level "+floor+" Availability:");
        for(ParkingSpot spot: parkingSpots){
            System.out.println("Spot "+spot.getSpotNumber()+": " + (spot.isAvailable() ? "Available For ":"Occupied By: ")+" "+spot.getVehicleType());
        }
    }
}
