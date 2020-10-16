package Customers;

import Rolls.Roll;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public abstract class Customer {
    public enum CustomerType {CASUAL, BUSINESS, CATERING};
    protected Dictionary<Roll.RollType, Integer> order = new Hashtable<>(
    );

    protected Roll.RollType chooseRollType() {
        Random random = new Random();
        return Roll.RollType.values()[random.nextInt(Roll.RollType.values().length)];
    }

    //public abstract void order();

}
