package Vehicle;


import Customer.Customer;

public class Car extends Vehicle implements Rentable {
    private boolean hasAirConditioning; // Specific to Cars

    // Constructor
    public Car(String vehicleId, String model, double baseRentalRate, boolean hasAirConditioning) {
        super(vehicleId, model, baseRentalRate);
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasAirConditioning) {
            cost += 50; // Extra fee for air conditioning
        }
        return cost;
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
        System.out.println("Car rented to " + customer.getName() + " for " + days + " days.");
        return true;
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned.");
    }
}
