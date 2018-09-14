package de.springboot.rest.services.restfulwebservices.versioning;

public class Name {

        private String firstName;
    private String secondName;

    public Name(String firstName,String secondName){
        this.firstName=firstName;
        this.secondName=secondName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
