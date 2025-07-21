package br.com.flixy.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id,
                          String name,
                          String email) {
}
