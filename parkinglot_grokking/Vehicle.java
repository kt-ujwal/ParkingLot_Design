package parkinglot_grokking;

public class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }
    public String getLicensePlate() {return licensePlate;}
    public VehicleType getVehicleType() {return vehicleType;}

}
