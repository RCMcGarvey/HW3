package Rolls;

public abstract class Roll {
    public enum RollType {SPRING, EGG, PASTRY, SAUSAGE, JELLY};
    private RollType rollType;

    public void setRollType(RollType rollType) {
        this.rollType = rollType;
    }

    public RollType getRollType() {
        return this.rollType;
    }
    
    public abstract int cost();
}
