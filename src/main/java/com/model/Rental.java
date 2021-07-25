package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document
public class Rental {

    @Field(name = "rentalId")
    private long rentalId;

    @Field(name = "filmId")
    private long filmId;

    @Field(name = "Film Title")
    private String filmTitle;

    @Field(name = "Rental Date")
    private String rentalDate;

    @Field(name = "Return Date")
    private String returnDate;

    @Field(name = "staffId")
    private int staffId;

    @Transient
    private int duration;


    @DBRef
    @Field(name = "Payments")
    private List<Payment> paymentList;

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", filmId=" + filmId +
                ", filmTitle='" + filmTitle + '\'' +
                ", rentalString=" + rentalDate +
                ", returnString=" + returnDate +
                ", staffId=" + staffId +
                ", paymentList=" + paymentList +
                '}';
    }

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public int getDuration() {
        try {
            Date rentalDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(getRentalDate());
            Date returnDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(getReturnDate());
            this.duration = (int) ((returnDate.getTime() - rentalDate.getTime()) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}