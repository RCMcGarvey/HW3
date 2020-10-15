package Rolls;

public class JellyRoll implements Rolls {

    JellyRoll(int quantity){
        this.inventory = quantity;
    }

    public int inventory;

    @Override
    public int getInventory() {
        return inventory;
    }
}
