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
        System.out.println("Enter vehicle color: ");
        String color = scanner.nextLine();

        display(dealership.getVehicleByColor(color));
    }

    private void processGetByYearRequest() {
        try {
            System.out.println("Enter minimum year of the vehicle: ");
            int minYear = scanner.nextInt();

            System.out.println("Enter max year of the vehicle: ");
            int maxYear = scanner.nextInt();

            display(dealership.getVehiclesByYear(minYear, maxYear));
        } catch (InputMismatchException ime) {
            System.err.println("invalid input");
            scanner.nextLine();
        }
    }

    private void processGetByModelRequest() {
        try{
            System.out.println("Enter who make the vehicle: ");
            String makeVehicle = scanner.nextLine();

            System.out.println("Enter model of the vehicle: ");
            String modelVehicle = scanner.nextLine();

            display(dealership.getVehiclesByModel(makeVehicle,modelVehicle));
        }catch (InputMismatchException ime){
            System.err.println("Invalid bro");
            scanner.nextLine();
        }
    }

    private void processGetByPriceRequest() {
        try {
            System.out.println("Enter minimum price of the vehicle: ");
            double minPrice = scanner.nextDouble();

            System.out.println("Enter maximum price of the vehicle: ");
            double maxPrice = scanner.nextDouble();

            display(dealership.getVehiclesByPrice(minPrice, maxPrice));
        }catch (InputMismatchException ime){
            System.err.println("invalid bro");
            scanner.nextLine();
        }
    }


    private void processRemoveVehicel() {
    }

    private void processAddVehicles() {
    }


}
