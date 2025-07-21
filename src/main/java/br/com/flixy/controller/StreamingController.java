package br.com.flixy.controller;

import br.com.flixy.controller.request.StreamingRequest;
import br.com.flixy.controller.response.StreamingResponse;
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

@Tag(name = "Streaming", description = "Recurso responsável pelo gerenciamento dos streamings.")
public interface StreamingController {

    @Operation(summary = "Buscar streamings", description = "Retorna todos os streamings cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Lista de streamings retornada com sucesso.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StreamingResponse.class))))
    ResponseEntity<List<StreamingResponse>> getAll();

    @Operation(summary = "Salvar streaming", description = "Cadastra um novo streaming.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Streaming cadastrado com sucesso.",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request);

    @Operation(summary = "Buscar streaming por ID", description = "Busca um streaming pelo ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streaming encontrado.",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado.", content = @Content())
    ResponseEntity<StreamingResponse> getById(@PathVariable Long id);

    @Operation(summary = "Deletar streaming por ID", description = "Remove um streaming pelo ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Streaming deletado com sucesso.", content = @Content())
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}
