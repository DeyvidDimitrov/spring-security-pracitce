package com.practice.ssp.services;

import java.util.Optional;

import com.practice.ssp.entity.User;
import com.practice.ssp.entity.security.SecurityUser;
import com.practice.ssp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    User u = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));


    return new SecurityUser(u);
  }
}