package Customers;

import Rolls.Roll;

import java.util.*;

public abstract class Customer {
    public enum CustomerType {CASUAL, BUSINESS, CATERING};
    protected HashMap<Roll.RollType, Integer> order = new HashMap<>();
    protected CustomerType customerType;

    protected Roll.RollType chooseRollType() {
        Random random = new Random();
        return Roll.RollType.values()[random.nextInt(Roll.RollType.values().length)];
    }


    protected HashMap<Roll.RollType, Integer> orderAnyRolls(HashMap<Roll.RollType, Integer> inventory) {
        int max = 0;
        for (int n : order.values()) {
            max += n;
        }
        int supply = 0;
        for (int n : inventory.values()) {
            supply += n;
        }

        for (int i = 0; i < max; i++) {
            if (supply == 0) {
                return inventory;
            }
            // order any roll
            Set set = inventory.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                Roll.RollType rollType = (Roll.RollType) entry.getKey();
                if (inventory.get(rollType) > 0) {
                    inventory.put(rollType, ((Integer) entry.getValue()) - 1);
                    break;
                }
            }
            supply -= 1;
        }

        return inventory;
    }

    protected HashMap<Roll.RollType, Integer> takeFullOrder(HashMap<Roll.RollType, Integer> inventory) {
        Set set = order.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Roll.RollType rollType = (Roll.RollType) entry.getKey();
            inventory.put(rollType, inventory.get(rollType) - ((Integer) entry.getValue()));
        }
        return inventory;
    }

    protected int numOutOfStock(HashMap<Roll.RollType, Integer> inventory) {
        // https://beginnersbook.com/2013/12/hashmap-in-java-with-example/#:~:text=HashMap%20is%20a%20Map%20based,null%20values%20and%20null%20key).
        int numOutOfStock = 0;
        Set set = order.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (inventory.get(entry.getKey()) < order.get(entry.getKey())) {
                numOutOfStock += order.get(entry.getKey()) - inventory.get(entry.getKey());
            }
        }
        return numOutOfStock;
    }

    public abstract HashMap<Roll.RollType, Integer> order(HashMap<Roll.RollType, Integer> inventory);

    public CustomerType getCustomerType() {return this.customerType;}
}
