package br.com.flixy.controller;

import br.com.flixy.controller.request.CategoryRequest;
import br.com.flixy.controller.response.CategoryResponse;
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

@Tag(name = "Category", description = "Recurso responsável pelo gerenciamento de categorias.")
public interface CategoryController {

    @Operation(summary = "Buscar categorias", description = "Retorna todas as categorias cadastradas.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class))))
    ResponseEntity<List<CategoryResponse>> getAll();

    @Operation(summary = "Salvar categoria", description = "Cadastra uma nova categoria.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso.",
            content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest request);

    @Operation(summary = "Buscar categoria por ID", description = "Busca uma categoria pelo ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria encontrada.",
            content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada.", content = @Content())
    ResponseEntity<CategoryResponse> getById(@PathVariable Long id);

    @Operation(summary = "Deletar categoria por ID", description = "Remove uma categoria pelo ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso.", content = @Content())
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}
