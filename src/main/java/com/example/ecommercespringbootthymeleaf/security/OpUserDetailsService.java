package com.example.ecommercespringbootthymeleaf.security;
import com.example.ecommercespringbootthymeleaf.exception.ResourceNotFoundException;
import com.example.ecommercespringbootthymeleaf.model.Users;
import com.example.ecommercespringbootthymeleaf.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Getter
@Setter
@AllArgsConstructor
public class OpUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Let people login with either username or email
        Optional<Users> user = userRepository.findByUsernameIgnoreCase(username);
        user.orElseThrow(() ->
                new UsernameNotFoundException("User not found with username or email : " + username)
        );
        return UserPrincipal.create(user.get());
    }
    @Transactional
    public UserDetails loadUserById(Long id) {
        Users user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return UserPrincipal.create(user);
    }
}
