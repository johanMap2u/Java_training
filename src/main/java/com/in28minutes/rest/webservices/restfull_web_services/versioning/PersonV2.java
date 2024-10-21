package com.in28minutes.rest.webservices.restfull_web_services.versioning;

public class PersonV2 {
    @Override
    public String toString() {
        return "PersonV2{" +
                "name=" + name +
                '}';
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public PersonV2(Name name) {
        this.name = name;
    }

    private Name name;

}
