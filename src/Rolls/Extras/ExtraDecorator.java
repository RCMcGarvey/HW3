package Rolls.Extras;

import Rolls.Roll;

// This class and the concrete classes in the Extras package implement a Decorator Pattern
public abstract class ExtraDecorator extends Roll {
    protected Roll roll;

    public RollType getRollType() {
        return roll.getRollType();
    }
}
