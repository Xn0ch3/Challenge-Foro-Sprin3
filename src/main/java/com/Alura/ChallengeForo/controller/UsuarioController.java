package com.Alura.ChallengeForo.controller;

import com.Alura.ChallengeForo.dto.DatosRegistroUsuario;
import com.Alura.ChallengeForo.models.Usuario;
import com.Alura.ChallengeForo.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid DatosRegistroUsuario datos) {
        Usuario usuario = new Usuario();
        usuario.setNombre(datos.nombre());
        usuario.setEmail(datos.email());
        usuario.setPassword(new BCryptPasswordEncoder().encode(datos.password()));
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
}
