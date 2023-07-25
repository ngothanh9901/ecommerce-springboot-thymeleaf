package com.example.ecommercespringbootthymeleaf.security;

import com.example.ecommercespringbootthymeleaf.model.Role;
import com.example.ecommercespringbootthymeleaf.model.Users;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
@ToString
@Builder
@Data
public class UserPrincipal implements UserDetails {
    private Users user;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public static UserPrincipal create(Users user) {
        Collection<Role> roles = user.getRoles() != null ? user.getRoles():null;
        return UserPrincipal.builder()
                .user(user)
                .authorities(roles.stream().map(role -> {return new SimpleGrantedAuthority(role.getName());
                }).collect(Collectors.toList()))
                .build();
    }
    public static UserPrincipal create(Users user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }
    public Long getId() {
        return user.getId();
    }
    public String getName() {
        return user.getName();
    }
    public String getAvatar() {
        return "";
    }
    public int getLoginTimes() {
        return user.getLoginTimes();
    }
    @Override
    public String getUsername() {
        return user.getUsername();
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserPrincipal that = (UserPrincipal) o;
        if (user == null || that.getUser() == null) {
            return false;
        }
        return Objects.equals(user.getId(), that.getUser().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId());
    }
}
