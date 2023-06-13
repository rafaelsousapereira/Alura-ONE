package sintaxe_variaveis_e_fluxos;

public class TestaCondicional2 {

	public static void main(String[] args) {
		System.out.println("Testando condicionais...");
		int idade = 20;
		int quantidadeDePessoas = 3;
		boolean acompanhado = quantidadeDePessoas >= 2;

		if (idade >= 18 && acompanhado) {
			System.out.println("Seja bem-vindo!");
		} else {
			System.out.println("Infelizmente voce nao pode entrar!");
		}
	}

}
