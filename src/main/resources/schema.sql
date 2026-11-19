-- =====================================================================
-- TechFind - criação da tabela de itens perdidos e encontrados
-- Este arquivo é executado automaticamente pelo Spring Boot
-- toda vez que a aplicação inicia (banco H2 em memória).
-- =====================================================================

-- Remove a tabela se ela já existir, para o script poder rodar
-- quantas vezes for preciso sem dar erro de "tabela já existe".
DROP TABLE IF EXISTS item;

CREATE TABLE item (
    -- Número do item, gerado sozinho pelo banco (1, 2, 3...)
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,

    -- 'PERDIDO' ou 'ENCONTRADO' (na classe Java vira um enum)
    tipo             VARCHAR(20)  NOT NULL,

    titulo           VARCHAR(100) NOT NULL,

    -- Opcional (sem NOT NULL)
    descricao        VARCHAR(500),

    categoria        VARCHAR(50)  NOT NULL,

    -- Onde o item foi perdido ou encontrado.
    -- Não usamos "local" porque pode conflitar com palavra reservada do SQL.
    localizacao      VARCHAR(50)  NOT NULL,

    -- Data em que o item foi perdido ou encontrado (formato AAAA-MM-DD)
    data_ocorrencia  DATE         NOT NULL,

    -- Contato de quem publicou (o app não tem login)
    nome_contato     VARCHAR(100) NOT NULL,
    email_contato    VARCHAR(100) NOT NULL,
    telefone_contato VARCHAR(20),

    -- Todo item começa como não devolvido
    devolvido        BOOLEAN      NOT NULL DEFAULT FALSE
);