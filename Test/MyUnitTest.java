import Customers.Customer;
import Customers.CustomerFactory;
import Rolls.Roll;
import Rolls.RollFactory;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MyUnitTest {

    @Test
    public void springRollFactoryTest(){
        RollFactory rollFactory = new RollFactory();
        Roll myRoll = rollFactory.getRoll(Roll.RollType.SPRING);
        assertEquals(myRoll.getRollType(), Roll.RollType.SPRING);
    }

    @Test
    public void eggRollFactoryTest(){
        RollFactory rollFactory = new RollFactory();
        Roll myRoll = rollFactory.getRoll(Roll.RollType.EGG);
        assertEquals(myRoll.getRollType(), Roll.RollType.EGG);
    }

    @Test
    public void pastryRollFactoryTest(){
        RollFactory rollFactory = new RollFactory();
        Roll myRoll = rollFactory.getRoll(Roll.RollType.PASTRY);
        assertEquals(myRoll.getRollType(), Roll.RollType.PASTRY);
    }

    @Test
    public void sausageRollFactoryTest(){
        RollFactory rollFactory = new RollFactory();
        Roll myRoll = rollFactory.getRoll(Roll.RollType.SAUSAGE);
        assertEquals(myRoll.getRollType(), Roll.RollType.SAUSAGE);
    }

    @Test
    public void jellyRollFactoryTest(){
        RollFactory rollFactory = new RollFactory();
        Roll myRoll = rollFactory.getRoll(Roll.RollType.JELLY);
        assertEquals(myRoll.getRollType(), Roll.RollType.JELLY);
    }

    @Test
    public void casualCustomerFactoryTest(){
        CustomerFactory customerFactory = new CustomerFactory();
        Customer myRoll = customerFactory.getCustomer(Customer.CustomerType.CASUAL);
        assertEquals(myRoll.getCustomerType(), Customer.CustomerType.CASUAL);
    }

    @Test
    public void buisnessCustomerFactoryTest(){
        CustomerFactory customerFactory = new CustomerFactory();
        Customer myRoll = customerFactory.getCustomer(Customer.CustomerType.BUSINESS);
        assertEquals(myRoll.getCustomerType(), Customer.CustomerType.BUSINESS);
    }

    @Test
    public void cateringCustomerFactoryTest(){
        CustomerFactory customerFactory = new CustomerFactory();
        Customer myRoll = customerFactory.getCustomer(Customer.CustomerType.CATERING);
        assertEquals(myRoll.getCustomerType(), Customer.CustomerType.CATERING);
    }

    @Test
    public void businessOrderFailTest(){
        CustomerFactory customerFactory = new CustomerFactory();
        Customer myCust = customerFactory.getCustomer(Customer.CustomerType.BUSINESS);
        HashMap<Roll.RollType, Integer> inventory = new HashMap<>();
        inventory.put(Roll.RollType.SPRING, 1);
        inventory.put(Roll.RollType.EGG, 1);
        inventory.put(Roll.RollType.PASTRY, 1);
        inventory.put(Roll.RollType.SAUSAGE, 1);
        inventory.put(Roll.RollType.JELLY, 1);
        Integer originalAmount = inventory.get(Roll.RollType.SPRING);
        Integer finalAmount = myCust.order(inventory).get(Roll.RollType.SPRING);
        assertEquals(finalAmount, originalAmount);
    }

    @Test
    public void businessOrderPassTest(){
        CustomerFactory customerFactory = new CustomerFactory();
        Customer myCust = customerFactory.getCustomer(Customer.CustomerType.BUSINESS);
        HashMap<Roll.RollType, Integer> inventory = new HashMap<>();
        inventory.put(Roll.RollType.SPRING, 30);
        inventory.put(Roll.RollType.EGG, 30);
        inventory.put(Roll.RollType.PASTRY, 30);
        inventory.put(Roll.RollType.SAUSAGE, 30);
        inventory.put(Roll.RollType.JELLY, 30);
        Integer originalAmount = inventory.get(Roll.RollType.SPRING);
        Integer finalAmount = myCust.order(inventory).get(Roll.RollType.SPRING);
        assertNotEquals(finalAmount, originalAmount);
    }

}
