package Rolls;

public class JellyRoll extends Roll {
    JellyRoll() {
        setRollType(RollType.JELLY);
    }

    @Override
    public int cost() {
        return 5;
    }
}
