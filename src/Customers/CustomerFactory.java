package Customers;

// This class along with the concrete Customers implement a Factory Pattern
public class CustomerFactory {
    public Customer getCustomer(Customer.CustomerType customerType) {
        if (customerType == Customer.CustomerType.CASUAL) {
            return new CasualCustomer();
        } else if (customerType == Customer.CustomerType.BUSINESS) {
            return new BusinessCustomer();
        } else if (customerType == Customer.CustomerType.CATERING) {
            return new CateringCustomer();
        } else {
            // Never happens, but should probably throw exception instead
            return null;
        }
    }
}
