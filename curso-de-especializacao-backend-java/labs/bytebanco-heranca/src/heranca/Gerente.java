package heranca;

public class Gerente extends Funcionario {

	private int senha;
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		}
		return false;
	}
	
	public double getBonificacao() {
		System.out.println("Chamando metodo bonificacao do GERENTE");
		return super.getBonificacao() + super.getSalario();
	}

}
