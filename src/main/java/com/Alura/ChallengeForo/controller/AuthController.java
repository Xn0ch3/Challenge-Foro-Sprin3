package com.Alura.ChallengeForo.controller;

import com.Alura.ChallengeForo.dto.DatosJWTToken;
import com.Alura.ChallengeForo.dto.DatosLogin;
import com.Alura.ChallengeForo.models.Usuario;
import com.Alura.ChallengeForo.repository.UsuarioRepository;
import com.Alura.ChallengeForo.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWTToken> login(@RequestBody @Valid DatosLogin datos) {
        Usuario usuario = usuarioRepository.findByEmail(datos.email())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(datos.password(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = tokenService.generarToken(usuario);
        return ResponseEntity.ok(new DatosJWTToken(token));
    }
}
