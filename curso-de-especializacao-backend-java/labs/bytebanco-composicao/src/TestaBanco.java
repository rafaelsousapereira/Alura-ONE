
public class TestaBanco {

	public static void main(String[] args) {
		Cliente joao = new Cliente();
		joao.nome = "João Matias";
		joao.cpf = "333.333.333-33";
		joao.profissao = "Programador";
		
		Conta contaDoJoao = new Conta();
		contaDoJoao.deposita(200.0);
		
		contaDoJoao.titular = joao;
		System.out.println(contaDoJoao.titular.nome);
		System.out.println(contaDoJoao.titular);
		System.out.println(joao);
	}
}
