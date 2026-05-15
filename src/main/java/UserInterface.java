import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    Scanner scanner = new Scanner(System.in);

    private void init() {
        DealershipFileMananger dfm = new DealershipFileMananger();
        this.dealership = dfm.getDealership();
    }

    public void display(ArrayList<Vehicle> allVehicles) {
        init();

        boolean running = true;


        do {
            System.out.println("""
                    Menu
                    A) For display all cars
                    B) Display cars by price
                    X) Exit
                    """);
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "A":
                    displayAlLCarsMenu();
                    break;
                case "B":
                    processAddVehicles();
                    break;
                case "C":
                    processRemoveVehicel();
                    break;
                case "X":
                    running = false;
                    break;

            }


        } while (running);
    }

    private void displayAlLCarsMenu() {
        boolean running = true;

        while (running) {
            System.out.println("""
                    Select filter to search vehicle
                    1) Search by price
                    2) Search by model
                    3) Search by year
                    4) Search by color
                    5) Search by mileage 
                    6) Search by vehicle type
                    7) Search by all vehicles in the dealership
                    8) Exit 
                    """);

            try {
                String userInput = scanner.nextLine();

                switch (userInput) {
                    case "1":
                        processGetByPriceRequest();
                        break;
                    case "2":
                        processGetByModelRequest();
                        break;
                    case "3":
                        processGetByYearRequest();
                        break;
                    case "4":
                        processGetByColorRequest();
                        break;
                    case "5":
                        processGetByMilageRequest();
                        break;
                    case "6":
                        processGetByVehicleTypeRequest();
                        break;
                    case "7":
                        processGetAllVehiclesRequest();
                        break;
                    case "8":
                        running = false;
                        break;

                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void processGetAllVehiclesRequest() {
        display(dealership.getAllVehicles());
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.nextLine();

    display(dealership.getVehicleByType(vehicleType));
    }

    private void processGetByMilageRequest() {
        try {
            System.out.println("Enter minimum mileage: ");
            int minimumMilage = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter maximum mileage");
            int maximumMilage = scanner.nextInt();
            scanner.nextLine();

            display(dealership.getVehicleByMillage(minimumMilage,maximumMilage));
        } catch (InputMismatchException ime) {
            System.err.println("Enter correct value");
            scanner.nextLine();
        }
    }

    private void processGetByColorRequest() {
    }

    private void processGetByYearRequest() {
    }

    private void processGetByModelRequest() {
    }

    private void processGetByPriceRequest() {
    }


    private void processRemoveVehicel() {
    }

    private void processAddVehicles() {
    }


}
