package com.example.demo.Entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "festivalcel")
public class FestivalCel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "festival_name", nullable = false)
    private String festivalName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "celebration_type")
    private String celebrationType;

    @Column(name = "rituals", columnDefinition = "TEXT")
    private String rituals;

    @Column(name = "cultural_importance", columnDefinition = "TEXT")
    private String culturalImportance;

    @Column(name = "images", columnDefinition = "TEXT")
    private String images;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "state_id")
    private State stateId;

    @Transient
    private List<String> imageList;

    @Transient
    private int length;

    public int getLength() {
        return getImageList()!=null?getImageList().size():0;
    }

    public void setLength(int length) {
        this.length = getImageList()!=null?getImageList().size():0;
    }

    public List<String> getImageList() {
        if (getImages() != null && getImages()!="") {
            this.imageList = Arrays.asList(getImages().split(","));
        }
        return this.imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public FestivalCel() {
    }

    public FestivalCel(String festivalName, Date dateTime, String celebrationType, String rituals,
            String culturalImportance, String images, State stateId) {
        this.festivalName = festivalName;
        this.dateTime = dateTime;
        this.celebrationType = celebrationType;
        this.rituals = rituals;
        this.culturalImportance = culturalImportance;
        this.images = images;
        this.stateId = stateId;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public java.util.Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(java.util.Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getCelebrationType() {
        return celebrationType;
    }

    public void setCelebrationType(String celebrationType) {
        this.celebrationType = celebrationType;
    }

    public String getRituals() {
        return rituals;
    }

    public void setRituals(String rituals) {
        this.rituals = rituals;
    }

    public String getCulturalImportance() {
        return culturalImportance;
    }

    public void setCulturalImportance(String culturalImportance) {
        this.culturalImportance = culturalImportance;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

}
