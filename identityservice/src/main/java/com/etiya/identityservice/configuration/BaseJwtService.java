package com.etiya.identityservice.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;



@Service
public class BaseJwtService {
    @Value("${jwt.expiration}")
    private Long EXPIRATION ;
    @Value("${jwt.secret_key}")
    private String SECRET_KEY ;


    public String generateToken(String userName) {
        return Jwts
                .builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .setSubject(userName)
                .signWith(getSignKey())
                .compact();
    }

    public Boolean validateToken(String token)
    {
        try {
            return getClaimsFromToken(token).getExpiration().after(new Date());
        }
        catch(Exception e)
        {
            // Token bir şekilde çözümlenemezse..
            return false;
        }
    }
    public String extractUsername(String token)
    {
        return getClaimsFromToken(token).getSubject();
    }

    private Claims getClaimsFromToken(String token)
    {
        SecretKey key = (SecretKey) getSignKey();
        return Jwts.parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}