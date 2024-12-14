package com.example.demo.Entity;

import java.sql.Date;
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
@Table(name = "monuments")
public class Monuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

   @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "state_id")
    private State stateId;

    @Column(name="threeD_image")
    private String  threeD_image ;
    
    public String getThreeD_image() {
        return threeD_image;
    }

    public void setThreeD_image(String threeD_image) {
        this.threeD_image = threeD_image;
    }

    @Column(name = "monument_name", nullable = false, length = 255)
    private String monumentName;

    @Column(name = "location", length = 500)
    private String location;

    @Column(name = "built_year")
    private java.sql.Date builtYear;

    @Column(name = "architectural_style", columnDefinition = "TEXT")
    private String architecturalStyle;

    @Column(name = "historical_significance", columnDefinition = "TEXT")
    private String historicalSignificance;

    @Column(name = "images", columnDefinition = "TEXT")
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

    public Monuments() {
    }

    public Monuments(State stateId, String monumentName, String location, Date builtYear, String architecturalStyle,
        String historicalSignificance, String images) {
        this.stateId = stateId;
        this.monumentName = monumentName;
        this.location = location;
        this.builtYear = builtYear;
        this.architecturalStyle = architecturalStyle;
        this.historicalSignificance = historicalSignificance;
        this.images = images;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public String getMonumentName() {
        return monumentName;
    }

    public void setMonumentName(String monumentName) {
        this.monumentName = monumentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public java.sql.Date getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(java.sql.Date builtYear) {
        this.builtYear = builtYear;
    }

    public String getArchitecturalStyle() {
        return architecturalStyle;
    }

    public void setArchitecturalStyle(String architecturalStyle) {
        this.architecturalStyle = architecturalStyle;
    }

    public String getHistoricalSignificance() {
        return historicalSignificance;
    }

    public void setHistoricalSignificance(String historicalSignificance) {
        this.historicalSignificance = historicalSignificance;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
