# Finance Manager

API REST para gerenciamento financeiro pessoal, desenvolvida com Spring Boot e Java 21.

> Em desenvolvimento.

## Tecnologias

- Java 21 / Spring Boot 4.0.6
- Spring Data JPA + Spring Security + Spring Validation
- PostgreSQL / Maven / Lombok

## Endpoints

**Autenticação**

| Método | Rota          | Descrição  |
|--------|---------------|------------|
| POST   | `/auth/login` | Login — retorna JWT token |

**Usuários**

| Método | Rota          | Descrição             |
|--------|---------------|-----------------------|
| POST   | `/users`      | Criar usuário         |
| GET    | `/users`      | Listar usuários       |
| GET    | `/users/{id}` | Buscar usuário por ID |
| PUT    | `/users/{id}` | Atualizar nome/senha  |
| DELETE | `/users/{id}` | Remover usuário       |

## Como executar

**Pré-requisitos:** Java 21+, PostgreSQL na porta `5433` com o banco `finance_manager` criado.

O arquivo `application-local.properties` deve conter as credenciais do banco e a chave secreta do JWT:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/finance_manager
spring.datasource.username=...
spring.datasource.password=...
jwt.secret-key=...
```

```bash
./mvnw spring-boot:run
```

Para usar configurações locais:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

A aplicação sobe em `http://localhost:8080`.
