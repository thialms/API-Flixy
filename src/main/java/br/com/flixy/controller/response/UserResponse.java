package br.com.flixy.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(
        @Schema(description = "ID do usuário", example = "10")
        Long id,

        @Schema(description = "Nome do usuário", example = "João Silva")
        String name,

        @Schema(description = "Email do usuário", example = "joao@email.com")
        String email
) {
}
