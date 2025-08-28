package com.example.parcelservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "my-very-secret-key-my-very-secret-key"; // En az 32 karakter

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String extractEmail(String token){
        return extractClaims(token).getSubject();
    }

    public boolean isValidToken(String token){
        try {
            extractClaims(token);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    private Claims extractClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
