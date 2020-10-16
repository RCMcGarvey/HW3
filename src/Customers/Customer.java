package Customers;

import Observers.Recorder;
import Rolls.Roll;
import Rolls.RollFactory;

import java.util.*;

public abstract class Customer {
    public enum CustomerType {CASUAL, BUSINESS, CATERING};
    private CustomerType customerType;
    protected HashMap<Roll.RollType, Integer> order = new HashMap<>();
    private List<Recorder> recorders = new ArrayList<>();
    private RollFactory rollFactory = new RollFactory();
    protected int orderCost = 0;
    private HashMap<Roll.RollType, Integer> rollsOrdered = new HashMap<>();

    protected void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    // Observer Pattern methods
    public void addObserver(Recorder recorder) {
        this.recorders.add(recorder);
    }

    public void removeObserver(Recorder recorder) {
        this.recorders.remove(recorder);
    }

    protected void purchase() {
        for (Recorder recorder : this.recorders) {
            recorder.sale(customerType, rollsOrdered, orderCost);
        }
    }

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
        if (supply == 0) {
            return inventory;
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
                    Roll roll = rollFactory.getRoll(rollType);
                    this.orderCost += roll.cost();
                    this.rollsOrdered.put(rollType, rollsOrdered.getOrDefault(rollType, 0) + 1);
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
            int numberOfRolls = (Integer) entry.getValue();
            inventory.put(rollType, inventory.get(rollType) - numberOfRolls);
            // Create rolls and purchase them
            for (int i = 0; i < numberOfRolls; i++) {
                Roll roll = rollFactory.getRoll(rollType);
                this.orderCost += roll.cost();
                this.rollsOrdered.put(rollType, rollsOrdered.getOrDefault(rollType, 0) + 1);
            }
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
}
