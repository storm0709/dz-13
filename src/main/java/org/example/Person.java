package org.example;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String partner;
    private boolean isDevorced;

    public Person (String firstName, String lastName, int age, String partner,boolean isDevorced){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.partner=partner;
        this.isDevorced=isDevorced;
    }

    public abstract boolean isRetired();
    public abstract void registerPartnership(String newLastName);

    private void deregisterPartnership(){
        if (isDevorced){
            System.out.println("Has devorced with "+partner);
        }
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public boolean getIsDevorced() {
        return isDevorced;
    }

    public void setIsDevorced(boolean isDevorced) {
        this.isDevorced = isDevorced;
    }


}

