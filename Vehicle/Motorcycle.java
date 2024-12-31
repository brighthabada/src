package Vehicle;


import Customer.Customer;

public class Motorcycle extends Vehicle implements Rentable {
    private boolean hasHelmetIncluded; // Specific to Motorcycles

    // Constructor
    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasHelmetIncluded) {
        super(vehicleId, model, baseRentalRate);
        this.hasHelmetIncluded = hasHelmetIncluded;
    }

    public boolean hasHelmetIncluded() {
        return hasHelmetIncluded;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days; // Flat rate
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    public boolean rent(Customer customer, int days) {
        if (!isAvailableForRental()) {
            return false;
        }
        setAvailable(false);
        System.out.println("Motorcycle rented to " + customer.getName() + " for " + days + " days.");
        return true;
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Motorcycle returned.");
    }
}
