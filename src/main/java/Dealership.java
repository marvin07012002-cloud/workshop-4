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

    public double getVehiclesByPrice(double min, double max){
        double priceResult = 0;
        return priceResult;
    }

    public String getVehiclesByModel(String make,String model){
        String vehiculeResult = "";
        return vehiculeResult;
    }

    public int getVehiclesByYear(int min,int max){
        int yearResult = 0;
        return yearResult;
    }

    public String getVehicleByColor(String color){
        String colorResult = "";
        return colorResult;
    }

    public int getVehicleByMillage(int min,int max){
        int millageResult = 0;
        return millageResult;
    }

    public String getVehicleByType(String vehicleType){
        String resultType = "";
        return resultType;
    }

    public String getAllVehicles(){
        String allVehicles = "";
        return allVehicles;
    }

    public void addVehicule(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }





}
