package br.com.flixy.controller;

import br.com.flixy.controller.request.MovieRequest;
import br.com.flixy.controller.response.MovieResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Movie", description = "Recurso responsavel pelo gerenciamento dos filmes.")
public interface MovieController {

    @Operation(summary = "Salvar filme", description = "Metodo responsavel para realizar o salvamento de um novo filme.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request);


    @Operation(summary = "Buscar filmes", description = "Metodo responsavel para retornar todos os filmes cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os filmes cadastrados.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> getAll();

    @Operation(summary = "Buscar filme por ID", description = "Metodo responsavel por buscar filme por ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado.", content = @Content())
    ResponseEntity<MovieResponse> getById(@PathVariable Long id);

    @Operation(summary = "Alterar filme", description = "Metodo responsavel por alterar dados do filme.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme alterado com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado.", content = @Content())
    ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request);

    @Operation(summary = "Buscar filmes por categoria", description = "Metodo responsavel para retornar todos os filmes de determinada categoria.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os filmes com determinada categoria.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> getByCategory(@RequestParam Long category);

    @Operation(summary = "Deletar filme por ID", description = "Metodo responsavel por deletar filme por ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Filme deletado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado.", content = @Content())
    ResponseEntity<Void> delete(@PathVariable Long id);
}
