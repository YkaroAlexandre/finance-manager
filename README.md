# Finance Manager

API REST para gerenciamento financeiro pessoal, desenvolvida com Spring Boot e Java 21.

> **Status:** Em desenvolvimento — estrutura base implementada, funcionalidades de transação em andamento.

## Sobre o Projeto

O Finance Manager tem como objetivo oferecer uma plataforma para controle de finanças pessoais, permitindo o registro e acompanhamento de receitas e despesas. Atualmente conta com o módulo de usuários implementado e a infraestrutura preparada para o módulo de transações.

## Tecnologias

- **Java 21**
- **Spring Boot 4.0.6**
- **Spring Data JPA** — persistência de dados
- **Spring Security** — autenticação e autorização
- **Spring Validation** — validação de entrada
- **PostgreSQL** — banco de dados relacional
- **Lombok** — redução de boilerplate
- **Maven** — gerenciamento de dependências

## Estrutura do Projeto

```
src/main/java/com/ykaro/financemanager/
├── config/          # Configurações (Spring Security, etc.)
├── controller/      # Endpoints HTTP
├── service/         # Regras de negócio
├── repository/      # Acesso ao banco de dados
├── entity/          # Entidades JPA
├── dto/             # Objetos de transferência de dados
├── enums/           # Enumerações (TransactionType)
├── exception/       # Tratamento de exceções (em desenvolvimento)
└── security/        # Configurações de segurança (em desenvolvimento)
```

## Funcionalidades

### Implementadas
- Cadastro de usuários
- Listagem de usuários
- Configuração de banco de dados com PostgreSQL

### Em Desenvolvimento
- Registro de transações (receitas e despesas)
- Autenticação e autorização de usuários
- Tratamento global de exceções
- Relatórios financeiros

## Endpoints

| Método | Rota     | Descrição              |
|--------|----------|------------------------|
| POST   | `/users` | Criar um novo usuário  |
| GET    | `/users` | Listar todos os usuários |

## Modelo de Dados

### Usuário (`users`)

| Campo        | Tipo            | Restrições          |
|--------------|-----------------|---------------------|
| `id`         | Long            | PK, auto-gerado     |
| `name`       | String          | Obrigatório         |
| `email`      | String          | Obrigatório, único  |
| `password`   | String          | Obrigatório         |
| `created_at` | LocalDateTime   | Obrigatório         |

### Tipos de Transação (`TransactionType`)
- `INCOME` — receita
- `EXPENSE` — despesa

## Configuração e Execução

### Pré-requisitos

- Java 21+
- Maven 3.x
- PostgreSQL rodando na porta `5433`

### Banco de Dados

Crie o banco de dados e o usuário no PostgreSQL:

```sql
CREATE USER usuarioteste WITH PASSWORD 'teste123';
CREATE DATABASE finance_manager OWNER usuarioteste;
```

### Executando a Aplicação

```bash
# Clone o repositório
git clone <url-do-repositorio>
cd finance-manager

# Execute com Maven
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

### Variáveis de Ambiente (Perfil local)

As configurações de desenvolvimento estão em `application-local.properties`. Para ativar:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

## Exemplo de Uso

### Criar Usuário

```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@email.com",
    "password": "senha123"
  }'
```

### Listar Usuários

```bash
curl http://localhost:8080/users
```
