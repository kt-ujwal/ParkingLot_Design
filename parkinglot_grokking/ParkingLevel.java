package parkinglot_grokking;
import java.util.*;

public class ParkingLevel {
    private String name;
    private int levelNumber;
    private Map<ParkingSpotType,List<ParkingSpot>> parkingSpots;

    public ParkingLevel(int levelNumber) {
        this.levelNumber = levelNumber;
        parkingSpots = new EnumMap<>(ParkingSpotType.class);
        for(ParkingSpotType parkingSpotType : ParkingSpotType.values()) {
            parkingSpots.put(parkingSpotType, new ArrayList<>());
        }

    }

    public ParkingLevel(String name, int levelNumber) {
        this(levelNumber);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getLevelNumber() {
        return levelNumber;
    }
    public void addParkingSpot(ParkingSpot parkingspot){
        parkingSpots.get(parkingspot.getParkingSpotType()).add(parkingspot);
    }

    public boolean parkVehicle(Vehicle vehicle){
        List<ParkingSpot> spots = parkingSpots.get(vehicle.getVehicleType().getRequiredparkingSpotType());
        for(ParkingSpot spot : spots){
            if(spot.isFree()){
                return spot.park(vehicle);
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle){
        for(List<ParkingSpot> spots : parkingSpots.values()){
            for(ParkingSpot spot : spots){
                if(spot.isFree() && spot.getVehicle().equals(vehicle)){
                    spot.freeParkingSpot();
                    return true;
                }
            }
        }
        return false;
    }

    public List<ParkingSpot> getFreeParkingSpots(ParkingSpotType parkingSpotType){
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for(ParkingSpot spot : parkingSpots.get(parkingSpotType)){
            if(spot.isFree()){
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }

}
