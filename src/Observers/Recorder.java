package Observers;

import Customers.Customer;
import Rolls.Roll;

import java.util.HashMap;

// This class, the concrete Recorder, Cashier, and the Customers implement an Observer Pattern
public interface Recorder {
    void sale(Customer.CustomerType customerType, HashMap<Roll.RollType, Integer> rollsOrdered, int orderCost);
}
