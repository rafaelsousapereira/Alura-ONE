package br.com.alura.med.voll.api.infra.security;

import br.com.alura.med.voll.api.domain.usuario.Usuario;
import br.com.alura.med.voll.api.infra.exception.TokenJWTNaoGeradoException;
import br.com.alura.med.voll.api.infra.exception.TokenJWTInvalidoOuExpiradoException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {


    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("API Voll.med").withSubject(usuario.getLogin()).withExpiresAt(dataExpiracao()).sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new TokenJWTNaoGeradoException("Erro ao gerar token JWT! " + exception);
        }
    }

    public String getSubject(String tokenJWT) {

        try {
            var algoritmo = Algorithm.HMAC256(secret);

            return JWT.require(algoritmo)
                    .withIssuer("API Voll.med")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new TokenJWTInvalidoOuExpiradoException("Token inválido ou expirado! " + exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
