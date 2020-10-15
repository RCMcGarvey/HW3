package Rolls;

public class PastryRoll implements Rolls {

    PastryRoll(int quantity){
        this.inventory = quantity;
    }

    public int inventory;

    @Override
    public int getInventory() {
        return inventory;
    }
}
