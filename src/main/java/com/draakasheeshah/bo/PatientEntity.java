package com.draakasheeshah.bo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.draakasheeshah.enums.Sex;

@Entity
@Table
public class PatientEntity
    implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 6375406330820935381L;
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String emailId;
    private long regNo;

    private int age;
    private Sex sex;
    private boolean isMarried;
    private String education;
    private String occupation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "observation_id")
    private ObservationEntity observation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "family_id")
    private FamilyEntity family;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "interrogate_id")
    private InterrogateEntity interrogate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getRegNo() {
        return regNo;
    }

    public void setRegNo(long regNo) {
        this.regNo = regNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public ObservationEntity getObservation() {
        return observation;
    }

    public void setObservation(ObservationEntity observation) {
        this.observation = observation;
    }

    public FamilyEntity getFamily() {
        return family;
    }

    public void setFamily(FamilyEntity family) {
        this.family = family;
    }

    public InterrogateEntity getInterrogate() {
        return interrogate;
    }

    public void setInterrogate(InterrogateEntity interrogate) {
        this.interrogate = interrogate;
    }

}
