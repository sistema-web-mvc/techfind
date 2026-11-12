package br.edu.iftm.techfind.model;

public enum TipoItem {
    PERDIDO("Perdido"),
    ENCONTRADO("Encontrado");

    private final String descricao;

    TipoItem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
} 
