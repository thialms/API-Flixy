package br.com.flixy.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(
        @Schema(description = "Nome do serviço de streaming", example = "Netflix")
        @NotEmpty(message = "Nome do streaming é obrigatório")
        String name
) {
}
