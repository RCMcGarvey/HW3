package Rolls;

public class SpringRoll extends Roll {
    SpringRoll() {
        setRollType(RollType.SPRING);
    }

    @Override
    public int cost() {
        return 1;
    }
}
