package heranca;

public class ControleBonificacao {

	private double soma;
	
	public double getSoma() {
		return soma;
	}
	
	public void registra(Funcionario funcionario) {
		double bonificacao = funcionario.getBonificacao();
		this.soma = this.soma + bonificacao;
	}
}
