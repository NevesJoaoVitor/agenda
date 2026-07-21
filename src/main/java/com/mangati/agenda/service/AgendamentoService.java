package com.mangati.agenda.service;

import com.mangati.agenda.dto.AgendamentoDTO;
import com.mangati.agenda.model.Agendamento;
import com.mangati.agenda.model.Servico;
import com.mangati.agenda.repository.AgendamentoRepository;
import com.mangati.agenda.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    public List<AgendamentoDTO> getAllAgendamentos() {
        return agendamentoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AgendamentoDTO> getAgendamentosByServicoId(Long servicoId) {
        return agendamentoRepository.findByServicoId(servicoId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AgendamentoDTO getAgendamentoById(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento not found with id: " + id));
        return convertToDTO(agendamento);
    }

    public AgendamentoDTO createAgendamento(AgendamentoDTO agendamentoDTO) {
        Servico servico = servicoRepository.findById(agendamentoDTO.getServicoId())
                .orElseThrow(() -> new RuntimeException("Servico not found with id: " + agendamentoDTO.getServicoId()));
        
        Agendamento agendamento = convertToEntity(agendamentoDTO, servico);
        agendamento = agendamentoRepository.save(agendamento);
        return convertToDTO(agendamento);
    }

    public AgendamentoDTO updateAgendamento(Long id, AgendamentoDTO agendamentoDTO) {
        Agendamento existingAgendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento not found with id: " + id));
        
        Servico servico = servicoRepository.findById(agendamentoDTO.getServicoId())
                .orElseThrow(() -> new RuntimeException("Servico not found with id: " + agendamentoDTO.getServicoId()));
        
        existingAgendamento.setServico(servico);
        existingAgendamento.setDataHoraInicio(agendamentoDTO.getDataHoraInicio());
        existingAgendamento.setDataHoraFim(agendamentoDTO.getDataHoraFim());
        existingAgendamento.setNomePaciente(agendamentoDTO.getNomePaciente());
        existingAgendamento.setTelefonePaciente(agendamentoDTO.getTelefonePaciente());
        existingAgendamento.setEmailPaciente(agendamentoDTO.getEmailPaciente());
        existingAgendamento.setObservacoes(agendamentoDTO.getObservacoes());
        existingAgendamento.setStatus(agendamentoDTO.getStatus());
        
        Agendamento updatedAgendamento = agendamentoRepository.save(existingAgendamento);
        return convertToDTO(updatedAgendamento);
    }

    public void deleteAgendamento(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento not found with id: " + id);
        }
        agendamentoRepository.deleteById(id);
    }

    // Method to generate available time slots
    public boolean isHorarioDisponivel(Long servicoId, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        // Check if the requested time slot overlaps with existing appointments
        List<Agendamento> existingAgendamentos = agendamentoRepository.findByServicoAndDateRange(
                servicoId, dataHoraInicio, dataHoraFim);
        
        return existingAgendamentos.isEmpty();
    }

    private AgendamentoDTO convertToDTO(Agendamento agendamento) {
        return new AgendamentoDTO(
                agendamento.getId(),
                agendamento.getServico() != null ? agendamento.getServico().getId() : null,
                agendamento.getDataHoraInicio(),
                agendamento.getDataHoraFim(),
                agendamento.getNomePaciente(),
                agendamento.getTelefonePaciente(),
                agendamento.getEmailPaciente(),
                agendamento.getObservacoes(),
                agendamento.getStatus()
        );
    }

    private Agendamento convertToEntity(AgendamentoDTO agendamentoDTO, Servico servico) {
        Agendamento agendamento = new Agendamento();
        agendamento.setId(agendamentoDTO.getId());
        agendamento.setServico(servico);
        agendamento.setDataHoraInicio(agendamentoDTO.getDataHoraInicio());
        agendamento.setDataHoraFim(agendamentoDTO.getDataHoraFim());
        agendamento.setNomePaciente(agendamentoDTO.getNomePaciente());
        agendamento.setTelefonePaciente(agendamentoDTO.getTelefonePaciente());
        agendamento.setEmailPaciente(agendamentoDTO.getEmailPaciente());
        agendamento.setObservacoes(agendamentoDTO.getObservacoes());
        agendamento.setStatus(agendamentoDTO.getStatus());
        return agendamento;
    }
}