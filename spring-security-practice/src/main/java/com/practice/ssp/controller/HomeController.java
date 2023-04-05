package com.practice.ssp.controller;

import static com.practice.ssp.constants.PathConstants.PATH_HOME;
import static com.practice.ssp.constants.PathConstants.PATH_LOGIN;
import static com.practice.ssp.constants.PathConstants.PATH_REGISTER;

import com.practice.ssp.dtos.AuthenticationResponse;
import com.practice.ssp.dtos.UserRegistrationDto;
import com.practice.ssp.dtos.UsernameAndPasswordAuthenticationRequest;
import com.practice.ssp.repository.RoleRepository;
import com.practice.ssp.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = PATH_HOME)
@AllArgsConstructor
@CrossOrigin("*")
public class HomeController {

    private final RoleRepository roleRepository;

    private final AuthenticationService authService;

    @PostMapping(PATH_LOGIN)
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody UsernameAndPasswordAuthenticationRequest request
    ) {
        AuthenticationResponse r =  authService.authenticate(request);
        var u = SecurityContextHolder.getContext().getAuthentication();
        u.getAuthorities().forEach(System.out::println);
        System.out.println(request.toString());
        return ResponseEntity.ok(r);
    }

    @PostMapping(PATH_REGISTER)
    public ResponseEntity<Void> register(@RequestBody UserRegistrationDto user) {
        try {
            authService.register(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/roles")
    public ResponseEntity<String> getRoles() {
        var u = SecurityContextHolder.getContext().getAuthentication();
        u.getAuthorities().forEach(System.out::println);
        System.out.println(roleRepository.findAll());
        return ResponseEntity.ok("Roles");
    }


    @GetMapping("/user")
    public ResponseEntity<String> getUser() {
        var u = SecurityContextHolder.getContext().getAuthentication();
        u.getAuthorities().forEach(System.out::println);
        System.out.println(roleRepository.findAll());
        return ResponseEntity.ok("Roles");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {
        var u = SecurityContextHolder.getContext().getAuthentication();
        u.getAuthorities().forEach(System.out::println);
        System.out.println(roleRepository.findAll());
        return ResponseEntity.ok("Roles");
    }
}