package com.project.dp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Portfolio")
public class Portfolio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "file", columnDefinition = "BLOB")
    private byte[] file;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "portfolio_file_name")
    private String portfolioFileName;
    @Column(name = "url")
    private String url;
    @Column(name = "portfolio_name")
    private String portfolioName;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

//    @OneToOne(mappedBy = "portfolio")
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    private PortfolioImage image;

    public Portfolio(int id, byte[] file, String url, String portfolioName, Person person, String fileName, String portfolioFileName) {
        this.id = id;
        this.file = file;
        this.url = url;
        this.portfolioName = portfolioName;
        this.person = person;
        this.fileName = fileName;
        this.portfolioFileName = portfolioFileName;
    }
       public Portfolio(){

        }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPortfolioFileName() {
        return portfolioFileName;
    }

    public void setPortfolioFileName(String portfolioFileName) {
        this.portfolioFileName = portfolioFileName;
    }
}
