package com.project.dp.services;

import com.project.dp.models.Person;
import com.project.dp.models.Portfolio;
import com.project.dp.models.PortfolioImage;
import com.project.dp.repositories.PortfoliosRepository;
import org.hibernate.boot.archive.internal.ByteArrayInputStreamAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class PortfoliosService {

    private final PortfoliosRepository portfoliosRepository;
    @Autowired
    public PortfoliosService(PortfoliosRepository portfoliosRepository) {
        this.portfoliosRepository = portfoliosRepository;
    }

    public List<Portfolio> getPortfolios(){
        return portfoliosRepository.findAll();
    }

    public void save(Portfolio portfolio, Person person) {
        portfolio.setPerson(person);
        portfoliosRepository.save(portfolio);
    }

    public void save(int id, Portfolio portfolio, Person person) {
        portfolio.setId(id);
        portfolio.setPerson(person);
        person.setPortfolio(portfolio);
        portfoliosRepository.save(portfolio);
    }

    public Portfolio getPortfolioByPersonId(int id){
        Optional<Portfolio> optional = portfoliosRepository.getPortfolioByPerson_Id(id);
        return optional.orElseGet(Portfolio::new);
    }

    public Portfolio getPortfolio(int id){
        return portfoliosRepository.findById(id).get();
    }

    public void addImage(MultipartFile fileImage) throws IOException {
        Path path = Path.of("src/main/resources/static/images/logo/");

        byte[] file = fileImage.getBytes();

        ByteArrayInputStream bais = new ByteArrayInputStream(file);
        if(!Files.exists(Path.of((path.toString() + "/" + fileImage.getOriginalFilename())))){
            Path finalPath = Files.createFile(Path.of((path.toString() + "/" + fileImage.getOriginalFilename())));
            FileOutputStream fos = new FileOutputStream(finalPath.toFile());
            while (bais.available() > 0){
                fos.write(bais.read());
            }
            fos.close();
        }
        bais.close();
    }

}
