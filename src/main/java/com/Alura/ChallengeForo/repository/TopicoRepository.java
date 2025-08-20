package com.Alura.ChallengeForo.repository;


import com.Alura.ChallengeForo.models.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository< Topico, Long> {}