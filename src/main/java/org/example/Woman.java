package org.example;

public class Woman extends Person {
    private String lastNameOriginal;

    public Woman(String firstName, String lastName, int age, String partner, boolean isDevorced, String lastNameOriginal) {
        super(firstName, lastName, age, partner, isDevorced);
        this.lastNameOriginal = lastNameOriginal;
    }

    @Override
    public boolean isRetired() {
        if (getAge() >= 60) {
            System.out.println("Already retired");
            return true;
        }
        System.out.println("Not retired yet");
        return false;
    }

    public void registerPartnership(String newLastName) {
        setLastName(newLastName);
        setPartner(getLastName());
        System.out.println("This woman is married to " + getPartner());
    }

    public String getLastNameOriginal() {

        return lastNameOriginal;
    }

    public void setLastNameOriginal(String lastNameOriginal) {

        this.lastNameOriginal = lastNameOriginal;
    }

    public void deregisterPartnership() {
        if (getPartner() == null) {
            return;
        }
        setPartner(null);
        setIsDevorced(true);
        setLastName(lastNameOriginal);
        System.out.println("Partner is " + getPartner() + " isDivorced status is " + getIsDevorced() + " LastName is " + getLastNameOriginal());
    }
}
