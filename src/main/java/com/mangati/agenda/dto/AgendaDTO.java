package com.mangati.agenda.dto;

import java.time.LocalTime;

public class AgendaDTO {

    private Long id;
    private String nome;
    private String descricao;
    private boolean ativo;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private Integer duracaoAtendimento;
    private Integer intervaloEntreAtendimentos;

    // Constructors
    public AgendaDTO() {}

    public AgendaDTO(Long id, String nome, String descricao, boolean ativo,
                     LocalTime horarioInicial, LocalTime horarioFinal,
                     Integer duracaoAtendimento, Integer intervaloEntreAtendimentos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.duracaoAtendimento = duracaoAtendimento;
        this.intervaloEntreAtendimentos = intervaloEntreAtendimentos;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalTime getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(LocalTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Integer getDuracaoAtendimento() {
        return duracaoAtendimento;
    }

    public void setDuracaoAtendimento(Integer duracaoAtendimento) {
        this.duracaoAtendimento = duracaoAtendimento;
    }

    public Integer getIntervaloEntreAtendimentos() {
        return intervaloEntreAtendimentos;
    }

    public void setIntervaloEntreAtendimentos(Integer intervaloEntreAtendimentos) {
        this.intervaloEntreAtendimentos = intervaloEntreAtendimentos;
    }
}