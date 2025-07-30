# FIAP Substitutiva

Um projeto abrangente desenvolvido em **Java**, **Spring Boot** e **SQL** para gerenciar entidades como `Agendamento`, `Avaliacao` e `Estabelecimento`. Este projeto demonstra a implementação de um sistema backend robusto com funcionalidades como operações CRUD, exceções personalizadas e gateways de repositório.

## Tabela de Conteúdos

- [Visão Geral](#visão-geral)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Funcionalidades](#funcionalidades)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Configuração e Instalação](#configuração-e-instalação)
- [Uso](#uso)
- [Testes](#testes)
- [Contribuição](#contribuição)
- [Licença](#licença)

---

## Visão Geral

O projeto  foi projetado para gerenciar agendamentos, avaliações e estabelecimentos. Ele fornece uma arquitetura limpa com gateways de repositório, modelos de domínio e camadas de persistência. O projeto foi construído com foco em escalabilidade e manutenção.

---

## Tecnologias Utilizadas

- **Java**: Linguagem de programação para o desenvolvimento backend.
- **Spring Boot**: Framework para construção de APIs RESTful.
- **SQL**: Banco de dados para persistência de dados.
- **Maven**: Ferramenta de gerenciamento de dependências e build.
- **JUnit**: Framework de testes unitários.
- **Mockito**: Framework para criação de mocks em testes.

---

## Funcionalidades

- **Gerenciamento de Agendamentos**:
    - Criar, atualizar e recuperar informações de agendamentos.
    - Gerenciamento de status com `StatusAgendamentoEnum`.

- **Gerenciamento de Avaliações**:
    - Criar e listar avaliações para profissionais e estabelecimentos.
    - Tratamento de exceções personalizadas para entidades ausentes.

- **Gerenciamento de Estabelecimentos**:
    - Operações CRUD para estabelecimentos.
    - Busca de estabelecimentos por nome ou ID.

- **Tratamento de Exceções Personalizadas**:
    - Tratamento de erros com códigos de status HTTP significativos.

---

## Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── fiap_substituva/
│   │   │   ├── domain/                # Modelos de domínio
│   │   │   ├── infrasctruture/        # Gateways e persistência
│   │   │   ├── application/           # Serviços de aplicação
│   │   │   └── exceptions/            # Exceções personalizadas
│   └── resources/
│       ├── application.properties     # Configuração do Spring Boot
├── test/
│   ├── java/
│   │   ├── fiap_substituva/           # Testes unitários