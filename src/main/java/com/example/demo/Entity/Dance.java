package com.example.demo.Entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "dance")
public class Dance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "state_id")
    private State stateId;

    @Column(name = "music_type")
    private String musicType;

    @Transient
    private List<String> imageList;

    public List<String> getImageList() {
        if (getImages() != null && getImages()!="") {
            this.imageList = Arrays.asList(getImages().split(","));
        }
        return this.imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public int getId() {
        return id;
    }

    @Transient
    private int length;

    public int getLength() {
        return getImageList()!=null?getImageList().size():0;
    }

    public void setLength(int length) {
        this.length = getImageList()!=null?getImageList().size():0;
    }

    public Dance() {
    }

    public Dance(String name, State stateId, String musicType, String images, String description) {
        this.name = name;
        this.stateId = stateId;
        this.musicType = musicType;
        this.images = images;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "images")
    private String images;

    @Column(name = "description")
    private String description;
}
