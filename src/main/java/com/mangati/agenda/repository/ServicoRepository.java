package com.mangati.agenda.repository;

import com.mangati.agenda.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findByAgendaId(Long agendaId);
    List<Servico> findByAtivoTrue();
    Servico findByNomeIgnoreCaseAndAgendaId(String nome, Long agendaId);
}