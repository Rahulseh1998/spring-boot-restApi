package com.demo.springboot.finaltest.model;

import javax.persistence.Embeddable;

@Embeddable
public class Location {

    String city,pincode,country;

    public Location() {
    }

    public Location(String city, String pincode, String country) {
        this.city = city;
        this.pincode = pincode;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
