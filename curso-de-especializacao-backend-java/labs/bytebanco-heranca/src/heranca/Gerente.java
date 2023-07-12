package heranca;

public class Gerente extends FuncionarioAutenticavel {

	public double getBonificacao() {
		System.out.println("Chamando metodo bonificacao do GERENTE");
		return super.getSalario();
	}

}
