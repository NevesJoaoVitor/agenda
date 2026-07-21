# Agenda API - Compatível com a Agenda da Mangati para NovoSGA 2.3

Esta é uma API de agendamento desenvolvida para ser 100% compatível com a API da Agenda da Mangati, permitindo que o NovoSGA 2.3 funcione sem depender do serviço oficial.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- MySQL 8
- Docker
- Docker Compose
- OpenAPI (Swagger)
- JWT ou Bearer Token
- Maven

## Funcionalidades

### Agendas
- Cada agenda representa um profissional ou setor
- Campos: id, nome, descrição, ativo, horário inicial, horário final, duração do atendimento, intervalo entre atendimentos

### Serviços
- Cada agenda poderá possuir vários serviços
- Campos: id, agenda, nome, descrição, duração, ativo

### Horários disponíveis
- Gerar automaticamente horários livres considerando:
  - Duração do serviço
  - Horário da agenda
  - Intervalo entre atendimentos
  - Agendamentos existentes
  - Feriados

## Como Executar

### Pré-requisitos
- Java 21
- Maven
- Docker e Docker Compose (opcional, para executar com containers)

### Executando com Docker Compose
```bash
docker-compose up --build
```

### Executando localmente
```bash
# Clone o repositório
git clone <repository-url>
cd agenda-api

# Compile e execute
mvn clean package
java -jar target/agenda-api-1.0.0.jar
```

## API Endpoints

### Agendas
- GET /api/agendas - Lista todas as agendas
- GET /api/agendas/{id} - Busca uma agenda por ID
- POST /api/agendas - Cria uma nova agenda
- PUT /api/agendas/{id} - Atualiza uma agenda existente
- DELETE /api/agendas/{id} - Exclui uma agenda

### Serviços
- GET /api/servicos - Lista todos os serviços
- GET /api/servicos/agenda/{agendaId} - Lista serviços por agenda
- GET /api/servicos/{id} - Busca um serviço por ID
- POST /api/servicos - Cria um novo serviço
- PUT /api/servicos/{id} - Atualiza um serviço existente
- DELETE /api/servicos/{id} - Exclui um serviço

### Agendamentos
- GET /api/agendamentos - Lista todos os agendamentos
- GET /api/agendamentos/servico/{servicoId} - Lista agendamentos por serviço
- GET /api/agendamentos/{id} - Busca um agendamento por ID
- POST /api/agendamentos - Cria um novo agendamento
- PUT /api/agendamentos/{id} - Atualiza um agendamento existente
- DELETE /api/agendamentos/{id} - Exclui um agendamento
- GET /api/agendamentos/horario-disponivel?servicoId={id}&dataHoraInicio={datetime}&dataHoraFim={datetime} - Verifica se um horário está disponível

## Documentação da API

A documentação interativa da API está disponível em:
http://localhost:8080/swagger-ui.html

## Licença

Este projeto está licenciado sob a Licença MIT.