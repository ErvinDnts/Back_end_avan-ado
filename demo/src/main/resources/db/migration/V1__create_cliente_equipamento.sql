CREATE TABLE cliente (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         cpf VARCHAR(14) NOT NULL UNIQUE,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         ativo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE equipamento (
                             id BIGSERIAL PRIMARY KEY,
                             tipo VARCHAR(100) NOT NULL,
                             marca VARCHAR(100),
                             modelo VARCHAR(100),
                             numero_serie VARCHAR(100) UNIQUE,
                             cliente_id BIGINT NOT NULL,
                             CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
