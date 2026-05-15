import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    Scanner  scanner =  new Scanner(System.in);

    private void init(){
        DealershipFileMananger dfm = new DealershipFileMananger();
        this.dealership = dfm.getDealership();
    }

    public void display (){
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

            switch (userInput){
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
                    running =  false;
                    break;

            }



        } while(running);
    }






}
