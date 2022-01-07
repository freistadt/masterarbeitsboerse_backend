package com.masterarbeitsboerse.masterarbeitsboerse.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private String title;
    private String description;
    private String paperCode;
    private String contact_person;
    private String imageUrl;
    private String division;
    private String institute;
    private boolean isPaid;
    private boolean withPartner;
    private Date startDate;
    private Date endDate;
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //default Consturctor
    public Paper() {}



    //TODO add consturctors for other instances with less values passed
    public Paper(String title, String description, String contact_person, String imageUrl,String division, String institute,
                 boolean isPaid, boolean withPartner, Date startDate, Date endDate, String type) {
        this.title = title;
        this.description = description;
        this.contact_person = contact_person;
        this.imageUrl = imageUrl;
        this.division =division;
        this.institute = institute;
        this.isPaid = isPaid;
        this.withPartner = withPartner;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isWithPartner() {
        return withPartner;
    }

    public void setWithPartner(boolean withPartner) {
        this.withPartner = withPartner;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
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

