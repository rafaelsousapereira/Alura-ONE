package br.com.alura.med.voll.api.infra.exception;

public class TokenJWTInvalidoOuExpiradoException extends RuntimeException {

    public TokenJWTInvalidoOuExpiradoException(String mensagem) {
        super(mensagem);
    }
}
