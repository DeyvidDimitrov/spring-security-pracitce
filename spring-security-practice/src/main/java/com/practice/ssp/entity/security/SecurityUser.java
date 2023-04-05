package com.practice.ssp.entity.security;

import com.practice.ssp.entity.Authority;
import com.practice.ssp.entity.Role;
import com.practice.ssp.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SecurityUser implements UserDetails {

  private final User user;

  public long getId() {
    return user.getId();
  }

  public Set<Role> getRoles() {
    return user.getRoles();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<Role> roles = this.getRoles();
    Set<Authority> authorities = new HashSet<>();
    for (Role role : roles) {
      authorities.addAll(role.getAuthorities());
    }
    return authorities.stream()
        .map(authority -> new SimpleGrantedAuthority(authority.getName()))
        .collect(Collectors.toSet());
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}