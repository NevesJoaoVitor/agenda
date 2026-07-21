package com.mangati.agenda.service;

import com.mangati.agenda.dto.AgendaDTO;
import com.mangati.agenda.model.Agenda;
import com.mangati.agenda.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<AgendaDTO> getAllAgendas() {
        return agendaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AgendaDTO getAgendaById(Long id) {
        Agenda agenda = agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda not found with id: " + id));
        return convertToDTO(agenda);
    }

    public AgendaDTO createAgenda(AgendaDTO agendaDTO) {
        Agenda agenda = convertToEntity(agendaDTO);
        agenda = agendaRepository.save(agenda);
        return convertToDTO(agenda);
    }

    public AgendaDTO updateAgenda(Long id, AgendaDTO agendaDTO) {
        Agenda existingAgenda = agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda not found with id: " + id));
        
        existingAgenda.setNome(agendaDTO.getNome());
        existingAgenda.setDescricao(agendaDTO.getDescricao());
        existingAgenda.setAtivo(agendaDTO.isAtivo());
        existingAgenda.setHorarioInicial(agendaDTO.getHorarioInicial());
        existingAgenda.setHorarioFinal(agendaDTO.getHorarioFinal());
        existingAgenda.setDuracaoAtendimento(agendaDTO.getDuracaoAtendimento());
        existingAgenda.setIntervaloEntreAtendimentos(agendaDTO.getIntervaloEntreAtendimentos());
        
        Agenda updatedAgenda = agendaRepository.save(existingAgenda);
        return convertToDTO(updatedAgenda);
    }

    public void deleteAgenda(Long id) {
        if (!agendaRepository.existsById(id)) {
            throw new RuntimeException("Agenda not found with id: " + id);
        }
        agendaRepository.deleteById(id);
    }

    private AgendaDTO convertToDTO(Agenda agenda) {
        return new AgendaDTO(
                agenda.getId(),
                agenda.getNome(),
                agenda.getDescricao(),
                agenda.isAtivo(),
                agenda.getHorarioInicial(),
                agenda.getHorarioFinal(),
                agenda.getDuracaoAtendimento(),
                agenda.getIntervaloEntreAtendimentos()
        );
    }

    private Agenda convertToEntity(AgendaDTO agendaDTO) {
        Agenda agenda = new Agenda();
        agenda.setId(agendaDTO.getId());
        agenda.setNome(agendaDTO.getNome());
        agenda.setDescricao(agendaDTO.getDescricao());
        agenda.setAtivo(agendaDTO.isAtivo());
        agenda.setHorarioInicial(agendaDTO.getHorarioInicial());
        agenda.setHorarioFinal(agendaDTO.getHorarioFinal());
        agenda.setDuracaoAtendimento(agendaDTO.getDuracaoAtendimento());
        agenda.setIntervaloEntreAtendimentos(agendaDTO.getIntervaloEntreAtendimentos());
        return agenda;
    }
}