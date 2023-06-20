package heranca;

public class TesteFuncionario {

	public static void main(String[] args) {

		Funcionario joao = new Funcionario();
		joao.setNome("Joao Pedro");
		joao.setCpf("111.111.111-11");
		joao.setSalario(2000.0);
		
		System.out.printf("Salario = R$ %2.2f%n", joao.getSalario());
		System.out.printf("Bonificacao = R$ %2.2f%n", joao.getBonificacao());
	}

}
