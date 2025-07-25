CREATE TABLE IF NOT EXISTS `user` (
  id bigint AUTO_INCREMENT primary key,
  username varchar(255) not null,
  password varchar(255) not null,
  email varchar(255) not null
);

CREATE TABLE IF NOT EXISTS cliente_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(20)
);