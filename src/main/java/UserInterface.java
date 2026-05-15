import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    Scanner scanner = new Scanner(System.in);

    private void init() {
        DealershipFileMananger dfm = new DealershipFileMananger();
        this.dealership = dfm.getDealership();
    }

    public void display() {
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
                    processRemoveVehicle();
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
        displayVehicle(dealership.getAllVehicles());
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.nextLine();

        displayVehicle(dealership.getVehicleByType(vehicleType));
    }

    private void processGetByMilageRequest() {
        try {
            System.out.println("Enter minimum mileage: ");
            int minimumMilage = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter maximum mileage");
            int maximumMilage = scanner.nextInt();
            scanner.nextLine();

            displayVehicle(dealership.getVehicleByMillage(minimumMilage, maximumMilage));
        } catch (InputMismatchException ime) {
            System.err.println("Enter correct value");
            scanner.nextLine();
        }
    }

    private void processGetByColorRequest() {
        System.out.println("Enter vehicle color: ");
        String color = scanner.nextLine();

        displayVehicle(dealership.getVehicleByColor(color));
    }

    private void processGetByYearRequest() {
        try {
            System.out.println("Enter minimum year of the vehicle: ");
            int minYear = scanner.nextInt();

            System.out.println("Enter max year of the vehicle: ");
            int maxYear = scanner.nextInt();

            displayVehicle(dealership.getVehiclesByYear(minYear, maxYear));
        } catch (InputMismatchException ime) {
            System.err.println("invalid input");
            scanner.nextLine();
        }
    }

    private void processGetByModelRequest() {
        try {
            System.out.println("Enter who make the vehicle: ");
            String makeVehicle = scanner.nextLine();

            System.out.println("Enter model of the vehicle: ");
            String modelVehicle = scanner.nextLine();

            displayVehicle(dealership.getVehiclesByModel(makeVehicle, modelVehicle));
        } catch (InputMismatchException ime) {
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

            displayVehicle(dealership.getVehiclesByPrice(minPrice, maxPrice));
        } catch (InputMismatchException ime) {
            System.err.println("invalid bro");
            scanner.nextLine();
        }
    }


    private void processRemoveVehicle() {
        dealership.removeVehicle(getVehicleFromUser());
        DealershipFileMananger.saveDealership(dealership);
    }

    private void processAddVehicles() {
        dealership.addVehicle(getVehicleFromUser());
        DealershipFileMananger.saveDealership(dealership);
    }

    private Vehicle getVehicleFromUser() {
        boolean getInput = true;
        do {
            try {
                System.out.println("Enter vehicle vin: ");
                int vin = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter vehicle year: ");
                int year = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter vehicle make: ");
                String make = scanner.nextLine();

                System.out.println("Enter vehicle model: ");
                String model = scanner.nextLine();

                System.out.println("Enter vehicle type: ");
                String vehicleType = scanner.nextLine();

                System.out.println("Enter vehicle color: ");
                String color = scanner.nextLine();

                System.out.println("Enter vehicle odometer: ");
                int odometer = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter vehicle price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                getInput = false;
                return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

            }catch (InputMismatchException ime){
                System.err.println("invalid input bro, try again");
                scanner.nextLine();
            }

        }while (getInput);
        return null;
    }
    private void displayVehicle(ArrayList<Vehicle> vehicles){
        System.out.println("Vin | Year | Make | Model | Vehicle Type | Color | Odometer | Price");
        for (Vehicle vehicle: vehicles){
            System.out.println("");

        }
    }

}
