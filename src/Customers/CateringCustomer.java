package Customers;

import Rolls.Roll;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CateringCustomer extends Customer {
    public CateringCustomer() {
        setCustomerType(CustomerType.CATERING);
        Integer[] arr = new Integer[Roll.RollType.values().length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));

        for (int i = 0; i < 3; i++) {
            order.put(Roll.RollType.values()[arr[i]], 5);
        }
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
