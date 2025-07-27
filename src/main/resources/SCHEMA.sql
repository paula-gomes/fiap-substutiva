CREATE TABLE IF NOT EXISTS cliente_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS estabelecimento_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cnpj VARCHAR(255),
    endereco VARCHAR(255),
    telefone VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS profissional_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    especialidade VARCHAR(255),
    horarios_disponiveis TEXT, -- Serialized as JSON or a delimited string
    tarifa DECIMAL(10, 2)
);