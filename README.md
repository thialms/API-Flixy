# 🎬 API Flixy

API REST para gerenciamento de catálogo de filmes e serviços de streaming, desenvolvida com **Spring Boot** e arquitetura moderna.

---

## 📌 Sobre o Projeto

O **Flixy** é uma plataforma que permite aos usuários descobrir e gerenciar filmes disponíveis em diversos serviços de streaming. O projeto foi criado com foco em:

- 🎯 **Organização de Conteúdo**: Categorização eficiente de filmes  
- 🔌 **Múltiplos Serviços**: Integração com provedores de streaming  
- 🔐 **Segurança**: Autenticação e autorização via JWT  
- ⚡ **Performance**: Queries otimizadas e suporte a cache  
- 🧱 **Escalabilidade**: Arquitetura preparada para expansão  

---

## 🏗️ Arquitetura

A estrutura do projeto segue uma arquitetura em camadas:

```
src/main/java/br/com/flixy/
├── config/         # Configurações do Spring e Security
├── controller/     # Controllers REST
├── entity/         # Entidades JPA
├── repository/     # Repositórios com Spring Data
├── service/        # Camada de regras de negócio
├── exception/      # Tratamento de exceções customizadas
└── mapper/         # Conversores entre entidades e DTOs
```

---

## 💻 Tecnologias Utilizadas

### 🔙 Backend
- Java 21 – Recursos modernos e robustez  
- Spring Boot 3  
- Spring Security  
- Spring Data JPA  
- JWT (JSON Web Token)  
- Lombok  
- Bean Validation (Jakarta)  

### 🗃️ Banco de Dados
- PostgreSQL 16  
- Flyway – Migrations versionadas  

### 🛠️ Dev Tools
- Maven – Build e gerenciamento de dependências  
- Swagger / OpenAPI – Documentação interativa  

---

## 🚀 Funcionalidades

### 🔐 Autenticação e Autorização
- Registro e login de usuários  
- Geração e validação de JWT  
- Proteção de endpoints por perfil de usuário  

### 🎞️ Gerenciamento de Filmes
- Cadastro, atualização, busca e remoção de filmes  
- Associação com categorias e serviços de streaming  
- Sistema de avaliação por nota  
- Busca por critérios (ex: categoria)  

### 🗂️ Categorias
- CRUD completo  
- Validações de integridade  

### 📡 Serviços de Streaming
- Cadastro e listagem de provedores  
- Associação com filmes  

---

## 📋 Pré-requisitos

- Java 21+  
- PostgreSQL 16+  
- Maven 3.8+  

---

## ⚙️ Como Executar

### 📜 Scripts Disponíveis

| Script      | Função                          |
|-------------|---------------------------------|
| `build.sh`  | Compila o projeto com Maven     |
| `start.sh`  | Inicia a aplicação via JAR      |

### 🧭 Passo a Passo

```bash
# Clone o repositório
git clone https://github.com/thialms/API-Flixy.git
cd API-Flixy

# Configure o PostgreSQL no application.properties
# Exemplo:
spring.datasource.url=jdbc:postgresql://localhost:5432/flixy
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Execute o build do projeto
./build.sh

# Inicie a aplicação
./start.sh
```

#### Alternativamente:

```bash
# Build manual
mvn clean package

# Execução manual
mvn spring-boot:run
```

A API estará disponível em:  
🔗 http://localhost:8080

---

## 📖 Documentação da API

Swagger disponível em:  
🔗 http://localhost:8080/swagger/swagger-ui.html

---

## 🧪 Testes com Curl

Scripts de testes estão organizados por funcionalidade para facilitar a validação dos endpoints. Você também pode utilizar o Postman.

---

## 📬 Principais Endpoints

### 🔐 Autenticação
- `POST /auth/register` – Registrar novo usuário  
- `POST /auth/login` – Login e geração de token  

### 🗂️ Categorias
- `POST /flix/category`  
- `GET /flix/category`  
- `GET /flix/category/{id}`  
- `DELETE /flix/category/{id}`  

### 📡 Serviços de Streaming
- `POST /flix/stream-service`  
- `GET /flix/stream-service`  
- `GET /flix/stream-service/{id}`  
- `DELETE /flix/stream-service/{id}`  

### 🎞️ Filmes
- `POST /flix/movie`  
- `GET /flix/movie`  
- `GET /flix/movie/{id}`  
- `GET /flix/movie/search?category={id}`  
- `PUT /flix/movie`  
- `DELETE /flix/movie/{id}`  

---

## 🤝 Contribuindo

1. Faça um fork  
2. Crie sua branch:  
   ```bash
   git checkout -b feature/NovaFuncionalidade
   ```
3. Commit suas alterações:  
   ```bash
   git commit -m 'feat: adiciona nova funcionalidade'
   ```
4. Push para a branch:  
   ```bash
   git push origin feature/NovaFuncionalidade
   ```
5. Crie um Pull Request  

---

## 👨‍💻 Autor

Desenvolvido por **Thiago Almeida**  
🔗 [github.com/thialms](https://github.com/thialms)

---
