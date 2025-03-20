package br.com.melhoremcasa.melhor_em_casa_api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "chaveSecretaSegura";

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 600)) // 10 min de validade
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }


    public boolean isTokenValid(String token){
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

}
