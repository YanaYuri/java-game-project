package rushHour_v7;

public class GameBoard {

    private final int[][] grid = new int[6][6];
    private Vehicle[] vehicles;
    private int movementID = 0; // count when player's car moves

    // call placeVehicle method and set all vehicle position in grid
    public void initializeGrid(Vehicle[] vehicles) {
        this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            placeVehicle(v);
        }
        displayState();
    }

    // placeVehicle method registers one vehicle position in the grid array
    private void placeVehicle(Vehicle vehicle) {
        int y = vehicle.getVehicleY();
        int x = vehicle.getVehicleX();
        for (int i = 0; i < vehicle.getVehicleSize(); i++) {
            if (vehicle.getVehicleDirection().equals("horizontal")) {
                grid[y][x + i] = vehicle.getVehicleNo();
            } else {
                grid[y + i][x] = vehicle.getVehicleNo();
            }
        }
    }

    public boolean moveVehicle(int vehicleNo, int movingDirection) {

        //1) search the vehicleNo(argument) in array vehicles
        Vehicle vehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getVehicleNo() == vehicleNo) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) return false;

        // 2) clear the position where currently occupied (as moving)
        int y = vehicle.getVehicleY();
        int x = vehicle.getVehicleX();
        for (int i = 0; i < vehicle.getVehicleSize(); i++) {
            if (vehicle.getVehicleDirection().equals("horizontal")) {
                grid[y][x + i] = 0;
            } else {
                grid[y + i][x] = 0;
            }
        }

        // 3) update the vehiclePosition
        if (vehicle.getVehicleDirection().equals("horizontal")) {
            vehicle.setVehicleX(vehicle.getVehicleX() + movingDirection);
        } else {
            vehicle.setVehicleY(vehicle.getVehicleY() + movingDirection);
        }

        // 4) increment each vehicle's movement count
        vehicle.incrementMovementCount();

        // 5) call placeVehicle method with the 'latest position of vehicle'
        placeVehicle(vehicle);

        // 6) update movementID to record each movement
        movementID++;

        // 7) display each vehicle position and visualization of grid
        displayState();

        return true;
    }

    public void displayState() {
        System.out.printf("\n---MovementID: %d---\n", movementID);
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
        displayGrid();
    }

    public void displayGrid() {
        System.out.println("Grid Visualization:");
        for (int[] y : grid) {
            for (int x : y) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public boolean checkWinCondition() {
        return grid[2][5] == 1;
    }

    // --by using [i][j]---
//    public void displayGrid() {
//        System.out.println("Grid Visualization:");
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                System.out.println(grid[i][j]);
//            }
//        }
//    }
}