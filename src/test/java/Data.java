import com.opencsv.bean.CsvBindByName;

public class Data {
    @CsvBindByName(column = "age")
    private int age;
    private String lastName;

    public Data() {
    }

    public Data(int age, String lastName) {
        this.age = age;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
