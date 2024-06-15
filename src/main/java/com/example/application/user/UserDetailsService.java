package com.example.application.user;

import com.example.infrastructure.user.IUserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private IUserJpaRepo _userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return _userRepo.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
