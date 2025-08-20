package com.Alura.ChallengeForo.service;

import com.Alura.ChallengeForo.models.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {



    // Clave secreta segura para firmar el token (mínimo 256 bits)
    private static final String SECRET_KEY = "mi_clave_super_secreta_de_mas_de_32_caracteres!!";

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail()) // identificador
                .claim("id", usuario.getId())   // extra claims (opcional)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1h
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getSubject(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false; // token inválido o expirado
        }
    }
}
