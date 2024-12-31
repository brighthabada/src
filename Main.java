

import Customer.Customer;
import Vehicle.Car;
import Vehicle.Motorcycle;
import Vehicle.Truck;
import Agency.RentalAgency;

public class Main {
    public static void main(String[] args) {
        // Create a rental agency
        RentalAgency rentalAgency = new RentalAgency("Accra Vehicle Rentals");

        // Add vehicles to the rental agency's fleet
        Car car1 = new Car("V001", "Toyota Corolla", 120.0, true);
        Motorcycle motorcycle1 = new Motorcycle("V002", "Yamaha XTZ", 50.0, true);
        Truck truck1 = new Truck("V003", "Kia Frontier", 200.0, true);

        rentalAgency.addVehicle(car1);
        rentalAgency.addVehicle(motorcycle1);
        rentalAgency.addVehicle(truck1);

        // List all available vehicles
        rentalAgency.listAvailableVehicles();

        // Create a customer
        Customer customer = new Customer("C001", "Kwame Asante", "0241234567", "kwame@example.com");

        // Rent a vehicle
        rentalAgency.rentVehicle("V001", customer, 3); // Renting Toyota Corolla

        // List available vehicles again
        rentalAgency.listAvailableVehicles();

        // Return a vehicle
        rentalAgency.returnVehicle("V001");

        // View transaction history
        rentalAgency.viewTransactions();
    }
}
