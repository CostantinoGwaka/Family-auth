package com.isofttz.family.auth.family_auth.services;

import com.isofttz.family.auth.family_auth.entities.Users;
import com.isofttz.family.auth.family_auth.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Users appUser= appUserRepository.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("User does not exist"));
        return User.builder().username(appUser.getUserName())
                .password(appUser.getPassword())
                .roles(appUser.getRole()).
                build();
    }


}
