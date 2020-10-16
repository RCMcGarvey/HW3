import Customers.Customer;
import Rolls.RollFactory;
import java.util.*;

public class Store{
    //All info on dictionaries was gathered from https://www.geeksforgeeks.org/java-util-dictionary-class-java/
    Store() {
        this.inventory.put("Spring Rolls", 30);
        this.inventory.put("Egg Rolls", 30);
        this.inventory.put("Pastry Rolls", 30);
        this.inventory.put("Sausage Rolls", 30);
        this.inventory.put("Jelly Rolls", 30);

    }

    private int day = 0;
    private Random rand = new Random();
    //recycled from HW2
    private List<Announcer> announcers = new ArrayList<>();


    //private CustomerFactory customerFactory = new CustomerFactory()

    Dictionary<String, Integer> inventory = new Hashtable<>();



    RollFactory rollFactory = new RollFactory();

    public void runDay(){
        List<Customer> dailyCustomers = new ArrayList<>();
        dailyCustomers = getCustomers();
        for(int i = 0; i < dailyCustomers.size(); ++i){
            //dailyCustomers[i].order
        }




    }

    public void addObserver(Announcer announcer) {
        this.announcers.add(announcer);
    }

    public void removeObserver(Announcer announcer) {
        this.announcers.remove(announcer);
    }

    private void changeState(String event){
        for(Announcer announcer : this.announcers){
            announcer.message(event);
        }
    }


    private void refreshInventory(){
        for(Enumeration i = inventory.keys(); i.hasMoreElements();) {
            if(inventory.get(i) == 0){
                inventory.put(i.toString(), 30);
            }
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
        return
    }





}
