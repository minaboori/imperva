package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "films")
public class Film {

    @Id
    private long id;

    @Field(name = "Title")
    private String title;

    @Field(name = "Special Features")
    private String specialFeatures;

    @Field(name = "Replacement Cost")
    private Double replacementCost;

    @Field(name = "Rental Duration")
    private int rentalDuration;

    @Field(name = "Rating")
    private String rating;

    @Field(name = "Length")
    private int length;

    @Field(name = "Description")
    private String description;

    @Field(name = "Category")
    private String category;

    @DBRef
    @Field(name = "Actors")
    private List<Actor> actorList;

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", replacementCost=" + replacementCost +
                ", rentalDuration=" + rentalDuration +
                ", rating='" + rating + '\'' +
                ", length=" + length +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", actorList=" + actorList +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}