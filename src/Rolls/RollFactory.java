package Rolls;

import Rolls.Extras.Filling;
import Rolls.Extras.Sauce;
import Rolls.Extras.Topping;

import java.util.Random;

public class RollFactory {
    private int getRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    private Roll applyExtras(Roll roll) {
        // Apply sauces to roll
        for (int i = 0; i < getRandomInt(4); i++) {
            roll = new Sauce(roll);
        }
        // Apply fillings to roll
        for (int i = 0; i < getRandomInt(2); i++) {
            roll = new Filling(roll);
        }
        // Apply toppings to roll
        for (int i = 0; i < getRandomInt(3); i++) {
            roll = new Topping(roll);
        }
        return roll;
    }

    public Roll getRoll(Roll.RollType rollType){
        if (rollType == Roll.RollType.SPRING) {
            return applyExtras(new SpringRoll());
        } else if (rollType == Roll.RollType.EGG) {
            return applyExtras(new EggRoll());
        } else if (rollType == Roll.RollType.PASTRY) {
            return applyExtras(new PastryRoll());
        } else if (rollType == Roll.RollType.SAUSAGE) {
            return applyExtras(new SausageRoll());
        } else if (rollType == Roll.RollType.JELLY) {
            return applyExtras(new JellyRoll());
        } else {
            // Should probably throw exception instead
            return null;
        }
    }
}
