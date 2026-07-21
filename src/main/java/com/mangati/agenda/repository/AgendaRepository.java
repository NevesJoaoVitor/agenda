package com.mangati.agenda.repository;

import com.mangati.agenda.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByAtivoTrue();
    Agenda findByNomeIgnoreCase(String nome);
}