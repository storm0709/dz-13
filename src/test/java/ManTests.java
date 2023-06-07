import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.example.Man;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManTests {
    private Man man;
    private static final Logger log = LogManager.getLogger(ManTests.class);

    @Description("This test checks if a man is NOT retired")
    @Step("Checking age {0} and Setting isRetired if a man has age 65+")
    @Test(description = "Check if a man is not retired", dataProvider = "age", dataProviderClass = TestDataProviders.class)
    public void testIsNotRetired(int age){
        log.trace("[Log4j] Starting testIsNotRetired with age={}", age);
        log.debug("[Log4j] Starting testIsNotRetired with age={}", age);
        log.info("[Log4j] Starting testIsNotRetired with age={}", age);
        log.info("[Log4j] Creating a man instance with age={}", age);
        log.warn("[Log4j] Starting testIsNotRetired with age={}", age);
        log.error("[Log4j] Starting testIsNotRetired with age={}", age);
        log.fatal("[Log4j] Starting testIsNotRetired with age={}", age);
        Reporter.log("[Reporter] Starting testIsNotRetired with age={}");
        man = new Man("Bob", "Last", age, "Name", false);
        log.info("[Log4j] Checking if the man instance age={} is retired", age);
        Reporter.log("[Reporter] Starting testIsNotRetired with age={}");
        Assert.assertFalse(man.isRetired(), "Age "+man.getAge()+" is 65+ years");
        Allure.addAttachment("log","text","[Reporter] Starting testIsNotRetired with age={}");
        Allure.addAttachment("log","text","[Log4j] Checking if the man instance age={} is retired");

    }

    @Description("This test checks if a man IS retired")
    @Test(description = "Check if a man is retired", dataProvider = "age", dataProviderClass = TestDataProviders.class)
    public void testIsRetired(int age){
        man = new Man("John", "LastName", age, "LastName", false);
        Assert.assertTrue(man.isRetired(), "Age "+man.getAge()+" is below 65 years");
    }

    @Description("This test checks if a partner is changed")
    @Test(description = "Check if partner is changed", dataProvider = "lastName", dataProviderClass = TestDataProviders.class)
    public void testRegisterPartnershipChanges(String lastName){
        man = new Man("John", lastName, 60, "LastName", false);
        man.registerPartnership(lastName);
        Assert.assertEquals(man.getLastName(), man.getPartner());
    }

    @Description("This test checks if a partner is changed and isDivorced status is changed")
    @Test(description = "Check if a partner is changed and isDivorced is changed when had one before", dataProvider = "partnerDivorced", dataProviderClass = TestDataProviders.class)
    public void testDeregisterPartnershipChanges(String partner, Boolean divorced){
        man = new Man("John", "LastName", 60, partner, divorced);
        man.deregisterPartnership();
        Assert.assertNotEquals(man.getLastName(), man.getPartner());
        Assert.assertTrue(man.getIsDevorced(), "The field 'isDivorced' set to false");
    }

    @Description("This test checks if a partner is NOT changed")
    @Test(description = "Check if a partner is not changed when didn't have one before", dataProvider = "partnerDivorced", dataProviderClass = TestDataProviders.class)
    public void testDeregisterPartnershipNotChanges(String partner, Boolean divorced){
        man = new Man("John", "LastName", 60, partner, divorced);
        man.deregisterPartnership();
        Assert.assertEquals(man.getPartner(),null);
    }
}

