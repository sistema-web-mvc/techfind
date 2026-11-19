package br.edu.iftm.techfind.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.edu.iftm.techfind.model.Item;
import br.edu.iftm.techfind.model.TipoItem;

@Repository
public class ItemRepository {

    private static final String COLUNAS = """
            id, tipo, titulo, descricao, categoria, localizacao, data_ocorrencia,
            nome_contato, email_contato, telefone_contato, devolvido
            """;

    private final JdbcTemplate jdbcTemplate;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Converte UMA linha do ResultSet em UM Item
    private final RowMapper<Item> itemRowMapper = (rs, rowNum) -> {
        Item item = new Item();
        item.setId(rs.getLong("id"));
        // O banco guarda o texto 'PERDIDO' ou 'ENCONTRADO'; valueOf transforma no enum
        item.setTipo(TipoItem.valueOf(rs.getString("tipo")));
        item.setTitulo(rs.getString("titulo"));
        item.setDescricao(rs.getString("descricao"));
        item.setCategoria(rs.getString("categoria"));
        item.setLocalizacao(rs.getString("localizacao"));
        item.setDataOcorrencia(rs.getObject("data_ocorrencia", LocalDate.class));
        item.setNomeContato(rs.getString("nome_contato"));
        item.setEmailContato(rs.getString("email_contato"));
        item.setTelefoneContato(rs.getString("telefone_contato"));
        item.setDevolvido(rs.getBoolean("devolvido"));
        return item;
    };

    public List<Item> findAll() {
        String sql = "SELECT " + COLUNAS + " FROM item ORDER BY data_ocorrencia DESC, id DESC";
        return jdbcTemplate.query(sql, itemRowMapper);
    }

    // O "?" é preenchido pelo PreparedStatement: o id nunca vira parte do texto do
    // SQL
    public Optional<Item> findById(Long id) {
        String sql = "SELECT " + COLUNAS + " FROM item WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, itemRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            // queryForObject lança essa exceção quando não acha nenhuma linha
            return Optional.empty();
        }
    }

    public Long insert(Item item) {
        String sql = """
                INSERT INTO item (tipo, titulo, descricao, categoria, localizacao,
                                  data_ocorrencia, nome_contato, email_contato,
                                  telefone_contato, devolvido)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            // name() devolve o texto do enum: "PERDIDO" ou "ENCONTRADO"
            ps.setString(1, item.getTipo().name());
            ps.setString(2, item.getTitulo());
            ps.setString(3, item.getDescricao());
            ps.setString(4, item.getCategoria());
            ps.setString(5, item.getLocalizacao());
            ps.setDate(6, Date.valueOf(item.getDataOcorrencia()));
            ps.setString(7, item.getNomeContato());
            ps.setString(8, item.getEmailContato());
            ps.setString(9, item.getTelefoneContato());
            ps.setBoolean(10, item.isDevolvido());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    // Devolve quantas linhas foram alteradas (0 ou 1)
    public int update(Item item) {
        String sql = """
                UPDATE item
                   SET tipo = ?, titulo = ?, descricao = ?, categoria = ?, localizacao = ?,
                       data_ocorrencia = ?, nome_contato = ?, email_contato = ?,
                       telefone_contato = ?, devolvido = ?
                 WHERE id = ?
                """;
        return jdbcTemplate.update(sql,
                item.getTipo().name(),
                item.getTitulo(),
                item.getDescricao(),
                item.getCategoria(),
                item.getLocalizacao(),
                item.getDataOcorrencia(),
                item.getNomeContato(),
                item.getEmailContato(),
                item.getTelefoneContato(),
                item.isDevolvido(),
                item.getId());
    }

    // Devolve quantas linhas foram removidas (0 ou 1)
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM item WHERE id = ?", id);
    }
}