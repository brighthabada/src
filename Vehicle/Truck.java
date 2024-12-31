package Vehicle;

import Customer.Customer;

public class Truck extends Vehicle implements Rentable {
    private double loadCapacity; // In tons, specific to Trucks

    // Constructor
    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadCapacity = loadCapacity;
    }

    public Truck(String v003, String kiaFrontier, double baseRentalRate, boolean b) {
        super(v003, kiaFrontier, baseRentalRate, b);
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Assuming that a truck with more load capacity will incur additional costs.
        double v = getBaseRentalRate() * days + (loadCapacity * 20); // Calculate based on load capacity
        return v; // Return total rental cost
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public boolean rent(Customer customer, int days) {
        if (!isAvailableForRental()) {
            return false;
        }
        setAvailable(false);
        System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
        return true;
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck returned.");
    }
}
