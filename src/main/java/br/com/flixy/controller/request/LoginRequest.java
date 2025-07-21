package br.com.flixy.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(
        @Schema(description = "Email do usuário", example = "user@email.com")
        String email,

        @Schema(description = "Senha do usuário", example = "123456")
        String password
) {
}
