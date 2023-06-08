import org.testng.annotations.DataProvider;


public class TestDataProviders {
    private final static String PATH ="src/test/resources/data.csv";
    @DataProvider(name="age")
    public static Object [][] ageDataProvider(){
      return CsvReader.getListObjectsFromCsv(PATH, Data.class).stream().map(age -> new Object[]{age.getAge()})
              .toArray(Object[][]::new);
    }

    @DataProvider(name="ageDB")
    public static Object [][] ageDataProviderDB(){
        return DBReader.getAgeFromDB().stream().map(age -> new Object[]{age.getAge()})
                .toArray(Object[][]::new);
    }

    @DataProvider(name="lastName")
    public static Object [][] lastNameDataProvider(){

        return new Object[][]{{"John"}, {"Brown"}, {null}, {""}};
    }

    @DataProvider(name="lastNameDB")
    public static Object [][] lastNameDataProviderDB(){
        return DBReader.getAgeFromDB().stream().map(lastName -> new Object[]{lastName.getLastName()})
                .toArray(Object[][]::new);
    }

    @DataProvider(name="partnerDivorced")
    public static Object [][] partnerDivorcedDataProvider(){
        return new Object[][]{{"John", true}, {"Brown", false}, {null, true}, {"",false}};
    }
}
