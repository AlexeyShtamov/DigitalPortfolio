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
    @Column(name = "url")
    private String url;
    @Column(name = "portfolio_name")
    private String portfolioName;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person user;

//    @OneToOne(mappedBy = "portfolio")
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    private PortfolioImage image;
    @Column(name = "image", columnDefinition = "BLOB")
    public byte[] image;

    public Portfolio(int id, byte[] file, byte[] image, String url, String portfolioName, Person user) {
        this.id = id;
        this.file = file;
        this.image = image;
        this.url = url;
        this.portfolioName = portfolioName;
        this.user = user;
    }
       public Portfolio(){

        }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public void setPortfolioName(String name) {
        this.portfolioName = name;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
