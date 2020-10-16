package Customers;

import Rolls.Roll;

import java.util.*;

public class CasualCustomer extends Customer {
    public CasualCustomer() {
        Random random = new Random();
        customerType = CustomerType.CASUAL;
        order.put(chooseRollType(), random.nextInt(4));
    }

    public HashMap<Roll.RollType, Integer> order(HashMap<Roll.RollType, Integer> inventory) {
        int numOutOfStock = numOutOfStock(inventory);
        if (numOutOfStock > 0) {
            inventory = orderAnyRolls(inventory);
        } else {
            // numOutOfStock equals 0, take full order
            inventory = takeFullOrder(inventory);
        }
        return inventory;
    }
}
