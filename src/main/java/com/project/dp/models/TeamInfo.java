package com.project.dp.models;

import jakarta.persistence.*;


@Entity
@Table(name = "Teaminfo")
public class TeamInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "countofperson")
    private String countOfPerson;
    @Column(name = "description")
    private String description;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
    private byte[] teamFile;
    private String teamFileName;

    public TeamInfo(int id, String name, String countOfPerson, String description, Person person, byte[] teamFile, String teamFileName) {
        this.id = id;
        this.name = name;
        this.countOfPerson = countOfPerson;
        this.description = description;
        this.person = person;
        this.teamFile = teamFile;
        this.teamFileName = teamFileName;
    }

    public TeamInfo() {
    }

    public int getId() {
        return id;
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

    public String getCountOfPerson() {
        return countOfPerson;
    }

    public void setCountOfPerson(String countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public byte[] getTeamFile() {
        return teamFile;
    }

    public void setTeamFile(byte[] teamFile) {
        this.teamFile = teamFile;
    }

    public String getTeamFileName() {
        return teamFileName;
    }

    public void setTeamFileName(String teamFileName) {
        this.teamFileName = teamFileName;
    }
}
