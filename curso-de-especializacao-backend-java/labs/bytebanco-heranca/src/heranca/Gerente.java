package heranca;

public class Gerente extends Funcionario implements Autenticavel {

private AutenticadorUtil autenticador;
	
	public Gerente() {
		this.autenticador = new AutenticadorUtil();
	}
	
	public double getBonificacao() {
		System.out.println("Chamando metodo bonificacao do GERENTE");
		return super.getSalario();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}
}
