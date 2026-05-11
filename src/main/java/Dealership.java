import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String number;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByModel(String make, String model) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehicleByColor(String color) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle currentVehicle : this.inventory){
            String currentColor = currentVehicle.getColor();
            if(currentColor.equalsIgnoreCase(color)){
                vehicles.add(currentVehicle);
            }
        }

        return vehicles;
    }

    public ArrayList<Vehicle> getVehicleByMillage(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehicleByType(String vehicleType) {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles(Vehicle vehicle) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : this.inventory) {
            vehicles.add(v);
        }
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }


}
