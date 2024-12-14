package com.example.demo.Entity;

import java.util.Arrays;
import java.util.List;

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
@Table(name="languages")
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "state_id")
    private State stateId;

    @Column(name = "language_name", nullable = false)
    private String languageName;

    @Column(name = "region_spoken", columnDefinition = "TEXT")
    private String regionSpoken;

    @Column(name = "dialects", columnDefinition = "TEXT")
    private String dialects;

    @Column(name = "number_of_speakers")
    private String numberOfSpeakers;

    @Column(name = "images")
    private String images;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Languages() {
    }

    public Languages(State stateId, String languageName, String regionSpoken, String dialects,
            String numberOfSpeakers) {
        this.stateId = stateId;
        this.languageName = languageName;
        this.regionSpoken = regionSpoken;
        this.dialects = dialects;
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getRegionSpoken() {
        return regionSpoken;
    }

    public void setRegionSpoken(String regionSpoken) {
        this.regionSpoken = regionSpoken;
    }

    public String getDialects() {
        return dialects;
    }

    public void setDialects(String dialects) {
        this.dialects = dialects;
    }

    public String getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(String numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }
    

}
