package br.com.alura.med.voll.api.infra.security;

import br.com.alura.med.voll.api.infra.exception.TokenJWTNaoEnviadoTokenJWTException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToken(request);

        var subject = tokenService.getSubject(tokenJWT);



        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null) {
            throw new TokenJWTNaoEnviadoTokenJWTException("Token JWT não enviado no cabeçario Authorization!");
        }

        return authorizationHeader.replace("Bearer", "").trim();
    }
}
