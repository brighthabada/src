package Agency;



import Vehicle.Vehicle;
import Customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalAgency {
    private String name;
    private List<Vehicle> fleet;
    private List<RentalTransaction> transactions;

    // Constructor
    public RentalAgency(String name) {
        this.name = name;
        this.fleet = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Add a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    // List all available vehicles
    public List<Vehicle> listAvailableVehicles() {
        return fleet.stream()
                .filter(Vehicle::isAvailableForRental)
                .collect(Collectors.toList());
    }

    // Rent a vehicle
    public boolean rentVehicle(String vehicleId, Customer customer, int days) {
        Vehicle vehicle = findVehicleById(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return false;
        }

        if (!vehicle.isAvailableForRental()) {
            System.out.println("Vehicle is not available for rental.");
            return false;
        }

        if (!customer.isEligibleForRental()) {
            System.out.println("Customer is not eligible for rental.");
            return false;
        }

        // Process the rental
        vehicle.rent(customer, days);
        transactions.add(new RentalTransaction(vehicle, customer, days));
        System.out.println("Vehicle rented successfully.");
        return true;
    }

    // Return a vehicle
    public boolean returnVehicle(String vehicleId) {
        Vehicle vehicle = findVehicleById(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return false;
        }

        if (vehicle.isAvailableForRental()) {
            System.out.println("Vehicle is not currently rented.");
            return false;
        }

        vehicle.returnVehicle();
        System.out.println("Vehicle returned successfully.");
        return true;
    }

    // Find a vehicle by ID
    private Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    // View transaction history
    public List<RentalTransaction> getTransactionHistory() {
        return new ArrayList<>(transactions);
    }

    @Override
    public String toString() {
        return "RentalAgency{" +
                "name='" + name + '\'' +
                ", fleetSize=" + fleet.size() +
                ", transactions=" + transactions.size() +
                '}';
    }

    public void viewTransactions() {
    }
}
