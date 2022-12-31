package com.bookstand.application.security.jwt;

import java.time.Duration;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.bookstand.application.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwtSecret}")
    private String jwtSecret;

    @Value("${jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${jwtCookieName}")
    private String jwtCookie;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if (cookie != null) {
            return cookie.getValue();
        }
        else {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(Duration.ofSeconds(12 * 60 * 60)).httpOnly(true).build();
        // ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(12 * 60 * 60).httpOnly(true).build();
        return cookie;
    }

    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
        return cookie;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }
        catch (SignatureException e) {
            logger.error("Firma de JWT no válida: {}", e.getMessage());
        }
        catch (MalformedJwtException e) {
            logger.error("Token JWT no válido: {}", e.getMessage());
        } 
        catch (ExpiredJwtException e) {
            logger.error("El token JWT expiró: {}", e.getMessage());
        }
        catch (UnsupportedJwtException e) {
            logger.error("Token JWT no sportado: {}", e.getMessage());
        }
        catch (IllegalArgumentException e) {
            logger.error("Cadena de concesiones vacía del JWT: {}", e.getMessage());
        }

        return false;
    }
    
    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs * 1000))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
    }
}