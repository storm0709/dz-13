import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WomanTests {
    private Woman woman;
    private static final Logger log = LogManager.getLogger(WomanTests.class);

    @Test(description = "Check if a woman is not retired", dataProvider = "age", dataProviderClass = TestDataProviders.class)
    public void testIsNotRetired(int age){
        woman = new Woman("Anna", "Last", age, "Name", false,"LastNameOriginal");
        Assert.assertFalse(woman.isRetired(),"Age "+woman.getAge()+" is 60+ years");
    }

    @Test(description = "Check if a woman is retired", dataProvider = "age", dataProviderClass = TestDataProviders.class)
    public void testIsRetired(int age){
        woman = new Woman("Bella", "LastName", age, "LastName", false,"LastNameOriginal");
        Assert.assertTrue(woman.isRetired(), "Age "+woman.getAge()+" is below 60 years");
    }

    @Test(description = "Check if LastName is changed and partner is changed", dataProvider = "lastName", dataProviderClass = TestDataProviders.class)
    public void testRegisterPartnershipChanges(String lastName){
        woman = new Woman("Bella", "LastName", 60, null, false,"LastNameOriginal");
        woman.registerPartnership(lastName);
        Assert.assertEquals(woman.getLastName(),lastName);
        Assert.assertEquals(woman.getLastName(), woman.getPartner());
    }

    @Test(description = "Check if a partner is changed, isDivorced is changed and LastName is changed", dataProvider = "partnerDivorced", dataProviderClass = TestDataProviders.class)
    public void testDeregisterPartnershipChanges(String partner, Boolean divorced){
        woman = new Woman("Bella", "LastName", 60, partner, divorced,"LastNameOriginal");
        woman.deregisterPartnership();
        Assert.assertNotEquals(woman.getPartner(),woman.getLastName());
        Assert.assertTrue(woman.getIsDevorced());
        Assert.assertEquals(woman.getLastName(),woman.getLastNameOriginal(), "Partner is set to null");
    }

    @Test(description = "Check if a partner is not changed", dataProvider = "partnerDivorced", dataProviderClass = TestDataProviders.class)
    public void testDeregisterPartnershipNotChanges(String partner, Boolean divorced){
        woman = new Woman("Bella", "LastNameOriginal", 60, partner, divorced,"LastNameOriginal");
        woman.deregisterPartnership();
        Assert.assertEquals(woman.getPartner(),null);
    }

    @Test(description = "Check if getLastNameOriginal() works", dataProvider = "lastName", dataProviderClass = TestDataProviders.class)
    public void testLastNameOriginal(String lastName){
        woman = new Woman("Lisa", "Yong", 60, null, false, "Yong");
        woman.setLastNameOriginal(lastName);
        Assert.assertEquals(woman.getLastNameOriginal(), lastName, "The original name is not the same");
    }

    @Test(description = "Check if a woman has LastNameOriginal not NULL", dataProvider = "lastName", dataProviderClass = TestDataProviders.class)
    public void testGetLastNameOriginalNotNull(String lastName){
        woman = new Woman("Lisa", "Yong", 60, null, false, lastName);
        Assert.assertNotEquals(woman.getLastNameOriginal(),null, "LastNameOriginal is null");
    }

    @Test(description = "Check if a woman has setLastNameOriginal()", dataProvider = "lastName", dataProviderClass = TestDataProviders.class)
    public void testSetLastNameOriginal(String lastName){
        woman = new Woman("Lisa", "Yong", 60, null, false, "Yong");
        woman.setLastNameOriginal(lastName);
        Assert.assertEquals(woman.getLastNameOriginal(), lastName);
    }

}
