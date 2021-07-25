package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "customers")
public class Customer extends Person{

    @Id
    private long id;

    @Field(name = "Address")
    private String address;

    @Field(name = "City")
    private String city;

    @Field(name = "Country")
    private String country;

    @Field(name = "District")
    private String district;

    @Field(name = "Phone")
    private String phone;

    @DBRef
    @Field(name = "Rentals")
    private List<Rental> rentalFilms;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id + " ,"+super.toString()+
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", phone='" + phone + '\'' +
                ", rentalFilms=" + rentalFilms +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Rental> getRentalFilms() {
        return rentalFilms;
    }

    public void setRentalFilms(List<Rental> rentalFilms) {
        this.rentalFilms = rentalFilms;
    }
}