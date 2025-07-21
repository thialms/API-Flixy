package br.com.flixy.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@Schema(type = "string", description = "Nome do filme")
                           @NotEmpty(message = "Nome do filme é obrigatório")
                           String tittle,
                           @Schema(type = "string", description = "Descricao do filme")
                           String description,
                           @Schema(type = "date", description = "Data de lancamento do filme" , example = "19/10/2003")
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,
                           @Schema(type = "double", description = "Score do filme", example = "7.8")
                           double rating,
                           @Schema(type = "array", description = "Lista de codigos das categorias")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de codigos dos streamings")
                           List<Long> streamings
) {
}
