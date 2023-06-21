package heranca;

public class EditorDeVideo extends Funcionario {

	public double getBonificacao() {
		System.out.println("Chamando o metodo de bonificacao do EDITOR DE VIDEO");
		return super.getBonificacao() + 100;
	}

}
