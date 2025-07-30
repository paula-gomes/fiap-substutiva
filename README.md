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

O projeto foi desenvolvido com foco em **Desenvolvimento Orientado a Testes (TDD)**, utilizando práticas de **código limpo** e seguindo os princípios da **Clean Architecture**. A estrutura do sistema foi projetada para garantir alta manutenibilidade, escalabilidade e separação de responsabilidades, promovendo um código modular e de fácil entendimento.

As principais características incluem:

- **Desenvolvimento Orientado a Testes (TDD)**: Os testes unitários foram implementados desde o início do desenvolvimento, garantindo a confiabilidade e a qualidade do código. Ferramentas como **JUnit** e **Mockito** foram utilizadas para validar o comportamento das funcionalidades.

- **Práticas de Código Limpo**: O código foi escrito seguindo princípios como legibilidade, simplicidade e reutilização, facilitando a colaboração e a evolução do projeto.

- **Clean Architecture**: A arquitetura foi estruturada em camadas bem definidas, separando as regras de negócio (domínio) das implementações de infraestrutura. Isso permite que mudanças em tecnologias ou frameworks não impactem diretamente o núcleo do sistema.
---

## Tecnologias Utilizadas


- **Java**: Linguagem de programação para o desenvolvimento backend.
- **Spring Boot**: Framework para construção de APIs RESTful.
- **SQL**: Banco de dados para persistência de dados.
- **Maven**: Ferramenta de gerenciamento de dependências e build.
- **JUnit**: Framework de testes unitários.
- **Mockito**: Framework para criação de mocks em testes.
- **GitHub Actions**: Ferramenta de CI/CD para automação de testes, builds e deploys.
- **Docker**: Utilizado para containerização da aplicação e versionamento no DockerHub.
- **Kubernetes (K8s)**: Gerenciamento de clusters para orquestração de containers.
- **DigitalOcean**: Plataforma utilizada para deploy e gerenciamento do cluster Kubernetes.

---

## Vantagens da Abordagem

- **Automação com CI/CD**:
    - Redução de erros manuais no processo de build e deploy.
    - Garantia de qualidade com execução automatizada de testes antes do deploy.

- **Containerização com Docker**:
    - Portabilidade da aplicação entre diferentes ambientes.
    - Facilidade no versionamento e compartilhamento de imagens via DockerHub.

- **Orquestração com Kubernetes**:
    - Escalabilidade automática para lidar com variações de carga.
    - Alta disponibilidade com gerenciamento de réplicas e balanceamento de carga.

- **Deploy na DigitalOcean**:
    - Infraestrutura confiável e de fácil configuração.
    - Integração nativa com Kubernetes para gerenciamento simplificado do cluster.


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
    - 
- **Swagger**: Ferramenta para documentação interativa das APIs.
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
