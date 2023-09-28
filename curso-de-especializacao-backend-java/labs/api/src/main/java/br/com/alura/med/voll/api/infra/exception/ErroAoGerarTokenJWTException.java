package br.com.alura.med.voll.api.infra.exception;

public class ErroAoGerarTokenJWTException extends RuntimeException {
    
    public ErroAoGerarTokenJWTException(String mensagem) {
        super(mensagem);
    }
    
}
