import Customers.Customer;
import Rolls.Roll;
import Rolls.RollFactory;
import java.util.*;

public class Store{
    //All info on dictionaries was gathered from https://www.geeksforgeeks.org/java-util-dictionary-class-java/
    Store() {
        this.inventory.put(Roll.RollType.SPRING, 30);
        this.inventory.put(Roll.RollType.EGG, 30);
        this.inventory.put(Roll.RollType.PASTRY, 30);
        this.inventory.put(Roll.RollType.SAUSAGE, 30);
        this.inventory.put(Roll.RollType.JELLY, 30);
    }

    private Random rand = new Random();

    //private CustomerFactory customerFactory = new CustomerFactory()

    HashMap<Roll.RollType, Integer> inventory = new HashMap<>();



    RollFactory rollFactory = new RollFactory();

    private void refreshInventory(){
        Set set = inventory.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            Roll.RollType rollType = (Roll.RollType) mentry.getKey();
            inventory.put(rollType, 30);
        }
    }

    public void runDay(){
        List<Customer> dailyCustomers = new ArrayList<>();
        dailyCustomers = getCustomers();
        for(int i = 0; i < dailyCustomers.size(); ++i){
            //dailyCustomers[i].order
        }




    }

    private List<Customer> getCustomers(){

        int casuals = rand.nextInt(12)+1;
        int business = rand.nextInt(3)+1;
        int caterers = rand.nextInt(3)+1;
        int a = 0;
        int b = 0;
        int c = 0;
        while(!(a == casuals) &&  !(b == business) && !(c == caterers)){
            int z = rand.nextInt(3);
            int y = rand.nextInt(2);
            if(z == 0){
                if(a == casuals){
                    if(y == 0){
                        b++;
                    } else {
                        c++;
                    }
                }else {
                    a++;
                }
            } else if(z == 1) {
                if(b == business){
                    if(y == 0){
                        a++;
                    } else {
                        c++;
                    }
                }else {
                    b++;
                }
            } else if(z == 2){
                if(c == caterers){
                    if(y == 0){
                        a++;
                    } else {
                        b++;
                    }
                }else {
                    c++;
                }
            }
        }
        return null;
    }


    private int day = 0;


}
