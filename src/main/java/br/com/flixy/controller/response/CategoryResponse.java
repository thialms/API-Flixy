package br.com.flixy.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CategoryResponse(
        @Schema(description = "ID da categoria", example = "1")
        Long id,

        @Schema(description = "Nome da categoria", example = "Ação")
        String name
) {
}
