package com.squadio.accountstatements.models;

import com.squadio.accountstatements.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetails implements UserDetails {
    public User user;

    public CustomUserDetails(final User _user) {
        this.user = _user;
    }

    public CustomUserDetails() {
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> _grntdAuths = new HashSet<GrantedAuthority>();

        List<String> _roles = null;

        if (user != null) {
            _roles = new ArrayList<>();
        }

        if (_roles != null) {
        }

        return _grntdAuths;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        if (this.user == null) {
            return null;
        }
        return this.user.getUserName();
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

    public User getUser() {
        return user;
    }


    @Override
    public String toString() {
        return "CustomUserDetails [user=" + user + "]";

    }

    public void setUser(User user) {
        this.user = user;
    }

}