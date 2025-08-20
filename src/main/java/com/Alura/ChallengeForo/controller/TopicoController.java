package com.Alura.ChallengeForo.controller;


import com.Alura.ChallengeForo.dto.DatosRegistroTopico;
import com.Alura.ChallengeForo.models.Topico;
import com.Alura.ChallengeForo.models.Usuario;
import com.Alura.ChallengeForo.repository.TopicoRepository;
import com.Alura.ChallengeForo.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> crear(@RequestBody @Valid DatosRegistroTopico datos,
                                        @RequestParam Long usuarioId) {
        Usuario autor = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setCurso(datos.curso());
        topico.setAutor(autor);

        repository.save(topico);
        return ResponseEntity.status(201).body(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}