package sintaxe_variaveis_e_fluxos;

public class TestaFatorial {

	public static void main(String[] args) {

		int fatorial = 1;
		for (int i = 1; i < 10; i++) {
			fatorial *= i;
			System.out.println("Fatorial de " + i + " = " + fatorial);
		}
	}

}
