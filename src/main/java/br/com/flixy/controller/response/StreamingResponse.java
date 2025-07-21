package br.com.flixy.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingResponse(
        @Schema(description = "ID do streaming", example = "1")
        Long id,

        @Schema(description = "Nome do serviço de streaming", example = "Netflix")
        String name
) {
}
