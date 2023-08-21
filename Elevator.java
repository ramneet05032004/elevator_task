import java.util.Scanner;

public class Elevator {
    // Here it is assumed that initially the elevator is at 0 floor
    static int currentElevatorFloor = 0;

    /**
     * @param destinationFloor this is floor where person want to reach from current
     *                         floor
     */
    public static void moveUp(int destinationFloor) {
        while (currentElevatorFloor < destinationFloor) {
            currentElevatorFloor++;
            System.out.println("Elevator has reached at " + currentElevatorFloor);
        }
    }

    /**
     * @param destinationFloor this is floor where person wants to reach
     */
    public static void moveDown(int destinationFloor) {
        while (currentElevatorFloor > destinationFloor) {
            currentElevatorFloor--;
            System.out.println("Elevator has reached at " + currentElevatorFloor);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        // Program starts by taking the floor count from the user
        System.out.println("Enter number of Floors in the building");
        final int maxFloors = scanner.nextInt();

        // Emergency button and elevator exit numbers are set which will be constants
        int emergencyElevatorButton = -1;
        int exitElevatorButton = -2;

        // It is considered that elevator is in use
        boolean elevatorInUse = true;
        System.out.println("");

        while (elevatorInUse) {
            // users input is taken and instructions are shown
            System.out.println("Enter floor from 0 to " + maxFloors);
            System.out.println("0 being the Ground Floor");
            System.out.println("and enter " + emergencyElevatorButton + " for emergency");
            System.out.println("and enter " + exitElevatorButton + " for exit");

            final int destinationFloor = scanner.nextInt();
            // Then the function works on user's instructions while considering the
            // different cases

            if (destinationFloor == emergencyElevatorButton) {
                System.out.println("Elevator goes in emergency");
                elevatorInUse = false;
            } else if (destinationFloor == exitElevatorButton) {
                System.out.println("User exits elevator");
                elevatorInUse = false;
            } else if (currentElevatorFloor == destinationFloor) {
                System.out.println("You are currently at the same floor");

            } else if (destinationFloor >= 0 && destinationFloor <= maxFloors) {
                System.out.println("Elevator door closes");
                if (currentElevatorFloor > destinationFloor) {
                    System.out.println("Elevator moves downwards");
                    moveDown(destinationFloor);
                } else {
                    System.out.println("Elevator moves upwards");
                    moveUp(destinationFloor);
                }
                System.out.println("Elevator door opens at floor " + currentElevatorFloor);
            } else {
                System.out.println("Invalid value entered");
            }
            System.out.println("\nElevator current floor " + currentElevatorFloor);
        }
        // Scanner is closed before terminating the program
        scanner.close();

    }
}
