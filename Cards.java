package rushHour_v7;

import java.util.Random;

public class Cards {

    // not necessary to put constructor, as default constructor can be called in main
    // public Cards() { }

    //method
    public Vehicle[] generateVehicles(int level) {
        int totalVehicles;
        switch (level) {
            case 1:
                totalVehicles = 5;
                break;
            case 2:
                totalVehicles = 9;
                break;
            case 3:
                totalVehicles = 13;
                break;
            default:
                throw new IllegalArgumentException("Invalid level");
        }

        // initialize Vehicle class type array vehicles
        Vehicle[] vehicles = new Vehicle[totalVehicles];
        boolean[][] occupied = new boolean[6][6];

        // set player's vehicleNo. is always vehicles[0]
        vehicles[0] = new Vehicle(1, 2, 3, "horizontal");

        //call markOccupied method
        markOccupied(vehicles[0], occupied);

        //set vehicle direction, position
        Random random = new Random();
        for (int i = 1; i < totalVehicles; i++) {
            while (true) {
                String direction = random.nextBoolean() ? "horizontal" : "vertical";
                int y = random.nextInt(6);
                int x = random.nextInt(6);

                // call method isPositionValid to check if valid position, then call markOccupied method
                Vehicle temp = new Vehicle(i + 1, y, x, direction);
                if (isValidPosition(temp, occupied)) {
                    vehicles[i] = temp;
                    markOccupied(temp, occupied);
                    break;
                }
            }
        }
        return vehicles;
    }

    // method to check vehicle postion is within the range of grid
    private boolean isValidPosition(Vehicle vehicle, boolean[][] occupied) {
        int y = vehicle.getVehicleY();
        int x = vehicle.getVehicleX();
        for (int i = 0; i < vehicle.getVehicleSize(); i++) {
            if (vehicle.getVehicleDirection().equals("horizontal")) {
                if (x + i >= 6 || occupied[y][x + i]) return false;
            } else {
                if (y + i >= 6 || occupied[y + i][x]) return false;
            }
        }
        return true;
    }

    // method to register occupied 2square as true by using loop
    private void markOccupied(Vehicle vehicle, boolean[][] occupied) {
        int y = vehicle.getVehicleY();
        int x = vehicle.getVehicleX();
        for (int i = 0; i < vehicle.getVehicleSize(); i++) {
            if (vehicle.getVehicleDirection().equals("horizontal")) {
                occupied[y][x + i] = true;
            } else {
                occupied[y + i][x] = true;
            }
        }
    }
}