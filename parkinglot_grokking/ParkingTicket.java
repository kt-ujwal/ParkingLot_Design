package parkinglot_grokking;

public class ParkingTicket {
    private final Vehicle vehicle;
    private final long entryTime;
    private long exitTime;

    public ParkingTicket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.entryTime = System.currentTimeMillis();
    }

    public double calculateCharge(Vehicle vehicle) {
        long duration = ((exitTime - entryTime) / 1000)/60;//mins
        double hours = duration / 60.0;
        return hours * vehicle.getVehicleType().getHourlyRate();
    }

    public void exit() {
        this.exitTime = System.currentTimeMillis();
    }
}
