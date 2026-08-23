# ServiceHub

Sistema de gestão de serviços desenvolvido como projeto de evolução técnica, acompanhando a implementação gradual de conceitos de desenvolvimento Full Stack, segurança, SaaS, sistemas distribuídos, mensageria e infraestrutura.

O projeto será construído em etapas. A aplicação começa como um sistema monolítico simples e, conforme cada etapa é concluída, sua arquitetura e complexidade serão evoluídas.

---

## Objetivo

Construir uma aplicação que permita a empresas gerenciar seus clientes e ordens de serviço, utilizando uma arquitetura que possa evoluir progressivamente até um ambiente próximo de produção.

O sistema inicialmente terá recursos como:

* Cadastro de empresas
* Cadastro de clientes
* Cadastro de usuários
* Ordens de serviço
* Acompanhamento do status dos serviços
* Controle de acesso
* Relatórios e informações operacionais

---

# Stack

### Frontend

* Angular
* TypeScript

### Backend

* Java
* Spring Boot

### Banco de dados

* PostgreSQL

### Infraestrutura e evolução

* Docker
* Go
* RabbitMQ
* Redis
* CI/CD
* Observabilidade
* Cloud

---

# Etapas do projeto

## 1. CRUD Full Stack

Construção da primeira versão funcional do sistema.

### Objetivos

* Estruturar o projeto
* Criar backend com Spring Boot
* Criar frontend com Angular
* Modelar banco de dados
* Implementar API REST
* Criar operações CRUD
* Implementar validações
* Implementar tratamento de erros
* Integrar frontend e backend
* Executar a aplicação utilizando Docker

### Funcionalidades iniciais

* Empresas
* Clientes
* Ordens de serviço

### Resultado esperado

Ao final desta etapa, o sistema deverá permitir que um usuário utilize a aplicação de ponta a ponta.

---

# 2. Autenticação e autorização

A aplicação passará a possuir usuários e controle de acesso.

### Objetivos

* Implementar login
* Implementar autenticação com JWT
* Configurar Spring Security
* Criar roles e permissões
* Proteger endpoints
* Implementar Guards no Angular
* Implementar interceptor para autenticação
* Controlar funcionalidades de acordo com o perfil do usuário

### Perfis iniciais

* ADMIN
* MANAGER
* TECHNICIAN

### Resultado esperado

Cada usuário deverá acessar somente os recursos permitidos para seu perfil.

---

# 3. SaaS Multi-Tenant

A aplicação será transformada em uma plataforma capaz de atender múltiplas empresas.

### Objetivos

* Criar conceito de Tenant/Company
* Associar usuários às empresas
* Isolar dados entre empresas
* Implementar controle de acesso por tenant
* Adaptar entidades existentes para multi-tenancy
* Revisar arquitetura e modelagem do banco
* Garantir que uma empresa não consiga acessar dados de outra

### Exemplo

```text
Empresa A
├── Usuários
├── Clientes
└── Ordens de serviço

Empresa B
├── Usuários
├── Clientes
└── Ordens de serviço
```

### Resultado esperado

O mesmo sistema poderá atender diversas empresas mantendo seus dados isolados.

---

# 4. Sistema distribuído

A aplicação começará a utilizar mais de um serviço.

O objetivo será introduzir Go e aprender comunicação entre diferentes aplicações.

### Arquitetura

```text
Angular
   ↓
Spring Boot
   ↓
Go Service
```

### Objetivos

* Criar um serviço utilizando Go
* Definir responsabilidades para cada serviço
* Implementar comunicação entre Java e Go
* Trabalhar contratos de API
* Utilizar Docker
* Criar múltiplos containers
* Configurar comunicação entre serviços
* Trabalhar tratamento de falhas

### Exemplo

O Spring Boot poderá enviar uma tarefa para o serviço Go realizar algum processamento específico e receber o resultado posteriormente.

### Resultado esperado

A aplicação passará a possuir serviços independentes que se comunicam entre si.

---

# 5. Mensageria

A comunicação entre os serviços será evoluída para um modelo assíncrono.

### Tecnologias

* RabbitMQ
* Redis
* Java
* Go

### Objetivos

* Trabalhar eventos
* Implementar filas
* Criar produtores e consumidores
* Trabalhar processamento assíncrono
* Implementar retries
* Trabalhar mensagens inválidas
* Estudar idempotência
* Utilizar Redis para cache e outras necessidades apropriadas

### Exemplo

```text
Ordem criada
      ↓
Spring Boot
      ↓
RabbitMQ
      ↓
Go Service
      ↓
Processamento
      ↓
RabbitMQ
      ↓
Spring Boot
```

### Resultado esperado

O sistema deverá conseguir executar determinadas tarefas de maneira assíncrona e desacoplada.

---

# 6. Ambiente próximo de produção

Na última etapa, o projeto será preparado para funcionar como uma aplicação real.

### Objetivos

* Criar pipeline de CI/CD
* Automatizar testes e builds
* Criar imagens Docker
* Fazer deploy
* Configurar HTTPS
* Trabalhar variáveis de ambiente e secrets
* Configurar logs
* Implementar métricas
* Configurar health checks
* Implementar monitoramento
* Trabalhar observabilidade
* Configurar banco em produção
* Criar estratégia de backup

### Possível stack

```text
GitHub
   ↓
CI/CD
   ↓
Docker
   ↓
Cloud
   ↓
Aplicação
```

Com observabilidade:

```text
Application
    ↓
Logs
Metrics
Health Checks
Monitoring
```

### Resultado esperado

Ter uma aplicação funcionando em um ambiente próximo de produção, com processos de deploy, monitoramento e manutenção.

---

# Evolução da arquitetura

O projeto deverá evoluir progressivamente:

```text
ETAPA 1

Angular
   ↓
Spring Boot
   ↓
PostgreSQL
```

```text
ETAPA 2

Angular
   ↓
Spring Security
   ↓
Spring Boot
   ↓
PostgreSQL
```

```text
ETAPA 3

Angular
   ↓
Spring Boot
   ↓
PostgreSQL
   ↓
Multi-Tenant
```

```text
ETAPA 4

Angular
   ↓
Spring Boot
   ├── PostgreSQL
   └── Go Service
```

```text
ETAPA 5

Angular
   ↓
Spring Boot
   ├── PostgreSQL
   ├── Redis
   └── RabbitMQ
          ↓
      Go Service
```

```text
ETAPA 6

                    Cloud
                      │
              ┌───────┴───────┐
              │               │
           Frontend         Backend
                              │
                  ┌───────────┼───────────┐
                  │           │           │
              PostgreSQL    Redis      RabbitMQ
                                          │
                                          ▼
                                      Go Service

                + CI/CD
                + Logs
                + Metrics
                + Monitoring
```

---

# Resultado final

Ao concluir as seis etapas, o projeto terá passado por diferentes níveis de complexidade:

```text
CRUD
 ↓
Autenticação
 ↓
Autorização
 ↓
Multi-Tenant
 ↓
Sistemas Distribuídos
 ↓
Go
 ↓
Mensageria
 ↓
Redis
 ↓
Docker
 ↓
CI/CD
 ↓
Observabilidade
 ↓
Cloud
```
