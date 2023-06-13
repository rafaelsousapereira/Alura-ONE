package sintaxe_variaveis_e_fluxos;

public class TestaMultiplosDeTres {

	public static void main(String[] args) {

		for (int numero = 1; numero < 100; numero++) {
			if (numero % 3 == 0) {
				System.out.println("Esse número é múltiplo de 3 = " + numero);
			}
		}
	}

}
