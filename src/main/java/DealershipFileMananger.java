import java.io.*;
import java.util.ArrayList;

public class DealershipFileMananger {


    public Dealership getDealership() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources" + "inventory.csv"));
            String line = reader.readLine();

            String[] parts = line.split("\\|");

            Dealership dealership = new Dealership(parts[0], parts[1], parts[2]);

            line = reader.readLine();
            while (line != null) {
                parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble((parts[7]));

                Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(newVehicle);
                line = reader.readLine();



            }
            reader.close();
            return dealership;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void saveDealership(Dealership dealership){
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources" + "inventory.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getNumber() + "\n";
            bufferedWriter.write(line);

            for (Vehicle v:dealership.getAllVehicles()){
                bufferedWriter.write(v.getVin() + "|"+v.getYear()+"|"+v.getMake()+"|"+v.getModel()+"|"+v.getVehicleType()+"|"+v.getColor()+v.getOdometer()+
                        "|"+v.getPrice());
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
