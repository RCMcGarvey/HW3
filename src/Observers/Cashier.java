package Observers;

import Customers.Customer;
import Rolls.Roll;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cashier implements Recorder {
    private HashMap<Customer.CustomerType, Integer> paymentsByCustomers = new HashMap<>();
    private HashMap<Customer.CustomerType, Integer> outagesByCustomers = new HashMap<>();
    public HashMap<Roll.RollType, Integer> dailyRollsSold = new HashMap<>();
    public int dailySales = 0;
    public int dailyOutages = 0;

    @Override
    public void sale(Customer.CustomerType customerType, HashMap<Roll.RollType, Integer> rollsOrdered, int orderCost) {
        // Check outage and add to outagesByCustomers
        if (orderCost <= 0) {
            outagesByCustomers.put(customerType, outagesByCustomers.getOrDefault(customerType, 0) + 1);
            dailyOutages += 1;
            return;
        }

        System.out.println("Order by " + customerType + " customer for $" + orderCost + " with extras:");
        Set set = rollsOrdered.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Roll.RollType rollType = (Roll.RollType) entry.getKey();

            // Print order
            System.out.println("    " + rollType + ": " + (Integer) entry.getValue());

            // Add to dailyRollsSold
            dailyRollsSold.put(rollType, dailyRollsSold.getOrDefault(rollType, 0) + 1);
        }

        // Add to paymentsByCustomer
        paymentsByCustomers.put(customerType, paymentsByCustomers.getOrDefault(customerType, 0) + orderCost);

        // Add to dailySales
        dailySales += orderCost;
    }

    public void printDailyStats() {
        Set set;
        Iterator iterator;

        // Print total payment for order for the day by customer type
        System.out.println("Payments by customer type:");
        set = paymentsByCustomers.entrySet();
        iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if ((Integer) entry.getValue() > 0) {
                System.out.println("    " + entry.getKey() + ": $" + entry.getValue());
            }
        }

        // Print total outages by customer type
        System.out.println("Outages by customer type:");
        set = outagesByCustomers.entrySet();
        iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("    " + entry.getKey() + ": " + entry.getValue());
        }

//        System.out.println("Rolls sold by type:");
//        Set set = rollsSold.entrySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            System.out.println("    " + entry.getKey() + ": " + entry.getValue());
//            totalRollsSold += (int) entry.getValue();
//        }
    }
}
