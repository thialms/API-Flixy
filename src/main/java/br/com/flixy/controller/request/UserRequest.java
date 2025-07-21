package br.com.flixy.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(
        @Schema(description = "Nome do usuário", example = "João Silva")
        String name,

        @Schema(description = "Email do usuário", example = "joao@email.com")
        String email,

        @Schema(description = "Senha do usuário", example = "senhaSegura123")
        String password
) {
}
