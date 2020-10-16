package Customers;

import Rolls.Roll;

import java.util.Random;

public class CasualCustomer extends Customer {
    public CasualCustomer() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(4); i++) {
            Roll.RollType rollType = chooseRollType();
        }
    }
}
