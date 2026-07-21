package com.mangati.agenda.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "agendas")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(name = "horario_inicial", nullable = false)
    private LocalTime horarioInicial;

    @Column(name = "horario_final", nullable = false)
    private LocalTime horarioFinal;

    @Column(name = "duracao_atendimento", nullable = false)
    private Integer duracaoAtendimento; // em minutos

    @Column(name = "intervalo_entre_atendimentos")
    private Integer intervaloEntreAtendimentos; // em minutos

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