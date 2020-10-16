import Rolls.Roll;
import java.util.*;

public class Store{
    private final int inventoryLevel;

    Store (int inventoryLevel) {
        this.inventoryLevel = inventoryLevel;
    }

    public HashMap<Roll.RollType, Integer> inventory = new HashMap<>();

    public void stockInventory() {
        for (Roll.RollType rollType : Roll.RollType.values()) {
            inventory.put(rollType, inventoryLevel);
        }
    }

    public HashMap<Roll.RollType, Integer> getInventory() {
        return inventory;
    }

    public boolean emptyInventory() {
        int stock = 0;
        for (int s : inventory.values()) {
            stock += s;
        }
        return stock <= 0;
    }

    public void printInventory() {
        Set set = inventory.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("    " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
