package Rolls;

public class SausageRoll extends Roll {
    SausageRoll() {
        setRollType(RollType.SAUSAGE);
    }

    @Override
    public int cost() {
        return 4;
    }

}
