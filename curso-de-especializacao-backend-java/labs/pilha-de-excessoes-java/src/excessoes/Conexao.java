package excessoes;

public class Conexao {

    public Conexao() {
        System.out.println("Abrindo conexao");
    }

    public void leDados() {
        System.out.println("Recebendo dados");
            throw new IllegalStateException();
    }

    public void fecha() {
        System.out.println("Fechando conexao");
    }
}
