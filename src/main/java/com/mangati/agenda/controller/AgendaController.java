package com.mangati.agenda.controller;

import com.mangati.agenda.dto.AgendaDTO;
import com.mangati.agenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<AgendaDTO>> getAllAgendas() {
        return ResponseEntity.ok(agendaService.getAllAgendas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDTO> getAgendaById(@PathVariable Long id) {
        return ResponseEntity.ok(agendaService.getAgendaById(id));
    }

    @PostMapping
    public ResponseEntity<AgendaDTO> createAgenda(@RequestBody AgendaDTO agendaDTO) {
        return ResponseEntity.ok(agendaService.createAgenda(agendaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaDTO> updateAgenda(@PathVariable Long id, @RequestBody AgendaDTO agendaDTO) {
        return ResponseEntity.ok(agendaService.updateAgenda(id, agendaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable Long id) {
        agendaService.deleteAgenda(id);
        return ResponseEntity.noContent().build();
    }
}