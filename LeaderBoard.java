package rushHour_v7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LeaderBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Session Number for this game: ");
        int sessionNo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Player Name: ");
        String playerName = scanner.nextLine();

        System.out.println("Enter Player ID: ");
        int playerID = scanner.nextInt();

        Player player = new Player(playerID, playerName);

        //call toString method in Player class to display
        System.out.printf("sessionNo: %d, %s\n",sessionNo,player);

        System.out.println("Choose a level for this game (1-3): ");
        int level = scanner.nextInt();

        Cards cards = new Cards();
        GameBoard gameBoard = new GameBoard();
        Vehicle[] vehicles = cards.generateVehicles(level);

        // call initializeGrid method from GameGrid class
        gameBoard.initializeGrid(vehicles);

        //time count start
        long startTime = System.currentTimeMillis();

        // call moveVehicle method from class GameGrid to play game until boolean gameEnd become true
        boolean gameEnd = false;

        while (!gameEnd) {
            System.out.println("Enter the Vehicle Number to move: ");
            int vehicleNo = scanner.nextInt();
            System.out.println("Enter moving Direction (1 for forward, -1 for backward): ");
            int direction = scanner.nextInt();

            if (!gameBoard.moveVehicle(vehicleNo, direction)) {
                System.out.println("Moving Direction is invalid. Try again.");
            }

            gameEnd = gameBoard.checkWinCondition();
        }

        // time count end
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Game over! The red car has escaped!");
        System.out.printf("Game Duration: %d minutes, %d seconds%n",
                elapsedTime / 60000, (elapsedTime % 60000) / 1000);

        System.out.printf("GameDate: %s%n",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
