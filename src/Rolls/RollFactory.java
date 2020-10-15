package Rolls;

public class RollFactory {

    public Rolls getRoll(String rollType, int quantity){
        if(rollType == "Spring") {
            return new SpringRoll(quantity);
        } else if(rollType == "Egg"){
            return new EggRoll(quantity);
        } else if(rollType == "Pastry"){
            return new PastryRoll(quantity);
        } else if(rollType == "Sausage"){
            return new SausageRoll(quantity);
        } else if(rollType == "Jelly"){
            return new JellyRoll(quantity);
        } else {
            return null;
        }
    }

}
