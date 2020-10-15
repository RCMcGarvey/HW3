package Rolls;

public class SausageRoll implements Rolls {

    SausageRoll(int quantity){
        this.inventory = quantity;
    }

    public int inventory;

    @Override
    public int getInventory() {
        return inventory;
    }

}
