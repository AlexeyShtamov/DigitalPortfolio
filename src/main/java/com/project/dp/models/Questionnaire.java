package com.project.dp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questionnaire")
public class Questionnaire {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private final static List<Profession> PROFESSIONS = List.of(Profession.values());
    @Column(name = "profession")
    private String infoAboutProfession;
    @Column(name = "projects")
    private String infoAboutProjects;
    @Column(name = "experience")
    private int infoAboutExperience;
    @Column(name = "homework")
    private String infoAboutWorkAtHome;
    @Column(name = "newinfo")
    private String infoAboutGettingInformation;
    @Column(name = "goals")
    private String infoAboutGoals;
    @Column(name = "anotherinfo")
    private String additionalInfo;
    @Column(name = "strongweak")
    private String infoAboutStrongAndWeak;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private User user;

    public Questionnaire(int id, String infoAboutProfession,
                         String infoAboutProjects, int infoAboutExperience,
                         String infoAboutWorkAtHome,
                         String infoAboutGettingInformation, String infoAboutGoals,
                         String additionalInfo, String infoAboutStrongAndWeak, User user) {
        this.id = id;
        this.infoAboutProfession = infoAboutProfession;
        this.infoAboutProjects = infoAboutProjects;
        this.infoAboutExperience = infoAboutExperience;
        this.infoAboutWorkAtHome = infoAboutWorkAtHome;
        this.infoAboutGettingInformation = infoAboutGettingInformation;
        this.infoAboutGoals = infoAboutGoals;
        this.additionalInfo = additionalInfo;
        this.infoAboutStrongAndWeak = infoAboutStrongAndWeak;
        this.user = user;
    }

    public Questionnaire(){

    }

    public static List<Profession> getProfessions(){
        return PROFESSIONS;
    }

    public String getInfoAboutStrongAndWeak() {
        return infoAboutStrongAndWeak;
    }

    public void setInfoAboutStrongAndWeak(String infoAboutStrongAndWeak) {
        this.infoAboutStrongAndWeak = infoAboutStrongAndWeak;
    }

    public String getInfoAboutProfession() {
        return infoAboutProfession;
    }

    public void setInfoAboutProfession(String infoAboutProfession) {
        this.infoAboutProfession = infoAboutProfession;
    }

    public String getInfoAboutProjects() {
        return infoAboutProjects;
    }

    public void setInfoAboutProjects(String infoAboutProjects) {
        this.infoAboutProjects = infoAboutProjects;
    }

    public int getInfoAboutExperience() {
        return infoAboutExperience;
    }

    public void setInfoAboutExperience(int infoAboutExperience) {
        this.infoAboutExperience = infoAboutExperience;
    }

    public String getInfoAboutWorkAtHome() {
        return infoAboutWorkAtHome;
    }

    public void setInfoAboutWorkAtHome(String infoAboutWorkAtHome) {
        this.infoAboutWorkAtHome = infoAboutWorkAtHome;
    }

    public String getInfoAboutGettingInformation() {
        return infoAboutGettingInformation;
    }

    public void setInfoAboutGettingInformation(String infoAboutGettingInformation) {
        this.infoAboutGettingInformation = infoAboutGettingInformation;
    }

    public String getInfoAboutGoals() {
        return infoAboutGoals;
    }

    public void setInfoAboutGoals(String infoAboutGoals) {
        this.infoAboutGoals = infoAboutGoals;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
