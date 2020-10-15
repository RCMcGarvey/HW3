package Rolls;

public class SpringRoll implements Rolls {

    SpringRoll(int quantity){
        this.inventory = quantity;
    }

    public int inventory;

    @Override
    public int getInventory() {
        return inventory;
    }

}
