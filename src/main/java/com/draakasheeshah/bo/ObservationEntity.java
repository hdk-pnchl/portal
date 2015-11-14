package com.draakasheeshah.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ObservationEntity
    implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 6678320910746778448L;
    @Id
    @GeneratedValue
    private long id;
    private String posture;
    private String bodyLanguage;
    private String eyeContact;
    private String headBalance;
    private String speedOfSpeech;

    public String getHeadBalance() {
        return headBalance;
    }

    public void setHeadBalance(String headBalance) {
        this.headBalance = headBalance;
    }

    public String getSpeedOfSpeech() {
        return speedOfSpeech;
    }

    public void setSpeedOfSpeech(String speedOfSpeech) {
        this.speedOfSpeech = speedOfSpeech;
    }

    private String memory;
    private String orientation;

    @OneToOne(mappedBy = "observation")
    private PatientEntity patient;

    public String getPosture() {
        return posture;
    }

    public void setPosture(String posture) {
        this.posture = posture;
    }

    public String getBodyLanguage() {
        return bodyLanguage;
    }

    public void setBodyLanguage(String bodyLanguage) {
        this.bodyLanguage = bodyLanguage;
    }

    public String getEyeContact() {
        return eyeContact;
    }

    public void setEyeContact(String eyeContact) {
        this.eyeContact = eyeContact;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
}
