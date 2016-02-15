package com.draakasheeshah.business.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class InterrogateEntity
    implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 6517859427601221004L;
    @Id
    @GeneratedValue
    private long id;
    private float income;
    private String familyTree;
    private String religion;
    private String socioEco;
    private String problem;
    private String onset;
    private String duration;
    private String medication;
    private String predisposingFact;
    private String participating;
    private String relaxing;
    private String pastHistory;
    private String medicalHistory;
    private String treatmentHistory;
    private String substanceUse;
    private String delivery;
    private String maternityFacility;
    private String breastFeeding;
    private String toiletTraining;
    private String stammering;
    private String ticks;
    private String habits;
    private String academicAchievement;
    private String phobia;
    private String playHistory;
    private String puberty;
    private String workSatisfaction;
    private String ambition;
    private String masterbation;
    private String sexualLife;
    private String marriageWithParentConsent;
    private String temper;
    private String interpersonalRelation;
    private String hobbies;
    private String mood;
    private String attitudeToWork;
    private String attitudeToSelf;
    private String religiousBelieve;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "patient")
	private PatientEntity patient;

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(String familyTree) {
        this.familyTree = familyTree;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSocioEco() {
        return socioEco;
    }

    public void setSocioEco(String socioEco) {
        this.socioEco = socioEco;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getOnset() {
        return onset;
    }

    public void setOnset(String onset) {
        this.onset = onset;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getParticipating() {
        return participating;
    }

    public void setParticipating(String participating) {
        this.participating = participating;
    }

    public String getRelaxing() {
        return relaxing;
    }

    public void setRelaxing(String relaxing) {
        this.relaxing = relaxing;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public String getSubstanceUse() {
        return substanceUse;
    }

    public void setSubstanceUse(String substanceUse) {
        this.substanceUse = substanceUse;
    }

    public String getBreastFeeding() {
        return breastFeeding;
    }

    public void setBreastFeeding(String breastFeeding) {
        this.breastFeeding = breastFeeding;
    }

    public String getToiletTraining() {
        return toiletTraining;
    }

    public void setToiletTraining(String toiletTraining) {
        this.toiletTraining = toiletTraining;
    }

    public String getStammering() {
        return stammering;
    }

    public void setStammering(String stammering) {
        this.stammering = stammering;
    }

    public String getTicks() {
        return ticks;
    }

    public void setTicks(String ticks) {
        this.ticks = ticks;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public String getPhobia() {
        return phobia;
    }

    public void setPhobia(String phobia) {
        this.phobia = phobia;
    }

    public String getPredisposingFact() {
        return predisposingFact;
    }

    public void setPredisposingFact(String predisposingFact) {
        this.predisposingFact = predisposingFact;
    }

    public String getMaternityFacility() {
        return maternityFacility;
    }

    public void setMaternityFacility(String maternityFacility) {
        this.maternityFacility = maternityFacility;
    }

    public String getAcademicAchievement() {
        return academicAchievement;
    }

    public void setAcademicAchievement(String academicAchievement) {
        this.academicAchievement = academicAchievement;
    }

    public String getPlayHistory() {
        return playHistory;
    }

    public void setPlayHistory(String playHistory) {
        this.playHistory = playHistory;
    }

    public String getPuberty() {
        return puberty;
    }

    public void setPuberty(String puberty) {
        this.puberty = puberty;
    }

    public String getWorkSatisfaction() {
        return workSatisfaction;
    }

    public void setWorkSatisfaction(String workSatisfaction) {
        this.workSatisfaction = workSatisfaction;
    }

    public String getAmbition() {
        return ambition;
    }

    public void setAmbition(String ambition) {
        this.ambition = ambition;
    }

    public String getMasterbation() {
        return masterbation;
    }

    public void setMasterbation(String masterbation) {
        this.masterbation = masterbation;
    }

    public String getSexualLife() {
        return sexualLife;
    }

    public void setSexualLife(String sexualLife) {
        this.sexualLife = sexualLife;
    }

    public String getMarriageWithParentConsent() {
        return marriageWithParentConsent;
    }

    public void setMarriageWithParentConsent(String marriageWithParentConsent) {
        this.marriageWithParentConsent = marriageWithParentConsent;
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public String getInterpersonalRelation() {
        return interpersonalRelation;
    }

    public void setInterpersonalRelation(String interpersonalRelation) {
        this.interpersonalRelation = interpersonalRelation;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getAttitudeToWork() {
        return attitudeToWork;
    }

    public void setAttitudeToWork(String attitudeToWork) {
        this.attitudeToWork = attitudeToWork;
    }

    public String getAttitudeToSelf() {
        return attitudeToSelf;
    }

    public void setAttitudeToSelf(String attitudeToSelf) {
        this.attitudeToSelf = attitudeToSelf;
    }

    public String getReligiousBelieve() {
        return religiousBelieve;
    }

    public void setReligiousBelieve(String religiousBelieve) {
        this.religiousBelieve = religiousBelieve;
    }

    @JsonIgnore
    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

}
