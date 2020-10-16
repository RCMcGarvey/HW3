package Customers;

import Rolls.Roll;

import java.util.HashMap;

public class BusinessCustomer extends Customer {
    public BusinessCustomer() {
        setCustomerType(CustomerType.BUSINESS);
        for (int i = 0; i < Roll.RollType.values().length; i++) {
            order.put(Roll.RollType.values()[i], 2);
        }
    }

    public HashMap<Roll.RollType, Integer> order(HashMap<Roll.RollType, Integer> inventory) {
        int numOutOfStock = numOutOfStock(inventory);
        if (numOutOfStock > 0) {
            this.orderCost = -1;
            purchase();
            return inventory;
        } else {
            // numOutOfStock equals 0, take full order
            inventory = takeFullOrder(inventory);
        }
        purchase();
        return inventory;
    }
}
