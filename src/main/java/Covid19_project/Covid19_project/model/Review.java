package com.example.covidProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Review {

    private final UUID id;

    private final String country;

    private String textbox;

    private final String postDate;

    public Review(@JsonProperty("id")UUID id, @JsonProperty("country")String country
                 , @JsonProperty("textbox")String textbox){
        this.id = id;
        this.country = country;
        this.textbox = textbox;

        LocalDateTime time = LocalDateTime.now();
        this.postDate = time.toString();
    }

    public UUID getId(){ return id; }
    public String getCountry(){ return country;}
    public String getTextbox(){ return textbox;}
    public String getPostDate(){ return  postDate;}

    public boolean equals(Review review){
        return id.equals(review.getId()) && country.equals(review.getCountry());
    }

    public void setTextbox(String textbox){
        this.textbox = textbox;
    }
}
