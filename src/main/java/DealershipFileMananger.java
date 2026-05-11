import java.io.*;
import java.util.ArrayList;

public class DealershipFileMananger {


    public Dealership getDealership() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources" + "inventory.csv"));
            String line = reader.readLine();

            String[] lineSplit = line.split("\\|");

            Dealership dealership = new Dealership(lineSplit[0], lineSplit[1], lineSplit[2]);

            line = reader.readLine();
            while (line != null) {
                lineSplit = line.split("\\|");
                int vin = Integer.parseInt(lineSplit[0]);
                int year = Integer.parseInt(lineSplit[1]);
                String make = lineSplit[2];
                String model = lineSplit[3];
                String vehicleType = lineSplit[4];
                String color = lineSplit[5];
                int odometer = Integer.parseInt(lineSplit[6]);
                double price = Double.parseDouble((lineSplit[7]));

                Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(newVehicle);
                line = reader.readLine();

            }

            return dealership;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void saveDealership(Dealership dealership){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources" + "inventory.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = dealership.getName()+"|"+dealership.getAddress()+"|"+dealership.getNumber()+"\n";


        }

    }


}
