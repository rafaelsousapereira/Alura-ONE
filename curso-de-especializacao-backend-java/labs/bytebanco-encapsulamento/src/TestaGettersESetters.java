
public class TestaGettersESetters {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
//		conta.numero = 4321;
		conta.setNumero(4321);
		conta.setAgencia(12);
		
		System.out.println("Número da Conta: " + conta.getNumero());
		System.out.println("Número da Agência: " + conta.getAgencia());
		
		Cliente maria = new Cliente();
		maria.setNome("Maria Aparecida");
		
		conta.setTitular(maria);
		System.out.println("Nome Cliente: " + conta.getTitular().getNome());
		
		conta.getTitular().setProfissao("Programadora");
		System.out.println("Profissão Cliente: " + conta.getTitular().getProfissao());
		
		Cliente titularDaConta = conta.getTitular();
		titularDaConta.setCpf("111.111.111-11");
		
		System.out.println("CPF Cliente: " + conta.getTitular().getCpf());
		
//		tem a mesma referência de memória
		System.out.println(conta.getTitular());
		System.out.println(maria);
		System.out.println(titularDaConta);
	}

}
