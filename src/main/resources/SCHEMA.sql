DROP TABLE IF EXISTS servico_entity;
DROP TABLE IF EXISTS profissional_horarios;
DROP TABLE IF EXISTS profissional_entity;
DROP TABLE IF EXISTS estabelecimento_fotos;
DROP TABLE IF EXISTS estabelecimento_profissionais;
DROP TABLE IF EXISTS estabelecimento_servicos;
DROP TABLE IF EXISTS estabelecimento_entity;
DROP TABLE IF EXISTS cliente_entity;
DROP TABLE IF EXISTS horario_entity;

CREATE TABLE IF NOT EXISTS cliente_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(255),
    nome VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS agendamento_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_profissional BIGINT NOT NULL,
    id_estabelecimento BIGINT NOT NULL,
    id_cliente BIGINT NOT NULL,
    id_servico BIGINT NOT NULL,
    status VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_termino TIME NOT NULL
);
CREATE TABLE IF NOT EXISTS avaliacao_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente BIGINT NOT NULL,
    estrelas INT NOT NULL,
    comentario VARCHAR(255),
    id_estabelecimento BIGINT NOT NULL,
    id_profissional BIGINT NOT NULL
);
CREATE TABLE IF NOT EXISTS estabelecimento_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    cnpj VARCHAR(255),
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    servicos JSON, -- Storing as JSON for a list of services
    profissionais JSON, -- Storing as JSON for a list of professionals
    fotos JSON -- Storing as JSON for a list of photos
);
CREATE TABLE IF NOT EXISTS foto_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    estabelecimento_id BIGINT NOT NULL
);
CREATE TABLE IF NOT EXISTS horario_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dia_da_semana VARCHAR(255) NOT NULL,
    inicio TIME NOT NULL,
    fim TIME NOT NULL,
    estabelecimento_id BIGINT NOT NULL
);
CREATE TABLE IF NOT EXISTS profissional_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especialidade VARCHAR(255),
    preco DECIMAL(19, 2),
    estabelecimento_id BIGINT NOT NULL
);
CREATE TABLE IF NOT EXISTS servico_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(19, 2),
    estabelecimento_id BIGINT NOT NULL
);

