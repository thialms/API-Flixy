package br.com.flixy.controller;

import br.com.flixy.controller.request.LoginRequest;
import br.com.flixy.controller.request.UserRequest;
import br.com.flixy.controller.response.LoginResponse;
import br.com.flixy.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "Recurso responsável pelo registro e login de usuários.")
public interface AuthController {

    @Operation(summary = "Registrar usuário", description = "Realiza o cadastro de um novo usuário.")
    @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso.",
            content = @Content(schema = @Schema(implementation = UserResponse.class)))
    ResponseEntity<UserResponse> register(@RequestBody UserRequest request);

    @Operation(summary = "Login", description = "Realiza a autenticação do usuário.")
    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso.",
            content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas.", content = @Content)
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request);
}
