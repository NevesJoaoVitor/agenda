package com.mangati.agenda.repository;

import com.mangati.agenda.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByServicoId(Long servicoId);
    List<Agendamento> findByDataHoraInicioBetween(LocalDateTime inicio, LocalDateTime fim);
    
    @Query("SELECT a FROM Agendamento a WHERE a.servico.id = ?1 AND a.dataHoraInicio >= ?2 AND a.dataHoraFim <= ?3")
    List<Agendamento> findByServicoAndDateRange(Long servicoId, LocalDateTime inicio, LocalDateTime fim);
}