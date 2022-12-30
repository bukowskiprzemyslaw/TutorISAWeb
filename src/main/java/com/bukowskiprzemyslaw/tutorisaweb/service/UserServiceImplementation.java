package com.bukowskiprzemyslaw.tutorisaweb.service;

import com.bukowskiprzemyslaw.tutorisaweb.entity.Role;
import com.bukowskiprzemyslaw.tutorisaweb.entity.User;
import com.bukowskiprzemyslaw.tutorisaweb.repository.UserRepository;
import com.bukowskiprzemyslaw.tutorisaweb.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getLogin(), registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByLogin(username);
        if(user == null) {
            throw new UsernameNotFoundException("Błędny login lub hasło.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
