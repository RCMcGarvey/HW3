package Rolls;

import java.util.ArrayList;
import java.util.List;

public class EggRoll implements Rolls {

    EggRoll(int quantity){
        this.inventory = quantity;
    }

    public int inventory;

    @Override
    public int getInventory() {
        return inventory;
    }
}
