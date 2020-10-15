import Rolls.RollFactory;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Store{
    Store() {
        this.inventory.put("Spring Rolls", 30);
        this.inventory.put("Egg Rolls", 30);
        this.inventory.put("Pastry Rolls", 30);
        this.inventory.put("Sausage Rolls", 30);
        this.inventory.put("Jelly Rolls", 30);

    }

    Dictionary<String, Integer> inventory = new Hashtable<>();



    RollFactory rollFactory = new RollFactory();

    private void refreshInventory(){
        for(Enumeration i = inventory.keys(); i.hasMoreElements();) {
            if(inventory.get(i) == 0){
                inventory.put(i.toString(), 30);
            }
        }
    }

    public void runDay(){
        
    }


    private int day = 0;


}
