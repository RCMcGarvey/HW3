package Rolls;

public class PastryRoll extends Roll {
    PastryRoll() {
        setRollType(RollType.PASTRY);
    }

    @Override
    public int cost() {
        return 3;
    }
}
