package com.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Person {

    @Field(name = "First Name")
    private String firstName;

    @Field(name = "Last Name")
    private String lastName;

    @Override
    public String toString() {
        return  " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' ;
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
}
