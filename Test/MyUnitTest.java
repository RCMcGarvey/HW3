import Customers.Customer;
import Customers.CustomerFactory;
import Rolls.Roll;
import Rolls.RollFactory;
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

}
