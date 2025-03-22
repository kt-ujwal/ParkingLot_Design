package parkinglot_grokking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String id;
    private String name;
    private Map<Integer,ParkingLevel> parkingLevels;

    public ParkingLot(int numLevels){
        this.parkingLevels = new HashMap<Integer,ParkingLevel>();
        for(int i=1; i<=numLevels; i++){
            this.parkingLevels.put(i, new ParkingLevel(i));
        }
    }


    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingLevel parkingLevel : parkingLevels.values()){
            if(parkingLevel.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle){
        for(ParkingLevel parkingLevel : parkingLevels.values()){
            if(parkingLevel.removeVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public List<ParkingSpot> getFreeParkingSpots(ParkingSpotType type){
        List<ParkingSpot> freeSpots = new ArrayList<ParkingSpot>();
        for(ParkingLevel parkingLevel : parkingLevels.values()){
            freeSpots.addAll(parkingLevel.getFreeParkingSpots(type));
        }
        return freeSpots;
    }

    public void addParkingSpot(int levelNumber, ParkingSpot spot){
        ParkingLevel level = parkingLevels.get(levelNumber);
        if(level != null){
            level.addParkingSpot(spot);
        }
        else{
            System.out.println("Invalid level number: " + levelNumber);
        }
    }

    public void displayStatus() {
        System.out.println("=== Parking Lot Status ===");
        for (ParkingSpotType type : ParkingSpotType.values()) {
            int totalAvailable = 0;
            for (ParkingLevel level : parkingLevels.values()) {
                int availableSpots = level.getFreeParkingSpots(type).size();
                totalAvailable += availableSpots;
            }
            System.out.printf("Available %s spots: %d%n", type, totalAvailable);
        }
        System.out.println("==========================");
    }

}
