package Rolls;

public class EggRoll extends Roll {
    EggRoll() {
        setRollType(RollType.EGG);
    }

    @Override
    public int cost() {
        return 2;
    }
}
