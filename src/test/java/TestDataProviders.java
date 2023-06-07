import org.testng.annotations.DataProvider;

public class TestDataProviders {
    @DataProvider(name="age")
    public static Object [][] ageDataProvider(){
        return new Object[][]{{59},{60},{61},{64}, {65}, {66}};
    }

    @DataProvider(name="lastName")
    public static Object [][] lastNameDataProvider(){
        return new Object[][]{{"John"}, {"Brown"}, {null}, {""}};
    }

    @DataProvider(name="partnerDivorced")
    public static Object [][] partnerDivorcedDataProvider(){
        return new Object[][]{{"John", true}, {"Brown", false}, {null, true}, {"",false}};
    }
}
