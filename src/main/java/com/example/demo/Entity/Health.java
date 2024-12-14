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
@Table(name = "health")
public class Health {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "practice_name", nullable = false, length = 255)
    private String practiceName;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "state_id")
    private State stateId;

    @Column(name = "technique", columnDefinition = "TEXT")
    private String technique;

    @Column(name = "benefits", columnDefinition = "TEXT")
    private String benefits;

    @Column(name = "related_medicines", columnDefinition = "TEXT")
    private String relatedMedicines;

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

    public Health() {
    }

    public Health(String practiceName, State stateId, String technique, String benefits, String relatedMedicines,
            String images) {
        this.practiceName = practiceName;
        this.stateId = stateId;
        this.technique = technique;
        this.benefits = benefits;
        this.relatedMedicines = relatedMedicines;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getRelatedMedicines() {
        return relatedMedicines;
    }

    public void setRelatedMedicines(String relatedMedicines) {
        this.relatedMedicines = relatedMedicines;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
