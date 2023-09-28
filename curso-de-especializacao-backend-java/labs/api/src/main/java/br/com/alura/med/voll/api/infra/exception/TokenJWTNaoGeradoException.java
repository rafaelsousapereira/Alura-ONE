package br.com.alura.med.voll.api.infra.exception;

public class TokenJWTNaoGeradoException extends RuntimeException {
    
    public TokenJWTNaoGeradoException(String mensagem) {
        super(mensagem);
    }
    
}
