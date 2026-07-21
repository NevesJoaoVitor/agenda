package com.mangati.agenda.controller;

import com.mangati.agenda.dto.AgendamentoDTO;
import com.mangati.agenda.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> getAllAgendamentos() {
        return ResponseEntity.ok(agendamentoService.getAllAgendamentos());
    }

    @GetMapping("/servico/{servicoId}")
    public ResponseEntity<List<AgendamentoDTO>> getAgendamentosByServicoId(@PathVariable Long servicoId) {
        return ResponseEntity.ok(agendamentoService.getAgendamentosByServicoId(servicoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> getAgendamentoById(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.getAgendamentoById(id));
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> createAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
        return ResponseEntity.ok(agendamentoService.createAgendamento(agendamentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> updateAgendamento(@PathVariable Long id, @RequestBody AgendamentoDTO agendamentoDTO) {
        return ResponseEntity.ok(agendamentoService.updateAgendamento(id, agendamentoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable Long id) {
        agendamentoService.deleteAgendamento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/horario-disponivel")
    public ResponseEntity<Boolean> verificarHorarioDisponivel(
            @RequestParam Long servicoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraFim) {
        boolean disponivel = agendamentoService.isHorarioDisponivel(servicoId, dataHoraInicio, dataHoraFim);
        return ResponseEntity.ok(disponivel);
    }
}