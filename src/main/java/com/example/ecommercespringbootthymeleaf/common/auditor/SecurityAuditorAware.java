package com.example.ecommercespringbootthymeleaf.common.auditor;

import com.example.ecommercespringbootthymeleaf.security.UserPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityAuditorAware implements AuditorAware<Long> {
  @Override
  public Optional<Long> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null
        || authentication instanceof AnonymousAuthenticationToken                // SKC : anonymous 인 경우에 빈값으로 리턴해야 함.
        || !authentication.isAuthenticated()) {
      return Optional.empty();
    }
    return Optional.of(((UserPrincipal) authentication.getPrincipal()).getId());
  }
}
