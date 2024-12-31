package Agency;

import Customer.Customer;
import Vehicle.Vehicle;


import java.time.LocalDate;

public class RentalTransaction {
    private Vehicle vehicle;
    private Customer customer;
    private int rentalDays;
    private LocalDate rentalDate;

    public RentalTransaction(Vehicle vehicle, Customer customer, int rentalDays) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDays = rentalDays;
        this.rentalDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "vehicle=" + vehicle.getVehicleId() +
                ", customer=" + customer.getCustomerId() +
                ", rentalDays=" + rentalDays +
                ", rentalDate=" + rentalDate +
                '}';
    }
}
