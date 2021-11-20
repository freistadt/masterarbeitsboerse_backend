package com.masterarbeitsboerse.masterarbeitsboerse.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//Serializable --> For better saving/controll when saving instances to Database
public class Paper implements Serializable{

    //for the primary Key in the database
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    //updatetabele = to make sure the value can not be changed after the ID is created
    @Column(updatable = false, nullable = false)
    // preventing null values
    @NotNull
    private Long id;
    private  String title;
    private String description;
    private String paperCode;
    private String contact_person;
    private String imageUrl;

    //default Consturctor
    public Paper() {}

    //TODO add consturctors for other instances with less values passed
    public Paper(String title, String description, String contact_person, String imageUrl) {
        this.title = title;
        this.description = description;
        this.contact_person = contact_person;
        this.imageUrl = imageUrl;

    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", contact_person='" + contact_person + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

