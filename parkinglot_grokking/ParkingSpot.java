package parkinglot_grokking;

public class ParkingSpot {
    private String parkingSpotId;
    private final ParkingSpotType parkingSpotType;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpot(ParkingSpotType spotType){
        this.parkingSpotType = spotType;
    }
    public ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType) {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.isFree = true;
        this.vehicle = null;
    }

    public boolean park(Vehicle vehicle) {
        if(!isFree || vehicle.getVehicleType().getRequiredparkingSpotType() != parkingSpotType) return false;

        this.isFree = false;
        this.vehicle = vehicle;
        return true;
    }

    public void freeParkingSpot() {
        isFree = true;
        vehicle = null;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }
    public boolean isFree() {
        return isFree;
    }
    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}
