package com.mangati.agenda.dto;

public class ServicoDTO {

    private Long id;
    private Long agendaId;
    private String nome;
    private String descricao;
    private Integer duracao;
    private boolean ativo;

    // Constructors
    public ServicoDTO() {}

    public ServicoDTO(Long id, Long agendaId, String nome, String descricao,
                      Integer duracao, boolean ativo) {
        this.id = id;
        this.agendaId = agendaId;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ativo = ativo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(Long agendaId) {
        this.agendaId = agendaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}