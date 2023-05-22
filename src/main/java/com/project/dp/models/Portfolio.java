package com.project.dp.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Entity
@Table(name = "Portfolio")
public class Portfolio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "file")
    private File file;
    @Column(name = "url")
    private String url;
    @Column(name = "portfolio_name")
    private String portfolioName;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private User user;
    @OneToOne(mappedBy = "portfolio")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private PortfolioImage image;

    public Portfolio(int id, File file, PortfolioImage image, String url, String portfolioName, User user) {
        this.id = id;
        this.file = file;
        this.image = image;
        this.url = url;
        this.portfolioName = portfolioName;
        this.user = user;
    }
       public Portfolio(){
           //this.image = "images/main/" + "portfolio__logo.jpg"; //пока реализация такая
        }

    public void crateLogo(){
        Path path = Paths.get("logo/" + image);
        try{
            Files.createFile(path);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public PortfolioImage getImage() {
        return image;
    }

    public void setImage(PortfolioImage image) {
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
