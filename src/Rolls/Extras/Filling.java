package Rolls.Extras;

import Rolls.Roll;

public class Filling extends ExtraDecorator {
    public Filling(Roll roll) {
        this.roll = roll;
    }

    public int cost() {
        int cost = roll.cost();
        if (roll.getRollType() == RollType.SPRING) {
            cost += 1;
        } else if (roll.getRollType() == RollType.EGG) {
            cost += 2;
        } else if (roll.getRollType() == RollType.PASTRY) {
            cost += 3;
        } else if (roll.getRollType() == RollType.SAUSAGE) {
            cost += 4;
        } else if (roll.getRollType() == RollType.JELLY) {
            cost += 5;
        }
        return cost;
    }
}
