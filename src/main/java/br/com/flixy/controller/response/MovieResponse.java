package br.com.flixy.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(@Schema(type = "long", description = "Codigo do filme")
                            Long id,
                            @Schema(type = "string", description = "Nome do filme")
                            String tittle,
                            @Schema(type = "string", description = "Descricao do filme")
                            String description,
                            @Schema(type = "date", description = "Data de lancamento do filme", example = "19/10/2003")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate realeaseDate,
                            @Schema(type = "double", description = "Score do filme", example = "7.8")
                            double rating,
                            @Schema(type = "array", description = "Lista de codigos das categorias")
                            List<CategoryResponse> categories,
                            @Schema(type = "array", description = "Lista de codigos dos streamings")
                            List<StreamingResponse> streamings) {
}
