package Observers;

import Customers.Customer;
import Rolls.Roll;

import java.util.HashMap;

public interface Recorder {
    void sale(Customer.CustomerType customerType, HashMap<Roll.RollType, Integer> rollsOrdered, int orderCost);
}
