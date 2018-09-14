package de.springboot.rest.services.restfulwebservices.versioning;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

public class PersonV1 {

    private String name;

    public PersonV1(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
