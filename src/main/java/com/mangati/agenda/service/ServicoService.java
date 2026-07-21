package com.mangati.agenda.service;

import com.mangati.agenda.dto.ServicoDTO;
import com.mangati.agenda.model.Servico;
import com.mangati.agenda.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<ServicoDTO> getAllServicos() {
        return servicoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ServicoDTO> getServicosByAgendaId(Long agendaId) {
        return servicoRepository.findByAgendaId(agendaId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ServicoDTO getServicoById(Long id) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servico not found with id: " + id));
        return convertToDTO(servico);
    }

    public ServicoDTO createServico(ServicoDTO servicoDTO) {
        Servico servico = convertToEntity(servicoDTO);
        servico = servicoRepository.save(servico);
        return convertToDTO(servico);
    }

    public ServicoDTO updateServico(Long id, ServicoDTO servicoDTO) {
        Servico existingServico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servico not found with id: " + id));
        
        existingServico.setNome(servicoDTO.getNome());
        existingServico.setDescricao(servicoDTO.getDescricao());
        existingServico.setDuracao(servicoDTO.getDuracao());
        existingServico.setAtivo(servicoDTO.isAtivo());
        
        Servico updatedServico = servicoRepository.save(existingServico);
        return convertToDTO(updatedServico);
    }

    public void deleteServico(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Servico not found with id: " + id);
        }
        servicoRepository.deleteById(id);
    }

    private ServicoDTO convertToDTO(Servico servico) {
        return new ServicoDTO(
                servico.getId(),
                servico.getAgenda() != null ? servico.getAgenda().getId() : null,
                servico.getNome(),
                servico.getDescricao(),
                servico.getDuracao(),
                servico.isAtivo()
        );
    }

    private Servico convertToEntity(ServicoDTO servicoDTO) {
        Servico servico = new Servico();
        servico.setId(servicoDTO.getId());
        servico.setNome(servicoDTO.getNome());
        servico.setDescricao(servicoDTO.getDescricao());
        servico.setDuracao(servicoDTO.getDuracao());
        servico.setAtivo(servicoDTO.isAtivo());
        // Note: agenda relationship should be set separately
        return servico;
    }
}