package Customers;

import Observers.Recorder;
import Rolls.Roll;

import java.util.*;

public class CasualCustomer extends Customer {
    public CasualCustomer() {
        setCustomerType(CustomerType.CASUAL);
        Random random = new Random();
        order.put(chooseRollType(), random.nextInt(2) + 1);
    }

    public HashMap<Roll.RollType, Integer> order(HashMap<Roll.RollType, Integer> inventory) {
        int numOutOfStock = numOutOfStock(inventory);
        if (numOutOfStock > 0) {
            inventory = orderAnyRolls(inventory);
        } else {
            // numOutOfStock equals 0, take full order
            inventory = takeFullOrder(inventory);
        }
        purchase();
        return inventory;
    }
}
