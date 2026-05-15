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

                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        break;
                    case "6":
                        break;
                    case "7":
                        break;
                    case "8":

                }

            }
        }
    }


    private void processRemoveVehicel() {
    }

    private void processAddVehicles() {
    }


}
