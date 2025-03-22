package parkinglot_grokking;

public enum VehicleType {
    CAR(25.0, ParkingSpotType.COMPACT),
    TRUCK(40.0,ParkingSpotType.LARGE),
    ELECTRIC(25.0, ParkingSpotType.ELECTRIC),
    VAN(30.0, ParkingSpotType.LARGE),
    MOTORBIKE(15.0, ParkingSpotType.MOTORBIKE);


    private final double hourlyRate;
    private final ParkingSpotType requiredparkingSpotType;

    VehicleType(double hourlyRate, ParkingSpotType requiredparkingSpotType) {
        this.hourlyRate = hourlyRate;
        this.requiredparkingSpotType = requiredparkingSpotType;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
    public ParkingSpotType getRequiredparkingSpotType() {
        return requiredparkingSpotType;
    }
}
