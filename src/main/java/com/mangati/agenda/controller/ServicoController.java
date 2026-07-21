package com.mangati.agenda.controller;

import com.mangati.agenda.dto.ServicoDTO;
import com.mangati.agenda.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> getAllServicos() {
        return ResponseEntity.ok(servicoService.getAllServicos());
    }

    @GetMapping("/agenda/{agendaId}")
    public ResponseEntity<List<ServicoDTO>> getServicosByAgendaId(@PathVariable Long agendaId) {
        return ResponseEntity.ok(servicoService.getServicosByAgendaId(agendaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> getServicoById(@PathVariable Long id) {
        return ResponseEntity.ok(servicoService.getServicoById(id));
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> createServico(@RequestBody ServicoDTO servicoDTO) {
        return ResponseEntity.ok(servicoService.createServico(servicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> updateServico(@PathVariable Long id, @RequestBody ServicoDTO servicoDTO) {
        return ResponseEntity.ok(servicoService.updateServico(id, servicoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        servicoService.deleteServico(id);
        return ResponseEntity.noContent().build();
    }
}