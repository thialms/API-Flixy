package br.com.flixy.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(
        @Schema(description = "Nome da categoria", example = "Ação")
        @NotEmpty(message = "Nome da categoria é obrigatório")
        String name
) {
}
