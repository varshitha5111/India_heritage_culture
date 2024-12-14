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
@Table(name = "wildlife")
public class WildLife {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "species_name", nullable = false, columnDefinition = "TEXT")
    private String speciesName;

    @Column(name = "habitat", columnDefinition = "TEXT")
    private String habitat;

    @Column(name = "conservation_status", columnDefinition = "TEXT")
    private String conservationStatus;

    @Column(name = "unique_features", columnDefinition = "TEXT")
    private String uniqueFeatures;

    @Column(name = "region_found", columnDefinition = "TEXT")
    private String regionFound;

    @Column(name = "images", columnDefinition = "TEXT")
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Transient
    private List<String> imageList;

    @Transient
    private int length;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "state_id")
    private State stateId;

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

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

    public WildLife() {
    }

    public WildLife(String speciesName, String habitat, String conservationStatus, String uniqueFeatures,
            String regionFound) {
        this.speciesName = speciesName;
        this.habitat = habitat;
        this.conservationStatus = conservationStatus;
        this.uniqueFeatures = uniqueFeatures;
        this.regionFound = regionFound;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(String conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public String getUniqueFeatures() {
        return uniqueFeatures;
    }

    public void setUniqueFeatures(String uniqueFeatures) {
        this.uniqueFeatures = uniqueFeatures;
    }

    public String getRegionFound() {
        return regionFound;
    }

    public void setRegionFound(String regionFound) {
        this.regionFound = regionFound;
    }

}
