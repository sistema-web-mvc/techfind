-- =====================================================================
-- TechFind - dados de exemplo
-- Executado logo depois do schema.sql. Como o H2 está em memória,
-- os dados voltam a ser estes 5 itens toda vez que a aplicação reinicia.
-- O id não é informado: o banco gera sozinho (AUTO_INCREMENT).
-- =====================================================================

INSERT INTO item (tipo, titulo, descricao, categoria, localizacao, data_ocorrencia, nome_contato, email_contato, telefone_contato, devolvido)
VALUES ('PERDIDO', 'Garrafa térmica azul', 'Garrafa de inox azul-marinho, 500 ml, com adesivo do IFTM na tampa', 'Garrafas e utensílios', 'Biblioteca', '2026-10-27', 'Maria Souza', 'maria@estudante.iftm.edu.br', '(34) 99999-0000', FALSE);

INSERT INTO item (tipo, titulo, descricao, categoria, localizacao, data_ocorrencia, nome_contato, email_contato, telefone_contato, devolvido)
VALUES ('PERDIDO', 'Carregador de celular Samsung', 'Carregador branco com cabo USB-C', 'Eletrônicos', 'Biblioteca', '2026-10-30', 'João Lima', 'joao@estudante.iftm.edu.br', '(34) 98888-1111', FALSE);

INSERT INTO item (tipo, titulo, descricao, categoria, localizacao, data_ocorrencia, nome_contato, email_contato, telefone_contato, devolvido)
VALUES ('ENCONTRADO', 'Carregador de notebook', 'Fonte preta encontrada em cima da bancada', 'Eletrônicos', 'Laboratório', '2026-10-28', 'Ana Costa', 'ana@estudante.iftm.edu.br', NULL, FALSE);

INSERT INTO item (tipo, titulo, descricao, categoria, localizacao, data_ocorrencia, nome_contato, email_contato, telefone_contato, devolvido)
VALUES ('PERDIDO', 'Carteirinha de estudante', 'Carteirinha em nome de Pedro Alves', 'Documentos', 'Cantina', '2026-10-28', 'Pedro Alves', 'pedro@estudante.iftm.edu.br', '(34) 97777-2222', FALSE);

INSERT INTO item (tipo, titulo, descricao, categoria, localizacao, data_ocorrencia, nome_contato, email_contato, telefone_contato, devolvido)
VALUES ('ENCONTRADO', 'Chaveiro com duas chaves', 'Chaveiro de metal com chave de armário e chave pequena', 'Chaves', 'Pátio', '2026-11-03', 'Carlos Mendes', 'carlos@estudante.iftm.edu.br', '(34) 96666-3333', FALSE);