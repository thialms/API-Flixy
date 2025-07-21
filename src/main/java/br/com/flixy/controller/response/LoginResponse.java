package br.com.flixy.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(
        @Schema(description = "Token JWT para autenticação")
        String token
) {
}
