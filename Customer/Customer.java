package Customer;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private List<String> rentalHistory; // List of vehicle IDs rented by the customer

    // Constructor
    public Customer(String customerId, String name, String phoneNumber, String email) {
        this.customerId = customerId;
        this.name = name;
        setPhoneNumber(phoneNumber); // Validation in setter
        setEmail(email); // Validation in setter
        this.rentalHistory = new ArrayList<>();
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{10}")) { // Basic validation for Ghanaian phone numbers
            throw new IllegalArgumentException("Invalid phone number. Must be 10 digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) { // Basic validation
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.email = email;
    }

    public List<String> getRentalHistory() {
        return new ArrayList<>(rentalHistory); // Return a copy to ensure encapsulation
    }

    // Methods
    public void addRental(String vehicleId) {
        rentalHistory.add(vehicleId);
    }

    public boolean isEligibleForRental() {
        // Simple check: customers with more than 3 ongoing rentals are ineligible
        return rentalHistory.size() <= 3;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", rentalHistory=" + rentalHistory +
                '}';
    }
}
