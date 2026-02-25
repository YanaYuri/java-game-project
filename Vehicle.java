package rushHour_v7;

public class Vehicle {
    private int vehicleNo;
    private int vehicleY;
    private int vehicleX;
    private String vehicleDirection;
    private final int vehicleSize = 2;
    private int movementCount = 0;

    public Vehicle(int vehicleNo, int vehicleY, int vehicleX, String vehicleDirection) {
        this.vehicleNo = vehicleNo;
        this.vehicleY = vehicleY;
        this.vehicleX = vehicleX;
        this.vehicleDirection = vehicleDirection;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public int getVehicleY() {
        return vehicleY;
    }

    public void setVehicleY(int vehicleY) {
        this.vehicleY = vehicleY;
    }

    public int getVehicleX() {
        return vehicleX;
    }

    public void setVehicleX(int vehicleX) {
        this.vehicleX = vehicleX;
    }

    public String getVehicleDirection() {
        return vehicleDirection;
    }

    public int getVehicleSize() {
        return vehicleSize;
    }

    public int getMovementCount() {
        return movementCount;
    }

    public void incrementMovementCount() {
        movementCount++;
    }

    @Override
    public String toString() {
        return String.format("vehicleNumber: %d, MovementCount: %d, vehiclePosition y: %d, vehiclePosition x: %d, vehicleDirection: %s",
                vehicleNo, movementCount, vehicleY, vehicleX, vehicleDirection);
    }
}