package com.mangati.agenda.dto;

import java.time.LocalDateTime;

public class AgendamentoDTO {

    private Long id;
    private Long servicoId;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String nomePaciente;
    private String telefonePaciente;
    private String emailPaciente;
    private String observacoes;
    private String status;

    // Constructors
    public AgendamentoDTO() {}

    public AgendamentoDTO(Long id, Long servicoId, LocalDateTime dataHoraInicio,
                          LocalDateTime dataHoraFim, String nomePaciente,
                          String telefonePaciente, String emailPaciente,
                          String observacoes, String status) {
        this.id = id;
        this.servicoId = servicoId;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.nomePaciente = nomePaciente;
        this.telefonePaciente = telefonePaciente;
        this.emailPaciente = emailPaciente;
        this.observacoes = observacoes;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}