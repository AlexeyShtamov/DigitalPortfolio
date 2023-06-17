package com.project.dp.services;

import com.project.dp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
}
