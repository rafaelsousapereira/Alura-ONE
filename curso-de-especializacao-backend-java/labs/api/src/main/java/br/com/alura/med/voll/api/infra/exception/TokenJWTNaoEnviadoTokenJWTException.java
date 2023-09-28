package br.com.alura.med.voll.api.infra.exception;

public class TokenJWTNaoEnviadoTokenJWTException extends RuntimeException {

    public TokenJWTNaoEnviadoTokenJWTException(String mensagem) {
        super(mensagem);
    }
    
}
