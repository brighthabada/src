package Vehicle;


import Customer.Customer;

public interface Rentable {
    boolean rent(Customer customer, int days);

    void returnVehicle();
}
