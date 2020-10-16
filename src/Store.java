import Customers.Customer;
import Observers.Recorder;
import Rolls.Roll;
import Rolls.RollFactory;
import java.util.*;

public class Store{
    private final int inventoryLevel;

    Store (int inventoryLevel) {
        this.inventoryLevel = inventoryLevel;
    }

    private int day = 0;
    private Random rand = new Random();
    //recycled from HW2
    private List<Recorder> recorders = new ArrayList<>();


    //private CustomerFactory customerFactory = new CustomerFactory()

    HashMap<Roll.RollType, Integer> inventory = new HashMap<>();



    RollFactory rollFactory = new RollFactory();

    public void runDay(){
        List<Customer> dailyCustomers = new ArrayList<>();
        dailyCustomers = getCustomers();
        for(int i = 0; i < dailyCustomers.size(); ++i){
            //dailyCustomers[i].order
        }




    }

//    public void addObserver(Recorder recorder) {
//        this.recorders.add(recorder);
//    }
//
//    public void removeObserver(Recorder recorder) {
//        this.recorders.remove(recorder);
//    }
//
////    private void changeState(String event){
////        for(Recorder recorder : this.recorders){
////            recorder.sale(event);
////        }
////    }


    public void stockInventory() {
        for (Roll.RollType rollType : Roll.RollType.values()) {
            inventory.put(rollType, inventoryLevel);
        }
    }

    public List<Customer> getCustomers(){

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


    public HashMap<Roll.RollType, Integer> getInventory() {
        return inventory;
    }

    public boolean emptyInventory() {
        int stock = 0;
        for (int s : inventory.values()) {
            stock += s;
        }
        return stock <= 0;
    }

    public void printInventory() {
        Set set = inventory.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("    " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
