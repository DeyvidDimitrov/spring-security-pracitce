package com.practice.ssp.services;

import java.util.Collections;

import com.practice.ssp.config.jwt.JwtUtils;
import com.practice.ssp.dtos.AuthenticationResponse;
import com.practice.ssp.dtos.UserRegistrationDto;
import com.practice.ssp.dtos.UsernameAndPasswordAuthenticationRequest;
import com.practice.ssp.entity.Role;
import com.practice.ssp.entity.User;
import com.practice.ssp.entity.security.SecurityUser;
import com.practice.ssp.repository.RoleRepository;
import com.practice.ssp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final RoleRepository roleRepository;
  private final JwtUtils jwtUtils;
  private final AuthenticationManager authenticationManager;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Transactional(readOnly = true)
  public AuthenticationResponse authenticate(UsernameAndPasswordAuthenticationRequest request) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              request.getUsername(),
              request.getPassword()
          )
      );
    } catch (Exception e) {
      System.out.println(e.getClass());
      System.out.println(e.getStackTrace());
      System.out.println(e.getMessage());
      throw new RuntimeException("Invalid username or password");
    }
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );
    System.out.println("Authentication successful");
    var user = repository.findByEmail(request.getUsername())
        .orElseThrow(() -> new EntityNotFoundException("User not found!"));
    SecurityUser securityUser = new SecurityUser(user);
    var jwtToken = jwtUtils.generateToken(securityUser);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .username(securityUser.getUsername())
        .authorities(securityUser.getAuthorities().toString())
        .build();
  }

  @Transactional
  public void register(UserRegistrationDto dto) {
    boolean userExists = repository.findByEmail(dto.getEmail())
            .isPresent();

    if (userExists) {
      throw new RuntimeException("Email already taken");
    }

    User user = new User(dto.getFirstName(),
            dto.getLastName(),
            dto.getEmail(),
            dto.getPassword()
    );

    // assign default role to the user
    Role role = roleRepository.findByName("ROLE_USER")
        .orElseThrow(() -> new RuntimeException("Default role not found."));
    user.setRole(role);

    String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

    user.setPassword(encodedPassword);

    repository.save(user);
  }
}