package Rolls.Extras;

import Rolls.Roll;

public abstract class ExtraDecorator extends Roll {
    protected Roll roll;

    public RollType getRollType() {
        return roll.getRollType();
    }
}
