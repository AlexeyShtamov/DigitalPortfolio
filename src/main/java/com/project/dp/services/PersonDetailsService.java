package com.project.dp.services;

import com.project.dp.models.Person;
import com.project.dp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository usersRepository;
    @Autowired
    public PersonDetailsService(PeopleRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         return usersRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найдет"));
    }

    public void updatePerson(int id,int team, Person changedPerson){
        changedPerson.setId(id);
        changedPerson.setTeam(team);
        usersRepository.save(changedPerson);
    }

    public void updateFace(Person person, MultipartFile multipartFile) throws IOException {
        person.setFileFace(multipartFile.getBytes());
        person.setFaceFileName(multipartFile.getOriginalFilename());
        usersRepository.save(person);
    }



    public Person findById(int id){
        return usersRepository.findById(id).get();
    }

    public List<Person> getAllTeams(){
        List<Person> people = usersRepository.findAll();

        List<Person> result = new ArrayList<>();
        for(Person person : people){
            if(person.getTeam() == 1)
                result.add(person);
        }
        return result;
    }

    public List<Person> getAllPeople(){
        List<Person> people = usersRepository.findAll();

        List<Person> result = new ArrayList<>();
        for(Person person : people){
            if(person.getTeam() == 0)
                result.add(person);
        }
        return result;
    }

    public List<Person> findAll(){
        return usersRepository.findAll();
    }

    public void addImage(MultipartFile fileImage) throws IOException {
        Path path = Path.of("src/main/resources/static/images/face/");

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
