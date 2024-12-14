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
@Table(name = "artifacts")
public class Artifacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "art_type", length = 255)
    private String artType;

    @Column(name = "materials_used", length = 255)
    private String materialsUsed;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "state_id")
    private State stateId;

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    @Column(name = "techniques")
    private String techniques;

    @Transient
    private List<String> imageList;

    @Transient
    private int length;

    public int getLength() {
        return getImageList() != null ? getImageList().size() : 0;
    }

    public void setLength(int length) {
        this.length = getImageList() != null ? getImageList().size() : 0;
    }

    public List<String> getImageList() {
        if (getImages() != null && getImages() != "") {
            this.imageList = Arrays.asList(getImages().split(","));
        }
        return this.imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public Artifacts(String artType, String materialsUsed, State stateId, String techniques, String images) {
        this.artType = artType;
        this.materialsUsed = materialsUsed;
        this.stateId = stateId;
        this.techniques = techniques;
        this.images = images;
    }

    public Artifacts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public String getMaterialsUsed() {
        return materialsUsed;
    }

    public void setMaterialsUsed(String materialsUsed) {
        this.materialsUsed = materialsUsed;
    }

    public String getTechniques() {
        return techniques;
    }

    public void setTechniques(String techniques) {
        this.techniques = techniques;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Column(name = "images")
    private String images;

}
