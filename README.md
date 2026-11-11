# 🔍 TechFind — Sistema de Achados e Perdidos

> **Projeto MVP — Disciplina de Projeto Sistema Web MVC e SQL**  
> **Professor:** Edson Angoti Júnior  
> **Instituição:** IFTM (Instituto Federal do Triângulo Mineiro)  

---

## 📌 1. Descrição do Problema
Em ambientes acadêmicos e comunitários (como o campus do IFTM), é comum que pertences pessoais — tais como documentos, eletrônicos, chaves e garrafas de água — sejam esquecidos ou perdidos. A centralização das informações sobre itens achados e perdidos ainda costuma ser informal, dependendo de avisos físicos ou mensagens dispersas em grupos de comunicação.

O **TechFind** surge como um produto mínimo viável (MVP) centralizado para registrar, visualizar e gerenciar o status de itens perdidos e encontrados dentro do campus, facilitando a devolução rápida aos seus respectivos donos.

---

## 🎯 2. Escopo do MVP
O projeto consiste em um sistema web monolítico baseado na arquitetura **MVC**, utilizando **Spring Boot**, **Thymeleaf**, **Bootstrap** e banco de dados **H2** manipulado via **Spring JDBC (JdbcTemplate)** com consultas SQL manuais parametrizadas.

---

## 📋 3. Requisitos do Sistema

### 3.1. Requisitos Funcionais (RF)
- **RF01 - Listar Itens:** Exibir uma tabela com todos os itens cadastrados (achados e perdidos), apresentando seus principais atributos e status.
- **RF02 - Detalhar Item:** Visualizar as informações completas de um item específico.
- **RF03 - Cadastrar Item:** Permitir a inclusão de um novo item com validação dos campos obrigatórios.
- **RF04 - Editar Item:** Permitir a atualização das informações de um item existente.
- **RF05 - Excluir Item:** Permitir a remoção de um item cadastrado (com confirmação).
- **RF06 - Buscar/Filtrar Itens:** Permitir a pesquisa de itens por palavra-chave (ex.: nome ou descrição) através de filtro com SQL parametrizado.


---

## 🗄️ 4. Modelagem do Banco de Dados (`schema.sql`)

O sistema opera sobre uma única tabela de domínio principal chamada `item`, contendo atributos de diferentes tipos (texto, data, enum/texto, booleano):

```sql
CREATE TABLE item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    local_encontrado VARCHAR(100) NOT NULL,
    data_registro DATE NOT NULL,
    tipo VARCHAR(20) NOT NULL, -- 'ACHADO' ou 'PERDIDO'
    devolvido BOOLEAN NOT NULL DEFAULT FALSE
);