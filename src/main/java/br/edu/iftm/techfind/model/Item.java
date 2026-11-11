package br.edu.iftm.techfind.model;

import java.time.LocalDate;

public class Item {

    private Long id;                  // id               BIGINT
    private TipoItem tipo;            // tipo             VARCHAR(20)
    private String titulo;            // titulo           VARCHAR(100)
    private String descricao;         // descricao        VARCHAR(500)
    private String categoria;         // categoria        VARCHAR(50)
    private String localizacao;       // localizacao      VARCHAR(50)
    private LocalDate dataOcorrencia; // data_ocorrencia  DATE
    private String nomeContato;       // nome_contato     VARCHAR(100)
    private String emailContato;      // email_contato    VARCHAR(100)
    private String telefoneContato;   // telefone_contato VARCHAR(20)
    private boolean devolvido;        // devolvido        BOOLEAN

    public Item() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoItem getTipo() { return tipo; }
    public void setTipo(TipoItem tipo) { this.tipo = tipo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public LocalDate getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(LocalDate dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }

    public String getNomeContato() { return nomeContato; }
    public void setNomeContato(String nomeContato) { this.nomeContato = nomeContato; }

    public String getEmailContato() { return emailContato; }
    public void setEmailContato(String emailContato) { this.emailContato = emailContato; }

    public String getTelefoneContato() { return telefoneContato; }
    public void setTelefoneContato(String telefoneContato) { this.telefoneContato = telefoneContato; }

    public boolean isDevolvido() { return devolvido; }
    public void setDevolvido(boolean devolvido) { this.devolvido = devolvido; }
}
