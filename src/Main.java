import Customers.Customer;
import Customers.CustomerFactory;
import Observers.Cashier;
import Observers.Recorder;
import Rolls.Roll;

import java.util.*;

public class Main {
    private static int INVENTORY_LEVEL = 30;
    private static int DAYS = 30;

    public static void main(String[] args) {
        // Summary statistics
        HashMap<Roll.RollType, Integer> rollsSold = new HashMap<>();
        for (Roll.RollType rollType : Roll.RollType.values()) {
            rollsSold.put(rollType, 0);
        }
        int totalSales = 0;
        int totalOutages = 0;

        // Create and stock the store
        Store store = new Store(INVENTORY_LEVEL);
        store.stockInventory();

        // Run days
        for (int i = 0; i < DAYS; i++) {
            // Print the day
            System.out.println("DAY " + (i + 1));

            // Get cashier for the day
            Cashier cashier = new Cashier();

            // Restock store if it has no inventory
            if (store.emptyInventory()) {
                store.stockInventory();
            }

            // Print store inventory at the start of the day
            System.out.println("Store inventory at the start of the day:");
            store.printInventory();

            // Create customers and shuffle them
            ArrayList<Customer> customers = getCustomers(cashier);
            Collections.shuffle(customers);

            // Have customers order rolls
            for (Customer customer : customers) {
                customer.order(store.getInventory());
            }

            // Check if store is empty
            if (store.emptyInventory()) {
                System.out.println("Store closes for the day because inventory has run out.");
            }

            // Print store inventory at the start of the day
            System.out.println("Store inventory at the end of the day:");
            store.printInventory();

            // Print daily stats
            cashier.printDailyStats();

            // Add to summary statistics
            for (Roll.RollType rollType : Roll.RollType.values()) {
                rollsSold.put(rollType, rollsSold.getOrDefault(rollType, 0) +
                        cashier.dailyRollsSold.getOrDefault(rollType, 0));
            }
            totalSales += cashier.dailySales;
            totalOutages += cashier.dailyOutages;
        }

        // Print summary statistics
        System.out.println("");
        System.out.println("STATISTICS FOR " + DAYS + " DAYS.");
        int totalRollsSold = 0;
        System.out.println("Rolls sold by type:");
        Set set = rollsSold.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("    " + entry.getKey() + ": " + entry.getValue());
            totalRollsSold += (int) entry.getValue();
        }
        System.out.printf("Total number of rolls sold: %d%n", totalRollsSold);
        System.out.printf("Total sales: $%d%n", totalSales);
        System.out.printf("Total outages: %d%n", totalOutages);
    }

    private static ArrayList<Customer> getCustomers(Recorder recorder) {
        ArrayList<Customer> customers = new ArrayList<>();
        CustomerFactory customerFactory = new CustomerFactory();
        Random random = new Random();

        // Create casual customers
        for (int i = 0; i < random.nextInt(12) + 1; i++) {
//        for (int i = 0; i < 1; i++) {
            Customer customer = customerFactory.getCustomer(Customer.CustomerType.CASUAL);
            customer.addObserver(recorder);
            customers.add(customer);
        }

        // Create business customers
        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            Customer customer = customerFactory.getCustomer(Customer.CustomerType.BUSINESS);
            customer.addObserver(recorder);
            customers.add(customer);
        }

        // Create catering customers
        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            Customer customer = customerFactory.getCustomer(Customer.CustomerType.CATERING);
            customer.addObserver(recorder);
            customers.add(customer);
        }

        return customers;
    }
}
